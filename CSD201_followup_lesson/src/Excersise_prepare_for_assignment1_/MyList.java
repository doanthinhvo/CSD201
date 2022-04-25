/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excersise_prepare_for_assignment1_;

/**
 *
 * @author doant
 */
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
          // hàm search tạm bợ (chỉ return về node đầu tiên có giá trị bằng age.
          Node search(int age){
                    Node p = head; 
                    while (p != null){
                              if (p.info.age == age){
                                        return p;
//                                        break;
                              }
                              p = p.next;
                    }
                    return null;
          }
//1. addLast(String xName, int xAge) – check if xName has the first letter ‘B’ or
//xAge < 17 then do nothing, otherwise add new person to the end of the list.
          void addLast(String name, int age) {
                    Node p = new Node(name, age);
                    if (name.charAt(0) == 'B' || age < 17) {
                              return;
                    } else {
                              if (isEmpty()) {
                                        head = tail = p;
                              } else {
                                        tail.next = p; // nối p vào đuôi.
                                        tail = p;
                              }
                    }
          }

          // delete node q
          void deleteNode(Node q) {

                    Node prev, cur;
                    prev = null;
                    cur = head;
                    while (cur != null) { // vòng lặp tìm kiếm vị trí node q trong list đồng thời trả ra previous node tương ứng. 
                              if (cur == q) {
                                        break;
                              }
                              prev = cur;
                              cur = cur.next;
                    }
                    // nếu tìm được thì cur ở vị trí của q cần tìm, còn prev ở ngay trước nó.
                    
                    // trường hợp 1: list empty hoặc không tìm được 
                    if (cur == null) {// list empty hoặc không tìm được 
                              return;//chạy đến cuối list mà không thấy hoặc head = null
                    }
                    // trường hợp 2: Node  q ở đầu list
                    if (prev == null) {// có chạy vòng while rồi nhưng chưa mới phần tử đầu tiên đã đúng nên break luôn;
                              head = head.next; // update head
                              
                              // nếu list chỉ có 1 phần tử thì cần update cả tail (vì ban đầu tail = head).
                              if (head == null) {
                                        tail = null; // update tail if q is tail
                              }
                              return;
                    }
                    // trường hợp 3: 
                    prev.next = cur.next;
                    if (cur.next == null) {
                              tail = prev; // nếu q ở cuối list thì update tail = previous 
                    }
          }
//2. Delete the first node having age = 20.

          public void dele() {
                    Node p = head;
                    while (p != null) {
                              if (p.info.age == 20) {
                                        deleteNode(p); // hàm deleteNode đã có update head tail. 
                                        break;
                              }
                              p = p.next;
                    }
          }
//3. Display the first 5 person having age > 22

          public void dele5() {
                    Node p = head;
                    int count = 0;
                    while (p != null) {
                              if (p.info.age > 22 && count < 5) {
//                                        deleteNode(p); // hàm deleteNode đã có update head tail.
                                        System.out.println(p.info);
                                        count++;
                              }
                              p = p.next;
                    }
          }

          

//4. Find the second max age. Display the first person having that age.
          // getMax by age
          Node getMax() {
                    if (isEmpty()) {
                              return null;
                    }
                    Node max = head;
                    Node p = head;
                    while (p != null) {
                              if (p.info.age > max.info.age) {
                                        max = p;
                              }
                              p = p.next;
                    }
                    return max;
          }
          void  secondMaxAge() {
                    // List has 0 element
                    if (isEmpty()) {
                              System.out.println("List is empty");
                              return;
                    }
                    // List has 1 element
                    if (head == tail) {
                              System.out.println("List has only one element");
                              return;
                    }
                    // List always has max element
                    int maxAge = getMax().info.age;
                    
                    int secondMax = head.info.age;
                    Node p = head; // pointer
                    while (p != null) {
                              if (p.info.age > secondMax && p.info.age != maxAge) {
                                        secondMax = p.info.age;
                              }
                              p = p.next;
                    }

                    // th: max ở đầu list, và tất cả phần tử đều bằng max. 
                    if (secondMax == maxAge) {
                              System.out.println("List doesnt have second max");
                              return;
                    }
                    else{
                              System.out.println("second max value is " + secondMax);
                    }  
          }
          // Note
          
//5. Sort the list descendingly by age.
          void sort() { 
                    Node pi, pj;
                    pi = head;
                    while (pi != null) { //mỗi lần thay đổi pi thì giá trị lớn nhất tương ứng với i trước đã được đưa lên đầu list.
                              pj = pi.next;
                              while (pj != null) {
                                        if (pj.info.age > pi.info.age) { // swap vị trí có giá trị lớn nhất list với vị trí pi hiện tại 
                                                  // chỉ thay đổi dữ liệu trong node nên không cần update head tail
                                                  Person tmp = pj.info;
                                                  pj.info = pi.info;
                                                  pi.info = tmp;
                                        }
                                        pj = pj.next; // duyệt toàn bộ list từ vị trí pi trở đi.

                              }
                              // với mỗi lần duyệt từng pi thì giá trị ở pi sẽ là giá trị lớn nhất. 
                              pi = pi.next;
                    }
          }

