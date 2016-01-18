/*
 * The MIT License
 *
 * Copyright 2016 Pablo_Macias.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package edd;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pablo_Macias
 */
public class GrafoTest {

    private Grafo instancia;

    private final ByteArrayOutputStream salida = new ByteArrayOutputStream();

    public GrafoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instancia = new Grafo();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test del método esVacio, de la clase Grafo. Grafo vacio
     */
    @Test
    public void testEsVacio() {
        System.out.println("esVacio");
        boolean expResult = true;
        boolean result = instancia.esVacio();
        assertEquals(expResult, result);
    }

    /**
     * Test del método esVacio, de la clase Grafo. Grafo lleno
     */
    @Test
    public void testEsVacio2() {
        System.out.println("esVacio2");
        instancia.nuevoNodo(1);
        boolean expResult = false;
        boolean result = instancia.esVacio();
        assertEquals(expResult, result);
    }

    /**
     * Test del método nuevoArco, de la clase Grafo. Grafo vacio
     */
    @Test
    public void testNuevoArco() {
        System.out.println("nuevoArco");
        int origen = 0;
        int destino = 0;
        int valor = 0;
        boolean expResult = false;
        boolean result = instancia.nuevoArco(origen, destino, valor);
        assertEquals(expResult, result);
    }

    /**
     * Test del método nuevoArco, de la clase Grafo. Grafo con nodos 1, 2 y 3
     */
    @Test
    public void testNuevoArco2() {
        System.out.println("nuevoArco2");
        int origen = 1;
        int destino = 2;
        int valor = 1;
        instancia.nuevoNodo(1);
        instancia.nuevoNodo(2);
        instancia.nuevoNodo(3);
        boolean expResult = true;
        boolean result = instancia.nuevoArco(origen, destino, valor);
        assertEquals(expResult, result);
    }

    /**
     * Test del método borraArco, de la clase Grafo. Grafo vacio
     */
    @Test
    public void testBorraArco() {
        System.out.println("borraArco");
        int origen = 0;
        int destino = 0;
        boolean expResult = false;
        boolean result = instancia.borraArco(origen, destino);
        assertEquals(expResult, result);
    }

    /**
     * Test del método borraArco, de la clase Grafo. Grafo con nodos 1,2,3 y
     * arco entre 1 y 2
     */
    @Test
    public void testBorraArco2() {
        System.out.println("borraArco2");
        int origen = 0;
        int destino = 0;
        instancia.nuevoNodo(origen);
        instancia.nuevoNodo(destino);
        instancia.nuevoNodo(3);
        instancia.nuevoArco(origen, destino, 1);
        boolean expResult = true;
        boolean result = instancia.borraArco(origen, destino);
        assertEquals(expResult, result);
    }

    /**
     * Test del método adyacente, de la clase Grafo. Grafo vacio
     */
    @Test
    public void testAdyacente() {
        System.out.println("adyacente");
        int origen = 0;
        int destino = 0;
        boolean expResult = false;
        boolean result = instancia.adyacente(origen, destino);
        assertEquals(expResult, result);
    }

    /**
     * Test del método adyacente, de la clase Grafo. Grafo con nodos 1,2 y arco
     * de 1 a 2
     */
    @Test
    public void testAdyacente2() {
        System.out.println("adyacente2");
        int origen = 0;
        int destino = 0;
        instancia.nuevoNodo(origen);
        instancia.nuevoNodo(destino);
        instancia.nuevoArco(origen, destino, 1);
        boolean expResult = true;
        boolean result = instancia.adyacente(origen, destino);
        assertEquals(expResult, result);
    }

    /**
     * Test del método getArco, de la clase Grafo.
     */
    @Test
    public void testGetArco() {
        System.out.println("getArco");
        int origen = 0;
        int destino = 0;
        int expResult = -1;
        int result = instancia.getArco(origen, destino);
        assertEquals(expResult, result);
    }

