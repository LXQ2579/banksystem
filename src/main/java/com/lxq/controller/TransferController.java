package com.lxq.controller;

import com.lxq.pojo.JsonResult;
import com.lxq.pojo.User;
import com.lxq.service.TransferService;
import com.lxq.utils.StrUtils;
import com.lxq.vo.TransferVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author 刘小七
 * @date 2019/09/16  11:45:00
 */
@Controller
@RequestMapping(path = "/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping("/transfer.do")
    @ResponseBody
    public JsonResult transfer(String descCardId, Double money, HttpSession session) {
        User sourceUser = (User)session.getAttribute(StrUtils.LOGIN_INFO);
        if(sourceUser == null){
            return new JsonResult(1, "账号失效,请重新登陆");
        }

        transferService.transfer(sourceUser.getCardId(), descCardId, money);


        return new JsonResult(0, "转账成功");
    }
    @RequestMapping("/transferInfo.do")
    @ResponseBody
    public JsonResult transferInfo(@DateTimeFormat(pattern = "yyyy-MM-dd")Date beginTime, @DateTimeFormat(pattern = "yyyy-MM-dd")Date endTime, HttpSession session, Integer page, Integer limit) {
        User user = (User)session.getAttribute(StrUtils.LOGIN_INFO);
        if(user == null){
            return new JsonResult(1, "账号失效,请重新登陆");
        }

        List<TransferVO> list = transferService.transferInfo(user.getId(), beginTime, endTime, page, limit);

        return new JsonResult(0, list);
    }

}
