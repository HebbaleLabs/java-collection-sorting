package com.talfinder.assessment;

/**
 * Created by hbhargav on 22/02/19.
 */
public class Student {

  private int id;

  private String firstName;

  private double cgpa;

  public Student(int id, String firstName, double cgpa) {
    this.id = id;
    this.firstName = firstName;
    this.cgpa = cgpa;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public double getCgpa() {
    return cgpa;
  }

  public void setCgpa(double cgpa) {
    this.cgpa = cgpa;
  }
}
