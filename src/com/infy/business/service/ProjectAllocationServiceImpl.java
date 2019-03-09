package com.infy.business.service;


import java.util.List;

import com.infy.bean.Mentor;
import com.infy.bean.ProjectAllocation;
import com.infy.business.validator.Validator;
import com.infy.dao.ProjectAllocationDAOImpl;
import com.infy.resources.Factory;

public class ProjectAllocationServiceImpl implements ProjectAllocationService {

	// don't tamper with the signature
	@Override
	public Integer allocateProject(ProjectAllocation projectAllocation)
			throws Exception {
		// TODO Auto-generated method stub
		Validator v=new Validator();
		v.validateMentorId(projectAllocation.getMentor().getMentorId());
		ProjectAllocationDAOImpl p=Factory.createProjectDAO();
		Mentor mentor=p.checkMentor(projectAllocation.getMentor().getMentorId());
		if(mentor==null){
			throw new Exception("Service.MENTORID_NOT_FOUND");
		}
		
		if(mentor.getNumberOfProjectsMentored()>=3){
			throw new Exception("Service.CANNOT_ALLOCATE");
		}
		ProjectAllocationDAOImpl pdao=Factory.createProjectDAO();
		Integer pid=pdao.allocateProject(projectAllocation);
		return pid;
		
		
	}

	
	// don't tamper with the signature
	@Override
	public Integer changeAllocation(Integer projectId, Integer newMentorId)
			throws Exception {
		// TODO Auto-generated method stub
		
		// Your code goes here
		ProjectAllocationDAOImpl pdao=Factory.createProjectDAO();
		Integer noOfProjects=pdao.changeAllocation(projectId, newMentorId);
		if(noOfProjects==null){
			throw new Exception("Service.INVALID_PROJECTID");
			
		}
		if(noOfProjects==-1){
			throw new Exception("Service.MENTORID_NOT_FOUND");
		}
		if(noOfProjects==0){
			throw new Exception("Service.CANNOT_ALLOCATE");
		}
		return noOfProjects;
	}

	
	// don't tamper with the signature
	@Override
	public List<ProjectAllocation> getProjectDetails(Integer projectCount)
			throws Exception {
		// TODO Auto-generated method stub
		
		// Your code goes here
		List<ProjectAllocation> list1=null;
		ProjectAllocationDAOImpl pdao=Factory.createProjectDAO();
		list1=pdao.getProjectDetails(projectCount);
		if(list1==null){
			throw new Exception("Service.NO_DETAILS_FOUND");
		}
		
		return list1;
	}

	

}
