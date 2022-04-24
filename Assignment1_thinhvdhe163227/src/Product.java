/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doant
 */
public class Product {
          String name;
          double Price;
          int Quantity;

          public Product(String name, double Price, int Quantity) {
                    this.name = name;
                    this.Price = Price;
                    this.Quantity = Quantity;
          }
          
          @Override
          public String toString(){
                    return "(" + name +", " + Price + ", " + Quantity + ")"; 
          }
}
