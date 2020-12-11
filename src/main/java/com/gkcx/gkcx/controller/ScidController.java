package com.gkcx.gkcx.controller;

import java.util.Arrays;

import com.gkcx.gkcx.core.bean.PageVo;
import com.gkcx.gkcx.core.bean.QueryCondition;
import com.gkcx.gkcx.core.bean.Resp;
import com.gkcx.gkcx.entity.Scid;
import com.gkcx.gkcx.service.ScidService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author jiangli
 * @since  2020-04-04 18:37:50
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("oms/scid")
public class ScidController implements ApplicationContextAware {
    @Autowired
    private ScidService scidService;
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext正在初始化,application:");
        this.applicationContext=applicationContext;
    }

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = scidService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    public Resp<Scid> info(@PathVariable("id") Integer id){
		Scid scid = scidService.getById(id);

        return Resp.ok(scid);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    public Resp<Object> save(@RequestBody Scid scid){
		scidService.save(scid);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    public Resp<Object> update(@RequestBody Scid scid){
		scidService.updateById(scid);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    public Resp<Object> delete(@RequestBody Integer[] ids){
		scidService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
