

/* About:
    Реализация связанного списка, как контейнера для произвольного типа данных.
    *здесь тестирование, а сама реализация - в My_list.java 
*/ 



/* PS
    Чтобы не загромождать код, я "зашил" параметры у тестируемых функций.
    Но это не очень большая беда - можно изменить их вручную и убедится, 
        что некоректные операции применимо к тестируемым функциям порождают исключения,
        к тому же связанный список работает с произвольным типом данных 
        и его не так-то просто вввести консольно(нужно специальную функцию инициализации писать),
        так что не интерактивное изменение параметров в данном случае, мне кажется, приемлимо.  
*/


import java.util.Scanner;

public class Test_List 
{

    static void print(String msg)
    {
        System.out.println(msg);}

    static void Wait_click()
    {
        print("Push ENTER key to see next step");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();                          // asking to push any symbol
        print("\n-----------------------------------------------------------\n");}


    public static void main(String[] args)
    {
        try                                 // Not to test each "exception-possible" function separately - let`s check all test-code and catch if List_exception happens 
        {
            My_list l = new My_list();

            print("=======[Pushed] 3 nodes to head of list===========");
            l.push_up("Joka");         // now String goes as node`s value
            l.push_up("Boka");
            l.push_up("%&#");
            l.print_list();
            Wait_click();

            print("=======[Pushed] to tail of list=======");
            l.push_down(45);            // now Integer goes as node`s value
            l.print_list();
            Wait_click();

            print("======= [Inserted] new node as 2-nd node:===========");
            l.push_i("It`s 2-nd node", 2); l.print_list(); 
            Wait_click();

            print("=======[Created] new list by class constructer: ===========");
            My_list Reborn = new My_list("Reborn");       
            Reborn.print_list();
            Wait_click();

            print("=======[Clearing] entire list:===========");
            Reborn.clear_list();
            Reborn.print_list();
            Wait_click();
            

            print("=======[Coping] old list into cleared list by copy-constructer:===========");
            Reborn = new My_list(l);
            Reborn.print_list();
            Wait_click();

            print("=======Head of list [deleted]:===========");
            Reborn.delete_up();
            Reborn.print_list();
            Wait_click();

            print("=======Tail of list [deleted]:===========");
            Reborn.delete_down();
            Reborn.print_list();
            Wait_click();

            print("======= [deleting] 2-nd node:===========");        
            Reborn.delete_i(2); Reborn.print_list();
         }
        
         catch(List_Exception expt)                              // Some exception while working with list
         {
             expt.exception_info();}                             // Printing exception`s message   
  
        
    }
}


