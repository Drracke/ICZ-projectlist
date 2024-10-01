package berger.projectlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import berger.projectlist.repository.CompanyRepository;
import berger.projectlist.repository.model.Company;
import berger.projectlist.api.CompanyCreationRequest;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(CompanyCreationRequest companyCreationRequest) {
        return companyRepository.save(new Company(companyCreationRequest.companyName(), companyCreationRequest.ico()));
    }

    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    public Company getCompanyByIco(final String id) {
        Company ret = null;
        List<Company> list = companyRepository.findCompanyByIco(id);
        if (list.size() > 0)
            ret = list.get(0);

        return ret;
    }
}
