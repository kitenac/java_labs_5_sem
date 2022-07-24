
/*
    Здесь реализовано бинарное дерево поиска(BST - bin sort tree) - обычное дерево,
        но с одной условностью: левый потомок всегда < своего родителя, правый >= родителя.
    Прелесть в том, что можно начинаь строить дерево с любого эл-та - главное соблюдать правильное ветвление.

    За счёт такой условности возможен поиск произвольного эл-та за log(n) шагов в худшем случае:
         каждый раз, сравнивая искомый эл-т с текущим мы выбираем 1-но из 2-ух поддеревьев <=> уменьшаем возможное число эл-ов вдвое
         деление каждый раз на 2-а до того момента, как найдём нужное - в предельном случае и есть логарифм(2-ичный) 

    На практике 2-ичное дерево поиска используется в струк-ах данных(напр - словарь) и в DNS.
*/







class binary_Node<Typ>        // element of tree
{
    Typ data;
    binary_Node Right;
    binary_Node Left;

    binary_Node(Typ el)
    {   data = el;
        Right = null;
        Left = null;    }

    binary_Node(binary_Node<Typ> src)
    {   data = src.data;
        Right = src.Right;
        Left = src.Left;    }

}


public class binary_tree<Typ extends Comparable<Typ> >      // saying that our generic "Typ" supports interface Comparable
{
    int size;                   // ammount of elements in a tree
    binary_Node root;           // root of the tree

    public binary_tree()
    { size = 0; root = null; }

    public binary_tree(Typ el)
    {
        size = 1;
        root = new binary_Node(el);
    }

    public binary_tree(binary_tree src)    // Coppy constructor
    {   
       size = src.size;
       root = new binary_Node(src.root);        // Copping head(root) of tree
       
       requrs_copy(root.Right);             // Copping right subtree of src tree
       requrs_copy(root.Left);              // Copping left subtree of src tree
    }







/* 
                  |--- ( R )
   ( node_i ) --- |
                  |--- ( L )
*/

    void requrs_copy(binary_Node node_i)   // watching all excisting tree-nodes 
    {
        if (node_i == null)                     // This will stop reqursion`s "branch"  each time we meet "leaf" of tree.
            {return;}                           //    - we`ll not get infinite reqursion --- because all the recursion stops, when all the "leafs" are found
                                                //    - we`ll not coppy same nodes --- just becaucse (it`s obvious when looking at some picture of tree) 
            
        binary_Node node = new binary_Node(node_i);         // Creating node 

        requrs_copy(node.Right);              // (R) ---> (node_i)
        requrs_copy(node.Left);               // (L) ---> (node_i)
        
    }
    


    binary_Node requrs_check(binary_Node node_i, Typ el)     // Returning node of tree element which .data == el or null if there`s no such node 
    {
        if (node_i == null)
            {return node_i;}
        
        if (el.compareTo((Typ)node_i.data) == 0)
            {return node_i;}
        

        if (el.compareTo((Typ)node_i.data) < 0)
            return requrs_check(node_i.Left, el);
        else
            return requrs_check(node_i.Right, el);
    }


    public boolean find(Typ el)                      // Checking indention of "el" in tree. Just analizing of requrs_check() output - nothing new
    {
        if (requrs_check(this.root, el) != null)
            return true;        
        else
            return false;
    }


// To append element in tree without rebuiding - we must find node with 0 or only 1 child. Then we replace old node or add him el as child.
//  Only time we rebuild tree - when el is already in tree - in this case we add el on a place of old point and link it`s subtree to added one.
    binary_Node get_parent(Typ el, binary_Node node_i)      // To fully understand this algo - look attentively on some picture of tree and ask yourself - "how to add new node?"  
    {
        
        if (el.compareTo((Typ)node_i.data) == 0)                 // Find excact the same node => end reqursion(not calling get_parent() again)
            return node_i;                                 
        

        if (el.compareTo((Typ)node_i.data) > 0)                  // Try to look right subtree
        {
            if (node_i.Right == null)                       // If can`t go, but need to move => we found place to add new one
                return node_i;
            else
                return get_parent(el, node_i.Right);        // Here we go forward until can
        }
         
        else                                                // Try to look left subtree
        {
           if (node_i.Left == null )                         // If can`t go, but need to move => we found place to add new one
              return node_i;
          
           else
              return get_parent(el, node_i.Left);
        }

        
    }

// Appending new element to tree without rebuilding tree(in case element haven`t occured yet)
// This func is much related with get_parent()!!! - it returns build point
    public void append(Typ el)
    {       
        size++;                                                            // bc we add element size increments

        if (size == 1) {root = new binary_Node(el); return;}                       // if our tree was empty before appending elemnet

        // getting parrent for new node
        binary_Node parent_node = get_parent(el, root);                    

        // linking new node to parent
        if (el.compareTo((Typ)parent_node.data) > 0)                       
            parent_node.Right = new binary_Node(el);                       // Right child of parent_node is granted == null when el > node.data  due function get_parrent() 
        
        else if  (el.compareTo((Typ)parent_node.data) < 0)
            parent_node.Left = new binary_Node(el);                        // For same reason as above
        

        else if (el.compareTo((Typ)parent_node.data) == 0)                      // In case if el was already in tree
        {
            binary_Node old_sub_tree = new binary_Node(parent_node.Right);          // Saving root-node of right sub-tree 
            
            parent_node.Right = new binary_Node(el);                                // Inserting new node 
            parent_node.Right.Right = old_sub_tree;    }                            // Linking old subtree to new node
    
    }


    public void del() 
    {   size = 0; root = null;   }
    

       

}

