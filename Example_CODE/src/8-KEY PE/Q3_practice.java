/**
 *
 * @author Thaycacac
 */
 
// Có phần ví dụ tương đối chuẩn trong file graph q3 of đề 5.
 ||__TRAVERSAL__//breadth-first traversal
 ||	    ||______//dept-first traversal
 ||     ||______//example breadth-first 
 ||
 ||___ALGORITHM_//dijkstra
 ||          ||_//euler cycle
 ||
 ||___OTHER_____//count the connectivity parts 


//breadth-first traversal
  void breadth(boolean [] visited, int k, RandomAccessFile f) throws Exception{
	GQueue q = new GQueue();
    int r,i;
    boolean [] enqueued = new boolean[20];
    for(i=0;i<n;i++) enqueued[i]=false;
    q.enqueue(k); enqueued[k]=true;
    while(!q.isEmpty())
     {r = q.dequeue();
      if(!visited[r]) {fvisit(r,f);//modifier function fvisit
	  visited[r] = true;}
      for(i=0;i<n;i++)
       {if(!visited[i] && !enqueued[i] && a[r][i]>0) {q.enqueue(i);enqueued[i]=true;}
       }
     }
   }

  void breadth(int  k, RandomAccessFile f) throws Exception{
	boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    breadth(visited,k,f);
    for(i=0;i<n;i++) if(!visited[i]) breadth(visited,i,f);
   }

//breadth first print degree with: A(4) E(3) F(3) G(2) I(3) B(2) C(1) H(2) D(1)
   void fvisitDeg(int i, RandomAccessFile f) throws Exception{
	f.writeBytes(" "+v(i)+"("+deg[i]+")");
   }
//dept-first traversal
  void depth(boolean [] visited,int k, RandomAccessFile f) throws Exception{
	fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) depth(visited,i,f);
      }
   }
  void depth(int k, RandomAccessFile f) throws Exception{
	boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth(visited,i,f);
   }

