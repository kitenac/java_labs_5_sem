
import java.util.Scanner;


public class Test_sorts 
{
    static void Wait_click()
    {
        System.out.println("Push ENTER key to see next step");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();                          // asking to push any symbol
        System.out.println("\n-----------------------------------------------------------\n");}


    public static <Typ> void print_arr( Typ[] arr)        // Красивый вывод массива 
    {
        int i; 
        for(i = 0; i < 3; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();             //print '\n'

        for(i = 3; i < arr.length; ++i)
        {
            System.out.print(arr[i] + " ");
            if ((i+1) % 3 == 0)
                System.out.println();   } //print '\n'
        System.out.println();             //print '\n'
    }

    
    public static void main(String[] args)
    {

        String[] BTS = {"Vi","John-Guck", "Chimin", "Chin", "Syuga","J-Hope"};
        Integer[] a_1 = {949, 1, 56, -77, 99, 10, 30};
        Double[] a_2 = {6.0, 4.5, 6.9, 1.7, -7.1, 0.42, 1.02, 33.2};
        
        System.out.println("Pyramid(qsort) sort of String[]: \n Before:");
        print_arr(BTS);
        System.out.println("After: \n");
        Effective_sort.qsort(BTS);
        print_arr(BTS);
        Wait_click();

        System.out.println("Heap sort of Double[]: \n Before:");
        print_arr(a_2);
        System.out.println("After: \n");
        Effective_sort.heap_sort(a_2);
        print_arr(a_2);
        Wait_click();


        System.out.println("Merge sort of Integer[]:  \n Before:");
        print_arr(a_1);
        System.out.println("After: \n");
        Effective_sort.qsort(a_1);
        print_arr(a_1);
    }

}
