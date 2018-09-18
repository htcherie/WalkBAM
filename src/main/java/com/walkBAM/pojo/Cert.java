package com.walkBAM.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Cert implements Serializable,Cloneable{
    private Integer certid;
    private String certT;

}
