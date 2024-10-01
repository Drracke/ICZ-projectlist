package berger.projectlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import berger.projectlist.repository.PersonRepository;
import berger.projectlist.repository.model.Person;
import berger.projectlist.api.PersonCreationRequest;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(PersonCreationRequest personCreationRequest) {
        return personRepository.save(new Person(personCreationRequest.id(), personCreationRequest.firstName(), personCreationRequest.lastName()));
    }

    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }
}
