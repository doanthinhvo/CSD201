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
                              Trong vòng while này, u được update theo previous[u] (đỉnh ở trước u). 
                              Khi u = -1, là khi đã đến được đến được với đỉnh đầu của path cần tìm. 
                              "Previous của startVertex luôn bằng -1." 
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
                    boolean [] checked = new boolean[n]; // kiểm tra xem đỉnh được thêm vào tập đỉnh chính của thuật toán chưa ( tập chứa các đỉnh theo path ngắn nhất theo dijkstra)
                    int [] d = new int[n]; // biến khoảng cách trong dijkstra. represent for current distance of one vertices. // là giá trị mỗi ô trong bảng minh hoạ thuật toán này. 
                    int [] previous = new int[n]; // array để lưu vết.
                    int min_d;  // để chọn ra đỉnh có distance bé nhất trong các đỉnh đã được chọn (checked  = true).
                    
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
                              for (int i = 0;i<n; i++){ // từ đỉnh u duyệt qua tất cả đỉnh còn lại. 
                                        if (!checked[i] && (d[i] > d[u] + w[u][i])){ // Nếu không có path giữa u và i thì w[u][i] = INF => mệnh đề if (d[i] > d[u] + w[u][i] chắc chắn sai. 
                                                  d[i] = d[u] + w[u][i];
                                                  previous[i] = u; // lưu mảng lưu vết ( để đi được đến i thì phải qua u).
                                        }
                              }
                              min_d = INF;
                              u = -1; // nếu không tìm được đỉnh mới thì dừng vòng while trên.
                              for (int i = 0; i < n; i++){ // vòng này để tìm đỉnh tiếp theo được đưa voà list đỉnh (list đỉnh chính).
                                        if (!checked[i] && (d[i] < min_d)){ // min_d đảm bảo đỉnh được tìm ra là đỉnh có distance min. 
                                                  min_d = d[i]; // tìm ra trong các đỉnh vừa mới tính khoảng cách với u: đỉnh nào là đỉnh có distance bé nhất
                                                   u = i; // chọn đỉnh đó để tiếp tục xử lý.
                                        }
                              }
                              if (u == endVertex) u = -1;
                    }
                    displayPath(startVertex, endVertex, d[endVertex], previous);
          }
          
}
