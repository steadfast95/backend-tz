package app.controller;

import app.model.Department;
import app.model.Employee;
import app.repository.DepartmentRepository;
import app.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@RequiredArgsConstructor
@RestController
public class EmployeeRest {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping("list")
    public Iterable<Employee> getEmployeeList() {
        return  employeeRepository.findAll();
    }

    @PutMapping("/add")
    public void addEmployee(@RequestBody Employee employee) {
       if(employee!=null && employee.getDepartment()!=null){
           Department department= departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
           if(department!=null){
               department.getEmployeeList().add(employee);
               departmentRepository.save(department);
           }
       }
        employeeRepository.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
    }
}
