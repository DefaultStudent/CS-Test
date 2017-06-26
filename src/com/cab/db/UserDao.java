package com.cab.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cab.modle.User;

public class UserDao {
	//添加用户信息
	public static int insertUser(Integer userid, String username, String sex, String tel){
		int i = 0;
		try{
			String sql = "insert into users values("+userid+", '"+username+"', '"+sex+"', '"+tel+"')";
			i = DAO.executeUpdate(sql);
		}catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//删除用户
	public static int deleteUser(Integer userid, String username, String sex, String tel){
		int i = 0;
		try{
			String sql = "delete from users where userid = "+userid+"";
		} catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
	
	//查询所有用户
	public static List<User> selectUser(){
		List<User> list = new ArrayList<User>();
		String sql = "select * from users";
		ResultSet rs = DAO.executeQuery(sql);
		try{
			while (rs.next()){
				User us = new User();
				us.setUserid(rs.getInt("userid"));
				us.setUsername(rs.getString("username"));
				us.setSex(rs.getString("sex"));
				us.setTel(rs.getString("tel"));
				list.add(us);
			} 
		} catch (Exception e){
				e.printStackTrace();
		}
		DAO.close();
		return list;
	}
	
	//修改用户
	public static int updateUser(Integer userid, String username, String sex, String tel){
		int i = 0;
		try{
			String sql = "update users set username='"+username+"', sex='"+sex+"', tel='"+tel+"'where userid='"+userid+"'";
			i = DAO.executeUpdate(sql);
		}catch (Exception e){
			e.printStackTrace();
		}
		DAO.close();
		return i;
	}
}
