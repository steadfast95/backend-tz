package app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_generator", sequenceName = "employee_sequence", allocationSize=1)
    @GeneratedValue(generator = "employee_generator")
    public Integer id;

    public String name;

    @JoinColumn(name = "departmentId")
    @ManyToOne()
    public Department department;

    public Boolean isArchive;

}
