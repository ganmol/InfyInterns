package com.infy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


//Strictly follow class diagram

@Entity
@Table(name="Mentor_Project")
@GenericGenerator(name="generatorName",strategy="sequence",
parameters={@Parameter(name="sequence",value="project_pid_seq")})
public class ProjectAllocationEntity {
	
	@Id
	@GeneratedValue(generator="generatorName")
	private Integer projectId;
	
	private String projectName;
	
	private Integer ideaOwner;
	
	@ManyToOne(cascade=CascadeType.ALL)  
	@JoinColumn(name="mentorId")
	private MentorEntity mentor;

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

	public MentorEntity getMentor() {
		return mentor;
	}

	public void setMentor(MentorEntity mentor) {
		this.mentor = mentor;
	}
	
	
	
}
