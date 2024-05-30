package it.epicode.Lezione.controller;

import it.epicode.Lezione.DTO.StudentDto;
import it.epicode.Lezione.DTO.UserDto;
import it.epicode.Lezione.entity.Student;
import it.epicode.Lezione.entity.User;
import it.epicode.Lezione.exception.BadRequestException;
import it.epicode.Lezione.exception.UserNotFoundException;
import it.epicode.Lezione.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/api/students")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveStudent(@RequestBody @Validated StudentDto studentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/api/students")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/api/students/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Student getStudentById(@PathVariable int id) {
        Optional<Student> studentOptional = studentService.getStudentById(id);

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new UserNotFoundException("Student with id=" + id + " not found!");
        }
    }

    @PutMapping("/api/students/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Student updateStudent(@PathVariable int id, @RequestBody @Validated StudentDto studentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage()).reduce("", (s, s2) -> s + s2));
        }
        return studentService.updateStudent(id, studentDto);
    }

    @DeleteMapping("/api/students/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }

}
