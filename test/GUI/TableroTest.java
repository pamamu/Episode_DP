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
package GUI;

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
public class TableroTest {
    
    public TableroTest() {
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
     * Test of tirarPared method, of class Tablero.
     */
    @Test
    public void testTirarPared() {
        System.out.println("tirarPared");
        Integer salaX = null;
        Integer salaY = null;
        Tablero instance = null;
        instance.tirarPared(salaX, salaY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarPersonajeEstacion method, of class Tablero.
     */
    @Test
    public void testInsertarPersonajeEstacion() {
        System.out.println("insertarPersonajeEstacion");
        char marca = ' ';
        int sala = 0;
        Tablero instance = null;
        instance.insertarPersonajeEstacion(marca, sala);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarNumPersonajesEstacion method, of class Tablero.
     */
    @Test
    public void testInsertarNumPersonajesEstacion() {
        System.out.println("insertarNumPersonajesEstacion");
        int numPers = 0;
        int sala = 0;
        Tablero instance = null;
        instance.insertarNumPersonajesEstacion(numPers, sala);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pintarParedes method, of class Tablero.
     */
    @Test
    public void testPintarParedes() {
        System.out.println("pintarParedes");
        Tablero instance = null;
        instance.pintarParedes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
