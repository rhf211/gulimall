package com.atguigu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> list = baseMapper.selectList(null);

        List<CategoryEntity> list1 = list
                .stream()
                .filter(a -> a.getParentCid() == 0)
                .map(categoryEntity ->
                        getChilrden(categoryEntity, list)
                ).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))
                )
                .collect(Collectors.toList());
        return list1;
    }

    @Override
    public void removeByMenus(List<Long> longs) {
        //这里做逻辑操作
        baseMapper.deleteBatchIds(longs);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {

        List<Long> paths = new ArrayList<>();
        findParentPath(catelogId, paths);
        Collections.reverse(paths);
        return paths.toArray(new Long[paths.size()]);
    }

    private void findParentPath(Long catelogId, List<Long> paths) {
        paths.add(catelogId);
        CategoryEntity categoryEntity = this.getById(catelogId);
        if (categoryEntity.getParentCid() != 0) {
            findParentPath(categoryEntity.getParentCid(), paths);
        }
    }

    //递归查找所有菜单的子菜单
    public CategoryEntity getChilrden(CategoryEntity entity, List<CategoryEntity> list) {
        List<CategoryEntity> chrilrden = list
                .stream()
                .filter(ca -> ca.getParentCid().equals(entity.getCatId()))
                .map(li -> getChilrden(li, list))
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))
                )
                .collect(Collectors.toList());

        entity.setChildren(chrilrden);
        return entity;
    }
}