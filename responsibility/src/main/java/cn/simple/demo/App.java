package cn.simple.demo;

import com.alibaba.fastjson.JSON;

import cn.simple.domain.HouseInfo;
import cn.simple.domain.OperationResult;
import cn.simple.domain.PublishFlow;
import cn.simple.flow.impl.Alipay;
import cn.simple.flow.impl.BannerAD;
import cn.simple.flow.impl.HouseValid;
import cn.simple.flow.impl.SaveToMysql;
import cn.simple.responsibility.impl.AD;
import cn.simple.responsibility.impl.AbstractResponsibility;
import cn.simple.responsibility.impl.Pay;
import cn.simple.responsibility.impl.Save;
import cn.simple.responsibility.impl.ValidHouse;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// 初始化流程中的每个模块
		PublishFlow publishFlow = new PublishFlow();
		publishFlow.setAd(new BannerAD());
		publishFlow.setPay(new Alipay());
		publishFlow.setSave(new SaveToMysql());
		publishFlow.setValidHouse(new HouseValid());

		// 初始化房源信息
		HouseInfo house = new HouseInfo();
		house.setTitle("");
		// 初始化职责流
		AbstractResponsibility save = new Save(null,publishFlow);
		AbstractResponsibility pay = new Pay(save,publishFlow);
		AbstractResponsibility ad = new AD(pay,publishFlow);
		ValidHouse validHouse = new ValidHouse(ad,publishFlow);
		validHouse.setHouse(house);

		OperationResult result = validHouse.process();
		System.out.println(JSON.toJSONString(result));
	}
}
