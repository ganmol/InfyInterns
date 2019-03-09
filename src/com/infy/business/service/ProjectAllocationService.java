package com.infy.business.service;



import java.util.List;
import com.infy.bean.ProjectAllocation;

public interface ProjectAllocationService {
	
	public Integer allocateProject(ProjectAllocation projectAllocation) throws Exception;
	public Integer changeAllocation(Integer projectId,Integer newMentorId) throws Exception;
	public List<ProjectAllocation> getProjectDetails(Integer projectCount) throws Exception;
}