//dijkstra
 // một cái code dijkstra chuẩn chỉ hơn
 void dijkstra2(int fro, int to, RandomAccessFile f) throws Exception {
    int i, j, k, t, INF;
    INF = 999;
    boolean[] S = new boolean[n];
    int[] d = new int[n];
    int[] p = new int[n];
    for (i = 0; i < n; i++) {
      S[i] = false;
      d[i] = a[fro][i];
      p[i] = fro;
    }

    int[] ss = new int[n]; // ss[0], ss[1], ss[2],... are vertices sequentially selected to S
    int[] pp = new int[n]; // ss[0] -> ss[1] -> ss[2],... is the shortest path
    int m, r; // m is number of vertices in S,
    // r is the number of vertices in shortest path
    j = 0;

    // select fro into the set S
    S[fro] = true;
    ss[0] = fro;
    while (true) { // find min d[i] in the set of those vertices not selected into S
      k = -1;
      t = INF;
      for (i = 0; i < n; i++) {
        if (S[i] == true) continue;
        if (d[i] < t) {
          k = i;
          t = d[i];
        }
      }
      if (k == -1) return; // no solution
      // select k into the set S
      S[k] = true;
      j++;
      ss[j] = k;
      if (k == to) break;
      // Recalculate d[i]
      for (i = 0; i < n; i++) {
        if (S[i] == true) continue;
        if (d[i] > d[k] + a[k][i]) {
          d[i] = d[k] + a[k][i];
          p[i] = k;
        }
      }
    }
    m = j;
    Stack s = new Stack();
    i = to;
    while (true) {
      s.push(i);
      if (i == fro) break;
      i = p[i];
    }
    j = 0;
    while (!s.isEmpty()) {
      i = s.pop();
      pp[j++] = i;
    }
    r = j;
 
 // vertices on the shortest Path
    f.writeBytes("" + v[pp[0]]);
    for (i = 1; i < r; i++) f.writeBytes("   " + v[pp[i]]);
    f.writeBytes("\r\n");
 
 // distance 
    f.writeBytes("" + d[pp[0]]);
    for (i = 1; i < r; i++) f.writeBytes("   " + d[pp[i]]);
    f.writeBytes("\r\n");
 
 
 //  last 3 vertices selected into the set. 
    int count1 = -1;
        for (i = 0; i < n; i++) {
            if (ss[i] == -1) break;
            else ++count1;
        }
        for (i = count1-2; i <= count1; i++) {
            f.writeBytes(v[ss[i]] + "-" + d[ss[i]] + " ");
        }
 
  }
 
  void dijkstra(int fro, int to, RandomAccessFile f) throws IOException {
    boolean [] S = new boolean[n];
    int [] d = new int[n];
    int [] p = new int[n];
    int INF = 999;
    int i,j,k, t;
    for(i=0;i<n;i++) {
      S[i] = false;
      d[i] = a[fro][i];
      p[i] = fro;
    }
    S[fro] = true;
    while(true) {
      // find d[k] = min {d[i}}
      t = INF; k=-1;
      for(i=0;i<n;i++) {
        if(S[i]==true) continue;
        if(d[i]<t) {
          t = d[i];
          k = i;
        }
      }
      if(k==-1) {
        return;
      }
      // add k to S
      S[k] = true;
      if(k==to) break;
      // update d[i] & p[i]
      for(i=0;i<n;i++) {
       if(S[i]==true) continue;
       if(d[i] > d[k] + a[k][i]) {
          d[i] = d[k] + a[k][i];
          p[i] = k;
        }
      }
    }
//    System.out.println("The shortest distance is " + d[to]);
    i = to;
    GStack s = new GStack();//store vertex
    ArrayList points = new ArrayList();//store distance
    while(true) {
      s.push(i);
      if(i==fro) break;
      i = p[i];
    }
//print line 1: vertex, line2 : distance

    while(!s.isEmpty()) {
      i = s.pop();
      points.add(i);
    }
    for (int l = 0; l < points.size(); l++)  f.writeBytes(v[l]+" ");//print vertex
    f.writeBytes("\n");
    for (int l = 0; l < points.size(); l++)   f.writeBytes(d[(int)points.get(l)]+ " ");//print distance
    f.writeBytes("\n");
    
//print (0)A->(9)C->(2)F->(9)E
    for (int l = 0; l < points.size()-1; l++)  f.writeBytes("("+d[(int)points.get(l)]+")"+v[l]+" "+"->");
    f.writeBytes("("+d[(int)points.get(points.size()-1)]+")"+v[points.size()-1]+" ");
    f.writeBytes("\n");
  }

//count degree
 int deg(int i) {
     int s,j;
     s=0;
     for(j=0;j<n;j++) s += a[i][j];
     s += a[i][i];
     return(s);
  }
  
//check has Isolated
  boolean hasIsolated() {
    for(int i=0;i<n;i++) 
      if(deg(i)==0) return(true);
    return(false);
  }
//check connect
  boolean isConnected() {
    boolean [] p = new boolean[n];
    int i,j,r;
    for(i=0;i<n;i++) p[i]=false;
    GStack s = new GStack();
    s.push(0); p[0] = true;
    while(!s.isEmpty()) {
      r = s.pop();
      for(i=0;i<n;i++)
        if(!p[i] && a[r][i]>0) {
          s.push(i); p[i]=true;  
        }  
    }
    for(i=0;i<n;i++)
        if(!p[i]) return(false);
    return(true);
  }
 
//check undirected
  boolean isUnDirected() {
    int i,j;
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
        if(a[i][j] != a[j][i]) return(false);
    return(true);
  }
  
//check all deg even
  boolean allDegEven() {
    for(int i=0;i<n;i++)
      if(deg(i)%2 == 1) return(false);
    return(true);
  }
  
//check has euler cycle
  boolean hasEulerCycle() {
    if(!hasIsolated() && isUnDirected() && isConnected() && allDegEven())
       return(true);
      else
        return(false);
  }
  
