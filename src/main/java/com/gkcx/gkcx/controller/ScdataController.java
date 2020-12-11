package com.gkcx.gkcx.controller;

import java.util.Arrays;


import com.gkcx.gkcx.core.bean.PageVo;
import com.gkcx.gkcx.core.bean.QueryCondition;
import com.gkcx.gkcx.core.bean.Resp;
import com.gkcx.gkcx.dto.QueryScdata;
import com.gkcx.gkcx.entity.Scdata;
import com.gkcx.gkcx.service.ScdataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author jiangli
 * @since  2020-04-04 18:37:50
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("oms/scdata")
public class ScdataController {
    @Autowired
    private ScdataService scdataService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    public Resp<PageVo> list(QueryCondition queryCondition, QueryScdata queryScdata) {
        PageVo page = scdataService.queryPage(queryCondition,queryScdata);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    public Resp<Scdata> info(@PathVariable("id") Integer id){
		Scdata scdata = scdataService.getById(id);

        return Resp.ok(scdata);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    public Resp<Object> save(@RequestBody Scdata scdata){
		scdataService.save(scdata);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    public Resp<Object> update(@RequestBody Scdata scdata){
		scdataService.updateById(scdata);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    public Resp<Object> delete(@RequestBody Integer[] ids){
		scdataService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
