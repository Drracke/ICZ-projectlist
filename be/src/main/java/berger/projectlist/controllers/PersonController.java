package berger.projectlist.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import berger.projectlist.service.PersonService;
import berger.projectlist.repository.model.Person;
import berger.projectlist.api.PersonCreationRequest;




@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person createCompany(@RequestBody PersonCreationRequest personCreationRequest) {
        return personService.createPerson(personCreationRequest);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // @PostMapping("/halp")
    // public String test(@RequestBody Dummy dummy) {
    //     return "also sent " + dummy.text();
    // }
    
    // @GetMapping("/halp/{text}")
    // public String GETtest(@PathVariable String text) {
    //     return "also sent " + text;
    // }
}
