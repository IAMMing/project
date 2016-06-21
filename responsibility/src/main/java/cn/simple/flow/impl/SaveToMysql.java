package cn.simple.flow.impl;

import cn.simple.domain.HouseInfo;
import cn.simple.domain.OperationResult;
import cn.simple.flow.ISave;

public class SaveToMysql  implements ISave{

	@Override
	public OperationResult save(HouseInfo info) {
		return new OperationResult("", "", "保存成功", true);
	}

}
