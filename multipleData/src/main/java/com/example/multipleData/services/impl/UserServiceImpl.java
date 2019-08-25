package com.example.multipleData.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.multipleData.dao.test1.UserMapper;
import com.example.multipleData.entity.User;
import com.example.multipleData.services.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userDao;

	@Override
	public List<Map<String, Object>> selectBySelective(Map<String,Object> params) {

		try {
			List<Map<String, Object>> userList = userDao.selectBySelective(params);
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int deleteByPrimaryKey(List ids) {
		try {
			userDao.deleteByPrimaryKey(ids);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return 0;
	}

	@Override
	public int insert(User user) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return 0;
	}

	@Override
	public int insertSelective(User user) {
		try {
			return userDao.insertSelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public User selectByPrimaryKey(String id) {
		try {
			return userDao.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int updateByPrimaryKeySelective(User user) {
		try {
			return userDao.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int updateByPrimaryKey(User user) {
		try {
			return userDao.updateByPrimaryKey(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int totalCount(Map<String, Object> params) {
		try {
			return userDao.totalCount(params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public User selectUserByNameAndPwd(Map<String, Object> params) {
		try {
			return userDao.selectUserByNameAndPwd(params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
