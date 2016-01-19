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
public class ArbolTest {

    private final ByteArrayOutputStream salida = new ByteArrayOutputStream();

    public ArbolTest() {
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
     * Test del método getHijoIzq, de la clase Arbol.
     */
    @Test
    public void testGetHijoIzq() {
        System.out.println("getHijoIzq");
        Arbol instance = new Arbol();
        Arbol expResult = null;
        Arbol result = instance.getHijoIzq();
        assertEquals(expResult, result);
    }

    /**
     * Test del método getHijoDer, de la clase Arbol.
     */
    @Test
    public void testGetHijoDer() {
        System.out.println("getHijoDer");
        Arbol instance = new Arbol();
        Arbol expResult = null;
        Arbol result = instance.getHijoDer();
        assertEquals(expResult, result);
    }

    /**
     * Test del método getRaiz, de la clase Arbol.
     */
    @Test
    public void testGetRaiz() {
        System.out.println("getRaiz");
        Arbol instance = new Arbol();
        Object expResult = null;
        Object result = instance.getRaiz();
        assertEquals(expResult, result);
    }

    /**
     * Test del método testVacio, de la clase Arbol.
     */
    @Test
    public void testVacio() {
        System.out.println("vacio");
        Arbol instance = new Arbol();
        boolean result = instance.vacio();
        assertTrue(result);
    }

    /**
     * Test del método Insertar, de la clase Arbol. Arbol Vacio
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Integer dato = null;
        Arbol instance = new Arbol();
        boolean result = instance.insertar(dato);
        assertTrue(result);
    }

    /**
     * Test del método Insertar, de la clase Arbol. Arbol lleno con elemento
     * igual
     */
    @Test
    public void testInsertar2() {
        System.out.println("insertar");
        Integer dato = 5;
        Arbol instance = new Arbol();
        instance.insertar(dato);
        boolean result = instance.insertar(dato);
        assertFalse(result);
    }

    /**
     * Test del método Insertar, de la clase Arbol. Arbol lleno con elemento
     * distinto.
     */
    @Test
    public void testInsertar3() {
        System.out.println("insertar");
        Integer dato = 5;
        Arbol instance = new Arbol();
        instance.insertar(3);
        boolean result = instance.insertar(dato);
        assertTrue(result);
    }

    /**
     * Test del método Pertenece, de la clase Arbol. Arbol con raiz 5, se
     * comprueba 5
     */
    @Test
    public void testPertenece() {
        System.out.println("pertenece");
        Integer dato = 5;
        Arbol instance = new Arbol();
        instance.insertar(dato);
        boolean result = instance.pertenece(dato);
        assertTrue(result);
    }

    /**
     * Test del método Pertenece, de la clase Arbol. Arbol con raiz 5, se
     * comprueba 3
     */
    @Test
    public void testPertenece2() {
        System.out.println("pertenece");
        Integer dato = 5;
        Arbol instance = new Arbol();
        instance.insertar(dato);
        boolean result = instance.pertenece(3);
        assertTrue(result);
    }

    /**
     * Test del método Borrar, de la clase Arbol.
     */
    @Test
    public void testBorrar() {
        System.out.println("borrar");
        Integer dato = 3;
        Arbol instance = new Arbol();
        instance.insertar(dato);
        instance.borrar(dato);
        assertEquals(instance.getRaiz(), null);
    }

    /**
     * Test del método InOrden, de la clase Arbol.
     */
    @Test
    public void testInOrden() {
        System.out.println("inOrden");
        System.setOut(new PrintStream(salida));
        Arbol instance = new Arbol();
        for (int i = 0; i < 5; i++) {
            instance.insertar(i);
        }
        instance.inOrden();
        String out = "1\n2\n3\n4\n5\n";
        assertEquals(salida.toString(), out);
        System.setOut(null);
    }

    /**
     * Test del método EsHoja, de la clase Arbol. Arbol con 1
     */
    @Test
    public void testEsHoja() {
        System.out.println("esHoja");
        Integer dato = 1;
        Arbol instance = new Arbol();
        instance.insertar(dato);
        boolean result = instance.esHoja(dato);
        assertTrue(result);
    }

    /**
     * Test del método EsHoja, de la clase Arbol. Arbol con 1,2
     */
    @Test
    public void testEsHoja2() {
        System.out.println("esHoja");
        Integer dato = 1;
        Arbol instance = new Arbol();
        instance.insertar(dato);
        instance.insertar(2);
        boolean result = instance.esHoja(dato);
        assertFalse(result);
    }
}
