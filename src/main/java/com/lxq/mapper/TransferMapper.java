package com.lxq.mapper;

import com.lxq.pojo.Transfer;
import com.lxq.vo.TransferVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author 刘小七
 * @date 2019/09/20  09:54:00
 */
public interface TransferMapper {

    void add(Transfer transfer);

    List<TransferVO> findAll(@Param("uid")Integer uid, @Param("beginTime") Date beginTime, @Param("endTime")Date endTime);

}
