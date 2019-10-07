package app.controller;

import app.model.Department;
import app.model.Employee;
import app.repository.DepartmentRepository;
import app.repository.EmployeeRepository;
import app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@RequiredArgsConstructor
@RestController
public class EmployeeRest {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        Employee department = employeeService.getEmployee(id);
        if(department == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Employee>> getEmployeeList() {
        return ResponseEntity.ok(employeeService.getEmployeeList());
    }

    @PostMapping("/")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("/")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
}
