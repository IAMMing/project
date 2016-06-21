package cn.simple.flow.impl;

import cn.simple.domain.OperationResult;
import cn.simple.flow.IAD;

public class BannerAD implements IAD {

	@Override
	public OperationResult effect() {
		return new OperationResult("广告", "", "添加广告成功", true);
	}
}
