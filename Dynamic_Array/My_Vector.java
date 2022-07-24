


public class My_Vector<Typ>
{
    Typ[] array;
    int size;               // how much elements are used
    int max_size;           // how much - are avaliable now

    public int[] get_sizes()
    {   int[] Vals = {size, max_size};  return Vals;}


    public My_Vector(int sz)
    {
        size = sz;
        max_size = size*2 + 10;
        array = (Typ[]) new Object[max_size];         // Выделение памяти для Generic массива, (Typ[]) - приведение к типу
        
    }


    public My_Vector(Typ[] src)    throws Vector_Exception         // Create dynamic array from src array
    {
        size = src.length;
        max_size = size*2 + 10;
        array = (Typ[]) new Object[max_size];         
        
        Copy_vals(src);
    }

    public My_Vector(My_Vector src)                   // Copy constructer for My_Vector
    {
        size = src.size;
        max_size = src.max_size;
        array = (Typ[])src.array;                            // Выделение памяти для Generic массива
    }


    public void Resize()         throws Vector_Exception                     // Used to resize already EXCISTING array - dont use it in My_Vector constructers !!!!!
    {
        Typ[] buff = array;
        size = max_size;                              // if we call Resize => all max_size elements are used and size = max_size

        max_size = max_size*2 + 10;
        array = (Typ[]) new Object[max_size];         // Выделение памяти для Generic массива
        Copy_vals(buff);
    }

    public void delete_arr()
    {
        size = 0; max_size = 0; array = null; 
    }


    public void axe_i(int i) throws Vector_Exception   // axe all elements starting from i <=> change array`s size to i
    {
        if (i < 0) throw new Vector_Exception();

        int k;
        for (k = i; k < size; ++k)  // deleting each element that is higher than i
            array[k] = null;
        
        size = i; 
        max_size = 2*size + 10;
    }

// Copy some part of src that`s fits into dyn arr
    public void Copy_vals( Typ[] src)   throws Vector_Exception    // Copies values of src array as much as possible for this.array
    {
        int i;
        for (i = 0; i < size; ++i)
        {
            System.out.println("Hey. i = " + i);
            array[i] = src[i];
        }
        System.out.println("Hey. i = " + i);
        axe_i(i);                                 // Clearing old values not to be as garbage in result array
    }

// Copy src array to dynamic array any way(by resizing)
    public void Init_arr(Typ[] src) throws Vector_Exception        // Copies values of src array and resize this "My_Vector" until it becomes posible to hold src 
    {
        if (src.length == 0)   
        {
            return;             // Nothing to add => return
        }    

        while (true)            // Scaling our array to fit with src array
            if (max_size >= src.length + 1 )
                break;
            else
    {   Resize(); System.out.println("Resized up to " + max_size + "elements" + "|src| = " + src.length); }

        int i = 0;
        for (Typ el : src)
        {
            array[i] = el;
            i++;          }       

        axe_i(i);                                 // Clearing old values not to be as garbage in result array
        
    }


    public void append(Typ el) throws Vector_Exception
    {
        try 
        {
            array[size] = el;
            size++;          } 
        catch (IndexOutOfBoundsException e) 
        {
            Resize();
            array[size] = el;   }
         
    }

    public void pop() throws Vector_Exception
    {
        if (size == 0) { throw new Vector_Exception("Empty array can`t be poped");}
        array[size - 1] = null;
        size--;
    }

    public void del_i(int i) throws Vector_Exception
    {
        try
        {
            array[i] = null;   }
        catch (IndexOutOfBoundsException e)
        {   throw new Vector_Exception("No such index");  }
    }

    public void add_i(int i, Typ el) throws Vector_Exception
    {
        try
        {
            array[i] = el;   }
        catch (IndexOutOfBoundsException e)
        {   throw new Vector_Exception("No such index");  }
    }

    public void print_arr() throws Vector_Exception
    {
        if (size == 0) {System.out.println("array is empty"); return;}
        int i;
        for (i = 0; i < size; ++i)
        try{  
            if (array[i] == null) System.out.print("[Deleted] "); else System.out.print(array[i] + " "); }
        catch (Exception e) { throw new Vector_Exception("No algorythm known to print " + i+"-th element \n- you should catch this exception and write your own printer to refered type");}

        System.out.println();
    }

}