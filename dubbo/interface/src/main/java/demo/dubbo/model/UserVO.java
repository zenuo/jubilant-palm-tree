package demo.dubbo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 袁臻
 */
@Data
public class UserVO implements Serializable {

    private Integer id;

    private String name;

    //private Integer age = 28;
}
