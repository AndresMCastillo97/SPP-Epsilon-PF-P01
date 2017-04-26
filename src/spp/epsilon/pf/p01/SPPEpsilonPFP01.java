//Proyecto Final 
//Problema 1
//Equipo Epsilon
//Nombres, matrículas y carreras de integrantes de equipo:
//Roberto Alain Rivera Bravo | A01411516 | IMT11
//Fabricio Arturo Balboa Cavazos | A01411541 | IMT11
//Andrés de Jesús Martínez Castillo | A01411447 | IMT11
//Jessica Delgado González | A01411536 | IMT11
//Alfredo Alejandro Lárraga Sosa | A01410278 | LMC

/*
Problema:
Desarrolla un programa en Java que solicite la cantidad de materias que llevas en este semestre, solicite cada materia 
y las guarde en un vector, después solicite para cada materia las calificaciones parciales para cada materia deberás mostrar 
el nombre de la materia al solicitar la calificación parcial, las guarde en una matriz, calcule y muestre el promedio para cada una,
mostrando el nombre de cada materia.
 */
package spp.epsilon.pf.p01;

import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author andres
 */
public class SPPEpsilonPFP01 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();//Método menú
    }
    public static void menu(){//Método menú en el cual se desarrollará el programa
       int nummaterias;
       nummaterias= devolverdato("Introduce el numero de materias");//LLamo al método que me devuelve una variable entera por JOptionPane
       String [] materias;
       double [] p1,p2,p3,promedio; 
       materias=vector(nummaterias);//LLamo al método que me devuelve un arreglo de una dimension tipo String
       p1=vectordouble(nummaterias,"Introduce la calificación del parcial 1 de: ",materias);//LLamo al método que me devuelve un arreglo de una dimension tipo double
       p2=vectordouble(nummaterias,"Introduce la calificación del parcial 2 de: ",materias);//LLamo al método que me devuelve un arreglo de una dimension tipo double
       p3=vectordouble(nummaterias,"Introduce la calificación del parcial 3 de: ",materias);//LLamo al método que me devuelve un arreglo de una dimension tipo double
       promedio(p1,p2,p3,nummaterias,materias);//LLamo al método que me obtiene el promedio de los parciales de cada materia
       salida();//LLamo al método salida que pregunta al usuario si desea volver a correr el programa o salir
    }
    public static int devolverdato(String mensaje){//Método que me devuelve una variable tipo int validada introducida por cuado de dialogo
      boolean flag;
      int x=0;
        do{
            try{
                String dato=JOptionPane.showInputDialog(null, mensaje);
                x=Integer.parseInt(dato) ;
                flag=true;
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Dato no válido, vuelva a intentarlo","ERROR", JOptionPane.OK_CANCEL_OPTION);
                flag=false;
            }
        }while(flag==false);
      return x;      
 }    
    public static String[] vector(int n){//Método que me devuelve un arreglo de una dimension tipo String
        String [] vector = new String [n];  
        int m=0;
            for (int i = 0; i < vector.length; i++) {
                m=m+1;
                vector[i]=solicitardato("Introduce el nombre de la materia "+ m);//Método que me devuelve una variable tipo String introducida por cuadro de dialogo
            }
        return vector;//Se regresa la matriz con los valores ingresados
        
 }
    public static String solicitardato(String mensaje){//Método que me devuelve una variable tipo String validada introducida mediante cuadro de dialogo
        boolean flag;
        String n = null;
            do{
                try{//Se utiliza un Try & Catch para evitar errores cuando se ingresan valores por teclado
                    n=JOptionPane.showInputDialog(null,  mensaje);
                    flag=true;
                 }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Dato no válido, vuelva a intentar");
                    flag=false;     
                }   
            }while(flag==false);
        return n;
 }
    public static double[] vectordouble(int n,String  mensaje,String[] materia){//Método que me devuelve un arreglo de una dimension tipo double con datos introducidos por cuadro de dialogo
        double [] vector = new double [n];
        boolean flag;
            for (int i = 0; i < vector.length; i++) {
                do{
                    try{
                        String dato=JOptionPane.showInputDialog(null, mensaje+materia[i]);
                        vector[i]=Double.parseDouble(dato);
                        flag=true;
                    }catch (Exception ex) {
                        flag=false;
                        JOptionPane.showMessageDialog(null,"Dato no válido, vuelva a intentarlo","ERROR", JOptionPane.OK_CANCEL_OPTION);
                    }   
                }while(flag==false);
            } 
        return vector;
    }
    public static void promedio(double[]a,double[]b,double[]c,int n,String[]m){//Método que calcula el promedio de los parciales de cada materia y muestra las calif de cada parcial y su promedio gral 
        double[]prom=new double [n];
        double suma1, suma2, suma3;
            for (int i = 0; i < a.length; i++) {
                prom[i]= (a[i]+b[i]+c[i])/3;  
                JOptionPane.showMessageDialog(null,"Calificaciones parciales de "+m[i]+": "+a[i]+" "+b[i]+" "+c[i]+"\nEl promedio general de "+m[i]+" es "+prom[i]);    
            }    
    }
    public static void salida(){//Método que pregunta al usuario si desea volver a correr el programa o salir mediante cuadro de dialogo
       int opcion=JOptionPane.showOptionDialog(null, "¿Qué desea hacer? ", "Menu de salida",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object []{"Volver a correr el programa", "Salir"}, "Volver a correr el programa");
            if(opcion==0){
               menu();
               System.exit(0);
            }else {
                JOptionPane.showMessageDialog(null,"Vuelva pronto!");
                System.exit(0);
            }
    }
}
