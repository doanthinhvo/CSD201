/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTex;

/**
 *
 * @author doant
 */
public class Node {
          Person info;
          Node left;
          Node right;
          
          Node(String name, int  age){
                    info = new Person(name, age);
                    left = null; right = null;
          }
}
