package com.gkcx.gkcx.service.impl;

import com.gkcx.gkcx.core.bean.PageVo;
import com.gkcx.gkcx.core.bean.Query;
import com.gkcx.gkcx.core.bean.QueryCondition;
import com.gkcx.gkcx.dao.ScidDao;
import com.gkcx.gkcx.entity.Scid;
import com.gkcx.gkcx.service.ScidService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("scidService")
public class ScidServiceImpl extends ServiceImpl<ScidDao, Scid> implements ScidService, ApplicationContextAware {
    private ApplicationContext applicationContext;

    public ScidServiceImpl() {
        System.out.println("sv");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext正在初始化,application:");
        this.applicationContext=applicationContext;
    }
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<Scid> page = this.page(
                new Query<Scid>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageVo(page);
    }

}
