package berger.projectlist.repository;

import berger.projectlist.repository.model.ProjectRole;

import java.util.List;

// import com.sunny.java.hibernate.trial.repository.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProjectRoleRepository extends JpaRepository<ProjectRole, Integer> {

    @Query("select p from ProjectRole p")
    List<ProjectRole> getAllProjectRoles();
}