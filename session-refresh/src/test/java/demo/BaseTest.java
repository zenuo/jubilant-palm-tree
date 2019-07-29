package demo;

import demo.model.Customer;
import demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class BaseTest {
    @Autowired
    private CustomerService service;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String initial = "0";

    private final Long id = 1L;

    /**
     * 复位
     */
    public void reset() {
        jdbcTemplate.update("update customer set firstName = ?, lastName = ? where id = ?", initial, initial, id);
    }

    @Test
    public void updateWithoutRefresh() {
        reset();
        service.updateWithoutRefresh(id);
        final Customer customer = service.get(id);
        Assert.assertEquals(initial, customer.getLastName());
    }

    @Test
    public void updateWithRefresh() {
        reset();
        service.updateWithRefresh(id);
        final Customer customer = service.get(id);
        Assert.assertEquals("J", customer.getLastName());
    }
}
