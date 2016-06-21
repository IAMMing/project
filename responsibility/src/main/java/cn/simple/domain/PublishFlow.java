package cn.simple.domain;

import cn.simple.flow.IAD;
import cn.simple.flow.IPay;
import cn.simple.flow.ISave;
import cn.simple.flow.IValid;

/**
 * 发布流程
 * 
 * @author ldm
 * @Date 2016年6月21日
 */
public class PublishFlow {
	private IValid validHouse;
	private IAD ad;
	private IPay pay;
	private ISave save;
	public IValid getValidHouse() {
		return validHouse;
	}
	public void setValidHouse(IValid validHouse) {
		this.validHouse = validHouse;
	}
	public IAD getAd() {
		return ad;
	}
	public void setAd(IAD ad) {
		this.ad = ad;
	}
	public IPay getPay() {
		return pay;
	}
	public void setPay(IPay pay) {
		this.pay = pay;
	}
	public ISave getSave() {
		return save;
	}
	public void setSave(ISave save) {
		this.save = save;
	}
	
	
}
