package it.epicode.Lezione.repository;

import it.epicode.Lezione.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
