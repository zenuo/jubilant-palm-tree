package demo.springboot.things;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetUserResponse implements IResponse {
    private List<String> ids;
}
