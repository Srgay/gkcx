package com.gkcx.gkcx.service.impl;

import com.gkcx.gkcx.core.bean.PageVo;
import com.gkcx.gkcx.core.bean.Query;
import com.gkcx.gkcx.core.bean.QueryCondition;
import com.gkcx.gkcx.dao.ScdataDao;
import com.gkcx.gkcx.dto.QueryScdata;
import com.gkcx.gkcx.entity.Scdata;
import com.gkcx.gkcx.service.ScdataService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("scdataService")
public class ScdataServiceImpl extends ServiceImpl<ScdataDao, Scdata> implements ScdataService {

    @Override
    public PageVo queryPage(QueryCondition params, QueryScdata queryScdata) {
        IPage<Scdata> page = this.page(
                new Query<Scdata>().getPage(params),
                new QueryWrapper<Scdata>().lambda()
                        .eq(Scdata::getProvincename, queryScdata.getProvincename())
                        .eq(Scdata::getProvinceid, queryScdata.getProvinceid())
                        .eq(Scdata::getTypename, queryScdata.getTypename())
                        .eq(Scdata::getBatchname, queryScdata.getBatchname())
                        .eq(Scdata::getYear, queryScdata.getYear())
                        .le(Scdata::getMin, queryScdata.getGrade() + 10)
                        .ge(Scdata::getMin, queryScdata.getGrade() - 10)
                        .orderByDesc(Scdata::getMin)
        );

        return new PageVo(page);
    }

}
