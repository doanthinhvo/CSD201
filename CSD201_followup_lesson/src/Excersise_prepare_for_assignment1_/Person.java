/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excersise_prepare_for_assignment1_;

/**
 *
 * @author doant
 */
public class Person {

          String name;
          int age;

          public Person(String name, int age) {
                    this.name = name;
                    this.age = age;
          }

          @Override
          public String toString() {
                    return "{" + name + ", " + age + "} ";
          }

}