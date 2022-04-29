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
public class BSTree {

          public static void main(String[] args) {
                    int[] a = {50, 14, 60, 20, 10, 80,15};
                    MyTree tree = new MyTree();
                    for (int i = 0; i < a.length; i++) {
                              tree.insert(a[i]);
                    }
                    

                                        /*
                                       50
                                  14        60
                               10   20        80
                                         */
                    // hiển thị cây
                    // breadth-first traverse (theo level)
                    // 50    14 60     10 20 80
                    // pre-Order (cha trước, rồi đến  L,  R)
                    // 50    14 10 20    60 80
                    // post-Order (L R cha)
                    // 10 20 14    80 60   50
                    // in-Order (L cha R) - hiển thị giá trị từ bé đến lớn
                    // 10  14  20      50     60  80
                    // con trái nhất = min (leftmost)
                    // con phải nhất = max (rightmost)

//                    tree.delByCopying(60);
//                    tree.preOrder();
//                    Node p = tree.search(tree.root, 14);
//                    System.out.println("height of " + p.info + " is " + tree.height(p));
//                    tree.rotateLeft(p);
//                    tree.preOrder();
//                    System.out.println(tree.search(tree.root, 20).info);
//                    System.out.println(tree.min(tree.root).info);
//                    tree.count();
//                    System.out.println(tree.sum(tree.root));
//                    System.out.println(tree.avg());
                    tree.BalanceFactor
          }
}
