package cn.simple.responsibility.impl;

import cn.simple.domain.OperationResult;
import cn.simple.domain.PublishFlow;
import cn.simple.flow.IAD;

public class AD extends AbstractResponsibility {
	IAD ad;

	public AD(AbstractResponsibility responsibility, PublishFlow publishFlow) {
		super(responsibility);
		super.setFlow(publishFlow);
	}

	@Override
	public OperationResult process() {
		System.out.println("执行广告");
		OperationResult result;
		if (flow != null) {
			ad = flow.getAd();
			if (ad != null) {
				result = ad.effect();
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
				return new OperationResult("广告", "", "流程中断", false);
			}
		} else {
			result = new OperationResult();
			result.setSuccess(false);
			result.setOperation("添加广告");
			result.setMessage("添加广告失败，流程获取失败");
			return result;
		}
	}

	@Override
	public boolean isFinish() {
		// TODO Auto-generated method stub
		return false;
	}

}
