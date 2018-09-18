package com.walkBAM.service.impl;

import com.walkBAM.dao.StatisDao;
import com.walkBAM.dao.TicketDao;
import com.walkBAM.service.StatisService;
import com.walkBAM.util.DateSubUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@AutoConfigureAfter({StatisDao.class})
public class StatisServiceImpl implements StatisService {

    @Autowired
    private StatisDao sdao;

    @Override
    public Integer findPending() {
        return sdao.selectPending();
    }

    @Override
    public Double findTotal(Date date,int amount) {
        return sdao.selectTotal(DateSubUtil.getDate(date,amount));
    }

    @Override
    public List<Double> findTotal() {
        List<Double> list = new ArrayList();
        for (int i = -6; i<=0;i++){
            list.add(findTotal(new Date(),i));
        }
        return list;
    }

    @Override
    public Integer findOrders(Date date,int amount) {
        return sdao.selectOrderByEveryDay(DateSubUtil.getDate(date,amount));
    }

    @Override
    public List<Integer> findOrders() {
        List<Integer> list = new ArrayList();
        for (int i = -6; i<=0;i++){
            list.add(findOrders(new Date(),i));
        }
        return list;
    }

    @Override
    public List<String> findWeeks() {
        List<String> list = new ArrayList();
        for (int i = -6; i<=0;i++){
            list.add(DateSubUtil.getDate(new Date(),i));
        }
        return list;
    }
}
