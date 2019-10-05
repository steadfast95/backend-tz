package app.controller;

import app.model.Department;
import app.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/department")
@RequiredArgsConstructor
@RestController
public class DepartmentRest {

    private final DepartmentRepository departmentRepository;

    @GetMapping("/get/{id}")
    public Department getDepartment(@PathVariable Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @GetMapping("/list")
    public Iterable<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    @PutMapping("/add")
    public void addDepartment(@RequestBody Department department) {
        if(department!=null && department.getParentDepartment()!=null){
            Integer parentId = department.getParentDepartment().getId();
            Department parent = departmentRepository.findById(parentId).orElse(null);
            if (parent != null) {
                parent.setIsParent(true);
                departmentRepository.save(parent);
            }
            department.setParentDepartment(parent);
        }
        departmentRepository.save(department);


    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentRepository.deleteById(id);
    }

}
