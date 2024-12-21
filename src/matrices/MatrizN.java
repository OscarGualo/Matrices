/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrices;

/**
 *
 * @author oscar,ariel
 */
import java.util.Scanner;

/**
 *
 * @author oscar
 */
public  class MatrizN {
   private int valorPropio;
   private int[][] vectorPropio;
   private int[][] matrizGenerica ; 
   private int dimension; 
   Scanner s1 = new Scanner(System.in);
   public MatrizN(int dimension){
       matrizGenerica = new int[dimension][dimension];
       vectorPropio = new int[dimension][1];
       this.dimension = dimension; 
   }
   public MatrizN(int dimension, int valorPropio){
       matrizGenerica = new int[dimension][dimension];
   }
   
   public void llenarMatriz(){
       for (int i = 0; i < matrizGenerica.length; i++) {
            for (int j = 0; j < matrizGenerica [i].length; j++) {
                System.out.println("Ingrese el valor para la pos " + i + " " + j);
                matrizGenerica[i][j] = s1.nextInt();
            }
        }
   } 
    public void llenarVectorPropio(){
       for (int i = 0; i < vectorPropio.length; i++) {
            for (int j = 0; j < vectorPropio [i].length; j++) {
                System.out.println("Ingrese el valor para la pos del vector  " + i + " " + j);
                vectorPropio[i][j] = s1.nextInt();
            }
        }
   }    
    public String mostrarVectorPropio(){
        StringBuilder sb = new StringBuilder("Matriz:\n");
        for (int[] fila : vectorPropio) {
            for (int valor : fila) {
                sb.append(valor).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
   

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int[][] getMatrizGenerica() {
        return matrizGenerica;
    }

    public void setMatrizGenerica(int[][] matrizGenerica) {
        this.matrizGenerica = matrizGenerica;
    }

    public int getValorPropio() {
        return valorPropio;
    }

    public int[][] getVectorPropio() {
        return vectorPropio;
    }
    
   public String mostrarMatriz() {
        StringBuilder sb = new StringBuilder("Matriz:\n");
        for (int[] fila : matrizGenerica) {
            for (int valor : fila) {
                sb.append(valor).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
   /**
    * Este metodo va a mostrar la ecuacion usada para encontrar los valores propios
    */
   public void mostrarEcuacionGeneral(){
       
       System.out.println("Ecuacion General");
       System.out.println("A*v = λ*v");
       System.out.println("A -> Matriz n*n");
       System.out.println("v -> Vector propio de la matriz");
       System.out.println("λ -> Valor propio de la matriz");
   }
   /**
    * Este metodo va a multiplicar la matriz NxN del usuario por su vector propio
    * @return  retorna una matriz nx1 
    */
    public int[][] multiplicarMatrices() {
         int[][] matrizMultiplicada = new int[dimension][1];
        int auxiliarSuma = 0 ; 
        for(int i = 0 ; i<  matrizMultiplicada.length ; i++){
            for(int j  = 0 ;j< matrizMultiplicada.length ; j++){
             auxiliarSuma += getMatrizGenerica()[i][j] * getVectorPropio()[j][0];
              
                
            }
            matrizMultiplicada[i][0] = auxiliarSuma;
            auxiliarSuma = 0; 
        }
        
        return matrizMultiplicada;
    }
    

  
}
