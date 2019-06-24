package demo.dubbo;

import demo.dubbo.model.UserVO;
import demo.dubbo.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 袁臻
 */
public class Consumer {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        final UserService userService = (UserService) context.getBean("userService");
        final List<UserVO> all = userService.getAll();
        all.forEach(System.err::println);
    }
}
