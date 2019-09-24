package com.lxq.controller;

import com.lxq.pojo.JsonResult;
import com.lxq.pojo.User;
import com.lxq.service.UserService;
import com.lxq.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 刘小七
 * @date 2019/09/16  11:45:00
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(String cardId, String password, HttpSession session) {

        User user = userService.login(cardId, password);

        session.setAttribute(StrUtils.LOGIN_INFO, user);

        return new JsonResult(0, user);
    }

    @RequestMapping("/showBalance.do")
    @ResponseBody
    public JsonResult showBalance(HttpSession session) {

        User user = (User) session.getAttribute(StrUtils.LOGIN_INFO);
        if(user == null){
            return new JsonResult(1, "账号失效,请重新登陆");
        }

        Double balance = userService.findBalance(user.getCardId());

        return new JsonResult(0, balance);
    }


    @RequestMapping("/quit.do")
    public String quit(HttpSession session) {
        session.removeAttribute(StrUtils.LOGIN_INFO);

        return "redirect:/login.html";
    }

    @RequestMapping("/changePassword")
    @ResponseBody
    public JsonResult changePassword(String oldPassword, String newPassword, HttpSession session) {
        User user = (User) session.getAttribute(StrUtils.LOGIN_INFO);
        if(user == null){
            return new JsonResult(1, "账号失效,请重新登陆");
        }
        userService.changePassword(user.getCardId(), oldPassword, newPassword);
        return new JsonResult(0, "密码修改成功,请重新登陆!");
    }

    @RequestMapping("/getLoginName.do")
    @ResponseBody
    public JsonResult login(HttpSession session) {

        User user = (User) session.getAttribute(StrUtils.LOGIN_INFO);
        if(user == null){
            return new JsonResult(1, "账号失效,请重新登陆");
        }

        return new JsonResult(0, user);
    }
}
