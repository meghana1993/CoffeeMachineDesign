package com.spiltwise.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EqualShare extends Share {

   public EqualShare(User u, double share) {
      super(u, share);
   }
}
