package com.walkBAM.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatisDao {
    /**
     * 查询每日订单数
     * @param date
     * @return
     */
    public Integer selectOrderByEveryDay(@Param("date")String date);

    /**
     * 查询每日待处理的事件
     * @param
     * @return
     */
    public Integer selectPending();

    /**
     * 查询昨日交易总金额
     * @param date
     * @return
     */
    public Double selectTotal(@Param("date")String date);
 }
