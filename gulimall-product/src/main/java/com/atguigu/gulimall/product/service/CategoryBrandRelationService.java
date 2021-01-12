package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryBrandRelationEntity;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author rhf
 * @email 1028623847@qq.com
 * @date 2020-11-06 15:54:02
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<BrandEntity> getBrandsByCatId(Long catId);

    void updateBrand(Long brandId, @NotEmpty(message = "品牌名必须填写") String name);

    void updateCategory(Long catId, String name);
}

