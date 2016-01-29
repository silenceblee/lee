package org.app.dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.system.dao.SysDictTypeMapper;
import com.system.po.SysDictType;


@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring_mybatis.xml"})

public class AppTest {
	private static Logger logger = Logger.getLogger(AppTest.class);
//	private ApplicationContext ac = null;

	@Autowired
	private SysDictTypeMapper dao;
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
		SysDictType record = new SysDictType();
		record.setDictType("2");
		record.setDictDesc("性别");
		record.setRemark("测试");
		logger.info(dao.insert(record));
		
//		SysDictType record = dao.selectByPrimaryKey("1");
//		logger.info(record.getDictDesc());
	}
}
