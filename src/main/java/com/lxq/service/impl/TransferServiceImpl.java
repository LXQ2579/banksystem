package com.lxq.service.impl;

import com.github.pagehelper.PageHelper;
import com.lxq.mapper.TransferMapper;
import com.lxq.mapper.UserMapper;
import com.lxq.pojo.Transfer;
import com.lxq.pojo.User;
import com.lxq.service.TransferService;
import com.lxq.vo.TransferVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 刘小七
 * @date 2019/09/20  10:14:00
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TransferMapper transferMapper;

    @Override
    public void transfer(String sourceCardId, String descCardId, Double money) {

        User sourceUser = userMapper.findByCardId(sourceCardId);
        User descUser = userMapper.findByCardId(descCardId);
        if (sourceCardId.equals(descCardId)) {
            throw new RuntimeException("转账卡号不能相同");
        }
        if (descUser == null) {
            throw new RuntimeException("转账卡号不存在");
        }
        if (sourceUser.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }

        Transfer sourceTransfer = new Transfer();
        sourceTransfer.setUid(sourceUser.getId());
        sourceTransfer.setMoney(-money);
        sourceTransfer.setBalance(sourceUser.getBalance() - money);
        sourceTransfer.setTradeType("转账");
        transferMapper.add(sourceTransfer);
        sourceUser.setBalance(sourceUser.getBalance() - money);
        userMapper.updateBalance(sourceUser);

        Transfer descTransfer = new Transfer();
        descTransfer.setUid(descUser.getId());
        descTransfer.setMoney(money);
        descTransfer.setBalance(descUser.getBalance() + money);
        descTransfer.setTradeType("转账");
        transferMapper.add(descTransfer);
        descUser.setBalance(descUser.getBalance() + money);
        userMapper.updateBalance(descUser);


    }

    @Override
    public List<TransferVO> transferInfo(Integer uid, Date beginTime, Date endTime, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TransferVO> list = transferMapper.findAll(uid, beginTime, endTime);
        return list;
    }
}
