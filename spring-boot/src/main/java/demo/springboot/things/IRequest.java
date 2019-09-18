package demo.springboot.things;

import org.springframework.http.HttpMethod;

import java.net.URI;

public interface IRequest<T extends IResponse> {

    Class<T> responseClass();

    URI uri();

    HttpMethod httpMethod();
}
