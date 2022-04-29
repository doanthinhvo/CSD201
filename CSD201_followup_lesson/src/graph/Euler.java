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
public class Euler {
          int [][] a; int n;
          public Euler(){
                    int [][] b = {
                              {0, 1, 1, 0, 0},
                              {1, 0 , 1, 0, 0},
                              {1, 1, 0, 1, 1},//C
                              {0, 0, 1, 0, 1},//D
                              {0, 0, 1, 1, 0}
                    };
                    a = b; n = b.length;
          }
          
          char [] v = "ABCDEFGHIJ".toCharArray();
          void displayGraph(){ //  hiển thị ra ma trận dạng bảng đỉnh kề
                    for (int i = 0; i < n; i++){ // duyệt từng rows
                              System.out.print(v[i] + ": "); // in ra tên đỉnh tương ứng với rows đó
                              for (int j = 0; j < n; j++)  // trong mỗi row lại duyệt theo từng cột để tìm xem đỉnh nào kề với đỉnh đang xét hiện tại
                                        if (a[i][j] > 0) // lớn hơn 0 nghĩa là có nối từ đỉnh i đến đỉnh đó
                                                  System.out.print(v[j] + " "); // in đỉnh này ra
                              System.out.println();
                    }
          }
          // count deg 
          int deg(int i) {
                    int s,j;
                    s=0; // biến để tính tổng deg
                    for(j=0;j<n;j++) s += a[i][j]; //duyệt qua từng phần tử trong hàng ứng với đỉnh đó. 
                    s += a[i][i]; // ?? why I need this line. 
                    return(s);
           }
          
          // check isolated 
          boolean hasIsolated() {
                    for (int i=0;i<n;i++) 
                              if(deg(i)==0) return(true);
                    return(false);
          }
          
          //check connect
            boolean isConnected() {
                    boolean [] p = new boolean[n];
                    int i,j,r;
                    
                    for(i=0;i<n;i++) p[i]=false;
                    MyStack s = new MyStack();
                    s.push(0); p[0] = true; // đưa 1 đỉnh vào stack, rồi từ đỉnh đó tìm đường đi đến các đỉnh khác ?? idea của DFS ?? 
                    
                    while(!s.isEmpty()) {
                              r = s.pop();
                              for(i=0;i<n;i++)
                                        if(!p[i] && a[r][i]>0) {
                                                  s.push(i); p[i]=true;   // dùng stack là DFS rồi. 
                                        }  
                              }
//                    for(i=0;i<n;i++)
//                                System.out.println("đỉnh " + i + " " + p[i]);
                    for(i=0;i<n;i++)
                              if(p[i] == false){
//                                        System.out.println("đỉnh không được duyệt là " + i);
                                        return false;
                              }
                    return(true);
            }

          //check undirected
            boolean isUnDirected() {
              int i,j;
              for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                  if(a[i][j] != a[j][i]) return(false);
              return(true);
            }

          //check all deg even
            boolean allDegEven() {
              for(int i=0;i<n;i++)
                if(deg(i)%2 == 1) return(false);
              return(true);
            }

          //check has euler cycle
            boolean hasEulerCycle() {
                    if(!hasIsolated() && isUnDirected() && isConnected() && allDegEven())
                              return(true);
                    else
//                              System.out.println("hasIsolated " + hasIsolated());
//                              System.out.println("isUndirected " + isUnDirected());
//                              System.out.println("connnected " + isConnected());
//                              System.out.println("all deg even " + allDegEven());
                              return(false);
            }
          
          public void euler(){
                    MyStack m = new MyStack();
                    m.push(0);
                    int [] e = new int[20];
                    int ne = 0;
                    
                    while (!m.isEmpty()){
                              int r = (int) m.top();
                    
                    
                    int i =0;
                    while (i < n && a[r][i] == 0) i++;
                    if (i == n){
                              e[ne] = r; m.pop(); ne++;
                    }
                    else {
                              a[r][i]--;
                              a[i][r]--;
                              m.push(i);}
                    }
                    char [] c = "ABCDEFGHIJ".toCharArray();
                    
                    for (int i = 0; i  < ne; i++){
                              System.out.println(c[e[i]] + "  ");
                    }
                    System.out.println("");
          }
}
