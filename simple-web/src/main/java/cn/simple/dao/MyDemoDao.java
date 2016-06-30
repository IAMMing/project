package cn.simple.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.simple.annotation.CurrentDataSource;
import cn.simple.constant.DataSource;
import cn.simple.domain.MyMobile;

@Repository
@CurrentDataSource(name = DataSource.DEMO_DATASOURCE)
public interface MyDemoDao {
	List<MyMobile> search();
}
