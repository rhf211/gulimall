package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author rhf
 * @email 1028623847@qq.com
 * @date 2020-11-09 10:28:09
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
