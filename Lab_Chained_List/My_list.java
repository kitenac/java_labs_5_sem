

class Node<Typ>   
{
    Typ data;  
    Node next;    
}



public class My_list<Typ> 
{

    Node head;
    Node tail;
    int n;
    
    // Constructers of chained list
    public My_list()
    {   head = null; tail = null; n = 0;   }


    public My_list(Typ el)
    {  head = new Node(); head.data = el; tail = head; n = 1;  }

    // Coping constructer
    public My_list(My_list src) 
    { head = src.head; tail = src.tail; n = src.n; }


    int list_size()
    {   return n;   }

    

    Node add_node(Typ el)              // Same part of every "push_" function
    {
        Node node = new Node();
        node.data = el;
        n++;                           // due we add new node 

        return node;
    }


    public void push_up(Typ el)
    {
        Node node = add_node(el);

        if (head == null)              // when list is empty - head == tail == NULL
        {
            tail = node;
            head = tail;  }

        else
        {
            head.next = node;           // "previous" head now becomes usual-node which has subnode - "node".
            head = node;      }         // "node" becomes "head" which has no .next (NULL), due it`s on top of list
        
    }

    public void push_down(Typ el)
    {
        Node node = add_node(el);

        if (head == null)               // when list is empty - head == tail == NULL
        {
            tail = node;
            head = tail;  }

        else
        {
            node.next = tail;           // now "node" points on old tail => "node" - is tail of list "de ure"
            tail = node;      }         // "node" becomes tail "de facto"
    }

   
    public void push_i(Typ el, int i) throws List_Exception   // This method throws up an exception to be handled somewhere else it`ll be called         
    {

        if (i == 1) 
            { push_down(el); return;}         // i=1 - same as add node to start

        else if  (i > n || i <= 0) 
            {throw new List_Exception("[push_i]: Inserting index 'i' should be in range: ("+1+","+n+")" + " but i = " + i);} 

        else{    
            Node node = tail;                 // Start watching from 1st node   
            int j;

            for (j = 1; j <= i - 2; ++j)      // i-2-th node => .next - i-1-th
            {
                if (node.next != null)
                    node = node.next;         // Crawling to i-th node step by step 
            }
            // exit with i-1-th node
            
            Node old_i = node.next;            // pointer to old i-th element        
            

            Node node_i = add_node(el);
           
            // Correcting left(i-1) and right(i-1) nodes to put new i-th node 
            node.next = node_i;                // now i-1-th node points on node_i => Now node_i - i-th node

            node_i.next = old_i;               // so node_i points on old node i-th => Now node - i+1-th 
            }
}


    public void clear_list()
        {head = null; tail = null; n = 0;}

    
    public void delete_down() throws List_Exception 
    {
        if (n == 0) throw new List_Exception("[delete_down] list is empty"); 

        tail = tail.next;        // now 2nd node became tail
        n--;                    // Ammount of nodes decreased}       
    }

    public void delete_up() throws List_Exception 
    {
        if (n == 0) throw new List_Exception("[delete_up] list is empty");

        Node node = tail; 
        while (node.next != head)
               node = node.next;
        head = node;
        n--;                    // Ammount of nodes decreased
    }

    public void delete_i(int i) throws List_Exception
    {
        if (n == 0) throw new List_Exception("[delete_i] list is empty"); 
        if (i > n || i <= 0) 
            throw new List_Exception("[delete_i] Unexisting index: " + i);
        Node node = tail;
        int j;

        for (j = 1; j < i-1; ++j)
            node = node.next;
        // i-1 st node is "node"

        Node jump = node.next;     // i 
        jump = jump.next;          // i+1 
        
        node.next = jump;          // i-1 ----> i+1 => i is deleted
        n--;                    // Ammount of nodes decreased
    }
    

    public void print_list() throws List_Exception
    {
        if (n == 0)
            { System.out.println("List is empty"); return; }

        Node node = tail;
        int i;

        
        for (i=1; i<=n ; ++i)
        {
            try{
                System.out.print("\n-------\n  " + node.data + "\n-------\n" + "\n    |\n");
                node = node.next;
            }
            catch(Exception e)          // When we don`t know how to print specific-typed node 
            {
                throw new List_Exception("[print_list] can`t print " + i+"-th" + "node`s data due it`s type \nif u want to print it - write printer for this type and call it when catch this exception ");   
            }
        }  
        System.out.println("<THE END>");
    
    }
}


