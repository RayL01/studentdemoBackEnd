package com.lhr.studentdemo;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/24/23:46
 * @Description:
 */
class EmailValidatorTest {
  private final EmailValidator underTest = new EmailValidator();
  @Test
  public void itShouldValidateCorrectEmail() {
    assertThat(underTest.test("hello@gmail.com")).isTrue();
  }
}