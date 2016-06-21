package cn.simple.flow;

import cn.simple.domain.HouseInfo;
import cn.simple.domain.OperationResult;

/**
 * 验证接口
 * 
 * @author ldm
 * @Date 2016年6月21日
 */
public interface IValid {
	/**
	 * 验证总入口
	 * @author ldm
	 * @Date 2016年6月21日
	 * @return
	 */
	OperationResult valid(HouseInfo house);
	
	OperationResult validId();

	/**
	 * 验证标题
	 * 
	 * @author ldm
	 * @Date 2016年6月21日
	 * @return
	 */
	OperationResult validTitle();

	OperationResult validAddress();

	OperationResult validAmount();

	OperationResult validArea();

	OperationResult validCity();

	OperationResult validContractMobile();

	OperationResult validDecorate();

	OperationResult validDistrict();

	OperationResult validFloor();

	OperationResult validHall();

	OperationResult validHouseType();

	OperationResult validRenovation();

	OperationResult validRoom();

	OperationResult validVillige();

}
