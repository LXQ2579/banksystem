package com.lxq.service;

import com.lxq.vo.TransferVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author 刘小七
 * @date 2019/09/20  10:11:00
 */
public interface TransferService {

    void transfer(String sourceCode, String descCode, Double money);

    List<TransferVO> transferInfo(Integer uid, Date beginTime, Date endTime, Integer page, Integer limit);
}
