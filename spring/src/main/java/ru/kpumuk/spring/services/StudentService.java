package ru.kpumuk.spring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpumuk.spring.dto.StudentDto;
import ru.kpumuk.spring.model.Student;
import ru.kpumuk.spring.repositories.StudentRepository;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void deleteById (Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
    }

    public Optional<StudentDto> findStudentDtoById (Long id) {
        return studentRepository.findById(id).map(StudentDto::new);
    }

    /*public List<StudentDto> findAll() {
        return (List<StudentDto>) studentRepository.findAll().stream().map(StudentDto::new);
    }*/

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public StudentDto saveOrUpdate (StudentDto studentDto) {
        if (studentDto.getId() != null && studentRepository.existsById(studentDto.getId()) ) {
            Student student = studentRepository.save(studentRepository.getById(studentDto.getId()));
            return new StudentDto(student);
        }
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        studentRepository.save(student);
        return new StudentDto(student);
    }




}
