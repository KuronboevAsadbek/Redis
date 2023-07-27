package uz.redistest.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import uz.redistest.model.Student;
import uz.redistest.model.StudentEntity;
import uz.redistest.repository.StudentEntityRepository;
import uz.redistest.repository.StudentRepository;

import java.util.List;

@Service
public class StudentEntityService {
    //
    public static final String HASH_KEY = "Student";
    private final StudentEntityRepository studentEntityRepository;
    private final StudentRepository repository;
    private final RedisTemplate redisTemplate;

    public StudentEntityService(StudentEntityRepository studentEntityRepository, StudentRepository repository, RedisTemplate redisTemplate) {
        this.studentEntityRepository = studentEntityRepository;
        this.repository = repository;
        this.redisTemplate = redisTemplate;
    }

    public StudentEntity save(StudentEntity studentEntity){
        return studentEntityRepository.save(studentEntity);
    }

    public List<StudentEntity> getAll(){
        Student student = new Student();
        List<StudentEntity> list = studentEntityRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            student.setId(list.get(i).getId());
            student.setName(list.get(i).getName());
            student.setCourse(list.get(i).getCourse());
            student.setAge(list.get(i).getAge());
            redisTemplate.opsForHash().put(HASH_KEY, student.getId(), student);
        }
        return redisTemplate.opsForHash().values(HASH_KEY);
    }
}