//euler cycle
   void eulerCycle(int fro, RandomAccessFile f) throws IOException {
    if(!hasEulerCycle()) {
      return;
    }
    int [] eu = new int[100];
    int m,i,j,r;
    GStack s = new GStack();
    s.push(fro);
    j=0;
    while(!s.isEmpty()) {
      r = s.top();
      for(i=0;i<n;i++) {
        if(a[r][i] > 0) break;  
      }
      if(i==n) { //r is isolated
        s.pop();
        eu[j++] = r;
          
      }
      else {
       s.push(i);
       a[r][i]--;
       a[i][r]--;
      }
    }
    m = j;
    for(i=0;i<m;i++) {
        f.writeBytes(v[eu[i]]+" ");
    }
  }
  
/*
declare a stack S of characters (a vertex is labeled by a character)
declare an empty array E (which will contain Euler cycle)
push the vertex X to S
while(S is not empty)
 {ch = top element of the stack S 
  if ch is isolated then remove it from the stack and put it to E
   else
   select the first vertex Y (by alphabet order), which is adjacent
   to ch,push  Y  to S and remove the edge (ch,Y) from the graph   
 }
 the last array E obtained is an Euler cycle of the graph
*/
void EulerCycle(int k, RandomAccessFile f) throws Exception{
	if(!isUndirected() || !isConnected() || !isEvenDegree())
      {f.writeBytes("Conditions are not satisfied\r\n");
       return;
      }
    MyStack  s = new MyStack();
    int [][] b = new int[20][20];
    int [] eu = new int[20]; int m;
    int i,j,r;
    for(i=0;i<n;i++)
      for(j=0;j<n;j++) b[i][j]=a[i][j];
    s.push(k);//Dua dinh k vao Stack
    m = 0;//Ban dau chu trinh chua co phan tu nao
    while(!s.isEmpty())
      {r = s.top();
       i=0;
       while(i<n && b[r][i]==0) i++;//Tim i dau tien de b[r][i]#0
       if(i==n) //r da la dinh co lap, dua  r  vao chu trinh Euler
         {eu[m++] = r; s.pop();}//Lay dinh co lap ra khoi Stack
         else
          {s.push(i);b[r][i]--;b[i][r]--;}//Loai canh (i,r) khoi do thi
      }
    // Display Euler cycle
    for(i=0;i<m;i++) f.writeBytes(v[eu[i]] + "  ");
    f.writeBytes("\r\n");
   }


//check conditions for the existence of Euler’s cycle
 void checkEulerCycle(RandomAccessFile f) throws Exception{
	if(isUndirected())
      f.writeBytes("The graph is undirected.\r\n");
       else
         f.writeBytes("The graph is directed.\r\n");
    if(isConnected())
      f.writeBytes("The graph is connected.\r\n");
       else
         f.writeBytes("The graph is not connected.\r\n");

    if(isEvenDegree())
      f.writeBytes("All vertices have even degree.\r\n");
       else
         f.writeBytes("The graph has a vertex with odd degree.\r\n");
    if(isUndirected() && isConnected() && isEvenDegree())
      f.writeBytes("Conditions for Euler's cycle are satisfied.\r\n");
        else
         f.writeBytes("Conditions for Euler's cycle are not satisfied.\r\n");
   }

//count the connectivity parts 
   public int connectedParts(){ //f123.writeBytes("k = " + k + "\r\n"); 
    boolean [] pushed = new boolean[20];
    boolean cont = false;
    int i, j, k, r;
    for(i=0;i<n;i++) pushed[i]=false;
    MyStack s = new MyStack();
    k=0;
    while(true)
     {s.clear();
      i = 0;
      while(i<n && pushed[i]) i++;
      if(i==n) break;
      s.push(i); pushed[i] = true;
      while(!s.isEmpty())
        {r = s.pop();
         for(i=0;i<n;i++)
          {if(i==r) continue;
           if(!pushed[i] && a[r][i]>0) {s.push(i); pushed[i] = true;}
          }
        }
       k++;
     }
    return(k);
   }
   