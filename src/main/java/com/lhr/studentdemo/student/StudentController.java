package com.lhr.studentdemo.student;

import com.lhr.studentdemo.exception.ApiRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/02/17:01
 * @Description:
 */
@RestController
@RequestMapping("api/students")
public class StudentController  {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getAllStudents(){
    return studentService.getAllStudents();


  }

  @PostMapping
  public void addNewStudent(@RequestBody @Valid Student student){
    studentService.addNewStudent(student);
  }

  @GetMapping(path = "{studentId}/courses")
  public List<StudentCourse> getAllCoursesForStudent(@PathVariable("studentId") UUID studentId){
    // TO DO
    return studentService.getAllCoursesForStudents(studentId);
  }
}
