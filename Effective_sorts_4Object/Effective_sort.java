


/* 
    Effective sorts they`re used a lot in practice, for ex. in PL`s sort functions.
    Here`re coded qsort(aka pyramid), heap and merge sorts. 
*/


public class Effective_sort{

    
    public static <Typ extends Comparable<Typ>> void qsort(Typ a[], int s_lft, int s_rght) {  // sorting some truncate of array
        if (s_lft < s_rght)
        {
           
            Typ base = a[(s_lft + s_rght) / 2];  // Middle element
            int lft = s_lft;                     // saving given lft and rght to operate `em bellow
            int rght = s_rght;

            while (lft <= rght) {

                while (a[lft].compareTo(base) < 0)   
                    lft++;
                while (a[rght].compareTo(base) > 0) 
                    rght--;

                if (lft <= rght) {              // Swappng lft and right
                    Typ buff = a[lft];
                    a[lft] = a[rght];
                    a[rght] = buff;
                    lft++;
                    rght--;
                }
            }

            qsort(a, s_lft, lft - 1);       // reqursion into left part
            qsort(a, lft, s_rght);          // - into right part
        }
    }


    public static <Typ extends Comparable<Typ>> void qsort(Typ a[]) {       // Sorting all array due Polymorhizm))
        qsort(a, 0, a.length - 1);            
    }



//-------------------------------------------------------------------------------------------------------------

public static Integer[] merge_sort(Integer[] arr){
    if (arr.length < 2)
        return arr;

    int mid = arr.length / 2;
    
    Integer[] arr_left = new Integer[mid];                          // Just copying sub arrays to use them as local values
    System.arraycopy(arr,0,arr_left,0, mid);

    Integer[] arr_right =  new Integer[arr.length - mid]; 
    System.arraycopy(arr,mid,arr_right,0, arr.length - mid);

    return merge_op(merge_sort(arr_left), merge_sort(arr_right));
}



// subfunction
public static Integer[] merge_op(Integer[] ar_1, Integer[] ar_2){
    Integer[] buff = new Integer[ar_1.length + ar_2.length];      // local buff-aray  

    int idx_up = 0;
    int idx_down = 0;

    for (int i = 0; i < buff.length; i++){                        // forming array watching subsorted up and down of same size
        if (idx_up == ar_1.length)
            buff[i] = ar_2[idx_down++];

        else if (idx_down == ar_2.length) 
            buff[i] = ar_1[idx_up++];
        
        else {
            if (ar_1[idx_up].compareTo(ar_2[idx_down]) < 0) 
                buff[i] = ar_1[idx_up++];
            else 
                buff[i] = ar_2[idx_down++];               
        }
    }

    return buff;
}



//-------------------------------------------------------------------------------------------------------------


    public static <Typ extends Comparable<Typ>> void heap_sort(Typ arr[], int lft, int rght){
        int n = rght - 1;
        for (int i = n/2; i >= lft; i--)
            balance(arr, i, n);             // rebalancing till left border

        for (int i = n; i >= lft; i--){     
            Typ buff = arr[lft];
            arr[lft] = arr[n];
            arr[n] = buff;
            n--;
            balance(arr, 0, n);
        }
    }

    public static <Typ extends Comparable<Typ>> void heap_sort(Typ arr[]) {
        heap_sort(arr, 0, arr.length);
    }

// subfunction
    public static <Typ extends Comparable<Typ>> void balance(Typ arr[], int pos, int size){
        int a = 2*pos + 1;
        int b = 2*pos + 2;
        int largest_el = pos;                          

        if (a <= size)
            if (arr[a].compareTo(arr[largest_el]) > 0){
                largest_el = a;
            }

        if (b <= size)
            if (arr[b].compareTo(arr[largest_el]) > 0){
                largest_el = b;
            }

        if (largest_el != pos) {
            Typ buff = arr[pos];                    // Swapping current el and max el
            arr[pos] = arr[largest_el];
            arr[largest_el] = buff;

            balance(arr, largest_el, size);      // reqursion till of "if"s are false
        }
    }



}

