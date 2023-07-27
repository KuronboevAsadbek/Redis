package uz.redistest.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import uz.redistest.model.Student;
import uz.redistest.repository.StudentRepository;

import java.util.List;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    public static final String HASH_KEY = "Student";
    private final RedisTemplate redisTemplate;

    public StudentService(StudentRepository studentRepository, RedisTemplate redisTemplate) {
        this.studentRepository = studentRepository;
        this.redisTemplate = redisTemplate;
    }
    public Student save(Student student){
        redisTemplate.opsForHash().put(HASH_KEY, student.getId(), student);
        return student;
    }
    public List<Student> getAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }
    public Student findById(Long id){
        return (Student) redisTemplate.opsForHash().get(HASH_KEY, id);
    }
    public String deleteStudent(Long id){
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "Deleted";
    }

}
