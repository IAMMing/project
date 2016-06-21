package cn.simple.responsibility.impl;

import cn.simple.domain.OperationResult;
import cn.simple.domain.PublishFlow;
import cn.simple.flow.IValid;

public class ValidHouse extends AbstractResponsibility {
	IValid valid;

	public ValidHouse(AbstractResponsibility responsibility, PublishFlow publishFlow) {
		super(responsibility);
		super.setFlow(publishFlow);
	}

	@Override
	public OperationResult process() {
		System.out.println("执行验证");
		OperationResult result;
		if (flow != null) {
			valid = flow.getValidHouse();
			if (valid != null) {
				
				result = valid.valid(house);
				if (result != null && !result.isSuccess()) {
					return result;
				}
			}
			if(isFinish())
			{
				return new OperationResult("验证", "", "发布完成", true);
			}
			if (responsibility != null) {
				return responsibility.process();
			} else {
				result = new OperationResult();
				result.setSuccess(false);
				result.setOperation("信息验证");
				result.setMessage("流程中断");
				return result;
			}
		} else {
			result = new OperationResult();
			result.setSuccess(false);
			result.setOperation("信息验证");
			result.setMessage("验证失败，流程获取失败");
			return result;
		}

	}

	@Override
	public boolean isFinish() {
		// TODO Auto-generated method stub
		return false;
	}
}
