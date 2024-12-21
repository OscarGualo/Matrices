/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrices;

/**
 *
 * @author oscar, ariel
 */
import java.util.Arrays;
public class CalculadorEigen {
    private final  MatrizN matriz;

    public CalculadorEigen(MatrizN matriz) {
        this.matriz = matriz;
    }
    /**
     * Este metodo sera privado ya que solo va a trabajar en la clase, el cual va a calcular el valor propio de la matriz dada por el ususario
     * @return returna un numero entero que es el valor propio asociado a la matriz y al vector propio del usuario
     */
    private double calcularValorPropio() {
        double  ValorPropio  = 0   ;
      
            ValorPropio = matriz.multiplicarMatrices()[0][0] / matriz.getVectorPropio()[0][0];
        
                
        return ValorPropio ; 
    }
   
    
     /**
     * Este metodo va a mostrar los valores propios propio encontrado 
     */
    public void mostrarValoresPropios(){
        double valorPropio = calcularValorPropio(); 
        
        System.out.println("El valor propio es: "+ valorPropio);
    }
    public  double[] calculateEigenvector( double eigenvalue) {
        int[][] matrizVector = matriz.getMatrizGenerica();
        int n = matrizVector.length;
        double[][] modifiedMatrix = new double[n][n];
        
        // Crear la matriz A - λI
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                modifiedMatrix[i][j] = matrizVector[i][j];
                if (i == j) {
                    modifiedMatrix[i][j] -= eigenvalue;
                }
            }
        }

        // Resolver el sistema de ecuaciones (A - λI)v = 0 usando eliminación gaussiana
        double[] eigenvector = new double[n];
        boolean foundSolution = resolverSistemaHomogeneo(modifiedMatrix, eigenvector);

        if (!foundSolution) {
            throw new IllegalArgumentException("No se encontró una solución no trivial para el vector propio.");
        }

        return eigenvector;
    }

    private  boolean resolverSistemaHomogeneo(double[][] matrix, double[] solution) {
        int n = matrix.length;
        double[] tempSolution = new double[n];

        // Transformar la matriz a forma escalonada
        for (int i = 0; i < n; i++) {
            // Buscar el pivote
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matrix[k][i]) > Math.abs(matrix[maxRow][i])) {
                    maxRow = k;
                }
            }

            // Intercambiar filas si es necesario
            double[] temp = matrix[i];
            matrix[i] = matrix[maxRow];
            matrix[maxRow] = temp;

            // Si el pivote es cero, no hay solución única
            if (Math.abs(matrix[i][i]) < 1e-10) {
                return false;
            }

            // Normalizar la fila del pivote
            for (int j = i + 1; j < n; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i; k < n; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }

        // Resolver el sistema triangular
        for (int i = n - 1; i >= 0; i--) {
            tempSolution[i] = 1; // Asignar un valor arbitrario para obtener una solución no trivial
            for (int j = i + 1; j < n; j++) {
                tempSolution[i] -= matrix[i][j] * solution[j];
            }
            tempSolution[i] /= matrix[i][i];
        }

        System.arraycopy(tempSolution, 0, solution, 0, n);
        return true;
    }
    public void mostrarVectorPropio(){
        double[]vectorPropio = calculateEigenvector(matriz.getValorPropio());
        
        System.out.println(Arrays.toString(vectorPropio));
    }
}
