package com.infy.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.ProjectDTO;
import com.infy.dto.TeamMemberDTO;
import com.infy.exception.AbcException;
import com.infy.repository.ProjectRepository;

@Service(value="projectService")
public class ProjectServiceImpl implements ProjectService {

	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Integer addProject(ProjectDTO project) throws AbcException {
		
		
		
		Integer I= projectRepository.addProject(project);
		return I;
		
		
		
		
		
		
		
		//return null;
	}


	
	@Override
	public List<ProjectDTO> getProjectDetails(String technology) throws AbcException {
		
		
		List<ProjectDTO>list= projectRepository.getProjectDetails();
		List<ProjectDTO>list1= list.stream().filter(list2-> list2.getTechnologyUsed()==technology).collect(Collectors.toList());
		
		List<ProjectDTO>list3= new ArrayList<>();
		
		for(ProjectDTO p:list1)
		{
			ProjectDTO projectDTO= new ProjectDTO();
			projectDTO.setProjectId(p.getProjectId());
			projectDTO.setProjectName(p.getProjectName());
			projectDTO.setTechnologyUsed(p.getTechnologyUsed());
			projectDTO.setTeamSize(p.getTeamSize());
			projectDTO.setCost(p.getCost());
			List<TeamMemberDTO> listmember= p.getMemberList();
			projectDTO.setMemberList(listmember);
			list3.add(projectDTO);
			
			
			
		}
			
		
		return list3;
		
			
		
		
		
		
		
		
		
		
		
		
		//return null;
	}


	
}
