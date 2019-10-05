package app.repository;

import app.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Integer> {
}
