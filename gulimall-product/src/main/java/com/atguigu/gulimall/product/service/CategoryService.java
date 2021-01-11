package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author rhf
 * @email 1028623847@qq.com
 * @date 2020-11-06 15:54:02
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<CategoryEntity> listWithTree();

    void removeByMenus(List<Long> longs);

    Long[] findCatelogPath(Long catelogId);

    void updateCascade(CategoryEntity category);
}

