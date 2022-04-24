/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

/**
 *
 * @author doant
 */
public class a {
//1.   Write a recursive function that computes the sum of all numbers from 1 to n, where n is given as parameter.
////return the sum 1+ 2+ 3+ ...+ n
//int sum(int n)
          int sum(int n)
          {
                    if(n <= 1) return 1;
                    else return n + sum(n - 1);
          }          
          
//2.   Write a recursive function that finds and returns the minimum element in an array, where the array and its size are given as parameters.
////return the minimum element in a[]
//int findmin(int a[], int n)
          int findMin(int a[], int n)
          {
                    if(n == 1) return a[0];
                    if(a[0] > a[n-1]) a[0] = a[n-1]; // so sánh số đầu với số cuối, số bé nhất luôn được đưa lên đầu
                    return findMin(a,n - 1); // mỗi lần gọi đệ quy là một lần so sánh với số gần cuối, đến cuối cùng khi array còn 1 số thì đó là số bé nhất vì số bé nhất luôn được đưa lên đầu.
          }
//3.   Write a recursive function that computes and returns the sum of all elements in an array, where the array and its size are given as parameters.
////return the sum of all elements in a[]
//int findsum(int a[], int n)
          int findSum(int a[], int n)
          {
                    if (n == 1) return a[0];
                    return a[n-1] + findSum(a, n-1);
          }
//4.   Write a recursive function that determines whether an array is a palindrome, where the array and its size are given as parameters.
////returns 1 if a[] is a palindrome, 0 otherwise. The string a is palindrome if it is the same as its reverse.
//int ispalindrome(char a[], int n)
          int ispalindrome(char a[], int n){
                    if (n == 1) return 1;
                    int m = a.length;
                    if (a[m - n] != a[n - 1]) return 0; // so sánh 2 số đối xứng nhau qua trục giữa, m-n có thể là bên trái , và n-1 có thể là bên phải
                    else {return ispalindrome(a, n-1);} // nếu chúng bằng nhau thì lại gọi đệ quy để xét số gần đó. Sau cùng khi gọi đến n==1 mà vẫn không tìm được cặp số khác nhau thì return true.
          }
//5.   Write a recursive function that searches for a target in a sorted array using binay search, where the array, its size and the target are given as parameters.
//          int indexInList(int[] a, int n, int x){
                    
//          }
//6.   Implement the Greatest Common Divisor algorithm as recursive method GCD. Use recursion. Do NOT use a loop.
          int GCD(int x, int y){ // x, y > 0
                    if (y == 0) return x;
                    else return GCD(y, x%y);
          }
//7.   Implement the power function recursively
          int power(int x,int n){
                    if (n == 0) return 1;
                    else {return x * power(x, n-1);}
          }
//8. Implement the factorial function recursively as fact
          int fact(int n){
                    if (n == 1) return 1;
                    else return n * fact(n - 1);
          }
//9.   Implement Fibonacci recursively as f
          int fib(int n){
                    if (n <= 0) return 0;
                    else if (n <= 2) return 1; // số fibo thứ 1 và 2 bằng 1
                    else return fib(n - 1) +fib(n - 2);
                    
          }
//10. Write recursive method addReciprocals that takes an integer as a parameter and returns the sum of the first n reciprocals.
//addReciprocals(n) returns (1.0 + 1.0/2.0 + 1.0/3.0 + 1.0/4.0 + ... + 1.0/n).
          double addReciprocals(int n){
                    if (n <= 0) return -1;
                    else if (n == 1) return 1; // làm điều kiện dừng.
                    else return 1.0/n + addReciprocals(n-1);
          }
//11.  Stirling numbers: A stirling number of the first kind is defined as follows
//
//s(0,0) = 1
//s(n,0) = 0, for all n > 0
//s(n+1,k) = s(n,k-1) - n*s(n,k), for all n ≥0 and k>0
          int stirling(int x, int y){
                    if (x == 0 && y == 0) return 1;
                    else if (x > 0 && y == 0) return 0;
                    else return stirling(x, y - 1) - x*stirling(x, y);
          }
}
