package yycg.base.dao.mapper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yycg.base.pojo.po.Sysuser;


public class SysuserMapperTest {
	
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {
		// 获取spring容器
		applicationContext = new ClassPathXmlApplicationContext(new String[] {
						"spring/applicationContext.xml", "spring/applicationContext-base-dao.xml"

				});
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindSysuserById() {
		SysuserMapper sysuserMapper = (SysuserMapper) applicationContext.getBean("sysuserMapper");
	//	Sysuser sysuser = sysuserMapper.selectByPrimaryKey("286");
	//	System.out.println(sysuser);
		Sysuser user = new Sysuser();
		user.setId(null);
		user.setUserid("zhangsan");
		user.setUsername("北京市医院");
		user.setPwd("123456");
		user.setGroupid("3");
		user.setUserstate("1");
		sysuserMapper.insert(user);
	}

}
