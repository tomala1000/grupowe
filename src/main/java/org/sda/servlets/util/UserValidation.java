package org.sda.servlets.util;

import org.sda.servlets.domain.User;

public class UserValidation {

    private UserValidation() {
    }

    public static boolean validate(User user) {

      return (user.getFirstName() != null
              && !user.getFirstName().equals("")
              && user.getLastName() != null
              && !user.getLastName().equals("")
              && user.getEmail() != null
              && !user.getEmail().equals(""));
    }


}
