package com.idleworx.mybatisdao;

import java.util.ArrayList;

import org.apache.ibatis.exceptions.PersistenceException;

/**
 * Generic implementation of DAO pattern
 * http://www.ibm.com/developerworks/java/library/j-genericdao.html
 */
public interface IParentDAO<T, PK>{
	public T get(PK id) throws PersistenceException;//get obj of type T by the primary key 'id'	
	public T getByName(String name) throws PersistenceException;//get obj of type T by the 'name' field, if one exists for that table
	public ArrayList<T> getAll() throws PersistenceException;//get all objects of type T
	public int create(T objInstance) throws PersistenceException;//insert an object of type T into the database
    int update(T transientObject) throws PersistenceException; //update an object of type T    
    int delete(PK id)  throws PersistenceException;//delete an object of type T
}
