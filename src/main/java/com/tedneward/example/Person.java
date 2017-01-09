package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static int instanceCount;
  
  //initializes person with blank name, age of 0, and salary of 0
  public Person() {
    this("", 0, 0.0d);
  }
  
  //initializes Person. Takes in a String for the name, and int for the age, and a double for 
  //the salary. Updates the number of instances of Person
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    ssn = "";
    this.instanceCount++;
  }
  
  //Compares the age of two Persons, gets done in ascending order.
  public static class AgeComparator implements Comparator<Person> {
    public int compare(Person one, Person two) {
      return one.getAge() - two.getAge();
    }
  }
  
  //returns the number of Person instances
  public static int count() {
    return instanceCount;
  }
  
  //Takes in int to change the value of the age. If the age is less than
  //0, throws an IllegalArgumentException.
  public void setAge(int newAge) {
    if(newAge < 0) {
      throw new IllegalArgumentException();
    }
    this.age = newAge;
  }
  
  //returns the age of the Person
  public int getAge() {
    return this.age;
  }
  
  //Can change the name of the Person. If the String is null, throws a new IllegalArgumentException
  public void setName(String newName) {
    if(newName == null) {
      throw new IllegalArgumentException();
    }
    this.name = newName;
  }
  
  //Returns the name of the Person
  public String getName() {
    return this.name;
  }
  
  //Sets the Salary of the person
  public void setSalary(double newSalary) {
    this.salary = newSalary;
  }
  
  //Returns the Salary of the Person
  public double getSalary() {
    return this.salary;
  }
  
  //Sets the SSN of the Person
  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  
  //Returns the SSN of the Person
  public String getSSN() {
    return this.ssn;
  }
  
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  //Returns the amount of Bonus
  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  //Compares two Persons. Considered equal if the name and age are both the same
  public boolean equals(Object other) {
    if(other instanceof Person) {
      Person p = (Person)other;
      return this.name.equals(p.name) && this.age == p.age;
    } else {
      return false;
    }
  }
  
  //Adds ten years to the Person
  public int timeWarp() {
    return age + 10;
  }
  
  //Returns a String in the format of "[Person name: age: salary: ]
  public String toString() {
    return "[Person name:" + this.name + " age:" + this.age + " salary:" + this.salary + "]";
  }
  
  //Used to implement Comparable, compares Persons based on salary. Done in descending order.
  public int compareTo(Person other) {
    return (int) other.salary - (int) this.salary;
  }
  
  //Returns a List of People objects of Neward's Family and their name, age, and Salary
  public static ArrayList<Person> getNewardFamily() {
    ArrayList<Person> newardFam = new ArrayList<Person>();
    newardFam.add(new Person("Ted", 41, 250000));
    newardFam.add(new Person("Charlotte", 43, 150000));
    newardFam.add(new Person("Michael", 22, 10000));
    newardFam.add(new Person("Matthew", 15, 0));
    return newardFam;
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
