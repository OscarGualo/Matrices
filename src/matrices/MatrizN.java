
package matrices;

/**
 *@Grupo 3
 * @author oscar,ariel,anderson,luis,christopher
 */
import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class MatrizN {

    private int valorPropio;
    private int[][] vectorPropio;
    private int[][] matrizGenerica;
    private int dimension;
    private boolean aux;
    Scanner s1 = new Scanner(System.in);

    public MatrizN(int dimension) {
        matrizGenerica = new int[dimension][dimension];
        vectorPropio = new int[dimension][1];
        this.dimension = dimension;
    }

    public MatrizN(int dimension, int valorPropio) {
        matrizGenerica = new int[dimension][dimension];
    }

    public void llenarMatriz() {
        for (int i = 0; i < matrizGenerica.length; i++) {
            for (int j = 0; j < matrizGenerica[i].length; j++) {
                do {
                    System.out.println("Ingrese el valor (En números enteros) para la pos de la matriz: " + i + " " + j);
                    System.out.print(">> '");
                    try {
                        matrizGenerica[i][j] = Integer.parseInt(s1.nextLine());
                        aux = true;
                    } catch (NumberFormatException e) {
                        System.out.print("\nOpción Inválida. Inténtelo de nuevo...\n\n");
                        aux = false;
                    }
                } while (!aux);
            }
        }
    }

    public void llenarVectorPropio() {
        for (int i = 0; i < vectorPropio.length; i++) {
            for (int j = 0; j < vectorPropio[i].length; j++) {
                do {
                    System.out.println("Ingrese el valor (En números enteros) para la pos del vector: " + i + " " + j);
                    System.out.print(">> '");
                    try {
                        vectorPropio[i][j] = Integer.parseInt(s1.nextLine());
                        aux = true;
                    } catch (NumberFormatException e) {
                        System.out.print("\nOpción Inválida. Inténtelo de nuevo...\n\n");
                        aux = false;
                    }
                } while (!aux);
            }
        }
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
    /**
     * Este metodo va a mostrar la ecuacion usada para encontrar los valores
     * propios
     */
    public void mostrarEcuacionGeneral() {

        System.out.println("Ecuacion General");
        System.out.println("A*v = λ*v");
        System.out.println("A -> Matriz n*n");
        System.out.println("v -> Vector propio de la matriz");
        System.out.println("λ -> Valor propio de la matriz");
    }

    /**
     * Este metodo va a multiplicar la matriz NxN del usuario por su vector
     * propio
     *
     * @return retorna una matriz nx1
     */
    public int[][] multiplicarMatrices() {
        int[][] matrizMultiplicada = new int[dimension][1];
        int auxiliarSuma = 0;
        for (int i = 0; i < matrizMultiplicada.length; i++) {
            for (int j = 0; j < matrizMultiplicada.length; j++) {
                auxiliarSuma += getMatrizGenerica()[i][j] * getVectorPropio()[j][0];

            }
            matrizMultiplicada[i][0] = auxiliarSuma;
            auxiliarSuma = 0;
        }

        return matrizMultiplicada;
    }

}
