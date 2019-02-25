package com.talfinder.assessment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hbhargav on 22/02/19.
 */
public class StudentSorter {

  public static List<Student> sort(List<Student> students) {
     /*
     * NOTE:
     * 1. Write your solution within this method
     * 2. Do not make changes to this Class Name, Method Name or Method Signature
     * 3. You're allowed to add new Classes & Methods
     * 4. Use the Run-Java command to run main method
     * 5. Use the BuildAndRunTests command to evaluate your solution
     */
    return students;
  }

  public static void main(String[] args) {
    List<Student> students = Arrays.asList(
        new Student(20,"Advith", 2.46),
        new Student(44,"Bhargav", 0.46),
        new Student(8,"Advith", 2.46),
        new Student(12,"Harsha", 3.83));

    students = sort(students);

    for(Student student : students) {
      System.out.println(student.getId() + " - " +student.getName() + " - " + student.getCgpa());
    }
  }
}
