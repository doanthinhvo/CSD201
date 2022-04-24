/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doant
 */
public class Main {
          public static void main(String[] args){
                    MyList m = new MyList();
                    
                    // check addLast
                    m.addLast("b", 20, 20);
//                    m.addLast("b", 2, 3);
                    m.addLast("c", 20, 6);
                    m.addLast("gg", 25, 0);
                    m.addLast("d", 0, 0);
                    m.addLast("kk", 20, 7);
                    m.addLast("baddx", 29.5, 0);
                    m.addLast("b", 8, 2);
                    m.addLast("b", 8, 3);
                    m.addLast("b", 8, 14);
                    m.addLast("b", 3, 3);
//                    m.display();
//                    m.remove_duplicates();
                    m.sortByValue();
//                    m.remove_duplicates();
                    
//                    m.display();
//                    m.display();
//                    m.traverse();
//                    System.out.println(m.getNode(m.count() - 1).info);
//                    m.sort();
//                    m.display();
//                    m.traverse();
//                    System.out.println("head = " + m.head.info);
//                    System.out.println("tail = " + m.tail.info);
                    m.display();
                    
//                    System.out.println(m.totalValue());
          }
}
