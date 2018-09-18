package com.walkBAM.service;

import java.util.List;
import java.util.Map;

public interface TicketService {
    public boolean modifyCar(String id,String sendDate,String endDate);

    public boolean modifyTrain(String id,String sendDate,String endDate);

    public boolean modifyPlane(String id,String sendDate,String endDate);

    public void findCar();

    public void findTrain();

    public void findPlane();
}
