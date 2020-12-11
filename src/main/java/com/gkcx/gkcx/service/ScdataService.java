package com.gkcx.gkcx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gkcx.gkcx.core.bean.PageVo;
import com.gkcx.gkcx.core.bean.QueryCondition;
import com.gkcx.gkcx.dto.QueryScdata;
import com.gkcx.gkcx.entity.Scdata;


/**
 *
 *
 * @author jiangli
 * @since  2020-04-04 18:37:50
 */
public interface ScdataService extends IService<Scdata> {

    PageVo queryPage(QueryCondition params, QueryScdata queryScdata);
}

