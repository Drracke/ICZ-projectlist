package berger.projectlist.repository.model;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor  @EqualsAndHashCode
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_short")
    private String projectShort;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_company")
    private Company company;

    public Project(String projectName, String projectShort, Company company) {
        this.projectName = projectName;
        this.projectShort = projectShort;
        this.company = company;
    }

}
