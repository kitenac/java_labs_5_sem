

import java.util.Scanner;

class Test_bin_tree
{

    static void Wait_click()
    {
        System.out.println("Push ENTER key to see next step");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();                          // asking to push any symbol
        System.out.println("\n-----------------------------------------------------------\n");}

    static void tree_test_info(binary_tree tree)
    {
        System.out.println("Is 'Serj' in tree? - " + tree.find("Serj"));
        System.out.println("Is 'Berlin' in tree? - " + tree.find("Berlin"));
        System.out.println("How large is black_list? - " + tree.size);

    }

    public static void main(String[] args)
    {
        System.out.println("Now creating new tree. Than we appending 'Serj' and 'Berlin' in it ");
        binary_tree contacts = new binary_tree();
        contacts.append("Serj");
        contacts.append("Berlin");
    
        tree_test_info(contacts);
        System.out.println("Is 'Vladimir' in tree? - " + contacts.find("Vladimir"));
        Wait_click();
     
        System.out.println("Now create new tree using copy-constructer:");
        binary_tree black_list = new binary_tree(contacts);
        tree_test_info(black_list);
        Wait_click();
        
        System.out.println("Know clearing tree called 'black_list'");
        black_list.del();
        tree_test_info(black_list);
        
    }

}