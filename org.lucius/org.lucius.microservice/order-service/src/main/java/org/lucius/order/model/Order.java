package org.lucius.order.model;

import java.math.BigDecimal;

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
public class Order {
	
	private Long id;
	private String orderNo;
	private BigDecimal amount;

}
