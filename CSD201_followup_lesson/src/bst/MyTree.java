/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author doant
 */
public class MyTree {

          Node root; // already contains left right tree.

          MyTree() {
                    root = null;
          }

//1.   boolean isEmpty() -   return true if a tree is empty, return false otherwise.
          boolean isEmpty() {
                    return root == null;
          }
//2.   void clear() - clear a tree.

          void clear() {
                    root = null;
          }
//3.   Node search(int x) - Search a node having value x. Return a reference to that node if found, return null otherwise.

          Node search(Node p, int x) {
                    if (p == null) {
                              return null;
                    } else if (p.info == x) {
                              return p;
                    } else if (p.info > x) {
                              return search(p.left, x);
                    } else {
                              return search(p.right, x);
                    }
          }

//4.   void insert(int x) - check if the key x does not exists in a tree then insert new node with value x into the tree.
          /* idea chung: Dùng biến chạy để duyệt cây. Biến thứ nhất để tìm vị trí cha phù hợp cho node muốn thêm vào. Biến 2 để xác định xem đã đến tận cùng của cây chưa. 
                    Sau khi đã xác định được 2 con trỏ này thì so sánh node cha vừa thìm được với node p ứng với x cần thêm để xác định xem nên thêm vào trái or phải. 
           */
          void insert(int x) {
                    if (isEmpty()) {
                              root = new Node(x);
                              return;
                    }
                    Node p = root; // root không có cha // p chỉ là biến chạy. 
                    Node parent = null; // cha của p
                    while (p != null) { // hết vòng while này giá trị node cha thích hợp sẽ được return. 
                              if (p.info == x) {
                                        System.out.println(x + " already exist.");
                                        return;
                              }
                              parent = p; // lưu vết vị trí node cha thích hợp 
                              if (p.info > x) {
                                        p = p.left; // p = null nghĩa là nó đã xuống tận cùng (vị trí thích hợp trong cây).
                              } else {
                                        p = p.right; // p = null nghĩa là nó đã xuống tận cùng (vị trí thích hợp trong cây).
                              }
                    }
                    // p = null
                    // sau bước while ở trên thì ta biết chắc chắn cái node cần insert là con của node cha nào. 
                    // add giá trị x vào con của parent
                    // cần xác định x là con trái hay con phải của parent
                    if (parent.info > x) {
                              parent.left = new Node(x);
                    } else {
                              parent.right = new Node(x);
                    }
          }

          void visit(Node p) {
                    System.out.print(p.info + " ");
          }
//5.   void breadth() - traverse a tree.

          void breadFirstSearch(Node p) {
                    if (p == null) {
                              return;
                    }
                    MyQueue m = new MyQueue(); // điều đặc biệt trong queue là càng về đầu queue thì level tương ứng trong cây càng thấp. Những level càng thấp thì càng được thêm vào muộn 
                    m.enqueue(p);
                    while (!m.isEmpty()) { // mỗi lần gọi sẽ in ra giá trị của node đó và enqueue tất cả con của node đó. 
                              Node q = (Node) m.dequeue(); // lấy giá trị đầu tiên của queue.
                              visit(q);
                              if (q.left != null) {
                                        m.enqueue(q.left); // thêm các left child và right child của node hiện tại vào queue. (các node này sẽ ở gần nhau, tượng trưng cho việc chúng có cùng level) 
                              }
                              if (q.right != null) {
                                        m.enqueue(q.right);
                              }
                    }
          }

          void breadFirstSearch() {
                    breadFirstSearch(root);
          }
//6.   void preorder(Node p) - recursive preorder traverse of a tree.

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
//7.   void inorder(Node p) - recursive inorder traverse of a tree.

          void inOrder(Node p) { // duyệt từ đỉnh và cố gắng đi xuống bên trái sâu nhất, đến null thì mới đầu in ra. 
                    if (p == null) {
                              return;
                    }
                    inOrder(p.left); // khi xuống đến tận cùng thì p.left là null và nó quay ngược lại in ra cái cha của p.left đó. 
                    visit(p);
                    inOrder(p.right);
          }

          void inOrder() {
                    inOrder(root);
          }
//8.   void postorder(Node p) - recursive postorder traverse of a tree.

          void postOrder(Node p) {
                    if (p == null) {
                              return;
                    }
                    postOrder(p.left);
                    postOrder(p.right);// postOrder khác với inOrder một chút chỗ nó sẽ in LR rồi mới đến root => để visit xuống cuối. 
                    visit(p);
          }
          void postOrder(){
                    postOrder(root);
          }
//9.   int count() - count and return number of nodes in the tree.

