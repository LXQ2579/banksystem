package com.lxq.mapper;

import com.lxq.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 刘小七
 * @date 2019/09/16  11:42:00
 */
public interface UserMapper {

    User findByCardId(String cardId);

    void updatePassword(@Param("cardId") String cardId, @Param("password") String newPassword);

    void updateBalance(User user);


}
