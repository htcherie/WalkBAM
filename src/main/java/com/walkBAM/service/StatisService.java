package com.walkBAM.service;

import java.util.Date;
import java.util.List;

public interface StatisService {
    /**
     * 查询代办事项
     * @return
     */
    public Integer findPending();

    /**
     * 查询单个（天）总金额
     * @return
     */
    public Double findTotal(Date date,int amount);

    /**
     * 查询历史7天每天的总金额，并存进list
     * @return
     */
    public List<Double> findTotal();

    /**
     * 查询单个（天）的订单数
     * @return
     */
    public Integer findOrders(Date date,int amount);

    /**
     * 查询历史7天每天的总金额，并存进list
     * @return
     */
    public List<Integer> findOrders();

    /**
     * 过去一周（包括今天）
     * @return
     */
    public List<String> findWeeks();
}
