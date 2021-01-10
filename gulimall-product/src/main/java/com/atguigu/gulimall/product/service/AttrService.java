package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.vo.AttrGroupRelationVo;
import com.atguigu.gulimall.product.vo.AttrRespVo;
import com.atguigu.gulimall.product.vo.AttrVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.AttrEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author rhf
 * @email 1028623847@qq.com
 * @date 2020-11-06 15:54:02
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    void saveAttr(AttrVo attr);

    AttrRespVo getAttrInfo(Long attrId);


    void updateAttr(AttrVo attr);

    void deleteRelation(AttrGroupRelationVo[] vos);
}

