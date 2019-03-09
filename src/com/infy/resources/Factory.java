package com.infy.resources;


import com.infy.business.service.ProjectAllocationServiceImpl;
import com.infy.dao.ProjectAllocationDAOImpl;

public class Factory {
	
	public static ProjectAllocationServiceImpl createProjectService(){
		return new ProjectAllocationServiceImpl();
	}
	
	public static ProjectAllocationDAOImpl createProjectDAO(){
		return new ProjectAllocationDAOImpl();
	}

}
