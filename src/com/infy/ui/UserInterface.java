package com.infy.ui;


import java.util.List;
import com.infy.bean.Mentor;
import com.infy.bean.ProjectAllocation;
import com.infy.business.service.ProjectAllocationService;
import com.infy.resources.AppConfig;
import com.infy.resources.Factory;
import com.infy.resources.HibernateUtility;

public class UserInterface {
	public static void main(String[] args) {
		try{
			allocateProject();
		//changeAllocation();
		//getProjectDetails();	
		}finally {
			HibernateUtility.closeSessionFactory();
		}	
	}
	public static void allocateProject(){
		try{
			Mentor mentor=new Mentor();			
			mentor.setMentorId(10012);
			ProjectAllocation pa=new ProjectAllocation();
			pa.setIdeaOwner(10009);
			pa.setProjectName("Android Shopping App");
			pa.setMentor(mentor);
			
			ProjectAllocationService service=Factory.createProjectService();
			Integer projectId=service.allocateProject(pa);
			System.out.println("\n\n"+AppConfig.PROPERTIES.getProperty("UserInterface.PROJECT_ALLOCATED1")+" "+projectId+" "+AppConfig.PROPERTIES.getProperty("UserInterface.PROJECT_ALLOCATED2")+" "+mentor.getMentorId());
			
		}
		catch (Exception e) {
			String message = AppConfig.PROPERTIES.getProperty(e.getMessage());
			if (message == null) {
				message = AppConfig.PROPERTIES.getProperty("General.EXCEPTION");
			}
			System.out.println("\n\nERROR:"+message);
		}
	}
    public static void changeAllocation(){
    	try{
    		Integer projectId=5;
    		Integer newMentorId=10038;
    		ProjectAllocationService service=Factory.createProjectService();
    		Integer i=service.changeAllocation(projectId, newMentorId);
    		System.out.println("\n\n"+AppConfig.PROPERTIES.getProperty("UserInterface.SUCCESS_DEALLOCATION1")+" "+newMentorId+AppConfig.PROPERTIES.getProperty("UserInterface.SUCCESS_DEALLOCATION2")+i);		
    	}
    	catch (Exception e) {
   	
			String message = AppConfig.PROPERTIES.getProperty(e.getMessage());
			if (message == null) {
				message = AppConfig.PROPERTIES.getProperty("General.EXCEPTION");
			}
			System.out.println("\n\nERROR:"+message);
		}
    }
    public static void getProjectDetails(){
    	
    	try{
    		Integer projectCount=2;
    		ProjectAllocationService service=Factory.createProjectService();
    		List<ProjectAllocation> pi=service.getProjectDetails(projectCount);
    		
    		System.out.println("\nFollowing are the mentor and their project details who are mentoring more than or equal to "+projectCount+" projects:");
    		System.out.println();
    		System.out.printf("%-20s%-20s%-30s%-30s%n","Mentor Id","Mentor Name","Project Name","Project Id");
    		System.out.printf("%-20s%-20s%-30s%-30s%n","*********","***********","*******************","**********");
    		
    		for(ProjectAllocation p:pi){
    			System.out.printf("%-20s%-20s%-30s%-30s%n",p.getMentor().getMentorId(),p.getMentor().getMentorName(),p.getProjectName(),p.getProjectId());
    		}
    		
    	}
    	catch (Exception e) {
			String message = AppConfig.PROPERTIES.getProperty(e.getMessage());
			if (message == null) {
				message = AppConfig.PROPERTIES.getProperty("General.EXCEPTION");
			}
			System.out.println("\n\nERROR:"+message);
		}
    }
}
