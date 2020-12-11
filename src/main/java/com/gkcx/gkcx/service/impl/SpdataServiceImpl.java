package com.gkcx.gkcx.service.impl;

import com.gkcx.gkcx.core.bean.PageVo;
import com.gkcx.gkcx.core.bean.Query;
import com.gkcx.gkcx.core.bean.QueryCondition;
import com.gkcx.gkcx.dao.SpdataDao;
import com.gkcx.gkcx.entity.Spdata;
import com.gkcx.gkcx.service.SpdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("spdataService")
public class SpdataServiceImpl extends ServiceImpl<SpdataDao, Spdata> implements SpdataService {

    @Autowired
    private SpdataDao spdataDao;

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<Spdata> page = this.page(
                new Query<Spdata>().getPage(params),
                new QueryWrapper<>()
        );
        return new PageVo(page);
    }

}
