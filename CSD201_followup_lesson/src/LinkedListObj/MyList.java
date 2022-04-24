/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListObj;

public class MyList {

          Node head;
          Node tail;

          MyList() {
                    head = null;
                    tail = null;
          }

          boolean isEmpty() {
                    return head == null; // mặc định tail = null 
          }

          void display() {
                    Node p = head;
                    while (p != null) {
                              System.out.print(p.info + " ");
                              p = p.next;
                    }
                    System.out.println();
          }

          // thêm x vào đầu danh sách
          void addFirst(String name, int age) {
                    Node p = new Node(name, age);
                    if (isEmpty()) { // head = tail = null, chưa có phần tử nào cả
                              // gán head = p, và tail cũng là p
                              head = p;
                              tail = p;
                    } else {
                              p.next = head;
                              head = p;
                    }
          }

          // tìm người đầu tiên trong danh sách có tên là name
          Node searchByName(String name) {
                    Node p = head;
                    // thêm các câu lệnh để tìm kiếm
                    while (p != null) {
                              if (p.info.name.equalsIgnoreCase(name)) {
                                        return p;
                              }
                              p = p.next;
                    }
                    // neu khong tim duoc thi p = null
                    return p;
          }

          void addLast(String name, int age) {
                    Node p = new Node(name, age);
                    if (isEmpty()){
                              head = tail = p;
                    }
                    else{
                              tail.next = p; 
                              tail = p; 
                    }          
          }

          void addAfter(Node p, String name, int age) {
                    if (p == null){
                              System.out.println("The node cannot be null");
                              return;
                    }
                    
                    Node c = new Node(name, age);
                    c.next  = p.next;
                    p.next = c;
                    
                    // update tail
                    if (c.next == null){
                              tail = c;
                    }
          }

          void addBefore(Node p, String name, int age) {
                    if (p == null){
                              System.out.println("The node cannot be null");
                              return;
                    }
                    if (isEmpty()) return;
                    if (head == tail) {
                              addFirst(name, age); return;
                    }
                    if (p == head) {
                              addFirst(name, age);
                              return;
                    }
                    Node q = head; // bien chay
                    Node prevNode = null;
                    
                    while (q != null && q != p){ 
                              prevNode = q;
                              q = q.next;
                    }
                    
                    if (q == p) {
                              System.out.println("Hello");
                              Node c = new Node(name, age);
                              prevNode.next = c;
                              c.next = p;
                              return;
                    }
                    else {
                              return;
                    }    
          }

          void delFirst() {
                    if (head == null){
                              return;
                    }
//                    Node p = head;
                    head = head.next;          
          }

          void delLast() {
                    if (head == null || head.next == null){
                              return;
                    }
                    
                    Node secondLast = head;
                    while (secondLast.next.next != null){
                              secondLast = secondLast.next;
                    }
                    
                    secondLast.next = null;
                    tail = secondLast;
          }
          
          void deleteBefore(Node p){
                    if (isEmpty()) return;
                    if (p == null) return;
                    Node q = head;
                    Node prevNode = null;
                    while (q != null && q != p){
                              prevNode = q;
                              q = q.next;
//                              System.out.println("prev Node = " + prevNode.info);
//                              System.out.println("q = " + q.info);
                    }
                    
                    if (q == p) { // dùng việc tìm ra p làm điều kiện dừng
                              System.out.println("Hello");
                              deleteNode(prevNode);
                    }
                    else return;
          }
//7. `int deleteAter(Node p)` - delete the node after the node  p  and return its info.
          void deleteAfter(Node p) {
                    if (isEmpty() || p == tail || p == null ){
                              return;
                    }
                    else if (p == head && p == tail){
                              return;
                    }
                    else if (p.next == tail){
                              delLast();
                    }
                    else {
                              p.next = p.next.next;
                    }
          }
//8. `void dele(int x)` - delele the first node whose age is equal to  x.
          public void dele(int x){
                    Node p = head;
                    while (p != null){
                              if (p.info.age == x) {deleteNode(p);break;}
                              p = p.next;
                    }
          }
//9. `Node search(int x)` - search and return the reference to the first node having age  x.
          public Node search(int x) {
                    Node p = head;
                    while (p != null) {
                              if (p.info.age == x){
                                        return p;
                              }
                              p = p.next; 
                    }
                    return null;
          }
          
//10. `int count()` - count and return number of nodes in the list.
          public int count() {
                    Node p = head;
                    int  count = 0;
                    while (p != null){ 
                              count++; 
                              p = p.next;
                    }
                    return count;          
          }
          
//11. `void dele(int i)` - delete an i-th node on the list. Besure that such a node exists.
          void deleteAt(int i){
                    if (isEmpty()) return;
                    if (i == 0){
                              Node p = head;
                              head = head.next;
                              p.next = null;
                    } else{
                              Node p  = getNode(i);
                              if (p == null) return;
                              deleteNode(p);
                    }
          }
          
          // Bonus: get Node at position i 
          public Node getNode(int i){
                    int count = 0;
                    Node p = head;
                    while (p != null && count < i){//.count và p tăng đồng thời.
                              p = p.next;
                              count++;
                    }
                    return p;
          }
          
//12. `void sort()` - sort the list by ascending order of info.
          void sort(){
                    Node pi, pj;
                    pi = head;
                    while (pi != null){
                              pj = pi.next;
                              while (pj != null){
                                        if (pj.info.age < pi.info.age){ // swap vị trí có giá trị bé nhất list với vị trí pi hiện tại
                                                  Person tmp =  pj.info;
                                                  pj.info = pi.info;
                                                  pi.info = tmp;
                                        }
                                        pj=pj.next; // duyệt toàn bộ list từ vị trí pi trở đi.
                                        
                              }
                              // với mỗi lần duyệt từng pi thì giá trị ở pi sẽ là giá trị lớn nhất. 
                              pi = pi.next;
                    }
          }
          
//13. `void deleteNode(Node p)` - delete node p if it exists in the list.
          public void deleteNode(Node q){
               
                    Node prev, cur;
                    prev = null;
                    cur = head;
                    while (cur != null){ // vòng lặp tìm kiếm vị trí node q trong list đồng thời trả ra previous node tương ứng. 
                              if (cur == q) break;
                              prev = cur; cur = cur.next;
                    }
                    // nếu tìm được thì cur ở vị trí của q cần tìm, còn prev ở ngay trước nó.
                    
                    
                    // trường hợp 1: không có node q trong list
                    if (cur == null) return;//chạy đến cuối list mà không thấy hoặc head = null
                    
                    // trường hợp 2: Node ở đầu list
                    if (prev == null){// có chạy vòng while rồi nhưng chưa mới phần tử đầu tiên đã đúng nên break luôn;
                              head = head.next; // update head
                              if (head == null) tail = null; // update tail if q is tail
                              return;
                    }
                    // trường hợp 3: 
                    prev.next = cur.next;
                    if (cur.next == null) tail = cur; // nếu q ở cuối list thì update tail. 
          }          

          
//18. `int max()` - find and return the maximum value in the list. 
          Node getMax(){
                    if (isEmpty()) return null;
                    Node max = head;
                    Node p = head;
                    while (p != null){
                              if (p.info.age > max.info.age) max = p;
                              p = p.next;}
                    return max;
          }         
          
}
