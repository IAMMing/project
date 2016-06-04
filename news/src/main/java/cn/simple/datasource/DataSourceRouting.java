package cn.simple.datasource;

import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceRouting extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceHolder.getTargetDatasource();
	}
	
	@Override
	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		super.setTargetDataSources(targetDataSources);
		// 加载数据源
		afterPropertiesSet();
	}

}
