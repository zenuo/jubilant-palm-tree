package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供方（服务端）
 *
 * @author zenuo
 * @date 2019/05/23
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloServerApplication {

    @Autowired
    private Registration registration;

    public static void main(String[] args) {
        SpringApplication.run(HelloServerApplication.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello World: " + registration.getServiceId() + ", " + registration.getHost() + ":" + registration.getPort();
    }
}
