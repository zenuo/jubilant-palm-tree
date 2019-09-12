package demo.springboot.things;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 使用UrlResource作为请求体
 */
@Slf4j
@Component
public class UrlResourcePost implements ApplicationRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final UrlResource urlResource = new UrlResource("http://cron.qqe2.com/index.html");
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        final MultiValueMap<String, Object> body = new LinkedMultiValueMap<>(2);
        body.add("file", urlResource);
        body.add("token", System.currentTimeMillis());
        final ResponseEntity<String> response = restTemplate.exchange("http://localhost:80", HttpMethod.POST, new HttpEntity<>(body, headers), String.class);
        log.info("response: {}", response);
    }
}
