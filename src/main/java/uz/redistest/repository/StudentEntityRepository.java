package uz.redistest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.redistest.model.StudentEntity;

@Repository
public interface StudentEntityRepository extends JpaRepository<StudentEntity, Long> {
}
