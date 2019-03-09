package com.infy.bean;



public class ProjectAllocation {

	private Integer projectId;
	private String projectName;
	private Integer ideaOwner;
	private Mentor mentor;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getIdeaOwner() {
		return ideaOwner;
	}
	public void setIdeaOwner(Integer ideaOwner) {
		this.ideaOwner = ideaOwner;
	}
	public Mentor getMentor() {
		return mentor;
	}
	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}
	

	
}
