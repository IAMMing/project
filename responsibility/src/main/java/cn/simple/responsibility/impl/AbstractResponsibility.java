package cn.simple.responsibility.impl;

import cn.simple.domain.HouseInfo;
import cn.simple.domain.OperationResult;
import cn.simple.domain.PublishFlow;
import cn.simple.responsibility.IResponsibility;

/**
 * 流程模块的抽象类
 * 
 * @author ldm
 * @Date 2016年6月21日
 */
public abstract class AbstractResponsibility implements IResponsibility {
	protected AbstractResponsibility responsibility;
	protected PublishFlow flow;
	protected HouseInfo house;

	public AbstractResponsibility(AbstractResponsibility responsibility) {
		this.responsibility = responsibility;
	}

	public PublishFlow getFlow() {
		return flow;
	}

	public void setFlow(PublishFlow flow) {
		this.flow = flow;
	}

	public HouseInfo getHouse() {
		return house;
	}

	public void setHouse(HouseInfo house) {
		this.house = house;
	}

	public abstract OperationResult process();
	public abstract boolean isFinish();

}
