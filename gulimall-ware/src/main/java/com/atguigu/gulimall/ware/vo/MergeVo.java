package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class MergeVo {

   @NotNull
   private Long purchaseId; //整单id
   private List<Long> items;//[1,2,3,4] //合并项集合
}
