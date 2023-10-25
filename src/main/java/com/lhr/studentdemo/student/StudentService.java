package com.lhr.studentdemo.student;

import com.lhr.studentdemo.EmailValidator;
import com.lhr.studentdemo.exception.ApiRequestException;

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
  private final EmailValidator emailValidator;

  @Autowired
  public StudentService(StudentDataAccessService studentDataAccessService, EmailValidator emailValidator){
    this.studentDataAccessService = studentDataAccessService;
    this.emailValidator = emailValidator;
  }
  List<Student> getAllStudents(){
    return studentDataAccessService.selectAllStudents();
  }
  public void addNewStudent(Student student) {
    addNewStudent(null, student);
  }
  public void addNewStudent(UUID studentId, Student student) {
    UUID newStudentId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());
    if(!emailValidator.test(student.getEmail())){
      throw new ApiRequestException(student.getEmail() + "is not valid");
    }
    if(studentDataAccessService.isEmailTaken(student.getEmail())){
      throw new ApiRequestException(student.getEmail() + " is taken");
    }
    studentDataAccessService.insertNewStudent(newStudentId, student);
  }
}
