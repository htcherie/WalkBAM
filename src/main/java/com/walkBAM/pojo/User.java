package com.walkBAM.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable,Cloneable {
    private Integer u_id;
    private String u_name;
    private String u_nickname;
    private String u_password;
    private Integer u_root;
    private String u_phone;
    private String u_idcard;
    private Integer u_cert;
}
