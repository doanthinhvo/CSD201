/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excersise_prepare_for_assignment2_;

import java.io.*;
import java.util.*;

/**
 *
 * @author doant
 */
public class MyTree {

          Node root; // already contains left right tree.

          MyTree() {
                    root = null;
          }
//1. void insert(String xName, int xAge) - check if the first letter of xName is 'B'
//(i.e. xName.charAt(0) == 'B') then do nothing, otherwise insert new person
//with name=xName, age=xAge to the tree.

          boolean isEmpty() {
                    return root == null;
          }

          void insert(String xName, int xAge) {
                    if (xName.charAt(0) == 'B') {
                              return;
                    }
                    if (isEmpty()) {
                              root = new Node(xName, xAge);
                              return;
                    }
                    Node p = root; // root không có cha // p chỉ là biến chạy. 
                    Node parent = null; // cha của p
                    while (p != null) { // hết vòng while này giá trị node cha thích hợp sẽ được return. 
                              if (p.info.name == xName) {
                                        System.out.println(xName + " already exist.");
                                        return;
                              }
                              parent = p; // lưu vết vị trí node cha thích hợp 
                              if (p.info.name.compareTo(xName) > 0) { // chuẩn chỉ rồi. 
                                        p = p.left; // p = null nghĩa là nó đã xuống tận cùng (vị trí thích hợp trong cây).
                              } else {
                                        p = p.right; // p = null nghĩa là nó đã xuống tận cùng (vị trí thích hợp trong cây).
                              }
                    }
                    // p = null
                    // sau bước while ở trên thì ta biết chắc chắn cái node cần insert là con của node cha nào. 
                    // add giá trị x vào con của parent
                    // cần xác định x là con trái hay con phải của parent
                    if (parent.info.name.compareTo(xName) > 0) {
                              parent.left = new Node(xName, xAge);
                    } else {
                              parent.right = new Node(xName, xAge);
                    }
          }

          void visit(Node p) {
                    System.out.print(p.info + " ");
          }

          // preorder
          void preOrder(Node p) {
                    if (p == null) {
                              return;
                    }
                    visit(p);
                    preOrder(p.left); // dừng gọi đệ quy khi mà xuống đến dưới cùng (p.left == null)
                    preOrder(p.right);// dừng gọi đệ quy khi mà xuống đến dưới cùng (p.right == null)
          }

          void preOrder() {
                    preOrder(root);
                    System.out.println();
          }

//2. Save all elements having age < the average age of the tree in format (name,
//age) to the file “q2.txt” by post-order traverse.

          /*
          CHECH NGAY KHI LAM XONG CAC CAU KHAC.
           */
          void fvisit(Node p, RandomAccessFile f) throws Exception {
                    if (p != null) {
                              f.writeBytes(p.info + " ");
                    }
          }

//          void postOrder2(Node p, RandomAccessFile f) throws Exception {
//                    if (p == null) {
//                              return;
//                    }
//
//                    postOrder2(p.left, f);
//                    postOrder2(p.right, f);
//                    if (p.info.age >= 3) {
//                              fvisit(p, f);
//                    }
//                    
//          }
          void preOrder2(Node p, RandomAccessFile f) throws Exception {
                    if (p == null) {
                              return;
                    }
                    if (p.info.age >= 3) {
                              fvisit(p, f);
                    }
                    preOrder2(p.left, f);
                    preOrder2(p.right, f);
          }

          void clear() {
                    root = null;
          }
//          void postOrder3() throws Exception {
//                    clear();
//                    String fname = "q2.txt";
//                    File checkexist = new File(fname);
//                    if (checkexist.exists()) checkexist.delete();
//                    RandomAccessFile f = new RandomAccessFile(fname, "rw");
//                    preOrder(root,f);
//                    f.writeBytes("\r\n");
//                    f.close();
//          }
//3. Calculate the height of the tree.

          int height(Node p) {
                    if (p == null) {
                              return 0;
                    } else {
                              int lDepth = height(p.left);
                              int rDepth = height(p.right);
                              if (lDepth > rDepth) {
                                        return (lDepth + 1);
                              } else {
                                        return (rDepth + 1);
                              }
                    }
          }
//4. Calculate the number of nodes of the tree.

          int count(Node p) {
                    if (p == null) {
                              return (0);
                    }
                    int k, h, r;
                    k = count(p.left);
                    h = count(p.right);
                    r = k + h + 1;
                    return (r);
          }
//5. Delete the root of the tree by copying.

