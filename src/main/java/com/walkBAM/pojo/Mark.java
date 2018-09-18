package com.walkBAM.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Mark implements Serializable,Cloneable{
    /**
     * 商家ID
     */
    private int m_id;
    /**
     * 商家名称
     */
    private String m_name;
    /**
     * 商家地址
     */
    private String m_address;
    /**
     * 商家联系电话
     */
    private String m_phone;
    /**
     * 商家法人
     */
    private Integer u_id;
    /**
     * 状态
     */
    private Integer m_state;
}
