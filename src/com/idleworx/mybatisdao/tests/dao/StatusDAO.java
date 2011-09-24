package com.idleworx.mybatisdao.tests.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import com.idleworx.mybatisdao.MyBatisDAO;
import com.idleworx.mybatisdao.tests.objects.Status;

/** Simple example DAO which uses the MyBatisDAO Helper Framework */
public class StatusDAO extends MyBatisDAO<Status,Integer>{
	
	//Don't forget to define the default custom constructor when implementing a new 
	//child DAO class, and set the class type accordingly 
	public StatusDAO(Class<Status> type,SqlSessionFactory containerSessionFactory) {
		super(type,containerSessionFactory);
	}
	
}