    /**
     * Test del método getArco, de la clase Grafo.
     */
    @Test
    public void testGetArco2() {
        System.out.println("getArco2");
        int origen = 0;
        int destino = 0;
        int expResult = 3;
        instancia.nuevoNodo(origen);
        instancia.nuevoNodo(destino);
        instancia.nuevoArco(origen, destino, expResult);
        int result = instancia.getArco(origen, destino);
        assertEquals(expResult, result);
    }

    /**
     * Test del método nuevoNodo, de la clase Grafo. Grafo vacio
     */
    @Test
    public void testNuevoNodo() {
        System.out.println("nuevoNodo");
        int n = 0;
        boolean expResult = true;
        boolean result = instancia.nuevoNodo(n);
        assertEquals(expResult, result);
    }

    /**
     * Test del método nuevoNodo, de la clase Grafo. Grafo vacio
     */
    @Test
    public void testNuevoNodo2() {
        System.out.println("nuevoNodo2");
        int n = 0;
        for (int i = 0; i < 115; i++) {
            instancia.nuevoNodo(i);
        }
        boolean expResult = false;
        boolean result = instancia.nuevoNodo(n);
        assertEquals(expResult, result);
    }

    /**
     * Test del método borraNodo, de la clase Grafo. Grafo vacio
     */
    @Test
    public void testBorraNodo() {
        System.out.println("borraNodo");
        int nodo = 12;
        boolean expResult = false;
        boolean result = instancia.borraNodo(nodo);
        assertEquals(expResult, result);
    }

    /**
     * Test del método borraNodo, de la clase Grafo. Grafo vacio
     */
    @Test
    public void testBorraNodo2() {
        System.out.println("borraNodo2");
        int nodo = 12;
        instancia.nuevoNodo(nodo);
        boolean expResult = true;
        boolean result = instancia.borraNodo(nodo);
        assertEquals(expResult, result);
    }

    /**
     * Test del método mostrarNodos, de la clase Grafo. Nodos del 0 al 4
     */
    @Test
    public void testMostrarNodos() {
        System.out.println("mostrarNodos");
        for (int i = 0; i < 5; i++) {
            instancia.nuevoNodo(i);
        }
        System.setOut(new PrintStream(salida));
        instancia.mostrarNodos();
        String out = "NODOS:\n" + "0 1 2 3 4 ";
        assertEquals(salida.toString(), out);
        System.setOut(null);
    }

    /**
     * Test del método mostrarArcos, de la clase Grafo. Nodos del 1 al 3. Arcos
     * 1-2 0-1, 2-3, 3-1
     */
    @Test
    public void testMostrarArcos() {
        System.out.println("mostrarArcos");
        for (int i = 0; i < 4; i++) {
            instancia.nuevoNodo(i);
        }
        instancia.nuevoArco(1, 2, 1);
        instancia.nuevoArco(0, 1, 1);
        instancia.nuevoArco(2, 3, 1);
        instancia.nuevoArco(3, 1, 1);
        System.setOut(new PrintStream(salida));
        instancia.mostrarArcos();
        String out = "ARCOS:\n"
                + "   0   #   #\n"
                + "   #   0   1\n"
                + "   #   #   0";
        assertEquals(salida.toString(), out);
        System.setOut(null);
    }

    /**
     * Test del método adyacentes, de la clase Grafo.
     */
    @Test
    public void testAdyacentes() {
        System.out.println("adyacentes");
        int origen = 0;
        Set<Integer> ady = new HashSet<>();
        instancia.adyacentes(origen, ady);
        assertTrue(ady.isEmpty());
    }

    /**
     * Test del método adyacentes, de la clase Grafo.
     */
    @Test
    public void testAdyacentes2() {
        System.out.println("adyacentes2");
        int origen = 0;
        instancia.nuevoNodo(origen);
        instancia.nuevoNodo(1);
        instancia.nuevoNodo(2);
        instancia.nuevoArco(origen, 1, 1);
        instancia.nuevoArco(origen, 2, 1);
        Set<Integer> ady = new HashSet<>();
        instancia.adyacentes(origen, ady);
        Object[] adyacentes = ady.toArray();
        assertTrue((int) adyacentes[0] == 1 && (int) adyacentes[2] == 2);
    }

