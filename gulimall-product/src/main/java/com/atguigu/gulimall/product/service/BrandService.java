package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author rhf
 * @email 1028623847@qq.com
 * @date 2020-11-06 15:54:02
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryList(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

