package berger.projectlist.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import berger.projectlist.service.CompanyService;
import berger.projectlist.repository.model.Company;
import berger.projectlist.api.CompanyCreationRequest;



@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public Company createCompany(@RequestBody CompanyCreationRequest companyCreationRequest) {
        return companyService.createCompany(companyCreationRequest);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable String id) {
        return companyService.getCompanyByIco(id);
    }

}
