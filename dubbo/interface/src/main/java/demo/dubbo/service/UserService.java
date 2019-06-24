package demo.dubbo.service;

import demo.dubbo.model.UserVO;

import java.util.List;

/**
 * @author 袁臻
 */
public interface UserService {
    List<UserVO> getAll();
}
