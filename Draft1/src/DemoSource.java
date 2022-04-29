/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doant
 */
public class DemoSource {
          void quiz(int n){
                    if (n > 1){
                              quiz(n/2);
                              quiz(n/2);
                    }
                    System.out.println("* ");
          }
}
