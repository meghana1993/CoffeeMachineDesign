package com.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class User {
    private int id;
    private String emailId;
    private String name;
    private String mobileNo;

    public User(int id, String emailId, String name, String mobileNo) {
        this.id = id;
        this.emailId = emailId;
        this.name = name;
        this.mobileNo = mobileNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
