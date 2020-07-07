package com.sucaisheng.test;


import com.sucaisheng.Mapper.OrderMapper;
import com.sucaisheng.Mapper.UserMapper;
import com.sucaisheng.pojo.Order;
import com.sucaisheng.pojo.User;
import com.sucaisheng.utils.sqlSessionUtils;
import com.sucaisheng.vo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class QuickStarDemo {

    @Test
    public void testFn() {
            try {
                String resource = "com/sucaisheng/mybatis/sqlMapConfig.xml";
                InputStream resourceAsStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
                SqlSession sqlSession = sqlSessionFactory.openSession(true);
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                List<User> userList = userMapper.getAllUser();
                System.out.println(userList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    @Test
    public void testFn1(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUserById(1);
    }

    @Test
    public void testFn2(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setEmail("zhangsn@qq.com");
        user.setSex(1);
        user.setUsername("zhangsn");
        userMapper.insert(user);
    }

    @Test
    public void testFn3(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("z");
        QueryVo queryVo = new QueryVo(user);
        List<User> userList = userMapper.getUsersByUsername(queryVo);
        System.out.println(userList);
    }

    @Test
    public void testFn4(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.getOrderList();
        System.out.println(orderList);
    }

    @Test
    public void testFn5(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("zhangsan");
        user.setSex(2);
        List<User> userList = userMapper.getUserBySexAndUsername(user);
        System.out.println(userList);
    }

    @Test
    public void testFn6(){
        SqlSession sqlSession = sqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        List<User> userList = userMapper.getUserByListId(ids);
        System.out.println(userList);
    }

    @Test
    public void testFn7(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //UserMapper userMapper = (UserMapper)applicationContext.getBean("userMapper");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        List<User> userList = userMapper.getAllUser();
        System.out.println(userList);
    }
}
