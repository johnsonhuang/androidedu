package com.alipay.mobile.educard.vo;

import java.io.Serializable;

public class UserInfo implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 1L;
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
    
    /**
     * 昵称
     */
    private String nick;
    /**
     * 姓名
     */
    private String name;
    /**
     * 账号
     */
    private String account ;
    /**
     * userid
     */
    private String userId ;
    

}
