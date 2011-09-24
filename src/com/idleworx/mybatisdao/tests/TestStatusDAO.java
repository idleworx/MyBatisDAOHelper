package com.idleworx.mybatisdao.tests;

import static org.junit.Assert.assertNotNull;

import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idleworx.mybatisdao.tests.dao.StatusDAO;
import com.idleworx.mybatisdao.tests.objects.Status;


public class TestStatusDAO {

	private static Logger log = LoggerFactory.getLogger(TestStatusDAO.class);
	private static SqlSessionFactory sf;
	private static StatusDAO statusDao;
	
	@BeforeClass
	public static void setUp() throws Exception {
		log.info("starting up myBatis tests");
		String resource = "mybatis.config.xml";
		Reader reader = Resources.getResourceAsReader(resource);		
		sf = new SqlSessionFactoryBuilder().build(reader,"testing");		
		statusDao = new StatusDAO(Status.class,sf);
	}
	
	@Test
	public void getStatus(){
		log.debug("getStatus()");				
		Status s = statusDao.get(1);
		assertNotNull(s);
		log.info("Status: " + s.toString());	
	}
	
	@Test
	public void getStatusByName(){
		log.debug("getStatusByName()");
				
		Status s = statusDao.getByName("Done");
		assertNotNull(s);
		log.info("Status: " + s.toString());		
	}
	
	@Test
	public void getAllStatuses(){
		log.debug("getAllStatuses()");
				
		ArrayList<Status> list = statusDao.getAll();		
		assertNotNull(list);
		printToStringArray(list);
		
	}
	
	@Test
	public void createStatus(){
		log.debug("createStatus()");
				
		Status s = new Status();
		s.setName("TestStatus");
		Integer result = statusDao.create(s);
		assertNotNull(result);
		log.info("insert result: " + result);
		
	}
	
	@Test
	public void updateStatus(){
		log.debug("updateStatus()");
				
		Status s = new Status();
		s.setId(4);//the status id to update
		s.setName("TestStatusUpdated");
		Integer result = statusDao.update(s);
		assertNotNull(result);
		log.info("update result: " + result);		
	}
	
	@Test
	public void deleteStatus(){
		log.debug("deleteStatus()");		
		Integer result = statusDao.delete(5);
		assertNotNull(result);
		log.info("delete result: " + result);
		
	}
	
	private static void printToStringArray(ArrayList<?> a){
		for(int i = 0;i<a.size();i++){
			log.info(a.get(i).toString());
		}
	}
	
}
