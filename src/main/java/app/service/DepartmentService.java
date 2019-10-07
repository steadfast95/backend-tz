package app.service;

import app.model.Department;
import app.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;


    public Department getDepartment(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Iterable<Department> getDepartmentList() {
        return departmentRepository.findAll();
    }

    public void addDepartment( Department department) {
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

    public void deleteDepartment(Integer id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if(department!=null){
            department.setParentDepartment(null);
        }
        departmentRepository.delete(department);
    }

}
