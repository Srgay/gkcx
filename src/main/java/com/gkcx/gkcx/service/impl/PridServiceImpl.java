package com.gkcx.gkcx.service.impl;

import com.gkcx.gkcx.core.bean.PageVo;
import com.gkcx.gkcx.core.bean.Query;
import com.gkcx.gkcx.core.bean.QueryCondition;
import com.gkcx.gkcx.dao.PridDao;
import com.gkcx.gkcx.entity.Prid;
import com.gkcx.gkcx.service.PridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("pridService")
public class PridServiceImpl extends ServiceImpl<PridDao, Prid> implements PridService {

    @Autowired
    private PridDao pridDao;

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<Prid> page = this.page(
                new Query<Prid>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}
