package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务消费方（客户端）
 *
 * @author zenuo
 * @date 2019/05/23
 */
@SpringBootApplication
@RestController
@EnableFeignClients
@EnableDiscoveryClient
public class HelloClientApplication {

    @Autowired
    private HelloClient client;

    public static void main(String[] args) {
        SpringApplication.run(HelloClientApplication.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return client.hello();
    }

    @FeignClient("HelloServer")
    interface HelloClient {
        @RequestMapping(value = "/", method = RequestMethod.GET)
        String hello();
    }
}
