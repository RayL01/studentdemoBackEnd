package com.lhr.studentdemo;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/24/23:40
 * @Description:
 */

@Component
public class EmailValidator implements Predicate<String> {
  public static final Predicate<String> IS_EMAIL_VALID =
          Pattern.compile(
                  "^[A-Za-z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                    Pattern.CASE_INSENSITIVE

          ).asPredicate();
  @Override
  public boolean test(String email) {
    return IS_EMAIL_VALID.test(email);
  }
}
