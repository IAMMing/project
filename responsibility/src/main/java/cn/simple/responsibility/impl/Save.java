package cn.simple.responsibility.impl;

import cn.simple.domain.OperationResult;
import cn.simple.domain.PublishFlow;
import cn.simple.flow.ISave;

public class Save extends AbstractResponsibility {
	ISave save;

	public Save(AbstractResponsibility responsibility) {
		super(responsibility);
	}
	public Save(AbstractResponsibility responsibility,PublishFlow flow) {
		super(responsibility);
		super.setFlow(flow);
	}
	@Override
	public OperationResult process() {
		System.out.println("执行保存");
		OperationResult result;
		if (flow != null) {
			save = flow.getSave();
			if (save != null) {
				result = save.save(house);
				if (result != null) {
					return result;
				}
				if (isFinish()) {
					return new OperationResult("验证", "", "发布完成", true);
				}
				if (responsibility != null) {
					return responsibility.process();
				} else {
					result = new OperationResult();
					result.setSuccess(false);
					result.setOperation("保存信息");
					result.setMessage("保存信息失败，位置错误");
					return result;
				}
			}
			result = new OperationResult();
			result.setSuccess(false);
			result.setOperation("保存信息");
			result.setMessage("保存信息失败失败，获取保存对象失败");
			return result;
		} else {
			result = new OperationResult();
			result.setSuccess(false);
			result.setOperation("保存信息");
			result.setMessage("保存信息失败失败，流程获取失败");
			return result;
		}
	}

	@Override
	public boolean isFinish() {
		return true;
	}
}
