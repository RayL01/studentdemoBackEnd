package com.lhr.studentdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/12/00:03
 * @Description:
 */
@Service
public class StudentService {
  private final StudentDataAccessService studentDataAccessService;

  @Autowired
  public StudentService(StudentDataAccessService studentDataAccessService){
    this.studentDataAccessService = studentDataAccessService;
  }
  List<Student> getAllStudents(){
    return studentDataAccessService.selectAllStudents();
  }
  public void addNewStudent(Student student) {
    addNewStudent(null, student);
  }
  public void addNewStudent(UUID studentId, Student student) {
    UUID newStudentId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());

    studentDataAccessService.insertNewStudent(newStudentId, student);
  }
}
