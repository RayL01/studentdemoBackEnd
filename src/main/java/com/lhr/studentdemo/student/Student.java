package com.lhr.studentdemo.student;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/02/16:41
 * @Description:
 */
public class Student {
  private final UUID studentId;




  @NotBlank
  private final String firstName;
  @NotBlank
  private final String lastName;
  @NotBlank
  private final String email;

  @NotNull
  private final Gender gender;
  public Student(@JsonProperty("studentId") UUID studentId,@JsonProperty("firstName") String firstName,@JsonProperty("lastName") String lastName,@JsonProperty("email") String email,@JsonProperty("gender") Gender gender) {
    this.studentId = studentId;
    this.firstName = firstName;

    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
  }
  enum Gender{
    MALE, FEMALE
  }

  public UUID getStudentId() {
    return studentId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }



  public String getEmail() {
    return email;
  }

  public Gender getGender() {
    return gender;
  }
  @Override
  public String toString() {
    return "Student{" +
            "studentId=" + studentId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", gender=" + gender +
            '}';
  }
}
