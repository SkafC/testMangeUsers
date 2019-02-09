package org.skafcommunity.emsikeep.manageusers.services;

import org.skafcommunity.emsikeep.manageusers.models.Administrator;
import org.skafcommunity.emsikeep.manageusers.models.Professor;
import org.skafcommunity.emsikeep.manageusers.models.Student;
import org.skafcommunity.emsikeep.manageusers.models.User;

import java.util.ArrayList;
import java.util.List;

public class TestServices {
  private static List<User> users = new ArrayList<>();
  static {
    Professor professor = new Professor();
    professor.setId("Y123");
    professor.setFistName("Ibrahim");
    professor.setLastName("EL-MALKI");
    professor.setEmail("Ibrahim.ELMALKI@gmail.com");
    users.add(professor);
    Administrator administrator = new Administrator();
    administrator.setId("X111");
    administrator.setFistName("Khalid");
    administrator.setLastName("ENNASIRI");
    administrator.setEmail("Khalid.ENNASIRI@gmail.com");
    users.add(administrator);
    Student student = new Student();
    student.setId("Z222");
    student.setFistName("Sabrina");
    student.setLastName("BENNANI");
    student.setEmail("Sabrina.Bent.BENNANI@gmail.com");
    users.add(student);
  }

  public static List<User> getUsers(){
    return users;
  }
}
