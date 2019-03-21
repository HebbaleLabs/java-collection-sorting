package com.talfinder.assessment;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Created by hbhargav on 22/02/19.
 */
@RunWith(Parameterized.class)
public class StudentSorterTest {

  private List<Student> input;
  private String[] expected;

  public StudentSorterTest(List<Student> input, String[] expected) {
    this.input = input;
    this.expected = expected;
  }

  @Parameters
  public static Collection<Object[]> parameters() {
    return Arrays.asList(new Object[][] {
        {Arrays.asList(new Student(33,"Rumpa", 3.68), new Student(85,"Ashish", 3.85), new Student(56,"Samiha", 3.75), new Student(19,"Samara", 3.75), new Student(22,"Fahim", 3.76)),
            new String []{"Ashish","Fahim","Samara","Samiha","Rumpa"}},
        {Arrays.asList(new Student(33,"Rumpa", 3.68), new Student(85,"Ashish", 3.85), new Student(56,"Samiha", 3.75), new Student(19,"Samara", 3.75), new Student(22,"Fahim", 3.76), new Student(12,"Samara", 3.75)),
            new String []{"Ashish","Fahim","Samara","Samara","Samiha","Rumpa"}},
        {Arrays.asList(), new String[]{}},
        {getStudentsFromFile("input.txt"), getStudentNamesFromFile("output.txt")}
    });
  }

  @Test
  public void sortStudents() {
    Assert.assertArrayEquals("input:Student List " + input, expected, getStudentNames(StudentSorter.sort(input)));
  }

  private static List<Student> getStudentsFromFile(String filename) {
    ClassLoader classLoader = StudentSorterTest.class.getClassLoader();
    Stream<String> lines = null;
    try {
      lines = Files.lines(Paths.get(classLoader.getResource(filename).toURI()));
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
    List<String> inputList = lines.collect(Collectors.toList());

    List<Student> students = new ArrayList<>();
    for(String input : inputList) {
      String[] inputArray = input.split(" ");
      Student student = new Student(Integer.parseInt(inputArray[0]), inputArray[1], Double.parseDouble(inputArray[2]));
      students.add(student);
    }
    return students;
  }

  private static String[] getStudentNamesFromFile(String filename) {
    ClassLoader classLoader = StudentSorterTest.class.getClassLoader();
    Stream<String> lines = null;
    try {
      lines = Files.lines(Paths.get(classLoader.getResource(filename).toURI()));
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
    return lines.collect(Collectors.toList()).toArray(new String[0]);
  }

  private static String[] getStudentNames(List<Student> students) {
    List<String> studentNames = new ArrayList<>();
    for(Student student : students) {
      studentNames.add(student.getName());
    }
    return studentNames.toArray(new String[0]);
  }
}
