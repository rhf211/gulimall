package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author rhf
 * @email 1028623847@qq.com
 * @date 2020-11-09 10:20:22
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
