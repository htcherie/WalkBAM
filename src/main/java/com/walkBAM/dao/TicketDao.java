package com.walkBAM.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TicketDao {
    public int carUpdate(@Param("id") String id,@Param("sendDate") String sendDate,@Param("endDate") String endDate);

    public int trainUpdate(@Param("id") String id,@Param("sendDate") String sendDate,@Param("endDate") String endDate);

    public int planeUpdate(@Param("id") String id,@Param("sendDate") String sendDate,@Param("endDate") String endDate);

    public List<Map<String, Object>> selectCar(@Param("nowDate") String nowDate);

    public List<Map<String, Object>> selectTrain(@Param("nowDate") String nowDate);

    public List<Map<String, Object>> selectPlane(@Param("nowDate") String nowDate);
}
