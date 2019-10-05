package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @SequenceGenerator(name = "department_generator", sequenceName = "department_sequence", allocationSize=1)
    @GeneratedValue(generator = "department_generator")
    public Integer id;

    @Column(nullable = false)
    public String name;

    public Boolean isParent = false; // родитель(true) или нет(false)

    @JoinColumn(name = "parentDepartmentId")
    @ManyToOne(cascade = CascadeType.ALL)
    public Department parentDepartment; // родитель(отдел)

    @OneToMany(mappedBy = "department")
    public List<Employee> employeeList = new ArrayList<>();

    @JsonProperty(value = "countEmployee")
    public Integer getCountEmployee(){
        return employeeList.size();
    }

}
