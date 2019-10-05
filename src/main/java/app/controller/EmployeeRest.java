package app.controller;

import app.model.Employee;
import app.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@RequiredArgsConstructor
@RestController
public class EmployeeRest {

    private final EmployeeRepository employeeRepository;

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping("list")
    public Iterable<Employee> getEmployeeList() {
        return  employeeRepository.findAll();
    }

    @PutMapping("/add")
    public void addEmplyee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @DeleteMapping("/delet/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
    }
}
