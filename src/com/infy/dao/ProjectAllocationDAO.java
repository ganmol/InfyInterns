package com.infy.dao;


import java.util.List;
import com.infy.bean.Mentor;
import com.infy.bean.ProjectAllocation;

public interface ProjectAllocationDAO {
	public Mentor checkMentor(Integer mentorId) throws Exception;
	public Integer allocateProject(ProjectAllocation projectAllocation) throws Exception;
	public Integer changeAllocation(Integer projectId,Integer newMentorId) throws Exception;
	public List<ProjectAllocation> getProjectDetails(Integer projectCount) throws Exception;

}
