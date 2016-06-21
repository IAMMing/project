package cn.simple.responsibility.impl;

import cn.simple.domain.OperationResult;
import cn.simple.domain.PublishFlow;
import cn.simple.flow.IPay;

public class Pay extends AbstractResponsibility {
	IPay pay;

	public Pay(AbstractResponsibility responsibility, PublishFlow publishFlow) {
		super(responsibility);
		super.setFlow(publishFlow);
	}

	@Override
	public OperationResult process() {
		System.out.println("执行支付");
		OperationResult result;
		if (flow != null) {
			pay = flow.getPay();
			if (pay != null) {
				result = pay.executePay();
				if (result != null && !result.isSuccess()) {
					return result;
				}
			}
			if (isFinish()) {
				return new OperationResult("验证", "", "发布完成", true);
			}
			if (responsibility != null) {
				return responsibility.process();
			} else {
				return new OperationResult("支付", "", "支付成功，发房失败，信息流中断", false);
			}
		} else {
			result = new OperationResult();
			result.setSuccess(false);
			result.setOperation("支付");
			result.setMessage("支付失败，流程获取失败");
			return result;
		}
	}

	@Override
	public boolean isFinish() {
		// TODO Auto-generated method stub
		return false;
	}

}
