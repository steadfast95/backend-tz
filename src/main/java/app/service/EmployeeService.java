package app.service;

import app.model.Department;
import app.model.Employee;
import app.repository.DepartmentRepository;
import app.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Iterable<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        if (employee != null && employee.getDepartment() != null) {
            Department department = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
            if (department != null) {
                department.getEmployeeList().add(employee);
                departmentRepository.save(department);
            }
        }
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        if (employee != null && employee.getDepartment() != null) {
            Department department = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
            if (department != null) {
                department.getEmployeeList().add(employee);
                departmentRepository.save(department);
            }
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
