package com.gkcx.gkcx.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gkcx.gkcx.entity.Spdata;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author jiangli
 * @since  2020-04-04 18:37:50
 */
@Mapper
@Component
public interface SpdataDao extends BaseMapper<Spdata> {

}
