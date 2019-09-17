package demo.dubbo.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserVO implements Serializable {

    private Integer id;

    private String name;

    //private Integer age = 28;
}
