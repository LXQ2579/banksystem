package com.lxq.service.impl;

import com.lxq.mapper.UserMapper;
import com.lxq.pojo.User;
import com.lxq.redis.RedisService;
import com.lxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘小七
 * @date 2019/09/16  11:43:00
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired(required = false)
    private RedisService redisService;

    @Override
    public User login(String cardId, String password) {
        User user = userMapper.findByCardId(cardId);
        if (user == null){
            throw new RuntimeException("卡号错误");
        }

        if (!password.equals(user.getPassword())){
            throw new RuntimeException("密码错误");
        }
        return user;
    }

    @Override
    public Double findBalance(String cardId) {
        Double balance = redisService.getBalance("balance", cardId);
        if (balance != null){
            return balance;
        }
        User user = userMapper.findByCardId(cardId);
        if (user == null){
            throw new RuntimeException("卡号错误");
        }

        redisService.setBalance("balance", cardId, user.getBalance());

        System.out.println(user.getBalance());
        return user.getBalance();
    }

    @Override
    public void changePassword(String cardId, String oldPassword, String newPassword) {
        User user = userMapper.findByCardId(cardId);
        if (user == null){
            throw new RuntimeException("卡号错误");
        }

        if (!oldPassword.equals(user.getPassword())){
            throw new RuntimeException("原密码输入错误");
        }
        userMapper.updatePassword(cardId, newPassword);
    }


}
