package com.gkcx.gkcx.controller;

import java.util.Arrays;

import com.gkcx.gkcx.core.bean.PageVo;
import com.gkcx.gkcx.core.bean.QueryCondition;
import com.gkcx.gkcx.core.bean.Resp;
import com.gkcx.gkcx.entity.Prid;
import com.gkcx.gkcx.service.PridService;
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
@RequestMapping("oms/prid")
public class PridController {
    @Autowired
    private PridService pridService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = pridService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    public Resp<Prid> info(@PathVariable("id") Integer id){
		Prid prid = pridService.getById(id);

        return Resp.ok(prid);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    public Resp<Object> save(@RequestBody Prid prid){
		pridService.save(prid);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    public Resp<Object> update(@RequestBody Prid prid){
		pridService.updateById(prid);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    public Resp<Object> delete(@RequestBody Integer[] ids){
		pridService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}
