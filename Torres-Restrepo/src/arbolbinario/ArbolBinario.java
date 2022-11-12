/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Edwin Orlando Restrepo Mosquera y Andres Torres Ciceri
 */
public class ArbolBinario {

    /**
     * Raiz del arbol binario
     */
    public Nodo raiz;

    /**
     * Constructor por defecto
     */
    public ArbolBinario() {
        raiz = null;
    }

    /**
     * Inserta un nodo en el arbol binario
     *
     * @param valor valor a insertar
     */
    public void inicializar() {
        Nodo nodo60 = new Nodo(60);
        //IZQUIERDO
        Nodo nodo41 = new Nodo(41);
        Nodo nodo16 = new Nodo(16);
        Nodo nodo25 = new Nodo(25);
        Nodo nodo53 = new Nodo(53);
        Nodo nodo46 = new Nodo(46);
        Nodo nodo42 = new Nodo(42);
        Nodo nodo55 = new Nodo(55);
        //DERECHO
        Nodo nodo74 = new Nodo(74);
        Nodo nodo65 = new Nodo(65);
        Nodo nodo63 = new Nodo(63);
        Nodo nodo62 = new Nodo(62);
        Nodo nodo64 = new Nodo(64);
        Nodo nodo70 = new Nodo(70);

        raiz = nodo60;
        raiz.setIzquierdo(nodo41);
        nodo41.setIzquierdo(nodo16);
        nodo16.setDerecho(nodo25);

        nodo41.setDerecho(nodo53);
        nodo53.setIzquierdo(nodo46);
        nodo46.setIzquierdo(nodo42);
        nodo53.setDerecho(nodo55);

        raiz.setDerecho(nodo74);
        nodo74.setIzquierdo(nodo65);
        nodo65.setIzquierdo(nodo63);
        nodo63.setIzquierdo(nodo62);
        nodo63.setDerecho(nodo64);
        nodo65.setDerecho(nodo70);

    }

    public void visitar(Nodo aux) {
        System.out.print(aux.getValor() + " ");
    }

    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Invoca al método recursivo
     */
    public void preorden() {
        preorden(raiz);
    }

    /**
     * Método recursivo de recorrido en pre-orden
     *
     * @param aux referencia a un nodo
     */
    private void preorden(Nodo aux) {
        if (aux != null) {
            visitar(aux);
            preorden(aux.getIzquierdo());
            preorden(aux.getDerecho());
        }
    }

    public float numeroNodos(ArbolBinario arbin) {
        Stack<Nodo> pila = new Stack<>();
        Queue<Nodo> cola = new ArrayDeque<>();
        float totalNodos = 0;

        pila.push(arbin.raiz);
        Nodo aux = pila.pop();
        cola.add(aux);

        while (!cola.isEmpty()) {
            totalNodos++;
            aux = cola.poll();
            if (aux.getIzquierdo() != null) {
                cola.add(aux.getIzquierdo());
            }
            if (aux.getDerecho() != null) {
                cola.add(aux.getDerecho());
            }
        }
        return totalNodos;
    }

    public void recorridoCamino(ArbolBinario arbin, int valor) {

        int numNodos = 0;
        int mulRamas = 1;
        int totalRama = 1;
        int nivel = 1;
        boolean encontrado = false;
        boolean encontrar = true;

        int nivelIzquierdo = 0;
        int nivelDerecho = 0;
        Stack<Nodo> pila = new Stack<>();
        Queue<Nodo> cola = new ArrayDeque<>();
        pila.push(arbin.raiz);
        Nodo aux = pila.pop();
        cola.add(aux);

        if ((arbin.raiz.getValor()).equals(valor)) {
            System.out.println("\n\nEl nodo con valor " + valor + " esta en el nivel " + nivel);
        }

        while (!cola.isEmpty()) {

            aux = cola.poll();

            numNodos++;

            if (aux.getIzquierdo() != null) {
                cola.add(aux.getIzquierdo());

                if (aux.getIzquierdo().getValor().equals(valor)) {
                    numNodos = numNodos + nivelIzquierdo;

                    do {
                        if (numNodos <= totalRama) {
                            System.out.println("\n\nEl nodo con valor " + valor + " esta en el nivel " + (nivel + 1));
                            encontrado = true;
                            encontrar = true;
                        } else {
                            nivel++;
                        }
                        totalRama = totalRama + (mulRamas * 2);
                        mulRamas = mulRamas * 2;
                    } while (encontrado == false);

                } else {
                    encontrar = false;
                }
            } else {
                nivelIzquierdo++;
            }

            if (aux.getDerecho() != null) {
                cola.add(aux.getDerecho());

                if (aux.getDerecho().getValor().equals(valor)) {
                    numNodos = numNodos + nivelDerecho;

                    do {
                        if (numNodos <= totalRama) {
                            System.out.println("\n\nEl nodo con valor " + valor + " esta en el nivel " + (nivel + 1));
                            encontrado = true;
                            encontrar = true;
                        } else {
                            nivel++;
                        }
                        totalRama = totalRama + (mulRamas * 2);
                        mulRamas = mulRamas * 2;
                    } while (encontrado == false);

                } else {
                    encontrar = false;
                }
            } else {
                nivelDerecho++;
            }
        }
        if (encontrado == false) {

            System.out.println("\n\nNo se encontro el nodo");
        }

    }

    public float caminoInterno(ArbolBinario arbin) {
        Queue<Nodo> cola = new ArrayDeque<>();
        cola.add(arbin.raiz);
        int nivel = 1;
        float longitudCamino = 0;

        while (!cola.isEmpty()) {
            longitudCamino = longitudCamino + (nivel * cola.size());
            nivel++;
            int total = cola.size();
            for (int i = 0; i < total; i++) {

                if (cola.peek().getIzquierdo() != null) {
                    cola.offer(cola.peek().getIzquierdo());
                }

                if (cola.peek().getDerecho() != null) {
                    cola.offer(cola.peek().getDerecho());
                }
                cola.poll();

            }
        }
        return longitudCamino;
    }
}
