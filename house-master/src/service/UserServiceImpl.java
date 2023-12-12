package service;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Pojo.*;
import dao.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> userList() throws Exception {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		List<User> list=userMapper.selectByExample(example);
		System.out.println("123"+list);
		return list;
	}

	@Override
	public User login(User user) throws Exception {
		return userMapper.selectByUser(user);		//依然是一个接口类
	}
  public void registration(User user )  {


	    userMapper.register(user);
  }
	public User selectByUser(User user){
		return userMapper.selectByUser(user);
	}
	public int countUser(User user){
		return userMapper.countUser(user);
	}
}
