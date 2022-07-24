
import java.util.Scanner; // For reading from some stream

public class test_complex
{

    public static void main(String args[])
    {
        complex z, z_2, sum, dec; 
        z = new complex();
        z_2 = new complex();
        sum = new complex();
        dec = new complex();

        Scanner sc = new Scanner(System.in);  
        System.out.println("Enter Re and Im parts of z" );
        System.out.print("Re: ");
         z.Re = sc.nextDouble();  
        System.out.print("Im: ");
         z.Im = sc.nextDouble();
       
         
        System.out.println("-||- of z_2");
        System.out.print("Re: ");
         z_2.Re = sc.nextDouble();  
        System.out.print("Im: ");
         z_2.Im = sc.nextDouble();
       
    
        
        double mod = z.get_Module();
        double arg = z.get_Arg();

        System.out.println("\n----------------\nModule[z] = " + mod);
        if (arg != 666)
            System.out.println("Arguement[z] = " + arg/Math.PI + "*pi"); // devide by pi = 3,1416.. for "beautiful" output(keep in mind variable 'arg' isn`t devided by Pi - "beautiful" for possible calculations )
        else
            System.out.println("(0,0) - has undefined arguement( it`s a null vector)");
        
        sum = complex.add(z, z_2);
        dec = complex.dec(z, z_2);
        System.out.println("\nz + z_2 = " + sum.Re +" + "+ sum.Im + "i");
        System.out.println("z - z_2 = " + dec.Re +" + "+ dec.Im + "i\n----------------\n");


    }
}
