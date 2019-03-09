package com.infy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



//Strictly follow class diagram
@Entity
@Table(name="Mentor")
public class MentorEntity {
	
	
	@Id
	private Integer mentorId;
	
	private String mentorName;
	@Column(name="projectCount")
	private Integer numberOfProjectsMentored;
	public Integer getMentorId() {
		return mentorId;
	}
	public void setMentorId(Integer mentorId) {
		this.mentorId = mentorId;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public Integer getNumberOfProjectsMentored() {
		return numberOfProjectsMentored;
	}
	public void setNumberOfProjectsMentored(Integer numberOfProjectsMentored) {
		this.numberOfProjectsMentored = numberOfProjectsMentored;
	}
	
	
	
	
	

}
