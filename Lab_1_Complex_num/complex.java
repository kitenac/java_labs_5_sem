
/*
 Все Static-методы классов в диретории грузятся в память по умолчанию!!!! 
    
 Без static - на уровне объекта
 Со static - на уровне клвсса
 */


//По поводу переопределения .equals() https://javarush.ru/quests/lectures/questsyntaxpro.level10.lecture04

/* Complex numbers */ 
public class complex 
{
  double Re;
  double Im;
  
  public complex() {};                // Empty prototype for creating obj without init 
  public complex(double x, double y)  // Create + Init
  {
    Re = x; 
    Im = y;    
  }
  
  @Override
  public boolean equals(Object obj) {
     if (!(obj instanceof complex) || obj == null)       // Если тип не complex или Null Pointer
         return false;

     complex comp = (complex) obj;                       // Casting Object(name of object)  to complex object
     
     if (Re == comp.Re && Im ==  comp.Im ) 
        return true;
     else 
        return false;
  }
  


  public static complex add( complex z, complex z_2)
  {
    complex z_3 = new complex(); 
    z_3.Re = z.Re + z_2.Re;
    z_3.Im = z.Im + z_2.Im;
    return z_3;
  }

  public static complex dec( complex z, complex z_2)
  {
    complex z_3 = new complex(); 
    z_3.Re = z.Re - z_2.Re;
    z_3.Im = z.Im - z_2.Im;
    return z_3;
  }

  public double get_Arg()
  {

    if(Re == 0)
    {
         if(Im > 0) 
            return Math.PI/2;
         else if(Im < 0) 
            return Math.PI/2 * (-1);
         else 
            return 666;                   //dot case: let arg be 0 when Re = Im = 0
    }
    if(Im == 0)
        if (Re > 0)
            return 0;
        else 
            return Math.PI;


    double Angle = Math.atan(Im/Re);
    if(Re > 0)
         return Angle; 
    else if (Im > 0) 
         return Angle + Math.PI;
    else  
         return Angle - Math.PI;
         
  }


  public double get_Module()
  { 
    return Math.sqrt(Re*Re + Im*Im);
  } 


}

