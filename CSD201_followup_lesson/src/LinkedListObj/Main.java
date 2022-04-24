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
public class Main {
          public static void main(String[] args){
                    MyList list = new MyList();
                    list.addFirst("a", 1);
                    list.addFirst("b", 2);
                    list.addFirst("c", 3);
                    list.addFirst("d", 4);
                    list.addFirst("e", 5);
                   //  {e, 5}  {d, 4}  {c, 3}  {b, 2}  {a, 1}  
//                   list.delFirst();
//                    list.delLast();
                    Node pe = list.searchByName("a");
                    Node se = new Node("k", 19);
//                    list.deleteNode(pe);
//                    list.addBefore(pe, "Tu xuong", 8);
                    list.deleteBefore(se);
//                    System.out.println();
//                    System.out.println(list.count());
                    list.display();
//                    System.out.println(list.searchByName("jd"));

          }
}
