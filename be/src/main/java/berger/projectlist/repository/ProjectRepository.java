package berger.projectlist.repository;

import berger.projectlist.repository.model.Project;

import java.util.List;

// import com.sunny.java.hibernate.trial.repository.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("select p from Project p")
    List<Project> getAllProjects();
}