package com.lhr.studentdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/12/00:24
 * @Description:
 */
@Repository
public class StudentDataAccessService {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public StudentDataAccessService(JdbcTemplate jdbcTemplate){

    this.jdbcTemplate = jdbcTemplate;
  }
  public List<Student> selectAllStudents(){
    String sql = "SELECT " +
                "student_id, " +
                "first_name, " +
                "last_name, " +
                "email, " +
                "gender " +
                "FROM student";
    return jdbcTemplate.query(sql, getStudentRowMapper());

  }

  private  RowMapper<Student> getStudentRowMapper() {
    return (resultSet, i) -> {
      String studentIdStr = resultSet.getString("student_id");
      UUID studentId = UUID.fromString(studentIdStr);

      String firstName = resultSet.getString("first_name");
      String lastName = resultSet.getString("last_name");
      String email = resultSet.getString("email");

      String genderStr = resultSet.getString("gender").toUpperCase();
      Student.Gender gender = Student.Gender.valueOf(genderStr);
      return new Student(studentId, firstName, lastName, email, gender);
    };
  }

   int insertNewStudent(UUID studentId, Student student) {
    String sql  = "" +
            "INSERT INTO student (" +
            "student_id," +
            " first_name," +
            " last_name," +
            " email," +
            " gender)" +
            "VALUES (?, ?, ?, ?, ?)";
    return jdbcTemplate.update(
            sql,
            studentId,
            student.getFirstName(),
            student.getLastName(),
            student.getEmail(),
            student.getGender().name().toUpperCase()
            );
  }

   boolean isEmailTaken(String email) {
    String sql = "" +
            "SELECT EXISTS (" +
            " SELECT 1 " +
            " FROM student" +
            " WHERE email = ?" +
            ")";
    return jdbcTemplate.queryForObject(
            sql,
            new Object[]{email},
            (resultSet, i) -> resultSet.getBoolean(1)
    );
  }
}
