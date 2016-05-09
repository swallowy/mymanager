package cn.yangys.mymanager.test;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yangys.mymanager.model.TestUser;
import cn.yangys.mymanager.service.TestUserService;

@RunWith(SpringJUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class MyBatisTestBySpringTestFramework {
	//注入userService
    @Autowired
    private TestUserService testUserService;
    
    @Test
    public void testAddUser(){
    	TestUser testUser = new TestUser();
        testUser.setLogin("admin1@comapny.com");
        testUser.setFirstname("Li");
        testUser.setLastname("Peter");
        Calendar instance = Calendar.getInstance();
        instance.set(1990, 9, 1);
        testUser.setBirthday(instance.getTime());
        testUserService.addTestUser(testUser);
    }
    
    @Test
    public void testGetUserById(){
        Integer testUserId = 2;
       TestUser testUser = testUserService.getTestUserById(testUserId);
        System.out.println(testUser.getLogin());
    }
}