/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import Graph.Dijktras;

/**
 *
 * @author doant
 */
public class TestGraph {

          public static void main(String[] args) {
//                    int[][] b = {
//                              {0, 1, 1, 0, 0, 0}, // row 0, đỉnh 0 nối với các đỉnh 1, 2
//                              {1, 0, 0, 1, 0, 0}, // đỉnh 1 nối với các đỉnh 0, 3
//                              {1, 0, 0, 0, 0, 0},
//                              {0, 1, 0, 0, 0, 0},
//                              {0, 0, 0, 0, 0, 1}, // đỉnh 4 nối với đỉnh 5
//                              {0, 0, 0, 0, 1, 0} // đỉnh 5 nối với đỉnh 6
//                    };

                    // tạo đồ thị
//                    MyGraph g = new MyGraph();
//                    g.setData(b);
////                    g.displayAdj();
//                    g.displayGraph();
////                    g.breadth(0);
//                    System.out.println("Breath First search: ");
//                    g.breath(3);
      
                    
                    /*
                    Test Dijkstra
                    */
//                    Dijktras djk = new Dijktras();
//                    int INF = 1001;
//                    int [][] input = {
//                              {0 , 7, 9, INF, INF, INF},
//                              {7, 0, 10, 15, INF, INF},
//                              {9, 10, 0, 11, INF, 2},
//                              {INF, 15, 11,   0,   6, INF},
//                              {INF, INF, INF, 6, 0, 9},
//                              {14, INF, 2, INF, 9, 0}
//                    };
//                    djk.setData(input);
//                    djk.dijkstra(0 , 3);
                    
                    /*
                    Test Euler
                    */
                    
                    Euler e = new Euler();
//                    e.displayGraph();
//                    e.euler(); // hàm này có thay đổi giá trị a nên nếu gọi hàm này khi gọi hàm check hasEulerCycle thì sẽ bị sai. 
                    System.out.println(e.hasEulerCycle());
//                    System.out.println(e.allDegEven());
//                    e.isConnected();
          }
}