          public void deleteByCopy(Node p) {
                    if (isEmpty()) {
                              return;
                    }
                    if (p == null) {
                              System.out.println("Key does not exists, deletion failed");
                              return;
                    }
                    // Find Node f where f is father of p
                    Node f = null;
                    Node q = root;
                    while (q != p) {
//                              if (p == )
                              if (q.info.name.compareTo(p.info.name) > 0) {         // Changed
                                        f = q;
                                        q = q.left;
                              } else {
                                        f = q;
                                        q = q.right;
                              }
                    }
                    // 1. p is a leaf (no right and left child)
                    if (p.left == null && p.right == null) {
                              // a BST has a Node only
                              if (f == null) {
                                        root = null;
                              } else if (f.left == p) {
                                        f.left = null;
                              } else if (f.right == p) {
                                        f.right = null;
                              }
                    } // 2. p has a left child only
                    else if (p.left != null && p.right == null) {
                              if (f == null) {// remove root
                                        root = p.left;
                              } else if (f.right == p) {
                                        f.right = p.left;
                              } else if (f.left == p) {
                                        f.left = p.left;
                              }
                    } // 3. p has a right child only
                    else if (p.right != null && p.left == null) {
                              if (f == null) {// remove root
                                        root = p.right;
                              } else if (f.right == p) {
                                        f.right = p.right;
                              } else if (f.left == p) {
                                        f.left = p.right;
                              }
                    } // 4. Both of right and left child 
                    else if (p.left != null && p.right != null) {
                              f = null;
                              Node rp = p.left;
                              while (rp.right != null) {
                                        f = rp;
                                        rp = rp.right;
                              }
                              p.info = rp.info;
                              if (f == null) {// rp has no right child 
                                        p.left = rp.left;
                              } else {
                                        f.right = rp.left;
                              }
                    }
          }

          void deleteRoot() {
                    deleteByCopy(root);
          }
//6. Perform breadth-first traverse from the root and delete by copying the
//second node having age >= the average age.

          void delete() {
                    Node p = searchNodeByBFS(root); // tìm node 
                    deleteByCopy(p); // xoá node 
                    BFS(root); // in ra 
          }

          double avg() {
                    if (root == null) {
                              return 0;
                    }
                    return 1.0 * sum(root) / count(root);
          }

          int sum(Node p) { // muốn gọi đệ quy lên từng node thì hàm này phải có tham số
                    // co can static khong? 
                    if (p == null) {
                              return 0;
                    }
                    return p.info.age + sum(p.left) + sum(p.right);
          }

          // Tìm node bằng BFS 
          Node searchNodeByBFS(Node p) {
                    // check empty
                    if (p == null) {
                              return null;
                    }
                    int count = 0;

                    MyQueue m = new MyQueue();
                    m.enqueue(p);
                    while (!m.isEmpty()) {
                              Node q = (Node) m.dequeue();
                              if (q.info.age >= avg()) {
                                        count++;
                              }
                              if (count == 2) {
                                        return q;
                              }
                              if (q.left != null) {
                                        m.enqueue(q.left);
                              }
                              if (q.right != null) {
                                        m.enqueue(q.right);
                              }
                    }
                    return null;
          }

          //delete by node p
          // already defind above
          // BFS để in ra 
          void BFS(Node p) { //input root
                    if (p == null) {
                              return;
                    }
                    MyQueue m = new MyQueue();
                    m.enqueue(p);
                    while (!m.isEmpty()) {
                              Node q = (Node) m.dequeue();// get node
                              if (q.left != null) { // if lever still hava node left
                                        m.enqueue(q.left);
                              }
                              if (q.right != null) { //if lever still hava node right
                                        m.enqueue(q.right);
                              }
                              visit(q);// traversal them
                    }
          }
//7. Check if the root having non-empty left-son then rotate it to right about its
//left-son.
//

          void rotateRoot() {
                    if (isEmpty()) {
                              return;
                    } else {
                              Node p = nodeRotateRight(root);
                              rotateRight(p);
                    }
          }

          Node parent(Node p) {
                    Node f, q;
                    f = null;
                    q = root;
                    while (q != null) {
                              if (q == p) {
                                        break;
                              }
                              f = q;
                              if (q.info.name.compareTo(p.info.name) > 0) {
                                        q = q.left;
                              } else {
                                        q = q.right;
                              }
                    }
                    return f;
          }

