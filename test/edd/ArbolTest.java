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
public class ArbolTest {
    
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
     * Test of getHijoIzq method, of class Arbol.
     */
    @Test
    public void testGetHijoIzq() {
        System.out.println("getHijoIzq");
        Arbol instance = new Arbol();
        Arbol expResult = null;
        Arbol result = instance.getHijoIzq();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHijoDer method, of class Arbol.
     */
    @Test
    public void testGetHijoDer() {
        System.out.println("getHijoDer");
        Arbol instance = new Arbol();
        Arbol expResult = null;
        Arbol result = instance.getHijoDer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRaiz method, of class Arbol.
     */
    @Test
    public void testGetRaiz() {
        System.out.println("getRaiz");
        Arbol instance = new Arbol();
        Object expResult = null;
        Object result = instance.getRaiz();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vacio method, of class Arbol.
     */
    @Test
    public void testVacio() {
        System.out.println("vacio");
        Arbol instance = new Arbol();
        boolean expResult = false;
        boolean result = instance.vacio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertar method, of class Arbol.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Object dato = null;
        Arbol instance = new Arbol();
        boolean expResult = false;
        boolean result = instance.insertar(dato);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pertenece method, of class Arbol.
     */
    @Test
    public void testPertenece() {
        System.out.println("pertenece");
        Object dato = null;
        Arbol instance = new Arbol();
        boolean expResult = false;
        boolean result = instance.pertenece(dato);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class Arbol.
     */
    @Test
    public void testBorrar() {
        System.out.println("borrar");
        Object dato = null;
        Arbol instance = new Arbol();
        instance.borrar(dato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inOrden method, of class Arbol.
     */
    @Test
    public void testInOrden() {
        System.out.println("inOrden");
        Arbol instance = new Arbol();
        instance.inOrden();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esHoja method, of class Arbol.
     */
    @Test
    public void testEsHoja() {
        System.out.println("esHoja");
        Object dato = null;
        Arbol instance = new Arbol();
        boolean expResult = false;
        boolean result = instance.esHoja(dato);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
