package ru.kpumuk.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpumuk.spring.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
