package Graph;

//This stack is used for Graph depth-first traversal
//-----------------------------------------------------------------------
import java.util.*;
public class GStack
  {LinkedList<Integer> t;
   GStack() {t=new LinkedList<Integer>();}
   boolean isEmpty() {return(t.isEmpty());}
   void clear() {t.clear();}
   void push(int x) {t.addLast(x);}
   Integer pop() 
     {if(isEmpty()) return(null);
      return(t.removeLast());
     }
   Integer top() 
     {if(isEmpty()) return(null);
      return(t.getLast());
     }
  }