          Node nodeRotateRight(Node p) {
                    if (p.left == null) { // điều kiện trong đề bài là chỉ xoay root có con trái khác null.
                              return p;
                    }
                    Node q = p.left;
                    p.left = q.right;
                    q.right = p;
                    return q;
          }

          void rotateRight(Node a) { // định hình lại cả cây (node p sau khi rotate link với parent nào)
                    Node b = nodeRotateRight(a);
                    if (a == root) { // nếu ban đầu vị trí node cần xoay là root thì sau khi xoay node mới ở vị trí đó chính là root.
                              root = b;
                              return;
                    }
                    Node par = parent(a); // cha của vị trí muốn rotate. 
                    if (par.info.name.compareTo(b.info.name) > 0) {
                              par.left = b;
                    } else {
                              par.right = b;
                    }
          }
//8. Perform pre-order traverse from the root, rotate the third node having non-
//empty right-son then rotate it to left about its right-son and display the tree
//to the output screen.
          int count = 0;
          Node a = null;

          void searchNodeByPreOrder(Node p) {
                    if (p == null) {
                              return;
                    }
//                    visit(p);
                    if (p.right != null) {
                              count++;
//                              System.out.println(count);
                    }
                    if (count == 3) {
//                              System.out.println(p.right.info);
                              a = p;
                              return;
                    }
                    searchNodeByPreOrder(p.left); // dừng gọi đệ quy khi mà xuống đến dưới cùng (p.left == null)
                    searchNodeByPreOrder(p.right);
          }

          // parent of one node 
          // already define above
          // Rotate left 
          Node nodeRotateLeft(Node p) { // định hình node p sau khi rotate (nó link với left right nào) (nó link với con nào)
                    if (p.right == null) {
                              return p;
                    }
                    Node p1 = p.right;
                    p.right = p1.left; // gắn right mới cho node cũ ở trí muốn rotate
                    p1.left = p; // gắn left mới cho node mới được trám vào vị trí muốn rotate. 
                    return p1;
          }

          void rotateLeft1(Node a) { // định hình lại cả cây (node p sau khi rotate link với parent nào)
                    Node b = nodeRotateLeft(a);
                    if (a == root) { // nếu ban đầu vị trí node cần xoay là root thì sau khi xoay node mới ở vị trí đó chính là root.
                              root = b;
                              return;
                    }
                    Node par = parent(a); // cha của vị trí muốn rotate. 
                    if (b.info.name.compareTo(par.info.name) < 0) {
                              par.left = b;
                    } else {
                              par.right = b;
                    }
          }

          void preorder(Node p) {
                    if (p == null) {
                              return;
                    }
                    visit(p);
                    preorder(p.left);
                    preorder(p.right);
          }

          void rotateLeft() {
                    searchNodeByPreOrder(root); // p must have right son
//                    System.out.println(p);
                    if (a == null) {
                              return;
                    } else {
                              rotateLeft1(a);
                    }
                    preorder(root);
          }
//9. Calculate balance factor of all nodes. Display all node with balance factor by
//breadth-first traverse.
          int balanceFactor(Node p){
                    return (height(p.right) - height(p.left));               
          }
          void showBalanceFactor(Node p){
                    System.out.println("Node " + p.info + " is " + balanceFactor(p));
          }
          void BalanceFactorBFS(Node p) {
                    if (p == null) {
                              return;
                    }
                    MyQueue m = new MyQueue(); 
                    m.enqueue(p);
                    while (!m.isEmpty()) { 
                              Node q = (Node) m.dequeue(); 
                              showBalanceFactor(q);
                              if (q.left != null) {
                                        m.enqueue(q.left);
                              }
                              if (q.right != null) {
                                        m.enqueue(q.right);
                              }
                    }
          }
//10.Check whether a given binary search tree is height balanced (AVL tree) or
//not.
          
//11.Calculate level of all nodes. Display all node with level by breadth-first
//traverse.
//12.Balance a binary search tree by simple balancing algorithm.
//13. Perform pre-order traverse from the root, find the first node p having age >=
//10, if node p has parent f and p is the right child of f then rotate node f to left
//about its right-son and display the tree to the output screen; otherwise, do
//nothing.
//14.Perform pre-order traverse from the root, find the first node having age >=
//10, if that node has parent f then delete by copying node f; otherwise, do
//nothing.
}
