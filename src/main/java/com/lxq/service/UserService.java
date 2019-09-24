package com.lxq.service;

import com.lxq.pojo.User;

/**
 * @author 刘小七
 * @date 2019/09/16  11:43:00
 */
public interface UserService {

    User login(String cardId, String password);

    Double findBalance(String cardId);

    void changePassword(String cardId, String oldPassword, String newPassword);
}
