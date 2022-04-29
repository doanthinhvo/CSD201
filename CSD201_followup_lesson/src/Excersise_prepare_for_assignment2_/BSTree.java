/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excersise_prepare_for_assignment2_;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 *
 * @author doant
 */
public class BSTree {
          public static void main(String[] args) throws FileNotFoundException, Exception {
                    MyTree tree = new MyTree();
                    tree.insert("d", 50);
                    tree.insert("b", 14);
                    tree.insert("a", 60);
                    tree.insert("c", 20);
                    tree.insert("e", 10);
                    tree.insert("f", 80);
                    tree.insert("g", 15);
                    tree.BalanceFactorBFS(tree.root);
                    tree.preOrder();
          }
}
