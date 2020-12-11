package com.gkcx.gkcx.controller;

import com.gkcx.gkcx.core.bean.Resp;
import com.gkcx.gkcx.entity.Spdata;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@Api(tags =" 更新")
@RestController
public class UpdataController {
    public static String updataurl="www.baidu.com";
    public static UpdataRep updataRep=new UpdataRep();
    @ApiOperation("更新")
    @GetMapping("/updata")
    public UpdataRep updata(UpdataRes updataRes) {
        if (updataRes.getVersion()<UpdataController.updataRep.getVersion()){
            return UpdataController.updataRep;
        }else{
            UpdataRep updataRep=new UpdataRep();
            updataRep.setStatus("0");
            return updataRep;
        }
    }
    @ApiOperation("发布更新")
    @GetMapping("/updata/publish")
    public UpdataRep publishUpdata(UpdataRep updataRep) {
        UpdataController.updataRep.setStatus(updataRep.getStatus());
        UpdataController.updataRep.setNote(updataRep.getNote());
        UpdataController.updataRep.setUrl(updataRep.getUrl());
        UpdataController.updataRep.setVersion(updataRep.version);
        return UpdataController.updataRep;
    }
    @Data
    class UpdataRes  implements Serializable {
        private String appid="";
        private int version=0;
    }
    @Data
    static class UpdataRep implements Serializable {
        private String status = "0";
        private String note = "";
        private String url = "";
        private int version=0;
    }
}
