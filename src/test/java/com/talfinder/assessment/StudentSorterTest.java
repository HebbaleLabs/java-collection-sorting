package com.talfinder.assessment;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    Assert.assertEquals("Rumpa", sortedStudents.get(4).getName());
  }

  @Test
  public void sortStudentEmptyList() {
    List<Student> students = Arrays.asList();
    List<Student> sortedStudents = studentSorter.sort(students);
    Assert.assertEquals(0 , sortedStudents.size());
  }

  @Test
  public void smallSortStudentByCGPANameId() {
    List<Student> students = Arrays.asList(
        new Student(33,"Rumpa", 3.68),
        new Student(85,"Ashish", 3.85),
        new Student(56,"Samiha", 3.75),
        new Student(19,"Samara", 3.75),
        new Student(22,"Fahim", 3.76),
        new Student(12,"Samara", 3.75));

    List<Student> sortedStudents = studentSorter.sort(students);
    Assert.assertEquals(12, sortedStudents.get(2).getId());
  }

  @Test
  public void largeSortStudentByCGPANameId() {
    ClassLoader classLoader = getClass().getClassLoader();

    List<String> inputList = new ArrayList<>();
    try (Stream<String> lines = Files.lines(Paths.get(classLoader.getResource("input.txt").toURI()))) {
      inputList = lines.collect(Collectors.toList());
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }

    List<Student> students = new ArrayList<>();
    for(String input : inputList) {
      String[] inputArray = input.split(" ");
      Student student = new Student(Integer.parseInt(inputArray[0]), inputArray[1], Double.parseDouble(inputArray[2]));
      students.add(student);
    }

    List<Student> sortedStudents = studentSorter.sort(students);
    List<String> sortedStudentName = new ArrayList<>();
    for(Student student : sortedStudents) {
      sortedStudentName.add(student.getName());
    }

    String[] actualSort = sortedStudentName.toArray(new String[0]);

    String[] expectedSort = new String[1000];
    try (Stream<String> lines = Files.lines(Paths.get(classLoader.getResource("output.txt").toURI()))) {
      expectedSort = lines.toArray(String[]::new);
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }

    Assert.assertArrayEquals(expectedSort, actualSort);
  }
}
