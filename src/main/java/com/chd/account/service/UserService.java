package com.chd.account.service;

import com.chd.account.model.MyResult;
import com.chd.account.model.User;

public interface UserService {

    MyResult login(User user);
}
