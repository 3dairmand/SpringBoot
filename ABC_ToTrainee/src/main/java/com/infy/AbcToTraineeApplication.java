package com.infy;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.infy.dto.ProjectDTO;
import com.infy.dto.TeamMemberDTO;
import com.infy.exception.AbcException;
import com.infy.service.ProjectService;

@SpringBootApplication
public class AbcToTraineeApplication implements CommandLineRunner{
	
	
	private static Log LOGGER= LogFactory.getLog(AbcToTraineeApplication.class);
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	Environment environment;

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(AbcToTraineeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		addProject();
		getProjectDetails();
	}

	public void addProject() {
		
		
		
		
		try {
			
			   ProjectDTO projectDTO= new ProjectDTO();
			   projectDTO.setProjectName("FSADM8");
			   projectDTO.setCost(200000);
			   projectDTO.setTeamSize(5);
			   projectDTO.setTechnologyUsed("Java");
			   List<TeamMemberDTO>list= new ArrayList<>();
			   TeamMemberDTO member= new TeamMemberDTO();
			   member.setEmployeeId(722009);
			   member.setEmployeeName("Robin");
			   member.setDesignation("SSC");
			   member.setSkills("Java,Oracle");
			  
			   TeamMemberDTO member2= new TeamMemberDTO();
			   member2.setEmployeeId( 722019);
			   member2.setEmployeeName("Monica");
			   member2.setDesignation("SSC");
			   member2.setSkills("Java, Python");
			   
			   
			   list.add(member);
			   list.add(member2);
			   projectDTO.setMemberList(list);
			   
			   Integer data= projectService.addProject(projectDTO);
			   LOGGER.info(environment.getProperty("UserInterface.PROJECT_ADDED_SUCCESS")+data);
			   
			   
			}catch(AbcException exception)
				{
				  LOGGER.error(environment.getProperty(exception.getMessage()));
				
				}
			   
		

	}


	public void getProjectDetails() {
		
		
		
		
   try {
			
			List<ProjectDTO>list= projectService.getProjectDetails("Java");
			
			if(list!=null)
			{
				for(ProjectDTO p: list)
			
			{
				
				LOGGER.info(p);
				
			}
		 }	
			
			
			
		}catch(AbcException exception)
		{
			LOGGER.error(environment.getProperty(exception.getMessage()));
		}
		
		
		
		
		

	}

	

}