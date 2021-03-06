package cn.simple.datasource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.alibaba.druid.pool.DruidDataSource;

public class BeanPostPrcessorImpl implements BeanPostProcessor {

	@Autowired
	DataSourceRouting dataSourceRouting;

	private static Map<Object, Object> _targetDataSources = new HashMap<Object, Object>();

	public static Map<Object, Object> get_targetDataSources() {
		return _targetDataSources;
	}

	public static void set_targetDataSources(Map<Object, Object> _dataSources) {
		BeanPostPrcessorImpl._targetDataSources = _dataSources;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof DruidDataSource) {
			System.out.println("before ==================" + beanName);
			_targetDataSources.put(beanName, bean);
			dataSourceRouting.setTargetDataSources(_targetDataSources);
		}
		return bean;
	}

}
