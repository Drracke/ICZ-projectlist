package berger.projectlist.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import berger.projectlist.service.ProjectService;
import berger.projectlist.repository.model.Project;
import berger.projectlist.api.ProjectCreationRequest;



@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public Project createProject(@RequestBody ProjectCreationRequest projectCreationRequest) {
        return projectService.createProject(projectCreationRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable int id) {
        projectService.deleteById(id);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

}
