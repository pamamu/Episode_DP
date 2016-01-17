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
package estructura;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import personajes.Personaje;

/**
 *
 * @author Fernando Gonzalez < fernandogv.inf@gmail.com >
 */
public class EstacionBaseTest {
    
    public EstacionBaseTest() {
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
     * Test of getID method, of class EstacionBase.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        EstacionBase instance = null;
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMidiclorianos method, of class EstacionBase.
     */
    @Test
    public void testGetMidiclorianos() {
        System.out.println("getMidiclorianos");
        EstacionBase instance = null;
        ArrayList<Midicloriano> expResult = null;
        ArrayList<Midicloriano> result = instance.getMidiclorianos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accion method, of class EstacionBase.
     */
    @Test
    public void testAccion() {
        System.out.println("accion");
        int turno = 0;
        EstacionBase instance = null;
        instance.accion(turno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarMidicloriano method, of class EstacionBase.
     */
    @Test
    public void testInsertarMidicloriano() {
        System.out.println("insertarMidicloriano");
        Midicloriano midicloriano = null;
        EstacionBase instance = null;
        instance.insertarMidicloriano(midicloriano);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sacarMidicloriano method, of class EstacionBase.
     */
    @Test
    public void testSacarMidicloriano() {
        System.out.println("sacarMidicloriano");
        EstacionBase instance = null;
        Midicloriano expResult = null;
        Midicloriano result = instance.sacarMidicloriano();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarPersonaje method, of class EstacionBase.
     */
    @Test
    public void testInsertarPersonaje() {
        System.out.println("insertarPersonaje");
        Personaje personaje = null;
        EstacionBase instance = null;
        instance.insertarPersonaje(personaje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sacarPersonaje method, of class EstacionBase.
     */
    @Test
    public void testSacarPersonaje() {
        System.out.println("sacarPersonaje");
        EstacionBase instance = null;
        Personaje expResult = null;
        Personaje result = instance.sacarPersonaje();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esPuerta method, of class EstacionBase.
     */
    @Test
    public void testEsPuerta() {
        System.out.println("esPuerta");
        EstacionBase instance = null;
        boolean expResult = false;
        boolean result = instance.esPuerta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimirPersonajesMarca method, of class EstacionBase.
     */
    @Test
    public void testImprimirPersonajesMarca() {
        System.out.println("imprimirPersonajesMarca");
        EstacionBase instance = null;
        String expResult = "";
        String result = instance.imprimirPersonajesMarca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of midiclorianosToString method, of class EstacionBase.
     */
    @Test
    public void testMidiclorianosToString() {
        System.out.println("midiclorianosToString");
        EstacionBase instance = null;
        String expResult = "";
        String result = instance.midiclorianosToString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLog method, of class EstacionBase.
     */
    @Test
    public void testToLog() {
        System.out.println("toLog");
        EstacionBase instance = null;
        instance.toLog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLogPersonajes method, of class EstacionBase.
     */
    @Test
    public void testToLogPersonajes() {
        System.out.println("toLogPersonajes");
        EstacionBase instance = null;
        instance.toLogPersonajes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
