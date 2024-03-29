package com.wy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wy.model.UserInfoForm;
import com.wy.tools.JDBConnection;

public class UserInfoDao implements UserInfoDaoImp
    {
	private JDBConnection connection = null;
	
	
	private boolean save(UserInfoForm userInfo)
	    {
		connection = new JDBConnection();
		String sql = "insert into tb_register3 values ('"
			+ userInfo.getAccount()
			+ "','"
			+ com.wy.tools.Encrypt
				.encodeMD5(userInfo.getPassword()) + "','"
			+ userInfo.getQuestion() + "','" + userInfo.getResult()
			+ "','" + userInfo.getEmail() + "','"
			+ userInfo.getRealName() + "','" + userInfo.getIDCard()
			+ "','" + userInfo.getBirthday() + "','"
			+ userInfo.getSex() + "','" + userInfo.getSpaceForm()
			+ "','" + userInfo.getSchoolAge() + "','"
			+ userInfo.getProfession() + "','"
			+ userInfo.getIncome() + "','" + userInfo.getTel()
			+ "','" + userInfo.getQqNumber() + "','"
			+ userInfo.getMsnNumber() + "','"
			+ userInfo.getSelfPage() + "','"
			+ userInfo.getAddress() + "','" + userInfo.getPost()
			+ "')";
		System.out.println(sql);
		return connection.executeUpdate(sql);
	    }
	
	public UserInfoForm query(String account)
	    {
		connection = new JDBConnection();
		String sql = "select * from tb_register3 where account = '"
			+ account + "'";
		ResultSet rs = connection.executeQuery(sql);
		UserInfoForm userInfo = null;
		try
		    {
			while (rs.next())
			    {
				userInfo = new UserInfoForm();
				userInfo.setId(rs.getInt(1));
				userInfo.setAccount(rs.getString(2));
				userInfo.setPassword(rs.getString(3));
				userInfo.setQuestion(rs.getString(4));
				userInfo.setResult(rs.getString(5));
				userInfo.setEmail(rs.getString(6));
				userInfo.setRealName(rs.getString(7));
				userInfo.setIDCard(rs.getString(8));
				userInfo.setBirthday(rs.getDate(9));
				userInfo.setSex(rs.getString(10));
				userInfo.setSpaceForm(rs.getString(11));
				userInfo.setSchoolAge(rs.getString(12));
				userInfo.setProfession(rs.getString(13));
				userInfo.setIncome(rs.getString(14));
				userInfo.setTel(rs.getString(15));
				userInfo.setQqNumber(rs.getInt(16));
				userInfo.setMsnNumber(rs.getInt(17));
				userInfo.setSelfPage(rs.getString(18));
				userInfo.setAddress(rs.getString(19));
				userInfo.setPost(rs.getInt(20));
				
			    }
		    } catch (SQLException e)
		    {
	
			e.printStackTrace();
		    }
		return userInfo;
	    }
	
	public boolean saveUserInfo(UserInfoForm userInfo)
	    {
		boolean flag = this.save(userInfo);
		connection.closeConnection();
		return flag;
	    }
	
	public UserInfoForm queryUserInfo(String account)
	    {
		UserInfoForm userInfo = this.query(account);
		connection.closeConnection();
		return userInfo;
	    }
	
    }
