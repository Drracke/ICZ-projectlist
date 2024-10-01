package berger.projectlist.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import berger.projectlist.controllers.CompanyController;
import berger.projectlist.service.CompanyService;
import berger.projectlist.repository.model.Company;
import berger.projectlist.api.CompanyCreationRequest;
import berger.projectlist.api.Dummy;



@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/status")
    public String getStatus() {
        System.out.println("getStatus");
        return "good";
    }

    @PostMapping
    public Company createCompany(@RequestBody CompanyCreationRequest companyCreationRequest) {
        System.out.println("create company");
        return companyService.createCompany(companyCreationRequest);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        System.out.println("Get all companies");
        return companyService.getAllCompanies();
    }

    @PostMapping("/halp")
    public String test(@RequestBody Dummy dummy) {
        System.out.println("Hi there, you sent " + dummy.text());
        return "also sent " + dummy.text();
    }
    
    @GetMapping("/halp/{text}")
    public String GETtest(@PathVariable String text) {
        System.out.println("Hi there, you sent " + text);
        return "also sent " + text;
    }
}
