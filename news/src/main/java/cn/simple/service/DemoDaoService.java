package cn.simple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.simple.annotation.CurrentDataSource;
import cn.simple.constant.DataSource;
import cn.simple.dao.MyDemoDao;
import cn.simple.domain.MyMobile;

@Service("demoDaoService")
@CurrentDataSource(name = DataSource.DEMO_DATASOURCE)
public class DemoDaoService {
	@Autowired
	MyDemoDao myDemoDao;
	
	@CurrentDataSource(name = DataSource.DEMO_DATASOURCE)
	public List<MyMobile> search() {
		return myDemoDao.search();
	}

}
