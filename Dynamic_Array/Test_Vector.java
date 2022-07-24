
/*
!!!!!!!!!!!!!!!!!!!!!!!!!!!
 Проблема в .Init_arr()  в месте, где Resize()
    при
!!!!!!!!!!!!!!!!!!!!!!!!!!
*/

import java.util.Scanner;

public class Test_Vector
{
    static<T> void print(T msg)
    { System.out.println(msg);}
    
    static void Wait_click()
    {
        print("Push ENTER key to see next step");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();                          // asking to push any symbol
        print("\n-----------------------------------------------------------\n");}


    public static void main(String[] args) 
    {
        try{
            Integer[] mess = {2, 35, -1}; 
            My_Vector arr = new My_Vector(mess);

            print("\n===========Created array by constractor and different array:");
            arr.print_arr();
            Wait_click();

            int[] sizes = arr.get_sizes();
            System.out.println("\nCurrent array size = " + sizes[0] + "\nCurrent avaliable size(allocated) = " + sizes[1]); 
            Wait_click();

            print("\n===========Initializing excisting dynamic array by simple array, that`s bigger than dyn arr:");
            Integer[] mess2 = {2, 45, 89, -88, 77, 8, 11, 27, 1, 10, -7, 888, 6, 5, 4, 9};
            arr.Init_arr(mess2);
            arr.print_arr();

            System.out.println("Active size: " + arr.size);
            Wait_click();

            print("\n===========Appending new element of string type");
            arr.append("{^.^}");
            arr.print_arr();
            Wait_click();

            print("\n===========Deleting head of array");
            arr.pop();
            arr.print_arr();
            Wait_click();

            print("\n===========Deleting 5-th el");
            arr.del_i(5);
            arr.print_arr();
            Wait_click();

            print("\n===========Inserting 5-th el");
            arr.add_i(5, "{*_*}");
            arr.print_arr();
            Wait_click();
            
            print("\n===========Changing array`s size down to 8");
            arr.axe_i(8); 
            arr.print_arr();
            Wait_click();

            print("\n===========Old array copied to new:");
            My_Vector cloned = new My_Vector(arr);
            cloned.print_arr();
            Wait_click();

            print("\n===========Changing array`s size up to 28");
            arr.axe_i(28); 
            arr.print_arr();
            Wait_click();

            sizes = arr.get_sizes();
            System.out.println("\nCurrent array size = " + sizes[0] + "\nCurrent avaliable size(allocated) = " + sizes[1]);
            Wait_click();

            print("\n===========Deleting array:");
            arr.delete_arr();
            
            sizes = arr.get_sizes();
            System.out.println("\nCurrent array size = " + sizes[0] + "\nCurrent avaliable size(allocated) = " + sizes[1]); }
        
        catch(Vector_Exception e)
        {
            e.exception_info();
        } 
    }
}