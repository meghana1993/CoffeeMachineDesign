package com.spiltwise.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercentShare extends Share {

   private double percent;

   public PercentShare(User u, double percent, double totalAmount) {
      super(u, (totalAmount * percent) / 100);
      this.percent = percent;
   }

}
