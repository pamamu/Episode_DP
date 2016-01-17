/*
 * The MIT License
 *
 * Copyright 2016 Fernando Gonzalez < fernandogv.inf@gmail.com >.
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

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fernando Gonzalez < fernandogv.inf@gmail.com >
 */
public class GrafoTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of esVacio method, of class Grafo.
     */
    @Test
    public void testEsVacio() {
        System.out.println("esVacio");
        Grafo instance = new Grafo();
        boolean expResult = false;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevoArco method, of class Grafo.
     */
    @Test
    public void testNuevoArco() {
        System.out.println("nuevoArco");
        int origen = 0;
        int destino = 0;
        int valor = 0;
        Grafo instance = new Grafo();
        boolean expResult = false;
        boolean result = instance.nuevoArco(origen, destino, valor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borraArco method, of class Grafo.
     */
    @Test
    public void testBorraArco() {
        System.out.println("borraArco");
        int origen = 0;
        int destino = 0;
        Grafo instance = new Grafo();
        boolean expResult = false;
        boolean result = instance.borraArco(origen, destino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adyacente method, of class Grafo.
     */
    @Test
    public void testAdyacente() {
        System.out.println("adyacente");
        int origen = 0;
        int destino = 0;
        Grafo instance = new Grafo();
        boolean expResult = false;
        boolean result = instance.adyacente(origen, destino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArco method, of class Grafo.
     */
    @Test
    public void testGetArco() {
        System.out.println("getArco");
        int origen = 0;
        int destino = 0;
        Grafo instance = new Grafo();
        int expResult = 0;
        int result = instance.getArco(origen, destino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevoNodo method, of class Grafo.
     */
    @Test
    public void testNuevoNodo() {
        System.out.println("nuevoNodo");
        int n = 0;
        Grafo instance = new Grafo();
        boolean expResult = false;
        boolean result = instance.nuevoNodo(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borraNodo method, of class Grafo.
     */
    @Test
    public void testBorraNodo() {
        System.out.println("borraNodo");
        int nodo = 0;
        Grafo instance = new Grafo();
        boolean expResult = false;
        boolean result = instance.borraNodo(nodo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarNodos method, of class Grafo.
     */
    @Test
    public void testMostrarNodos() {
        System.out.println("mostrarNodos");
        Grafo instance = new Grafo();
        instance.mostrarNodos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarArcos method, of class Grafo.
     */
    @Test
    public void testMostrarArcos() {
        System.out.println("mostrarArcos");
        Grafo instance = new Grafo();
        instance.mostrarArcos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adyacentes method, of class Grafo.
     */
    @Test
    public void testAdyacentes() {
        System.out.println("adyacentes");
        int origen = 0;
        Set<Integer> ady = null;
        Grafo instance = new Grafo();
        instance.adyacentes(origen, ady);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarPW method, of class Grafo.
     */
    @Test
    public void testMostrarPW() {
        System.out.println("mostrarPW");
        Grafo instance = new Grafo();
        instance.mostrarPW();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarFloydC method, of class Grafo.
     */
    @Test
    public void testMostrarFloydC() {
        System.out.println("mostrarFloydC");
        Grafo instance = new Grafo();
        instance.mostrarFloydC();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of warshall method, of class Grafo.
     */
    @Test
    public void testWarshall() {
        System.out.println("warshall");
        Grafo instance = new Grafo();
        instance.warshall();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of floyd method, of class Grafo.
     */
    @Test
    public void testFloyd() {
        System.out.println("floyd");
        Grafo instance = new Grafo();
        instance.floyd();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of siguiente method, of class Grafo.
     */
    @Test
    public void testSiguiente() {
        System.out.println("siguiente");
        int origen = 0;
        int destino = 0;
        Grafo instance = new Grafo();
        int expResult = 0;
        int result = instance.siguiente(origen, destino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Grafo.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Grafo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
