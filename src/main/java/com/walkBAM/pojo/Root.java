package com.walkBAM.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Root implements Serializable,Cloneable{
    private Integer root_id;
    private String root_T;

}
