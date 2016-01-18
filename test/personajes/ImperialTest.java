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
package personajes;

import estructura.Midicloriano;
import java.util.ArrayList;
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
public class ImperialTest {
    
    public ImperialTest() {
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
     * Test of accionPuerta method, of class Imperial.
     */
    @Test
    public void testAccionPuerta() {
        System.out.println("accionPuerta");
        Imperial instance = null;
        instance.accionPuerta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accionEstacion method, of class Imperial.
     */
    @Test
    public void testAccionEstacion() {
        System.out.println("accionEstacion");
        Imperial instance = null;
        instance.accionEstacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esImperial method, of class Imperial.
     */
    @Test
    public void testEsImperial() {
        System.out.println("esImperial");
        Imperial instance = null;
        boolean expResult = false;
        boolean result = instance.esImperial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarCamino method, of class Imperial.
     */
    @Test
    public void testGenerarCamino() {
        System.out.println("generarCamino");
        Imperial instance = null;
        instance.generarCamino();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMidiclorianos method, of class Imperial.
     */
    @Test
    public void testSetMidiclorianos() {
        System.out.println("setMidiclorianos");
        ArrayList<Midicloriano> midiclorianos = null;
        Imperial instance = null;
        instance.setMidiclorianos(midiclorianos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Imperial.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Imperial instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
