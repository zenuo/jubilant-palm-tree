package demo.dubbo.service;

import demo.dubbo.model.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> getAll();
}