          int count(Node p) {
                    if (p == null) {
                              return 0;
                    }
                    MyQueue m = new MyQueue(); // điều đặc biệt trong queue là càng về đầu queue thì level tương ứng trong cây càng thấp. Những level càng thấp thì càng được thêm vào muộn 
                    m.enqueue(p);
                    int count = 0;
                    while (!m.isEmpty()) { // mỗi lần gọi sẽ in ra giá trị của node đó và enqueue tất cả con của node đó. 
                              Node q = (Node) m.dequeue(); // lấy giá trị đầu tiên của queue.
//                              visit(q);
                              count++;
                              if (q.left != null) {
                                        m.enqueue(q.left); // thêm các left child và right child của node hiện tại vào queue. (các node này sẽ ở gần nhau, tượng trưng cho việc chúng có cùng level) 
                              }
                              if (q.right != null) {
                                        m.enqueue(q.right);
                              }
                    }
                    return count;
          }

          void count() {
                    System.out.println(count(root));
          }
//10. void dele(int x) - delete a node having value x.

          // Idea chính của delByCopying là dùng giá trị right most của left subtree hoặc left most của right node (của node mình muốn xoá).
          void delByCopying(int x) {
                    if (isEmpty()) {
                              return;
                    }
                    // tìm node chứa giá trị x
                    // tìm parent của node đó
                    Node p = root;
                    Node parent = null;
                    while (p != null) {
                              if (p.info == x) {
                                        break;
                              }
                              parent = p;
                              if (p.info > x) {
                                        p = p.left;
                              } else {
                                        p = p.right;
                              }
                    }

                    // p là node chứa x, parent là cha của p, parent có thể là null (p là root)
                    // hoặc p = null (tìm đến cuối mà vẫn không có node thoả mãn để "break") (không có x trong cây)
                    if (p == null) {
                              System.out.println(x + " doesnt exist in tree.");
                              return; // không có x trong cây để xóa
                    }

                    /**
                     * p là lá, không có con *******
                     */
                    /*
                         parent       parent            p  (cây chỉ có 1 node)
                      p                               p
                     */
                    if ((p.left == null) && (p.right == null)) {
                              if (parent == null) { // trường hợp tree chỉ có 1 node duy nhất là root. 
                                        root = null;
                              } else {
                                        if (parent.left == p) {
                                                  parent.left = null;
                                        } else {
                                                  parent.right = null;
                                        }
                              }
                    }

                    /**
                     * **** p có 1 con ******
                     */
                    /*
                              p    p                    |             parent              parent            parent                    parent 
                                                                      p                       p                                        p                                  p
                                                                p.L                             p.R                          p.L                                            p.R
                         p.L         p.R             |
                     */
                    if ((p.left != null) && (p.right == null)) {
                              if (p.info > parent.info) {
                                        parent.right = p.left;
                              } else {
                                        parent.left = p.left;
                              }
                    }
                    if ((p.left == null) && (p.right != null)) {
                              if (p.info > parent.info) {
                                        parent.right = p.right;
                              } else {
                                        parent.left = p.right;
                              }
                    }

                    /**
                     * p có 2 con *************
                     */
                    /*
                              p                                                                                                                                                  p
                    p.L             p.R                                                                                                                            rm               p.R       (parentRm = null)
                         right                                                                                                                            rm.L
                              ...
                                  parentRm
                                        rightMost (giá trị lớn nhất của cây con trái)
                                   rm.left
                     */
                    // Tìm right Most of left subtree. 
                    if ((p.left != null) && (p.right != null)) {
                              // tìm rightmost của cây con trái
                              // copy giá trị rightmost vào node p
                              // xóa node rightmost
                              Node rm = p.left; // rm luôn khác null
                              Node parentRm = null;
                              while (rm.right != null) {
                                        parentRm = rm;
                                        rm = rm.right;
                              }

                              p.info = rm.info; // xoá giá trị node p chính là thay giá trị node p bằng một giá trị node khác rồi, rồi xoá cái node trùng gốc kia đi. 
                              if (parentRm == null) { // p.left chính là node duy nhất của cây con trái. 
                                        p.left = rm.left;
                              } else {
                                        parentRm.right = rm.left; // rm.left có thể bằng null, hoặc bằng 1 giá trị nào đó (nhưng chắc chắn sẽ phù hợp để thay rightmost (vì rightmost chắc chắn không có con phải nữa)).
                              }
                    }
          }

//11. Node min() - find and return the node with minimum value in the tree. 
          // idea: In Binary Search tree, the most left node is the node with min value
          Node min(Node p) {
                    Node current = p;
                    while (current.left != null) {
                              current = current.left;
                    }
                    return current;
          }

//12. Node max() - find and return the node with maximum value in the tree. 
          Node max() {
                    Node current = root;
                    while (current.left != null) {
                              current = current.left;
                    }

                    return current;
          }
//13. int sum() - return the sum of all values in the tree. 
          // sum using queue

//          int sum(Node p) {
//                    int sum = 0;
//                    if (p == null) {
//                              return 0;
//                    }
//                    MyQueue m = new MyQueue(); // điều đặc biệt trong queue là càng về đầu queue thì level tương ứng trong cây càng thấp. Những level càng thấp thì càng được thêm vào muộn 
//                    m.enqueue(p);
//                    while (!m.isEmpty()) { // mỗi lần gọi sẽ in ra giá trị của node đó và enqueue tất cả con của node đó. 
//                              Node q = (Node) m.dequeue(); // lấy giá trị đầu tiên của queue.
//                              sum += q.info;
//                              if (q.left != null) {
//                                        m.enqueue(q.left); // thêm các left child và right child của node hiện tại vào queue. (các node này sẽ ở gần nhau, tượng trưng cho việc chúng có cùng level) 
//                              }
//                              if (q.right != null) {
//                                        m.enqueue(q.right);
//                              }
//                    }
//                    return sum;
//          }
          int sum(Node p) { // muốn gọi đệ quy lên từng node thì hàm này phải có tham số
                    // co can static khong? 
                    if (p == null) {
                              return 0;
                    }
                    return p.info + sum(p.left) + sum(p.right);
          }

//14. int avg() - return the average of all values in the tree.
          int avg() {
                    if (root == null) {
                              return 0;
                    }
                    return sum(root) / count(root);
          }
//15. The height of a tree is the maximum number of nodes on a path from the root to a leaf node. Write a  function that returns the height of a binary tree.
          // khó hiểu quá :)) 
          int height(Node p){
                    if (p == null) return 0;
                    else {
                              int lDepth = height(p.left);
                              int rDepth = height(p.right);
                              if (lDepth > rDepth) return (lDepth + 1);
                              else return (rDepth + 1);
                    }
          }
//16. The cost of a path in a tree is sum of the keys of the nodes participating  in that path. Write a  function that returns the cost of the most expensive  path from the root to a leaf node.
//17. Write a  function to determine whether a given binary tree is AVL or not.
          // An AVL tree (by Adelson Velskii, Landis) is a height-balanced binary search tree.
//          boolean isBalanced(Node root)
//          {
//                    int lh; /* for height of left subtree */
//                    int rh; /* for height of right subtree */
//
//                    if (root == null) return true;
//
//                    lh = height(root.left);
//                    rh = height(root.right);
//
//                    if (Math.abs(lh - rh) <= 1 && isBalanced(root.right) && isBalanced(root.right)) return true;
//
//                    return false;
//          }
//18. What value does the following function return when called with each of the binary trees in question 3?
//int mystery(Node x) {
//if (x == null)
//return 0;
//else
//return max(mystery(x.left), mystery(x.right));
//}
//19. Write a  function to determine whether a given binary tree is a heap.
//20 . Rotate Left
          Node parent(int x){
                    Node f, p;
                    f = null;
                    p = root;
                    while (p != null){
                              if(p.info == x) break;
                              f = p;
                              if (x > p.info) p = p.right;
                              else p = p.left;
                    }
                    return f; //không có node x thì sao?? 
          }
          
