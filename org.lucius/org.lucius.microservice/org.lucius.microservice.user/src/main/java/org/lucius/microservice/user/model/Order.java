package org.lucius.microservice.user.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@Accessors( chain = true )
@ToString
@ApiModel(value = "订单信息")
public class Order {
	
	@ApiModelProperty(value = "订单ID",
            example = "14724798216321",
            required = true)
	private Long id;
	@ApiModelProperty(value = "订单编号",
            example = "b1efd74ca40b466f84e20c12df6b76f2",
            required = true)
	private String orderNo;
	@ApiModelProperty(value = "订单金额",
            example = "11.00",
            required = true)
	private BigDecimal amount;
	
}
