/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author doant
 */
public class Main {
          public static void main(String[] args){
                    MyList list = new MyList();
                    list.addToTail(5);
                    list.addToTail(4);
                    list.addToTail(99);
                    list.addToTail(2);
                    list.addToTail(1);
                    // 1 2 3 4 5
//                    list.deleteFromHead();
//                    list.deleteFromTail();
//                    Node b = list.search(5);
//                    list.deleteAfter(b);
//                    list.display();
//                    list.dele(5);
//                    list.deleteNode(b);
//                    list.deleteAt(3);
//                    list.sort();
                    System.out.println(list.getMax().info);
                    list.display();
          }
}
