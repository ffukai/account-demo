package com.chd.account.service.impl;

import com.chd.account.dao.UserDao;
import com.chd.account.model.MyResult;
import com.chd.account.model.User;
import com.chd.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public MyResult login(User user) {
        User u = new User();
        List<User> userList = new ArrayList<User>();
        userList = userDao.login(user);
        MyResult myResult = new MyResult();
        if (userList.size() != 0){
            myResult.setCode(0);
            myResult.setList(userList);
            myResult.setMsg("登陆成功！");
            myResult.setObject(userList.get(0));
        }else {
            myResult.setCode(1);
            myResult.setMsg("登陆失败！");

        }
        return myResult;
    }
}
