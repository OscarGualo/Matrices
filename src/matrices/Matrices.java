/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrices;


/**
 *
 * @author oscar,ariel
 */
import java.util.Scanner;
import java.util.Arrays;
public class Matrices {

   public static void main(String[] args) {
    Scanner s1 = new Scanner(System.in);
    int opc = 0 ; 
    boolean boleano, aux, finalizar = true;
    do{
      do {
        System.out.println("//// BIENVENIDOS AL INICIO DEL PROGRAMA /// \n");
        System.out.println("--- Que desea hallar ? ---\n");
        System.out.println("2. Vector propio");
        System.out.println("1. Valor Propio");
        System.out.println("0. Para Finalizar el Programa");

        try {
          opc = Integer.parseInt(s1.nextLine());
          if ((opc < 0) || (opc > 2)) {
            System.out.print("\nError, el número: " + opc + " no es una opción\n");
            System.out.println("Inténtelo de nuevo...\n");
          }
        } catch (NumberFormatException e) {
            System.out.print("\nOpción Inválida. Inténtelo de nuevo...\n\n");
            opc = -1;
        }

        if ((opc < 0) || (opc > 2)) {
            boleano = false;
        } else {
            boleano = true;
        }
      } while (!boleano);
         switch (opc) {
            case 1:
              int x = 0;
              do {
                System.out.println("De qué tamaño es su matriz ");
                try {
                    x = Integer.parseInt(s1.nextLine()); 
                    if (x < 0) {
                      System.out.print("\nError, el número: " + x + " no es una opción\n");
                      System.out.println("Inténtelo de nuevo...\n");
                      aux = false; 
                    } 
                    else {
                      aux = true; 
                    }
                  } catch (NumberFormatException e) {
                      System.out.print("\nOpción Inválida. Inténtelo de nuevo...\n\n");
                      aux = false;
                  }
              } while (!aux);

                //para camibar esto mejor implementar interfaces y dejar una matrizN
                MatrizN matriz = new MatrizN(x);
                matriz.llenarMatriz();
                matriz.llenarVectorPropio();
                CalculadorEigen calculadora = new CalculadorEigen(matriz);
                matriz.mostrarEcuacionGeneral();
                calculadora.mostrarValoresPropios();
            break;
            case 2:
             int y = 0, valorPropio = 0;
             do {
                 System.out.println("De qué tamaño es su matriz ");
                 try {
                     y = Integer.parseInt(s1.nextLine()); 
                     if (y < 0) {
                       System.out.print("\nError, el número: " + y + " no es una opción\n");
                       System.out.println("Inténtelo de nuevo...\n");
                       aux = false; 
                     }
                      else {
                      aux = true; 
                     }
                 } catch (NumberFormatException e) {
                     System.out.print("\nOpción Inválida. Inténtelo de nuevo...\n\n");
                     aux = false;
                 }
             } while (!aux);
              
             do {
                 System.out.println("Ingrese el valor propio (En números enteros): ");
                 try {
                     valorPropio = Integer.parseInt(s1.nextLine()); 
                     aux = true;
                     }
                 catch (NumberFormatException e) {
                     System.out.print("\nOpción Inválida. Inténtelo de nuevo...\n\n");
                     aux = false;
                 }
                
             } while (!aux);
                 //para camibar esto mejor implementar interfaces y dejar una matrizN
                   MatrizN matrizCaso2 = new MatrizN(y,valorPropio);
                   matrizCaso2.llenarMatriz();
                   CalculadorEigen calculadorVectorPropio = new CalculadorEigen(matrizCaso2);
                   calculadorVectorPropio.mostrarVectorPropio();   

            break;

            default:
              System.out.println("Saliendo del programa .......");
         }
     
      do {
        System.out.println("//// FIN DEL PROGRAMA /// \n");
        System.out.println("--- Desea continuar ?? ---\n");
        System.out.println("1. Para Reiniciar");
        System.out.println("0. Para Finalizar el Programa");

        try {
          opc = Integer.parseInt(s1.nextLine());
          if ((opc < 0) || (opc > 1)) {
            System.out.print("\nError, el número: " + opc + " no es una opción\n");
            System.out.println("Inténtelo de nuevo...\n");
          }
        } catch (NumberFormatException e) {
            System.out.print("\nOpción Inválida. Inténtelo de nuevo...\n\n");
            opc = -1;
        }
        if (opc == 0){
          finalizar = false;
          System.out.println("Saliendo del programa .......");
        }
        if ((opc < 0) || (opc > 1)) {
            boleano = false;
        } else {
            boleano = true;
        }
      } while (!boleano);
    } while (finalizar);
  }
}
