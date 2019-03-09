package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infy.bean.Mentor;
import com.infy.bean.ProjectAllocation;
import com.infy.entity.MentorEntity;
import com.infy.entity.ProjectAllocationEntity;
import com.infy.resources.HibernateUtility;

public class ProjectAllocationDAOImpl implements ProjectAllocationDAO {

	
	// don't tamper with the signature 
	@Override
	public Mentor checkMentor(Integer mentorId) throws Exception {
		// TODO Auto-generated method stub
		
		// Your code goes here
		SessionFactory sessionfactory=null;
		Session session=null;
		try{
			sessionfactory=HibernateUtility.createSessionFactory();
			session=sessionfactory.openSession();
			MentorEntity m=(MentorEntity)session.get(MentorEntity.class,mentorId);
			if(m!=null){
				Mentor mentor=new Mentor();
				mentor.setMentorId(m.getMentorId());
				mentor.setMentorName(m.getMentorName());
				mentor.setNumberOfProjectsMentored(m.getNumberOfProjectsMentored());
		
				
				return mentor;
			}
			else{
				return null;
			}
		}catch (HibernateException e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(HibernateUtility.class);
			logger.debug(e.getMessage(),e);
			throw e;
		}
		catch (Exception e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(HibernateUtility.class);
			logger.debug(e.getMessage(),e);
			throw e;
		}
		finally{
			if(session.isOpen()||session!=null){
			session.close();
		}
		
		}
		
		
		
	}

	
	// don't tamper with the signature 
	@Override
	public Integer allocateProject(ProjectAllocation projectAllocation)
			throws Exception {
		// TODO Auto-generated method stub
		
		// Your code goes here
		SessionFactory sessionfactory=null;
		Session session=null;
		try{
			sessionfactory=HibernateUtility.createSessionFactory();
			session=sessionfactory.openSession();
			session.beginTransaction();
			MentorEntity m=(MentorEntity)session.get(MentorEntity.class,projectAllocation.getMentor().getMentorId());
			if(m!=null){
			
				
				ProjectAllocationEntity p=new ProjectAllocationEntity();
				p.setIdeaOwner(projectAllocation.getIdeaOwner());
				
				p.setProjectName(projectAllocation.getProjectName());
				//MentorEntity me=new MentorEntity();
				//me.setMentorName(m.getMentorName());
				//me.setNumberOfProjectsMentored(m.getNumberOfProjectsMentored());
				//me.setMentorId(m.getMentorId());
				
			
				//session.persist(me);
				//session.persist(p);
				p.setMentor(m);
			
				//session.persist(me);
				
				
				Integer noOfProjects=m.getNumberOfProjectsMentored()+1;
				
				m.setNumberOfProjectsMentored(noOfProjects);
			
				session.persist(m);
			
			session.persist(p);
			
				//System.out.println(p.getProjectId());
				Integer pid=p.getProjectId();
				
				session.getTransaction().commit();
				
				//session.save(p);
			
				
			
				return pid;
				
				
			}
			else{
				return null;
			}
		
		
	}
catch (HibernateException e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(HibernateUtility.class);
			logger.debug(e.getMessage(),e);
			throw e;
		}
		catch (Exception e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(HibernateUtility.class);
			logger.debug(e.getMessage(),e);
			throw e;
		}
		finally{
			if(session.isOpen()||session!=null){
			session.close();
		}
		
		}
	}

	
	// don't tamper with the signature 
	@Override
	public Integer changeAllocation(Integer projectId, Integer newMentorId)
			throws Exception {
		// TODO Auto-generated method stub
		
		// Your code goes here
		SessionFactory sessionfactory=null;
		Session session=null;
		try{
			sessionfactory=HibernateUtility.createSessionFactory();
			session=sessionfactory.openSession();
			ProjectAllocationEntity p=(ProjectAllocationEntity)session.get(ProjectAllocationEntity.class,projectId);
			if(p==null){
				return null;
			}
			else{
				MentorEntity m=(MentorEntity)session.get(MentorEntity.class,newMentorId);
				
				if(m==null){
					return -1;
				}
				else{
					if(m.getNumberOfProjectsMentored()<3){
						session.beginTransaction();
						p.setMentor(null);
						p.setMentor(m);
						session.persist(p);
						Integer newNoOfProject=m.getNumberOfProjectsMentored()+1;
						Integer oldNoOfProject=p.getMentor().getNumberOfProjectsMentored()-1;
						p.getMentor().setNumberOfProjectsMentored(oldNoOfProject);
						m.setNumberOfProjectsMentored(newNoOfProject);
						session.persist(p);
						session.persist(m);
						session.getTransaction().commit();
						return m.getNumberOfProjectsMentored();
					}
					else{
						return 0;
					}
				}

			}
		
		
		
	}
catch (HibernateException e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(HibernateUtility.class);
			logger.debug(e.getMessage(),e);
			throw e;
		}
		catch (Exception e) {
			
			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
			Logger logger=Logger.getLogger(HibernateUtility.class);
			logger.debug(e.getMessage(),e);
			throw e;
		}
		finally{
			if(session.isOpen()||session!=null){
			session.close();
		}
		
		}
	}

	
	// don't tamper with the signature 
	@Override
	@SuppressWarnings("unchecked")
	public List<ProjectAllocation> getProjectDetails(Integer projectCount)
			throws Exception {
		// TODO Auto-generated method stub
		
		// Your code goes here
		SessionFactory sessionfactory=null;
		Session session=null;
		List<ProjectAllocationEntity> list1=new ArrayList<>();
		List<ProjectAllocationEntity> listNew=new ArrayList<>();
		List<ProjectAllocation> list2=new ArrayList<>();
		try{
			
			sessionfactory=HibernateUtility.createSessionFactory();
			session=sessionfactory.openSession();
			String hql="from ProjectAllocationEntity";
			Query query=session.createQuery(hql);
			//query.setParameter("projectCount",projectCount);
			list1=query.list();
		
			for(ProjectAllocationEntity i:list1){
				if(i.getMentor().getNumberOfProjectsMentored()>=projectCount){
					listNew.add(i);
				}
			}
		
			
			if(listNew.size()!=0){
				
				for(ProjectAllocationEntity p:listNew){
					
					ProjectAllocation project=new ProjectAllocation();
					project.setProjectId(p.getProjectId());
					project.setIdeaOwner(p.getIdeaOwner());
					project.setProjectName(p.getProjectName());
				
					Mentor m=new Mentor();
					m.setMentorId(p.getMentor().getMentorId());
					m.setMentorName(p.getMentor().getMentorName());
					project.setMentor(m);
		
					list2.add(project);
					
				}
				
				return list2;
			}
			else{
				return null;
			}
			
			
		
		
		
	}catch (HibernateException e) {
		
		DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
		Logger logger=Logger.getLogger(HibernateUtility.class);
		logger.debug(e.getMessage(),e);
		throw e;
	}
	catch (Exception e) {
		
		DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
		Logger logger=Logger.getLogger(HibernateUtility.class);
		logger.debug(e.getMessage(),e);
		throw e;
	}
		finally{
			if(session.isOpen()||session!=null){
			session.close();
		}
		
		}

	}	
}
