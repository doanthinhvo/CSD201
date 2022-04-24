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
          
          void visit(int i){
                    System.out.println(" " + v[i]);
          }
          
          void breath(boolean enqueue[], int k){
                    MyQueue q = new MyQueue();
                    int i, h;
//                    q.enqueue(h);
          }
          void breath(int k){
                    
          }
          
}
