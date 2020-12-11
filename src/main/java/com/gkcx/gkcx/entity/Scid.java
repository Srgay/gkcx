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
@TableName("scid")
public class Scid implements Serializable {
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
	@ApiModelProperty(name = "name",value = "")
	private String name;

}
