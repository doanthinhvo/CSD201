/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author doant
 */
public class TestGraph {

          public static void main(String[] args) {
                    int[][] b = {
                              {0, 1, 1, 0, 0, 0}, // row 0, đỉnh 0 nối với các đỉnh 1, 2
                              {1, 0, 0, 1, 0, 0}, // đỉnh 1 nối với các đỉnh 0, 3
                              {1, 0, 0, 0, 0, 0},
                              {0, 1, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 1}, // đỉnh 4 nối với đỉnh 5
                              {0, 0, 0, 0, 1, 0} // đỉnh 5 nối với đỉnh 6
                    };

                    // tạo đồ thị
                    MyGraph g = new MyGraph();
                    g.setData(b);
//                    g.displayAdj();
                    g.displayGraph();
//                    g.breadth(0);
          }
}
