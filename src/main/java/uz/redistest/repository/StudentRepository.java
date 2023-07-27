package uz.redistest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.redistest.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    //

}
