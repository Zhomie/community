package com.homie.community;

import com.homie.community.Controller.AlphaController;
import com.homie.community.Dao.AlphaDao;
import com.homie.community.Service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.lang.management.MemoryManagerMXBean;
import java.security.Provider;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {


	private  ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
				this.applicationContext = applicationContext;
	}
	@Test
	void testApplicationContext() {
		System.out.println(applicationContext);

		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		alphaDao = (AlphaDao) applicationContext.getBean("alphaDaoHibernateImpl");
		System.out.println(alphaDao.select());
	}


	@Test
	public void testBeanManagement(){
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);

	}
	@Autowired
	//@Qualifier限定哪个bean应该被自动注入。
	@Qualifier("alphaDaoHibernateImpl")
	private AlphaDao  alphaDao ;
	@Autowired
	private  AlphaService alphaService;
	/*@Autowired
	private AlphaController alphaController;*/
	@Test
	public void testDI(){
		System.out.println(alphaDao);
		System.out.println(alphaService);
/*		System.out.println(alphaController);*/
	}
}
