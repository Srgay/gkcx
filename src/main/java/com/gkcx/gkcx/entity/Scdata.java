package com.gkcx.gkcx.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author jiangli
 * @since 2020-04-04 18:37:50
 */
@ApiModel
@Data
@TableName("scdata")
public class Scdata implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "")
	private Integer id;
	/**
	 *
	 */
	@ApiModelProperty(name = "schoolid",value = "")
	private Integer schoolid;
	/**
	 *
	 */
	@ApiModelProperty(name = "provinceid",value = "")
	private Integer provinceid;
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
	@ApiModelProperty(name = "max",value = "")
	private Integer max;
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
