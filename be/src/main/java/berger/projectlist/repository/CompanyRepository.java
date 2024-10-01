package berger.projectlist.repository;

import berger.projectlist.repository.model.Company;

import java.util.List;

// import com.sunny.java.hibernate.trial.repository.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CompanyRepository extends JpaRepository<Company, String> {

    @Query("select c from Company c")
    List<Company> getAllCompanies();
}