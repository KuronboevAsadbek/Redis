package uz.redistest.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;


import java.io.Serializable;

@Data
@RedisHash("Student")
public class Student implements Serializable {
    //


    private Long id;
    private String name;
    private String age;
    private String course;



}
