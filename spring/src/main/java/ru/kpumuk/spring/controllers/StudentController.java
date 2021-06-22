package ru.kpumuk.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpumuk.spring.dto.StudentDto;
import ru.kpumuk.spring.model.Student;
import ru.kpumuk.spring.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/{id}")
    public StudentDto getStudentDtoById (@RequestParam Long id) {
        return studentService.findStudentDtoById(id).orElseThrow(() ->
                new RuntimeException("Student with id: " + id + " doesn't exist"));
    }

    @GetMapping
    public List<Student> findAllStudents () {
        System.out.println(studentService.findAll().toString());
        return studentService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto saveOrUpdateStudent (@RequestBody StudentDto studentDto) {
        return studentService.saveOrUpdate(studentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id) {
        studentService.deleteById(id);
    }



}
