package com.walkBAM.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
public class Scenery implements Serializable,Cloneable {
    private Integer s_id;
    private Integer s_city;
    private double s_num;
    private Integer m_id;
    private String s_title;
    private String s_txt;
    private String s_img;
    private String s_fmImg;
    private Integer s_click;
    private double s_price;
    private double s_price_yuan;
    private Integer s_state;
    private Date s_audit;
}
