/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrices;


/**
 *
 * @author oscar
 */
import java.util.Scanner;
import java.util.Arrays;
public class Matrices {

   public static void main(String[] args) {
         
         Scanner s1 = new Scanner(System.in);
         int opc = 0 ; 
          int y = 0; 
         System.out.println("Que desea hallar ?");
         System.out.println("1. Valor Propio");
         System.out.println("2. Vector propio");
         opc = s1.nextInt();
         switch (opc) {
             case 1:
                 int x = 0; 
                 System.out.println("De que tamaño es su matriz ");
                 x = s1. nextInt();
                 //para camibar esto mejor implementar interfaces y dejar una matrizN
                   MatrizN matriz = new MatrizN(x);
                   matriz.llenarMatriz();
                   matriz.llenarVectorPropio();
                   CalculadorEigen calculadora = new CalculadorEigen(matriz);
                   matriz.mostrarEcuacionGeneral();
                   calculadora.mostrarValoresPropios();
                     
                 
                 
                 break;
             case 2: 
                
                 System.out.println("De que tamaño es su matriz ");
                 y = s1. nextInt();
                 System.out.println("Ingrese el valor propio: ");
                  int valorPropio = s1.nextInt();
                 //para camibar esto mejor implementar interfaces y dejar una matrizN
                   MatrizN matrizCaso2 = new MatrizN(y,valorPropio);
                   matrizCaso2.llenarMatriz();
                   CalculadorEigen calculadorVectorPropio = new CalculadorEigen(matrizCaso2);
                   calculadorVectorPropio.mostrarVectorPropio();
                   
                 break;
             default:
                 throw new AssertionError();
         }
     
     }
    
}
