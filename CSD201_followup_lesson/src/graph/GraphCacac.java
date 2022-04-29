/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author doant
 */
public class GraphCacac {

          int[][] a;//adjcency matrix
          int n;//total vertex
          char[] vertex = "ABCDEFGHIJKLMN".toCharArray();

          public GraphCacac() {
                    int[][] b = {
                              //A  B  C  D  E  F  G  H  I
                              {0, 1, 1, 1, 0, 0, 0, 0, 0}, //A
                              {1, 0, 1, 1, 0, 0, 0, 0, 0}, //B 
                              {1, 1, 0, 1, 0, 0, 0, 0, 0}, //C
                              {1, 1, 1, 0, 0, 1, 0, 0, 0}, //D
                              {0, 0, 0, 0, 0, 1, 0, 0, 0}, //E
                              {0, 0, 0, 1, 1, 0, 0, 0, 0}, //F
                              {0, 0, 0, 0, 0, 0, 0, 1, 1}, //G
                              {0, 0, 0, 0, 0, 0, 1, 0, 0}, //H
                              {0, 0, 0, 0, 0, 0, 1, 0, 0} //I
                    };
                    a = b;
                    n = a.length;
          }
          //visit vertex i

          public void visit(int i) { // chuyển từ đỉnh ở dạng số thứ tự sang dạng ABCDEF
                    System.out.print(vertex[i] + "  ");
          }

          //Breadth first traversal
          public void BFT(int u, boolean[] c) { // từ đỉnh u BFT đến các đỉnh khác . 
                    MyQueue mq = new MyQueue();
                    mq.enqueue(u); // cho đỉnh u vào queue.
                    c[u] = true; // đỉnh u đã được visit.
                    while (!mq.isEmpty()) {
                              int j = (int) mq.dequeue();
                              visit(j);
                              for (int i = 0; i < n; i++) {
                                        if (!c[i] && a[j][i] > 0) { // check xem có thêm đỉnh vào queue không
                                                  mq.enqueue(i);
                                                  c[i] = true; // nếu được thì update lại checked. 
                                        }
                              }
                    }
          }
          //Breath first traversal

          public void BFT(int u) {
                    boolean[] c = new boolean[n]; // khởi tạo như này tất cả giá trị trong c mặc định bằng false. 
//                    for (int i = 0; i < n; i++){ 
//                              System.out.println("c[" + i +"] = " + c[i]);
//                    }

                    BFT(u, c); // chạy BFT với những đỉnh có connect với u.

                    // Đối với những đỉnh không connected với u. 
                    for (int i = 0; i < n; i++) {
                              if (!c[i]) { // những đỉnh còn lại chưa được duyệt. 
                                        BFT(i, c);
                              }
                    }
          }

          //Depth first traversal 
          public void DFT(int i, boolean[] c) { // xử lý việc DFT từ i tới các đỉnh liên thông  (connect) với i.
                    c[i] = true;
                    visit(i);
                    for (int j = 0; j < n; j++) {
                              if (!c[j] && a[i][j] > 0) {
                                        DFT(j, c);  // IMPORTANT. => Điểm khác nhau chính với BFS. 
                              }
                    }
          }

          public void DFT(int i) {
                    boolean[] c = new boolean[n];
                    DFT(i, c); // với những đỉnh có connect với i

                    // với những đỉnh không connect với i
                    for (int j = 0; j < n; j++) {
                              if (!c[j]) {
                                        DFT(j, c);
                              }
                    }
          }

          // count connectivity paths.
          public int connectedParts() {
                    boolean[] pushed = new boolean[20];
                    boolean cont = false;
                    int i, j, k, r;
                    
                    for (i = 0; i < n; i++) {
                              pushed[i] = false;
                    }
                    
                    MyStack s = new MyStack(); // ? dùng idea of DFS
                    k = 0;
                    while (true) { // mỗi lần vòng while này chạy là đang duyệt cho 1 cụm thành phần liên thông 
                              // biến k được update cuối vòng while ám chỉ vừa mới duyệt qua 1 thành phần liên thônng ( connectivity parts).
                              s.clear(); // sang cụm thành phần liên thông mới
                              i = 0; //??? 
                              while (i < n && pushed[i]) { // nếu i chưa duyệt hết các đỉnh và 1 đỉnh đã được pushed thì update i
                                        // dừng khi gặp 1 đỉnh chưa được pushed. 
                                        i++;
                              }
                              
                              
                              if (i == n) {
                                        break;// duyệt đến hết đỉnh thì dừng. 
                              }
                              
                              s.push(i); // nếu gặp 1 đỉnh chưa được push thì thêm vào s. 
                              pushed[i] = true; // update pushed. 
                              while (!s.isEmpty()) { // chạy hết vòng này thì tất cả các đỉnh có connect với đỉnh i (ngay dòng trên) sẽ được pushed. 
                                        r = s.pop();
                                        for (i = 0; i < n; i++) {
                                                  if (i == r) {
                                                            continue;
                                                  }
                                                  if (!pushed[i] && a[r][i] > 0) { // chưa được push và có connect với cụm đỉnh đang xét. 
                                                            s.push(i);
                                                            pushed[i] = true;
                                                  }
                                        }
                              }
                              
                              
                              k++;
                    }
                    return (k);
          }
          
          

          // Từ đây trở về xuống chưa hiểu để làm gì. 
          /*Session 1_______________________________________________________________*/
          //connectivity
          int[] tp;
          int con;

          public void conDFT(int i, boolean[] c) {
                    c[i] = true;
                    tp[i] = con;
                    for (int j = 0; j < n; j++) {
                              if (!c[j] && a[i][j] > 0) {
                                        conDFT(j, c);
                              }
                    }
          }

          public void conDFT() {
                    con = 0;
                    tp = new int[n];
                    boolean[] c = new boolean[n];
                    for (int i = 0; i < n; i++) {
                              if (!c[i]) {
                                        con++;
                                        conDFT(i, c);
                              }
                    }
                    //output connectivity
                    System.out.println("Connectivity: " + con);
                    for (int i = 1; i <= con; i++) {
                              System.out.println("Connectivity = " + i);
                              for (int j = 0; j < n; j++) {
                                        if (tp[j] == i) {
                                                  visit(j);
                                        }
                              }
                              System.out.println("");
                    }
          }

          //a path between u and v
          int u, v;
          int[] t;
          boolean found = false;

          public void pathDFT(int i, boolean[] c) {
                    c[i] = true;
                    for (int j = 0; j < n; j++) {
                              if (!c[j] && a[i][j] > 0) {
                                        t[j] = i;
                                        if (j == v) {
                                                  found = true;
                                                  return;
                                        }
                                        pathDFT(j, c);
                              }
                    }
          }

          public void pathDFT(int u, int v) {
                    boolean[] c = new boolean[n];
                    t = new int[n];
                    this.u = u;
                    this.v = v;
                    pathDFT(u, c);
                    if (found == false) {
                              System.out.println("not found a path from " + vertex[u] + " to " + vertex[v]);
                    } else {
                              System.out.println("a path from " + vertex[u] + " to " + vertex[v]);
                              int[] h = new int[n];
                              int hn = 0;
                              h[0] = v;
                              while (u != v) {
                                        v = t[v];
                                        h[++hn] = v;
                              }
                              for (int i = hn; i >= 0; i--) {
                                        visit(h[i]);
                                        if (i > 0) {
                                                  System.out.print("->");
                                        }
                              }
                    }
          }
          /*Session 2_______________________________________________________________*/
}
