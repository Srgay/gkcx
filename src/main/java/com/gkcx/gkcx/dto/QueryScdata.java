package com.gkcx.gkcx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class QueryScdata {
    @ApiModelProperty(name = "provincename",value = "生源地",required = false)
    private String provincename;

    @ApiModelProperty(name = "provinceid",value = "学校所在地",required = false)
    private Integer provinceid;

    @ApiModelProperty(name = "typename",value = "文理科",required = false)
    private String typename;

    @ApiModelProperty(name = "batchname",value = "批次",required = false)
    private String batchname;

    @ApiModelProperty(name = "grade",value = "分数",required = false)
    private Integer grade;

    @ApiModelProperty(name = "year",value = "年份",required = false)
    private Integer year;

}
