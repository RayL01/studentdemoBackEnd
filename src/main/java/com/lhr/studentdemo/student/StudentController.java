package com.lhr.studentdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/02/17:01
 * @Description:
 */
@RestController
@RequestMapping("students")
public class StudentController  {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getAllStudents(){
//    return studentService.getAllStudents();
    throw new IllegalStateException("Oops can't get all students");


  }

  @PostMapping
  public void addNewStudent(@RequestBody Student student){
    studentService.addNewStudent(student);
  }
}
