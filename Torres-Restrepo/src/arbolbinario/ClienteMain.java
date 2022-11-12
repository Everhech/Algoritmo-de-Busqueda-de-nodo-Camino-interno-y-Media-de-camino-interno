/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Edwin Orlando Restrepo Mosquera y Andres Torres Ciceri
 */
public class ClienteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        ArbolBinario ab = new ArbolBinario();
        ab.inicializar();

        do {
            System.out.println("\nOpciones:"
                    + "\n1.Buscar nodo y nivel"
                    + "\n2.Calcular la longitud del camino interno"
                    + "\n3.Calcular la longitud del camino media"
                    + "\n4.Salir"
                    + "\nOpcion:");
            int option = leer.nextInt();
            switch (option) {
                case 1:
                    System.out.println("\n\nDigite el valor del nodo a buscar:");
                    int valor = leer.nextInt();
                    ab.recorridoCamino(ab, valor);
                    break;
                case 2:
                    System.out.println("\n\nLa longitud del camino interno es: " + ab.caminoInterno(ab));
                    break;
                case 3:
                    double respuesta = ab.caminoInterno(ab) / ab.numeroNodos(ab);
                    System.out.println("\n\nLa media de la longitud del camino interno es: " + respuesta);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    break;
            }
        } while (salir == false);

    }
}