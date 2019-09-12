package demo.service;

import demo.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer get(Long id) {
        return jdbcTemplate.query(
                "select id, firstName, lastName from customer where id = ?", new Object[]{id},
                (rs, rowNum) -> new Customer(rs.getLong("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"))
        ).get(0);
    }

    @Override
    public void updateWithoutRefresh(Long id) {
        try (final Session session = entityManager.unwrap(Session.class)) {
            final Customer customer = session.load(Customer.class, id);
            // 请知悉：若无此行，则结果为“JdbcTemplate和Hibernate更新都有效”；原因是load方法返回一个代理实例，访问其属性时才会查询数据库，此处不展开
            log.info(customer.toString());
            // 执行JdbcTemplate更新
            jdbcTemplate.update("update customer set lastName = ? where id = ?", "J", id);
            // 执行Hibernate更新
            customer.setFirstName("H");
            session.update(customer);
            session.flush();
            log.info(customer.toString());
            // 结果：JdbcTemplate更新无效，Hibernate更新有效
            // 原因：JdbcTemplate更新被Hibernate覆盖
        }
    }

    @Override
    public void updateWithRefresh(Long id) {
        try (final Session session = entityManager.unwrap(Session.class)) {
            final Customer customer = session.load(Customer.class, id);
            // 立即加载
            log.info(customer.toString());
            // 执行JdbcTemplate更新
            jdbcTemplate.update("update customer set lastName = ? where id = ?", "J", id);
            // 从底层数据库重新读取给定实例的状态
            session.refresh(customer);
            // 执行Hibernate更新
            customer.setFirstName("H");
            session.update(customer);
            session.flush();
            log.info(customer.toString());
            // 结果：JdbcTemplate和Hibernate更新都有效
            // 原因：JdbcTemplate更新之后，被Hibernate重新从数据库读取（因为在同个事务，所以可见），Hibernate再执行更新，更新结果体现了两者
        }
    }
}