          Node parent(Node p){
                    Node f, q;
                    f = null; q = root;
                    while (q!=null){
                              if (q == p) break;
                              f = q;
                              if (p.info > q.info) q = q.right;
                              else q = q.left;
                    }
                    return f;
          }
          
          Node nodeRotateLeft(Node p){ // định hình node p sau khi rotate (nó link với left right nào) (nó link với con nào)
                    if (p.right == null) return p;
                    Node p1 = p.right; 
                    p.right = p1.left; // gắn right mới cho node cũ ở trí muốn rotate
                    p1.left = p; // gắn left mới cho node mới được trám vào vị trí muốn rotate. 
                    return p1;
          }
          
          void rotateLeft(Node a){ // định hình lại cả cây (node p sau khi rotate link với parent nào)
                    Node  b = nodeRotateLeft(a);
                    if (a == root){ // nếu ban đầu vị trí node cần xoay là root thì sau khi xoay node mới ở vị trí đó chính là root.
                              root = b;
                              return;
                    }
                    Node par = parent(a); // cha của vị trí muốn rotate. 
                    if (par.info > b.info){
                              par.left = b;
                    }
                    else 
                              par.right = b;
          }
          
//21. Rotate Right
          Node nodeRotateRight(Node p){
                    if(p.left == null) return p;
                    Node q = p.left;
                    p.left = q.right;
                    q.right = p;
                    return q;
          }
          
          void rotateRight(Node a){ // định hình lại cả cây (node p sau khi rotate link với parent nào)
                    Node  b = nodeRotateRight(a);
                    if (a == root){ // nếu ban đầu vị trí node cần xoay là root thì sau khi xoay node mới ở vị trí đó chính là root.
                              root = b;
                              return;
                    }
                    Node par = parent(a); // cha của vị trí muốn rotate. 
                    if (par.info > b.info){
                              par.left = b;
                    }
                    else 
                              par.right = b;
          }
// 22. Calculate balance factor 
}
