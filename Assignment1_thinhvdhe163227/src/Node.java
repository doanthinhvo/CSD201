/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doant
 */
public class Node {

          Product info;
          Node next;

          Node(Product x) {
                    info = new Product(x.name, x.Price, x.Quantity);
                    next = null;
          }

          Node(String name, double price, int quantity) {
                    info = new Product(name, price, quantity);
                    next = null;
          }
}
