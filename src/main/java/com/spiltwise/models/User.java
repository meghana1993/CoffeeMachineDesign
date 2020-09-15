package com.spiltwise.models;

import lombok.Getter;

@Getter
public class User {
   private String name;
   private String emailId;
   private String phoneNo;

   public User(String name, String emailId, String phoneNo) {
      this.name = name;
      this.emailId = emailId;
      this.phoneNo = phoneNo;
   }
}
