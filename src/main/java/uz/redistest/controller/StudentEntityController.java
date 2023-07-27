package uz.redistest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.redistest.model.StudentEntity;
import uz.redistest.service.StudentEntityService;

@RestController
@RequestMapping("/api")
public class StudentEntityController {
    //

    private final StudentEntityService service;

    public StudentEntityController(StudentEntityService service) {
        this.service = service;
    }

    @PostMapping("/student")
    public ResponseEntity<?> create(@RequestBody StudentEntity studentEntity){
        return ResponseEntity.ok(service.save(studentEntity));
    }

    @GetMapping("/getallstudents")
    public ResponseEntity<?> getall(){

        return ResponseEntity.ok(service.getAll());
    }
}
