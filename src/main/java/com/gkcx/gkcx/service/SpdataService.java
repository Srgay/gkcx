package com.gkcx.gkcx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gkcx.gkcx.core.bean.PageVo;
import com.gkcx.gkcx.core.bean.QueryCondition;
import com.gkcx.gkcx.entity.Spdata;


/**
 *
 *
 * @author jiangli
 * @since  2020-04-04 18:37:50
 */
public interface SpdataService extends IService<Spdata> {

    PageVo queryPage(QueryCondition params);
}

