package demo.springboot.things;

import org.springframework.http.HttpMethod;

import java.net.URI;

public class GetUserRequest extends AbstractRequest<GetUserResponse>{
    @Override
    public URI uri() {
        return URI.create("http://localhost:80/user/ids");
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    public static void main(String[] args) {
        System.out.println(new GetUserRequest().responseClass());
    }
}
