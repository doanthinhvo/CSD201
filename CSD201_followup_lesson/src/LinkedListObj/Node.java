/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListObj;

import LinkedList.*;

/**
 *
 * @author doant
 */
public class Node {

          Person info;
          Node next;

          Node(Person x) {
                    info = new Person(x.name, x.age);
                    next = null;
          }

          Node(String name, int age) {
                    info = new Person(name, age);
                    next = null;
          }
}
