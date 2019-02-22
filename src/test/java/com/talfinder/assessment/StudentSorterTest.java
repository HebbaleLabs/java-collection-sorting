package com.talfinder.assessment;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hbhargav on 22/02/19.
 */
public class StudentSorterTest {
  private StudentSorter studentSorter = new StudentSorter();

  @Test
  public void sortStudentByCGPAName() {
    List<Student> students = Arrays.asList(
        new Student(33,"Rumpa", 3.68),
        new Student(85,"Ashish", 3.85),
        new Student(56,"Samiha", 3.75),
        new Student(19,"Samara", 3.75),
        new Student(22,"Fahim", 3.76));

    List<Student> sortedStudents = studentSorter.sort(students);
    Assert.assertEquals("Rumpa", sortedStudents.get(4).getFirstName());
  }
}
