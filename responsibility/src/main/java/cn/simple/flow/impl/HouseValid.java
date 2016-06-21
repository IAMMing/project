package cn.simple.flow.impl;

import org.apache.commons.lang.StringUtils;

import cn.simple.domain.HouseInfo;
import cn.simple.domain.OperationResult;
import cn.simple.flow.IValid;

public class HouseValid implements IValid {
	HouseInfo house;

	public void setHouse(HouseInfo info) {
		this.house = info;
	}

	@Override
	public OperationResult valid(HouseInfo house) {
		this.house=house;
		return validId();
	}

	@Override
	public OperationResult validId() {
		// 如果id满足执行标题验证
		if (StringUtils.isEmpty(house.getTitle())) {
			return new OperationResult("验证", "title", "标题不能为空", false);
		} else {
			return validTitle();
		}
	}

	@Override
	public OperationResult validTitle() {

		return validAddress();
	}

	@Override
	public OperationResult validAddress() {
		// TODO Auto-generated method stub
		return validAmount();
	}

	@Override
	public OperationResult validAmount() {
		// TODO Auto-generated method stub
		return validArea();
	}

	@Override
	public OperationResult validArea() {
		// TODO Auto-generated method stub
		return validCity();
	}

	@Override
	public OperationResult validCity() {
		// TODO Auto-generated method stub
		return validContractMobile();
	}

	@Override
	public OperationResult validContractMobile() {
		// TODO Auto-generated method stub
		return validDecorate();
	}

	@Override
	public OperationResult validDecorate() {
		// TODO Auto-generated method stub
		return validDistrict();
	}

	@Override
	public OperationResult validDistrict() {
		// TODO Auto-generated method stub
		return validFloor();
	}

	@Override
	public OperationResult validFloor() {
		// TODO Auto-generated method stub
		return validHall();
	}

	@Override
	public OperationResult validHall() {
		// TODO Auto-generated method stub
		return validHouseType();
	}

	@Override
	public OperationResult validHouseType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationResult validRenovation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationResult validRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationResult validVillige() {
		return null;
	}

}
