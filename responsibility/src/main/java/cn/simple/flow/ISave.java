package cn.simple.flow;

import cn.simple.domain.HouseInfo;
import cn.simple.domain.OperationResult;

/**
 * 保存房源信息
 * 
 * @author ldm
 * @Date 2016年6月21日
 */
public interface ISave {
	OperationResult save(HouseInfo info);
}
