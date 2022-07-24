
import java.util.Arrays;

public class Simple_sorts 
{


/*
[!!!!]  
        <Typ extends Comparable<Typ> 
           -means that our generic "Typ" supports interface Comparable
            due methods are static their generics are separate! from possible generics declared in class
*/ 


    public static <Typ extends Comparable<Typ> > Typ[] buble_sort(Typ[] arr, int a, int b)       
    {
        int n = b;
        Typ buff;

        Typ[] Buff = Arrays.copyOf(arr, arr.length);            // Array are passing by link not by value => we must 
        arr = Buff;                                             // change link. So we created  Buff samevalued as src arr and work with it

        for (int i = a; i < n - 1; ++i)                         // n - 1 times going into arr
            for (int j = a; j < n-i - 1; ++j)                   // Watching how j-st element fits to other el-ts. Border (n-1 - i) - because each itteration of "i" we`ll have most greater el on a top. 
                if (arr[j].compareTo(arr[j+1]) < 0)             // checking if arr[j] < arr[j+1], but for Object type
                    {                                           // Then swaping elements
                        buff = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = buff;   }   
                
        return arr;             
    }

    public static <Typ extends Comparable<Typ> > Typ[] buble_sort(Typ[] arr)    
    {   return buble_sort(arr, 0, arr.length);  }


    public static <Typ extends Comparable<Typ> > Typ[] selection_sort(Typ arr[], int a, int b)       
    {

        Typ[] Buff = Arrays.copyOf(arr, arr.length);            // Array are passing by link not by value => we must 
        arr = Buff;                                             // change link. So we created  Buff samevalued as src arr and work with it

        int n = b;         int i,j;  
        Typ buff;
        Typ max;                                       
        int m_i;                                            // index of max element

        for (i = a; i < n; ++i)                        
        {    
            max = arr[i];                                       // we need to find max el in [i:n] slice of arr, so let now max be i-th el
            m_i = i;                                            // m_i must be rechosen to!

            for (j = i; j < n; ++j)                             // Seek max element in unsorted part of array
                if (arr[j].compareTo(max) > 0)
                {   max = arr[j]; m_i = j;   }
             
                
            buff = arr[i];
            arr[i] = max;
            arr[m_i] = buff;  
        }

        return arr;
    }

    public static <Typ extends Comparable<Typ> > Typ[] selection_sort(Typ arr[])    // For entire array
    {   return selection_sort(arr, 0, arr.length);  }



//  Алгоритм сортировки простыми вставками делит список на 2 части — отсортированную и неотсортированную. 
//   Из неотсортированной части извлекается очередной элемент и вставляется на нужную позицию, в результате 
//   чего отсортированная часть списка увеличивается, а неотсортированная уменьшается. Так происходит, 
//   пока не исчерпан набор входных данных  и не отсортированы все элементы.

    public static <Typ extends Comparable<Typ> > Typ[] insertion_sort(Typ arr[], int a, int b)
    {
        Typ[] Buff = Arrays.copyOf(arr, arr.length);            // Array are passing by link not by value => we must 
        arr = Buff;                                             // change link. So we created  Buff samevalued as src arr and work with it
        
        int n = b;         int i,j;  
        Typ buff;
       
        for (i = a; i < n; ++i)                                 // crawling each element                        
        {                     
            for (j = a; j < i; ++j)                             // inserting i-th element to sorted subarray( from a - to (i-1) elements) 
                if (arr[i].compareTo(arr[j]) > 0)               
                {        
                    buff = arr[j];
                    arr[j] = arr[i];
                    arr[i] = buff;      }      
        }

        return arr;
    }

    
    public static <Typ extends Comparable<Typ> > Typ[] insertion_sort(Typ arr[])
    {   return insertion_sort(arr, 0, arr.length);  }



     /*
 Сортировка простыми вставками

a = [1, 7, -3, 9, 0, -67, 34, 12, 45, 1000, 6,  8, -2, 99]
n = len(a)

for i in range(1, n): 
    elem = a[i]  # первый элемент из неотсортированной части списка
    j = i
    while j >= 1 and a[j - 1] > elem: 
        a[j] = a[j - 1]
        j -= 1
    a[j] = elem

*/
}