//6. Delete the last node having age = 20
          // Bonus: get Node at position i 
          public Node getNode(int i) {
                    int count = 0;
                    Node p = head;
                    while (p != null && count < i) {//.count và p tăng đồng thời.
                              p = p.next;
                              count++;
                    }
                    return p;
          }

          public int count() {
                    Node p = head;
                    int count = 0;
                    while (p != null) {
                              count++;
                              p = p.next;
                    }
                    return count;
          }

          public void removeLastNodeCondition() {
                    if (isEmpty()) {
                              return;
                    }
                    int c = 0;
                    int sz = count();
                    for (int i = sz - 1; i >= 0; i--) {
                              Node p = getNode(i);
                              if (p.info.age == 20) {
                                        c++;
                                        deleteNode(p);
                                        if (c >= 1) {
                                                  break;
                                        }
                              }
                    }
          }
          
          // code áp dụng cho trường hợp chỉ xoá 1 phần tử cuối.
          public void deleLast20(){
                    Node p = head;
                    Node temp = null;
                    while (p != null){
                              if (p.info.age == 20){
                                        temp = p; // chỉ tìm p có age =  20 và chỉ xoá sau khi duyệt cả dãy. 
                              }
                              p = p.next;
                    }
                    deleteNode(temp);
          }
//7. Display the last 5 person having age > 22

          public void removeLastFiveNodeCondition() {
                    if (isEmpty()) {
                              return;
                    }
                    int c = 0;
                    int sz = count();
                    for (int i = sz - 1; i >= 0; i--) {
                              Node p = getNode(i);
                              if (p.info.age > 22) {
                                        c++;
                                        deleteNode(p);
                                        if (c >= 5) {
                                                  break;
                                        }
                              }
                    }
          }
//8. Find the third max age. 
          int  secondMaxAgeVal() {
                    // List has 0 element
                    if (isEmpty()) {
                              return -1;
                    }
                    // List has 1 element
                    if (head == tail) {
                              return -1;
                    }
                    // List always has max element
                    int maxAge = getMax().info.age;
                    
                    int secondMax = head.info.age;
                    Node p = head; // pointer
                    while (p != null) {
                              if (p.info.age > secondMax && p.info.age != maxAge) {
                                        secondMax = p.info.age;
                              }
                              p = p.next;
                    }

                    // th: max ở đầu list, và tất cả phần tử đều bằng max. 
                    if (secondMax == maxAge) {
                              return -1;
                    }
                    else{
                              return secondMax;
                    }  
          }
          
          void thirdMaxAge() {
                   if (count() <= 2) {
                             System.out.println("List doesn't have third max age");
                             return;
                   } 
                   Node p = head;
                   int thirdMax = head.info.age;
                   int secondMax = secondMaxAgeVal();
                   while (p != null){
                             
                             if (p.info.age < secondMax && thirdMax < p.info.age){
                                       thirdMax = p.info.age;
                             }
                             p= p.next;
                   }
                   // trường hợp không tìm ra third max ( tương đương việc thirdmax >= secondmax)
                   if (thirdMax >= secondMax) System.out.println("list doesnt have third max");
                   else System.out.println("third max is " + thirdMax);
          }
// 8* : Find nth max
          public int Max(int upper){
                    int max3 = Integer.MIN_VALUE;
                    Node node = head;
                    while (node != null){
                              if (node.info.age > max3 && node.info.age < upper){ // upper ở đây là cận trận, ví dụ tìm max 3 thì upper là max2, tìm max2 thì upper là max1. 
                                        max3 = node.info.age;
                              }
                              node = node.next;
                    }
                    return max3;
          }
          // áp dụng
          void nthMax(){
                    int max1 = Max(Integer.MAX_VALUE);
                    int max2 = Max(max1);
                    int max3 = Max(max2);
                    System.out.println("max1 = " + max1 );
                    System.out.println("max2 = ");
          }
//9. add(String xName, int xAge, int index) – insert the new person at the given
//index
          // thêm vào index đó thì node cũ ở index đó lùi ra sau. 
                    public void insertPositionK(String xName, int xAge, int index) {
                              // list 0 elements
                              if (isEmpty()) head = tail = new Node(xName, xAge);
                              int count = count();
                              // invalid index
                              if (index >= count || index < 0) {
                                        System.out.println("invalid index");
                                        return;
                              }
                              else { // bài này có index nên xử lý theo index luôn 
                                        // đầu list
                                        Node p = new Node(xName, xAge);
                                        if (index == 0){
                                                  p.next = head.next;
                                                  head = p;
                                        }
                                        
                                        // cuoois list: hơi thừa vì insert thì không có trường hợp nào thay đổi tail được. 
                                        else if (index == count - 1){
                                                  tail.next = p;
                                                  tail = p;
                                        }
                                        // giua list 
                                        else {
                                                  Node prev = getNode(index - 1);
                                                  p.next = prev.next;
                                                  prev.next = p;
                                        }
                              }
                              
                    }          
         
//10. sort(int startIndex, int endIndex) – sort the linked list ascendingly by name
//from startIndex to endIndex
          public void sortByFor(int startIndex, int endIndex) {
                    for (int i = startIndex; i < endIndex - 1; i++) {
                              for (int j = i + 1; j <= endIndex - startIndex; j++) {
                                        Node pi = getNode(i);
                                        Node pj = getNode(j);
                                        if (pi.info.name.compareTo(pj.info.name) > 0) {
                                                  Person temp = pi.info; // chỉ thay đổi giá trị node, nên không cần update head tail. 
                                                  pi.info = pj.info;
                                                  pj.info = temp;
                                        }
                              }
                    }
          }
}
