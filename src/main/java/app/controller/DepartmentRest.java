package app.controller;

import app.model.Department;
import app.repository.DepartmentRepository;
import app.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/department")
@RequiredArgsConstructor
@RestController
public class DepartmentRest {

    private final DepartmentService departmentService;

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Integer id) {
        Department department = departmentService.getDepartment(id);
        if(department == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Department>> getDepartmentList() {
        return ResponseEntity.ok(departmentService.getDepartmentList());
    }

    @PostMapping("/")
    public void addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }

}
