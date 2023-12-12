package service;

import java.util.List;

import Pojo.User;
import Pojo.Userlist;
import org.apache.ibatis.session.SqlSession;

public interface UserService {

	public List<User> userList() throws Exception;
	public User login(User user) throws Exception;		//接口类，不实现具体函数
	public void registration(User user);
	public User selectByUser(User user);
	public int countUser(User user);

	
}
