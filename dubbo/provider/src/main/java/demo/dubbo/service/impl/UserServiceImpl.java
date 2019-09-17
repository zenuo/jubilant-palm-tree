package demo.dubbo.service.impl;

import demo.dubbo.model.UserVO;
import demo.dubbo.service.UserService;

import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<UserVO> getAll() {
        return Collections.singletonList(UserVO.builder().id(1).name("Tom").build());
    }
}
