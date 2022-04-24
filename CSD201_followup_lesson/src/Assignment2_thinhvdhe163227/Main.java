/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2_thinhvdhe163227;

/**
 *
 * @author doant
 */
public class Main {
          public static void main(String[] args) {
                    MyTree tree = new MyTree();
//                    (A6,1) (A2,5) (B6,1) (A1,2) (A5,5) (A4,7) (A3,7) (B8,3) (A7,3) (A9,6) (A8,4)
// (A91,2) (A11,10)
                    tree.insert("A6", 1);
                    tree.insert("A2", 5);
                    tree.insert("B6", 1);
                    tree.insert("A1", 2);
                    tree.insert("A5", 5);
                    tree.insert("A4", 7);
                    tree.insert("A3", 7);
                    tree.insert("B8", 3);
                    tree.insert("A7", 3);
                    tree.insert("A9", 6);
                    tree.insert("A8", 4);
                    tree.insert("A91", 2);
                    tree.insert("A11", 11); 
//                    tree.traverse();
//                    tree.delete();
                    tree.rotateLeft();
          }
}
