
/*Class for working with list`s exceptions*/

public class List_Exception extends Exception {    
    String msg = null;
    String Alert = "\n----Allert: List Exception!!!";
    String border = "\n*******************\n";

    List_Exception()                         // Default constructor
    {}

    List_Exception(String mess)               // Advanced constructer
    {
        msg = mess;
    }

    public void exception_info()              // Method for printing Exception
    { 
        if (msg == null)
            System.out.println("No messege given to this exception");
        else
            System.out.println(Alert + border + "Ups, we`ve got an exception:\n" + msg + border);
    }
}
