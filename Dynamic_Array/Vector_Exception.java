
/*Class for working with list`s exceptions*/

public class Vector_Exception extends Exception {    
    String msg = null;
    String Alert = "\n----Allert: Vector Exception!!!";
    String border = "\n*******************\n";

    Vector_Exception()                         // Default constructor
    {}

    Vector_Exception(String mess)               // Advanced constructer
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
