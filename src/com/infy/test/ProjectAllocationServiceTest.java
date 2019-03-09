package com.infy.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.infy.bean.ProjectAllocation;
import com.infy.business.service.ProjectAllocationServiceImpl;
import com.infy.resources.Factory;


public class ProjectAllocationServiceTest {
	
	
	// don't tamper with the signature
	@Rule
	public ExpectedException ee=ExpectedException.none();
	@Test
	public void allocateProjectInvaldMentorIdTest() throws Exception {
		ee.expect(Exception.class);
		ee.expectMessage("Validator.INVALID_MENTOR_ID");
		ProjectAllocation p=new ProjectAllocation();
		p.setIdeaOwner(10025);
		p.setProjectName("CityMapper");
		p.getMentor().setMentorId(1002);
		ProjectAllocationServiceImpl ps=Factory.createProjectService();
		ps.allocateProject(p);
		
	}


	// don't tamper with the signature
	@Test
	public void allocateProjectMentorNotFoundTest() throws Exception {
		ee.expect(Exception.class);
		ee.expectMessage("Service.MENTORID_NOT_FOUND");
		ProjectAllocation p=new ProjectAllocation();
		p.setIdeaOwner(10025);
		p.setProjectName("CityMapper");
		p.getMentor().setMentorId(20000);
		ProjectAllocationServiceImpl ps=Factory.createProjectService();
		ps.allocateProject(p);
	}
	
	
	
	// don't tamper with the signature
	@Test
	public void allocateProjectCannotAllocateTest() throws Exception {
		ee.expect(Exception.class);
		ee.expectMessage("Service.CANNOT_ALLOCATE");
		ProjectAllocation p=new ProjectAllocation();
		p.setIdeaOwner(10025);
		p.setProjectName("CityMapper");
		p.getMentor().setMentorId(10038);
		ProjectAllocationServiceImpl ps=Factory.createProjectService();
		ps.allocateProject(p);
	}

}