    /**
     * Test del método mostrarPW, de la clase Grafo.
     */
    @Test
    public void testMostrarPW() {
        System.out.println("mostrarPW");
        int origen = 0;
        instancia.nuevoNodo(origen);
        instancia.nuevoNodo(1);
        instancia.nuevoNodo(2);
        instancia.nuevoArco(origen, 1, 1);
        instancia.nuevoArco(origen, 2, 1);
        instancia.warshall();
        System.setOut(new PrintStream(salida));
        instancia.mostrarPW();
        String out = "warshallC:\n"
                + "  true  true  true\n"
                + " false  true false\n"
                + " false false  true";
        assertEquals(salida.toString(), out);
        System.setOut(null);
    }

    /**
     * Test del método mostrarFloydC, de la clase Grafo.
     */
    @Test
    public void testMostrarFloydC() {
        System.out.println("mostrarFloydC");
        int origen = 0;
        instancia.nuevoNodo(origen);
        instancia.nuevoNodo(1);
        instancia.nuevoNodo(2);
        instancia.nuevoArco(origen, 1, 1);
        instancia.nuevoArco(origen, 2, 1);
        instancia.floyd();
        System.setOut(new PrintStream(salida));
        instancia.mostrarFloydC();
        String out = "floydC:\n"
                + "   099999999\n"
                + "   1   09999\n"
                + "   19999   0\n"
                + "floydP:\n"
                + "  -1  -1  -1\n"
                + "  -1  -1  -1\n"
                + "  -1  -1  -1";
        assertEquals(salida.toString(), out);
        System.setOut(null);
    }

    /**
     * Test del método warshall, de la clase Grafo.
     */
    @Test
    public void testWarshall() {
        System.out.println("mostrarPW");
        int origen = 0;
        instancia.nuevoNodo(origen);
        instancia.nuevoNodo(1);
        instancia.nuevoNodo(2);
        instancia.nuevoArco(origen, 1, 1);
        instancia.nuevoArco(origen, 2, 1);
        instancia.nuevoArco(origen, 1, 2);
        System.setOut(new PrintStream(salida));
        instancia.mostrarPW();
        String out = "warshallC:\n"
                + "  true  true  true\n"
                + " false  true false\n"
                + " false false  true";
        assertEquals(salida.toString(), out);
        System.setOut(null);
    }

    /**
     * Test del método floyd, de la clase Grafo.
     */
    @Test
    public void testFloyd() {
        System.out.println("floyd");
        int origen = 0;
        instancia.nuevoNodo(origen);
        instancia.nuevoNodo(1);
        instancia.nuevoNodo(2);
        instancia.nuevoArco(origen, 1, 1);
        instancia.nuevoArco(origen, 2, 1);
        instancia.nuevoArco(1, origen, 1);
        instancia.nuevoArco(1, 2, 1);
        instancia.floyd();
        System.setOut(new PrintStream(salida));
        instancia.mostrarFloydC();
        String out = "floydC:\n"
                + "   0   19999\n"
                + "   1   09999\n"
                + "   1   1   0\n"
                + "floydP:\n"
                + "  -1  -1  -1\n"
                + "  -1  -1  -1\n"
                + "  -1  -1  -1";
        assertEquals(salida.toString(), out);
        System.setOut(null);
    }

    /**
     * Test del método siguiente, de la clase Grafo.
     */
    @Test
    public void testSiguiente() {
        System.out.println("siguiente");
        int origen = 0;
        int destino = 0;
        int expResult = -1;
        int result = instancia.siguiente(origen, destino);
        assertEquals(expResult, result);
    }
    
}
