package cn.simple.flow.impl;

import cn.simple.domain.OperationResult;
import cn.simple.flow.IPay;

public class Alipay implements IPay {

	@Override
	public OperationResult executePay() {
		return new OperationResult("支付","","支付成功",true);
	}

	@Override
	public boolean callback() {
		return false;
	}

}
