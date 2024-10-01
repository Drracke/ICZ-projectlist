package berger.projectlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import berger.projectlist.repository.ProjectRepository;
import berger.projectlist.repository.model.Project;
import berger.projectlist.repository.model.Company;
import org.springframework.beans.factory.annotation.Autowired;

import berger.projectlist.api.ProjectCreationRequest;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    
    @Autowired
    private CompanyService companyService;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(ProjectCreationRequest projectCreationRequest) {
        System.out.println("Hello there, company service is: " + companyService.toString());
        Company c = companyService.getCompanyByIco(projectCreationRequest.customerIco());
        
        if (c == null)
            throw new RuntimeException("No such company");
        return projectRepository.save(new Project(projectCreationRequest.name(), projectCreationRequest.shortcut(), c));
    }

    public List<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }

    public void deleteById(int id) {
        projectRepository.deleteById(id);
    }
}
