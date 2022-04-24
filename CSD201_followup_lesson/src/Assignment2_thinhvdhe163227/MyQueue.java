/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2_thinhvdhe163227;
//import bst.*;
import java.util.LinkedList;

/**
 *
 * @author doant
 */
public class MyQueue {

          LinkedList<Object> head;

          public MyQueue() {
                    head = new LinkedList<>();
          }

          public void enqueue(Object obj) { // add to last of queue.
                    head.addLast(obj);
          }

          public boolean isEmpty() {
                    return head.isEmpty();
          }

          public Object dequeue() { // get and remove first value
                    if (isEmpty()) {
                              return null;
                    } else {
                              return head.removeFirst();
                    }
          }

          public Object front() { // get but not remove first value
                    if (isEmpty()) {
                              return null;
                    } else {
                              return head.getFirst();
                    }
          }

          public void clear() {
                    head = null;
          }
}
