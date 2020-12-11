package com.gkcx.gkcx.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author jiangli
 * @since 2020-04-04 18:37:50
 */
@ApiModel
@Data
public class ScdataDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@ApiModelProperty(name = "name",value = "")
	private String name;
	/**
	 *
	 */
	@ApiModelProperty(name = "provincename",value = "")
	private String provincename;
	/**
	 *
	 */
	@ApiModelProperty(name = "typename",value = "")
	private String typename;
	/**
	 *
	 */
	@ApiModelProperty(name = "batchname",value = "")
	private String batchname;
	/**
	 *
	 */
	@ApiModelProperty(name = "min",value = "")
	private Integer min;
	/**
	 *
	 */
	@ApiModelProperty(name = "year",value = "")
	private Integer year;

}
