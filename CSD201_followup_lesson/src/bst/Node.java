/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author doant
 */
public class Node {
          int info;
          Node left;
          Node right;

          Node(int x) {
              info = x;
              left = null;
              right = null;
          }
}
