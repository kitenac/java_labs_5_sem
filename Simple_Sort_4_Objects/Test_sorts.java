
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
        Integer[] mass = {22, 8, 1, 4, -8, 6, 0};    // not "int"!!! Because generic must be an Object!
        String[] weapons = {"AK-47,", "RPG-7B2,", "TT,", "M-16,", "AKSU,", "FIM-STINGER,", "SCORPION,", "KEDR,", "M4A4,", "DESERT-EAGLE,"};

        System.out.println("Testing each sort-algo on integer array of fixed size" + "\n Our unsorted arr:");
        print_arr(mass);
        Wait_click();

        System.out.println("    [buble sort]");
        print_arr(Simple_sorts.buble_sort(mass));
        Wait_click();
        
        System.out.println("    [selection sort]");
        print_arr(Simple_sorts.selection_sort(mass));
        Wait_click();

        System.out.println("    [insertion sort]");
        print_arr(Simple_sorts.insertion_sort(mass));
        Wait_click();

        System.out.println("\nTesting each sort-algo on string array(to demonstrate that our sort algos can sort every type)" + "\n Our unsorted arr:\n");
        print_arr(weapons);
        Wait_click();

        System.out.println("    [buble sort]");
        print_arr(Simple_sorts.buble_sort(weapons));
        Wait_click();

        System.out.println("    [selection sort]");
        print_arr(Simple_sorts.selection_sort(weapons));
        Wait_click();

        System.out.println("    [insertion sort]");
        print_arr(Simple_sorts.insertion_sort(weapons));
        Wait_click();


        System.out.println("Demonstrating possibility of sorting of subarray( first 3 elements aren`t sorted):\n");
        print_arr(Simple_sorts.insertion_sort(weapons, 2, weapons.length));

    }
}


