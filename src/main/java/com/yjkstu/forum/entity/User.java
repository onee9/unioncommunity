package com.yjkstu.forum.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author yjk
 * @version 1.0
 */
@Data
public class User {

    private String id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private int type;
    private int status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;


}
