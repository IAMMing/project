package cn.simple.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.simple.annotation.CurrentDataSource;
import cn.simple.constant.DataSource;
import cn.simple.domain.MyTest;

@Repository
@CurrentDataSource(name = DataSource.TEST_DATASOURCE)
public interface MyTestDao {
	List<MyTest> search();
}
