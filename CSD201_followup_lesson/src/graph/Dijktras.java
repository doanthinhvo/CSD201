package Graph;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doant
 */

public class Dijktras {
          int n; 
          char []  v = "ABCDEFGHIJK".toCharArray();
          int [][] w;
          int INF = 1000;
          
          void setData(int [][] b){ // b is adjency matrix
                    n = b.length; 
                    w = new int[n][n];
                    for (int i = 0;  i < n; i++){
                              for (int j = 0; j < n; j ++){
                                        w[i][j] = b[i][j];
                              }
                    }
          }
          
          void displayWeight(){
                    for (int i = 0; i < n; i++) {
                              for (int j = 0; j < n; j++)
                                        if (w[i][j] != INF)
                                                  System.out.printf("%4d", w[i][j]);
                                        else
                                                  System.out.print("INF ");
                              System.out.println("");
                    }
          }
          
          void visit(int u){
                    System.out.print(" " + v[u]);
          }
          
          void displayDistance(int [] d) {
                    for (int i = 0; i < n; i++)
                              System.out.print(d[i] + " ");
    }
          
          void displayPath(int startVertex, int endVertex, int d, int [] p){
                    if (d == INF){
                              System.out.println("No path from " + v[startVertex] + " to " +v[endVertex]);
                              return;
                    }
                    
                    System.out.println("The shortest path from " + v[startVertex] + " to " + v[endVertex] + " is " + d);
                    MyStack s = new MyStack();
                    int u = endVertex;
                    while (u != -1){
                              /*
                              Trong v??ng while n??y, u ???????c update theo previous[u] (?????nh ??? tr?????c u). 
                              Khi u = -1, l?? khi ???? ?????n ???????c ?????n ???????c v???i ?????nh ?????u c???a path c???n t??m. 
                              "Previous c???a startVertex lu??n b???ng -1." 
                              */
                              s.push(u);
                              u = p[u];
                    }
                    u = s.pop();
                    System.out.print(v[u]);
                    while (!s.isEmpty()){
                              u = s.pop();
                              System.out.println("  ->  " + v[u]);
                    }
                    System.out.println();
          }
          
          void dijkstra(int startVertex, int endVertex){
                    boolean [] checked = new boolean[n]; // ki???m tra xem ?????nh ???????c th??m v??o t???p ?????nh ch??nh c???a thu???t to??n ch??a ( t???p ch???a c??c ?????nh theo path ng???n nh???t theo dijkstra)
                    int [] d = new int[n]; // bi???n kho???ng c??ch trong dijkstra. represent for current distance of one vertices. // l?? gi?? tr??? m???i ?? trong b???ng minh ho??? thu???t to??n n??y. 
                    int [] previous = new int[n]; // array ????? l??u v???t.
                    int min_d;  // ????? ch???n ra ?????nh c?? distance b?? nh???t trong c??c ?????nh ???? ???????c ch???n (checked  = true).
                    
                    for (int i = 0; i < n; i++){
                              checked[i] = false;
                    }
                    
                    for (int i = 0; i < n; i++){
                              d[i] = INF;
                    }
                    
                    d[startVertex] = 0;
                    
                    for (int i = 0; i < n; i++){
                              previous[i] = -1;
                    }
                    
                    int u = startVertex;
                    while (u != -1){
                              checked[u] = true;
                              for (int i = 0;i<n; i++){ // t??? ?????nh u duy???t qua t???t c??? ?????nh c??n l???i. 
                                        if (!checked[i] && (d[i] > d[u] + w[u][i])){ // N???u kh??ng c?? path gi???a u v?? i th?? w[u][i] = INF => m???nh ????? if (d[i] > d[u] + w[u][i] ch???c ch???n sai. 
                                                  d[i] = d[u] + w[u][i];
                                                  previous[i] = u; // l??u m???ng l??u v???t ( ????? ??i ???????c ?????n i th?? ph???i qua u).
                                        }
                              }
                              min_d = INF;
                              u = -1; // n???u kh??ng t??m ???????c ?????nh m???i th?? d???ng v??ng while tr??n.
                              for (int i = 0; i < n; i++){ // v??ng n??y ????? t??m ?????nh ti???p theo ???????c ????a vo?? list ?????nh (list ?????nh ch??nh).
                                        if (!checked[i] && (d[i] < min_d)){ // min_d ?????m b???o ?????nh ???????c t??m ra l?? ?????nh c?? distance min. 
                                                  min_d = d[i]; // t??m ra trong c??c ?????nh v???a m???i t??nh kho???ng c??ch v???i u: ?????nh n??o l?? ?????nh c?? distance b?? nh???t
                                                   u = i; // ch???n ?????nh ???? ????? ti???p t???c x??? l??.
                                        }
                              }
                              if (u == endVertex) u = -1;
                    }
                    displayPath(startVertex, endVertex, d[endVertex], previous);
          }
          
}
