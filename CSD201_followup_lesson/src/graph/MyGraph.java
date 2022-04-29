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
public class MyGraph {
          int n; 
          int[][] a;          
          char[] v;

          public MyGraph() {
                    v = "ABCDEFGHIJKLMN".toCharArray();
          }
          
          void setData(int[][] b){ // không hiểu cái này lắm, copy lại nội dung matrix gốc input sang input xử lý xuyên suốt. (từ biến bên ngoài vào (không thể thay đổi, chuyển sang biến được khai báo cho hàm và có thể thay đổi.??? 
                    n = b.length;
                    a = new int[n][n];
                    for (int i = 0; i<n; i++){
                              for (int j =  0; j < n; j++){
                                        a[i][j] = b[i][j];
                              }
                    }
          }
          
          void displayAdj(){ // in ra lại adjacency matrix 
                    for (int i = 0;i < n; i++){
                              for (int j = 0; j < n; j++)
                                        System.out.print(a[i][j] + " ");
                              System.out.println(""); // cú pháp hay, thụt dòng có ảnh hưởng (không phải chỉ mỗi dấu {} 
                    }
          }
          
          void displayGraph(){ //  hiển thị ra ma trận dạng bảng đỉnh kề
                    for (int i = 0; i < n; i++){ // duyệt từng rows
                              System.out.print(v[i] + ": "); // in ra tên đỉnh tương ứng với rows đó
                              for (int j = 0; j < n; j++)  // trong mỗi row lại duyệt theo từng cột để tìm xem đỉnh nào kề với đỉnh đang xét hiện tại
                                        if (a[i][j] > 0) // lớn hơn 0 nghĩa là có nối từ đỉnh i đến đỉnh đó
                                                  System.out.print(v[j] + " "); // in đỉnh này ra
                              System.out.println();
                    }
          }
          
          void visit(int i){ // visit đỉnh được đánh số là i. 
                    System.out.print(" " + v[i]);
          }
          
          
          /*
          Breath First Search Traversal: Note: Nếu có thành phần không liên thông với đỉnh xuất phát thì phần đó không được duyệt. 
          */
          
          void breath(boolean enqueue[], int k){ // đỉnh được đánh số thứ k. 
                    MyQueue q = new MyQueue();
                    int i, h;
                    q.enqueue(new Integer(k));
                    enqueue[k] = true;
                    while (!q.isEmpty()){ // mỗi vòng while này lấy ra 1 đỉnh đã thêm vào queue và duyệt các đỉnh kề nó. Trong queue, các đỉnh cùng level sẽ ở gần nhau, => breath first search.
                              h = Integer.parseInt(q.dequeue().toString().trim());
                              visit(h);
                              for (i = 0; i < n; i++){
                                        if ((!enqueue[i] && a[h][i] > 0)){ // a[h][i] là element trong adjancy matrix 1 or 0 thể hiện xem có cạnh nối giữa 2 đỉnh h và i không. 
                                                  q.enqueue(new Integer(i));
                                                  enqueue[i] = true; // đánh dấu là đã thăm đỉnh này. 
                                        }
                              } 
                    }
                    System.out.println("");
          }
          void breath(int k){
                    MyQueue q = new MyQueue();
                    boolean[] enqueued = new boolean[n];
                    for (int i = 0; i < n; i++){
                              enqueued[i] = false; // ban đầu tất cả các đỉnh đều chưa được đưa vào queue.
                    }
                    breath(enqueued, k); 
          }
          
          
          /*
          DEPTH FIRST TRAVERSAL
          */
          public void DFT(int i, boolean []c){
                    
          }
          
          void DFT(int i){
                    
          }
          int [] tp; int con;
          void conDFT(int i, boolean [] c){
                    
          }
          
          void conDFT(){
                    
          }
          
          //a path between u and v
           int u, v; int [] t; boolean found = false;
    public void pathDFT(int i, boolean []c){
              
    }
}
