/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author doant
 */
public class MyList {

          private Node head, tail;

          public MyList() {
                    head = null;
                    tail = null;

          }

          public boolean isEmpty() {
                    return (head == null);
          }

          public void clear() {
                    head = null;
                    tail = null;
          }
          
          public void displayHeadTail(){
                    System.out.println("Head : " + head.info);
                    System.out.println("Tail : " + tail.info);
          }
          
          void display(){
                    Node p = head;
                    while (p!=null){
                              System.out.print(p.info + " ");
                              p = p.next;
                    }
          }
          
//    1. `void addToHead(int x)` - add a node with value x  at the head of  a list.
          public void addToHead(int x) {
                    Node p = new Node(x);
                    if (isEmpty()){
                              head = p;
                              tail = p;
                    } else{
                              p.next = head;
                              head = p;
                    }          
          }

//2. `void addToTail(int x)` - add a node with value x  at the tail of  a list.
          public void addToTail(int x) {
                    Node p = new Node(x);
                    if (isEmpty()){
                              head = tail = p;
                    }
                    else{
                              tail.next = p; 
                              tail = p; 
                    }
          }

          // void addAfter(index i, int x)
//3. `void addAfter(Node p, int x)` - add a node with value x  after the node p.
          public void addAfter(Node p, int x) {
                    if (p == null){
                              System.out.println("The node cannot be null");
                              return;
                    }
                    Node c = new Node(x);
                    c.next  = p.next;
                    p.next = c;
                    
                    // update tail
                    if (c.next == null){
                              tail = c;
                    }
          }

//4. `void traverse()` - traverse from head to tail and dislay info of all nodes in the list.
          public void traverse() {
                    Node p = head;
                     while(p != null){
                               System.out.println(p.info +"  "); 
                              p = p.next;
                     }
          }

//5. `int deleteFromHead()` - delete the head and return its info.
          public int deleteFromHead() {
                    if (head == null){
                              return -111;
                    }
                    Node p = head;
                    head = head.next;
                    
                    return p.info;
          }
//6. `int deleteFromTail()` - delete the tail and return its info.

          public int deleteFromTail() {
                    if (head == null || head.next == null){
                              return -111;
                    }
                    
                    Node secondLast = head;
                    while (secondLast.next.next != null){
                              secondLast = secondLast.next;
                    }
                    int infoLast  = secondLast.next.info;
                    secondLast.next = null;
                    tail = secondLast;
                    
                    return infoLast;
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
                              deleteFromTail();
                    }
                    else {
                              p.next = p.next.next;
                    }
          }

//8. `void dele(int x)` - delele the first node whose info is equal to  x.
          public void dele(int x){
                    Node p = head;
                    while (p != null){
                              if (p.info == x) {deleteNode(p);break;}
                              p = p.next;
                    }
          }

//9. `Node search(int x)` - search and return the reference to the first node having info x.
          public Node search(int x) {
                    Node p = head;
                    while (p != null) {
                              if (p.info == x){
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
                    while (p != null && count < i){//.count v?? p t??ng ?????ng th???i.
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
                                        if (pj.info < pi.info){ // swap v??? tr?? c?? gi?? tr??? b?? nh???t list v???i v??? tr?? pi hi???n t???i
                                                  int tmp =  pj.info;
                                                  pj.info = pi.info;
                                                  pi.info = tmp;
                                        }
                                        pj=pj.next; // duy???t to??n b??? list t??? v??? tr?? pi tr??? ??i.
                                        
                              }
                              // v???i m???i l???n duy???t t???ng pi th?? gi?? tr??? ??? pi s??? l?? gi?? tr??? l???n nh???t. 
                              pi = pi.next;
                    }
          }
//13. `void deleteNode(Node p)` - delete node p if it exists in the list.
          public void deleteNode(Node q){
               
                    Node prev, cur;
                    prev = null;
                    cur = head;
                    while (cur != null){ // v??ng l???p t??m ki???m v??? tr?? node q trong list ?????ng th???i tr??? ra previous node t????ng ???ng. 
                              if (cur == q) break;
                              prev = cur; cur = cur.next;
                    }
                    // n???u t??m ???????c th?? cur ??? v??? tr?? c???a q c???n t??m, c??n prev ??? ngay tr?????c n??.
                    
                    
                    // tr?????ng h???p 1: kh??ng c?? node q trong list
                    if (cur == null) return;//ch???y ?????n cu???i list m?? kh??ng th???y ho???c head = null
                    
                    // tr?????ng h???p 2: Node ??? ?????u list
                    if (prev == null){// c?? ch???y v??ng while r???i nh??ng ch??a m???i ph???n t??? ?????u ti??n ???? ????ng n??n break lu??n;
                              head = head.next; // update head
                              if (head == null) tail = null; // update tail if q is tail
                              return;
                    }
                    // tr?????ng h???p 3: 
                    prev.next = cur.next;
                    if (cur.next == null) tail = cur; // n???u q ??? cu???i list th?? update tail. 
          }
//14. `int [] toArray()` - create and return array containing info of all nodes in the list.
//15. Merge two ordered singly linked lists of integers into one ordered list.
//16. `void addBefore(Node p, int x)` - add a node with value x  before the node p.
//17. Attach a singly linked list to the end of another singly linked list.
//18. `int max()` - find and return the maximum value in the list. 
          Node getMax(){
                    if (isEmpty()) return null;
                    Node max = head;
                    Node p = head;
                    while (p != null){
                              if (p.info > max.info) max = p;
                              p = p.next;}
                    return max;
          }
//19. `int min()` - find and return the minimum value in the list. 
//20. `int sum()` - return the sum of all values in the list. 
//21. `int avg()` - return the average of all values in the list.
//22. `boolean sorted()` - check and return true if the list is sorted, return false if the list is not sorted.
//23. `void insert(int x)` - insert node with value x into sorted list so that the new list is sorted.
//24. Reverse a singly linked list using only one pass through the list.
//25. Check whether two singly linked list have the same contents.    

}
