/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTex;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 *
 * @author doant
 */
public class BSTree {
          public static void main(String[] args) throws FileNotFoundException, Exception {
                    MyTree tree = new MyTree();
                    tree.insert("a", 9);
                    tree.insert("gdda", 9);
                    tree.insert("c", 9);
                    tree.insert("d", 9);
                    tree.insert("e", 9);
                    tree.insert("f", 9);
                    String fname = "q2.txt";
                    RandomAccessFile f = new RandomAccessFile(fname, "rw");
//                    tree.preOrder();
//                    tree.postOrder();
//                    tree.postOrder3();
                    tree.preOrder2(tree.root, f);
          }
}
