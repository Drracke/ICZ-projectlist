package berger.projectlist.repository;

import berger.projectlist.repository.model.Person;

import java.util.List;

// import com.sunny.java.hibernate.trial.repository.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonRepository extends JpaRepository<Person, String> {

    @Query("select p from Person p")
    List<Person> getAllPersons();
}