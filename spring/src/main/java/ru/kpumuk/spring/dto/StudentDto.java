package ru.kpumuk.spring.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpumuk.spring.model.Student;

@Data
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private int age;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
    }
}
