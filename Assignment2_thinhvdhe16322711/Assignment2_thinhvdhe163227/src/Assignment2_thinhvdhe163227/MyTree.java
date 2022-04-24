/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2_thinhvdhe163227;

/**
 *
 * @author doant
 */
public class MyTree {

          Node root; // already contains left right tree.

          MyTree() {
                    root = null;
          }

//1. void insert(String xName, int xAge): check if xName contains ‘B’ or age > 10
//then do nothing, otherwise, insert that person information to the tree.
//For example, the input for insert method can be:
//(A6,1) (A2,5) (B6,1) (A1,2) (A5,5) (A4,7) (A3,7) (B8,3) (A7,3) (A9,6) (A8,4)
//(A91,2) (A11,10)
          boolean isEmpty() {
                    return root == null;
          }

          void insert(String xName, int xAge) {
                    for (int i = 0; i < xName.length() - 1; i++) {
                              if (xName.charAt(i) == 'B') {
                                        return;
                              }
                    }
                    if (xAge > 10) {
                              return;
                    }
                    
                    Node p = new Node(xName, xAge);
                    if (isEmpty()) {
                              root = p;
                              return;
                    }
                    
                    Node f = null;
                    Node q = root;
                    while (q != null) {
                              if (q.info.name.equals(xName)) {
                                        System.out.println("Insertion failed, duplicated key");
                                        return;
                              } else if (q.info.name.compareToIgnoreCase(xName) > 0) {
                                        f = q;
                                        q = q.left;
                              } else {
                                        f = q;
                                        q = q.right;
                              }
                    }
                    if (f.info.name.compareToIgnoreCase(xName) > 0) {
                              f.left = p;
                    } else {
                              f.right = p;
                    }
          }


          void visit(Node p) {
                    System.out.print(p.info + " ");
          }

//2. void traverse(): Display all persons having age < the average age of the tree in
//format (name, age) to the output screen by post-order traverse.
//For example, the output must be:
//(A1,2) (A8,4) (A91,2) (A7,3) (A6,1)
          double  avg() {
                    if (root == null) {
                              return 0;
                    }
                    return 1.0 * sum(root) / count(root);
          }

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

          int sum(Node p) { // muốn gọi đệ quy lên từng node thì hàm này phải có tham số
                    // co can static khong? 
                    if (p == null) {
                              return 0;
                    }
                    return p.info.age + sum(p.left) + sum(p.right);
          }

          void traverseByPostOrderwithcondition(Node p) {
                    if (p == null) {
                              return;
                    }
                    traverseByPostOrderwithcondition(p.left);
                    traverseByPostOrderwithcondition(p.right);
                    if (p.info.age < avg()) {
                              visit(p);
                    }
          }

          void traverse() {
                    traverseByPostOrderwithcondition(root);
          }
//3. void delete(): Perform breadth-first traverse from the root and delete by copying the
//second node having age >= the average age, write the tree to the output screen by
//breadth-first traverse.
//For example, the output must be:
//(A6, 1) (A2, 5) (A7, 3) (A1, 2) (A4, 7) (A9, 6) (A3, 7) (A8, 4) (A91, 2)

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
                    while (q != null) {
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

          void delete() {
                    Node p = searchNodeByBFS(root);
                    deleteByCopy(p);
                    BFS(root);
          }

//4. void rotateLeft(): Perform pre-order traverse from the root and rotate the third node
//having non-empty right-son then rotate it to left about its right-son and display the
//tree to the output screen by pre-order traverse.
//For example, the output must be:
//(A6, 1) (A2, 5) (A1, 2) (A5, 5) (A4, 7) (A3, 7) (A9, 6) (A7, 3) (A8, 4) (A91, 2)         
          // Find third node having non-empty right-son 
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
          Node parent(Node p) {
                    Node f, q;
                    f = null;
                    q = root;
                    while (q != null) {
                              if (q == p) {
                                        break;
                              }
                              f = q;
                              if (p.info.name.compareTo(q.info.name) < 0) {
                                        q = q.left;
                              } else {
                                        q = q.right;
                              }
                    }
                    return f;
          }

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
                    if (a == null) return;
                    else rotateLeft1(a);
                    preorder(root);
          }
}
