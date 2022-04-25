/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

          /*1. void addLast(String pName, double pPrice, int pQuantity) – check if pName has last
character ‘a’ or the price > 30 then do nothing, otherwise, add new product to the end
of the list.*/
          void addLast(String pName, double pPrice, int pQuantity) {
                    Node p = new Node(pName, pPrice, pQuantity);
                    if (pName.charAt(pName.length() - 1) == 'a' || pPrice > 30) {
                              return;
                    } else {
                              if (isEmpty()) {
                                        head = tail = p;
                              } else {
                                        tail.next = p;
                                        tail = p;
                              }
                    }
          }

          /*2. void traverse() - Traverse the linked list with the format like an example above.*/
          void traverse() {
                    Node p = head;
                    while (p != null) {
                              System.out.println(p.info + " ");
                              p = p.next;
                    }
                    System.out.println();
          }

          /*3. void sort() – sort the list in the alphabetical order of the product name.*/
          void sort() {
                    for (int i = 0; i <= count() - 1; i++) {
                              for (int j = i + 1; j <= count() - 1; j++) {
                                        Node pi = getNode(i);
                                        Node pj = getNode(j);
                                        if (pi.info.name.compareTo(pj.info.name) > 0) {
                                                  Product temp = pi.info;
                                                  pi.info = pj.info;
                                                  pj.info = temp;
                                        }
                              }
                    }
          }

          public Node getNode(int i) {
                    int count = 0;
                    Node p = head;
                    while (p != null && count < i) {//.count và p tăng đồng thời.
                              p = p.next;
                              count++;
                    }
                    return p;
          }

          int count() {
                    Node p = head;
                    int count = 0;
                    while (p != null) {
                              count++;
                              p = p.next;
                    }
                    return count;
          }

          /*4. double totalValue() – return total value of all products,
each product has a value = price * quantity */
          double totalValue() {
                    double totalVal = 0;
                    Node p = head;
                    while (p != null) {
                              totalVal += p.info.Price * p.info.Quantity;
                              p = p.next;
                    }
                    return totalVal;
          }

          /*5. void removeDuplicate() - Remove duplicate products (according to the product name)
in the list: for each duplicate product name, keep the product which have the highest
value = price * quantity and remove the others. For example, 2 products following have
same name, the product in the red color will be removed.*/
          
// idea câu này là: Đầu tiên sắp xếp theo thứ tự  value giảm dần, 
// Sau đó dùng 2 con trỏ, con trỏ 1 chạy từ đầu đến cuối, con trỏ 2 chạy từ vị trí con trỏ 1 đến cuối, nếu gặp trùng lặp thì remove ngay
// việc sắp xếp theo value giảm dần đảm bảo Product có value lớn nhất luôn được giữ lại.
          void remove_duplicates() {
                    sortByValue();
                    Node ptr1 = null, ptr2 = null, dup = null;
                    ptr1 = head;

                    while (ptr1 != null && ptr1.next != null) {
                              ptr2 = ptr1;


                              while (ptr2.next != null) {

                                        if (ptr1.info.name == ptr2.next.info.name) {

                                                  ptr2.next = ptr2.next.next;
                                                  System.gc();
                                        } else {
                                                  ptr2 = ptr2.next;
                                        }
                              }
                              ptr1 = ptr1.next;
                    }
          }
          void sortByValue() {
                    for (int i = 0; i <= count() - 1; i++) {
                              for (int j = i + 1; j <= count() - 1; j++) {
                                        Node pi = getNode(i);
                                        Node pj = getNode(j);
                                        if (pi.info.Price * pi.info.Quantity < pj.info.Price * pj.info.Quantity) {
                                                  Product temp = pi.info;
                                                  pi.info = pj.info;
                                                  pj.info = temp;
                                        }
                              }
                    }
          }

}
