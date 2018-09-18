package com.walkBAM.service.impl;

import com.walkBAM.dao.SceneryDao;
import com.walkBAM.dao.TicketDao;
import com.walkBAM.service.TicketService;
import com.walkBAM.util.DateSubUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
@AutoConfigureAfter({TicketDao.class})
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDao tdao;

    @Override
    public boolean modifyCar(String id,String sendDate,String endDate) {
        if (tdao.carUpdate(id,sendDate,endDate)>0)
            return true;
        return false;
    }

    @Override
    public boolean modifyTrain(String id,String sendDate,String endDate) {
        if (tdao.trainUpdate(id,sendDate,endDate)>0)
            return true;
        return false;
    }

    @Override
    public boolean modifyPlane(String id,String sendDate,String endDate) {
        if (tdao.planeUpdate(id,sendDate,endDate)>0)
            return true;
        return false;
    }

    @Override
    public void findCar() {
        System.out.println("findCar...");
        List<Map<String, Object>> list = tdao.selectCar(DateSubUtil.getDate(new Date(), 0));
        for (Map<String, Object> map : list) {
            String sendDate = map.get("cc_send").toString();
            String endDate = map.get("cc_end").toString();
            String id = (String) map.get("cc_id");
            System.out.println("1:"+sendDate);
            System.out.println("2"+endDate);
            String sendDate1 = sendDate.substring(0,sendDate.indexOf(" "));
            String sendDate2 = sendDate.substring(sendDate.indexOf(" "));
            String endDate1 = endDate.substring(0,endDate.indexOf(" "));
            String endDate2 = endDate.substring(endDate.indexOf(" "));
            System.out.println("发车时间："+sendDate);
            System.out.println("到达时间："+endDate);
            boolean res = modifyCar(id,DateSubUtil.getDate(sendDate,1)+sendDate2,DateSubUtil.getDate(endDate,1)+endDate2);
            System.out.println("修改成功？："+res);
        }
    }

    @Override
    public void findTrain() {
        System.out.println("findTrain...");
        List<Map<String, Object>> list = tdao.selectTrain(DateSubUtil.getDate(new Date(), 0));
        for (Map<String, Object> map : list) {
            String sendDate = map.get("tc_send").toString();
            String endDate = map.get("tc_end").toString();
            String id = (String) map.get("tc_id");
            System.out.println(sendDate);
            System.out.println(endDate);
            String sendDate1 = sendDate.substring(0,sendDate.indexOf(" "));
            String sendDate2 = sendDate.substring(sendDate.indexOf(" "));
            String endDate1 = endDate.substring(0,endDate.indexOf(" "));
            String endDate2 = endDate.substring(endDate.indexOf(" "));
            System.out.println("发车时间："+sendDate);
            System.out.println("到达时间："+endDate);
            boolean res = modifyTrain(id,DateSubUtil.getDate(sendDate,1)+sendDate2,DateSubUtil.getDate(endDate,1)+endDate2);
            System.out.println("修改成功？："+res);
        }
    }

    @Override
    public void findPlane() {
        System.out.println("findPlane...");
        List<Map<String, Object>> list = tdao.selectPlane(DateSubUtil.getDate(new Date(), 0));
        for (Map<String, Object> map : list) {
            String sendDate = map.get("pc_send").toString();
            String endDate = map.get("pc_end").toString();
            String id = (String) map.get("pc_id");
            System.out.println(sendDate);
            System.out.println(endDate);
            String sendDate1 = sendDate.substring(0,sendDate.indexOf(" "));
            String sendDate2 = sendDate.substring(sendDate.indexOf(" "));
            String endDate1 = endDate.substring(0,endDate.indexOf(" "));
            String endDate2 = endDate.substring(endDate.indexOf(" "));
            System.out.println("发车时间："+sendDate);
            System.out.println("到达时间："+endDate);
            boolean res = modifyPlane(id,DateSubUtil.getDate(sendDate,1)+sendDate2,DateSubUtil.getDate(endDate,1)+endDate2);
            System.out.println("修改成功？："+res);
        }
    }



}
