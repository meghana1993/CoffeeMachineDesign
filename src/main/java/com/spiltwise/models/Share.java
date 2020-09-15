package com.spiltwise.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Share {
   private String shareid;
   private User shareOwner;
   private double share;

   public Share(User u, double share) {
      this.shareid = UUID.randomUUID().toString();
      this.shareOwner = u;
      this.share = share;
   }
}
