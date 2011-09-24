package com.idleworx.mybatisdao.tests.objects;

/** 
 * A simple DTO (Data Transfer Object) class that provides the mapping of data to a table similar to this:
 * table: status
 * columns: status_id (INT),status_name (VARCHAR)
 */
public class Status 
{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {		
		return "[Status] " + "(" + id + ") " + name;
	}
}
