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

import estructura.EstacionBase;
import estructura.Midicloriano;
import etc.Camino;
import java.util.ArrayList;
import java.util.LinkedList;
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
public class PersonajeTest {
    
    public PersonajeTest() {
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
     * Test of getTurno method, of class Personaje.
     */
    @Test
    public void testGetTurno() {
        System.out.println("getTurno");
        Personaje instance = null;
        int expResult = 0;
        int result = instance.getTurno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Personaje.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Personaje instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstacionPosicion method, of class Personaje.
     */
    @Test
    public void testGetEstacionPosicion() {
        System.out.println("getEstacionPosicion");
        Personaje instance = null;
        EstacionBase expResult = null;
        EstacionBase result = instance.getEstacionPosicion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarcaClase method, of class Personaje.
     */
    @Test
    public void testGetMarcaClase() {
        System.out.println("getMarcaClase");
        Personaje instance = null;
        char expResult = ' ';
        char result = instance.getMarcaClase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isGanador method, of class Personaje.
     */
    @Test
    public void testIsGanador() {
        System.out.println("isGanador");
        Personaje instance = null;
        boolean expResult = false;
        boolean result = instance.isGanador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRuta method, of class Personaje.
     */
    @Test
    public void testGetRuta() {
        System.out.println("getRuta");
        Personaje instance = null;
        LinkedList<Camino> expResult = null;
        LinkedList<Camino> result = instance.getRuta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRuta method, of class Personaje.
     */
    @Test
    public void testSetRuta_LinkedList() {
        System.out.println("setRuta");
        LinkedList<Camino> ruta = null;
        Personaje instance = null;
        instance.setRuta(ruta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRuta method, of class Personaje.
     */
    @Test
    public void testSetRuta_ArrayList() {
        System.out.println("setRuta");
        ArrayList<Integer> camino = null;
        Personaje instance = null;
        instance.setRuta(camino);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recogerMidicloriano method, of class Personaje.
     */
    @Test
    public void testRecogerMidicloriano() {
        System.out.println("recogerMidicloriano");
        Midicloriano midicloriano = null;
        Personaje instance = null;
        instance.recogerMidicloriano(midicloriano);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mover method, of class Personaje.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        Personaje instance = null;
        instance.mover();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accion method, of class Personaje.
     */
    @Test
    public void testAccion() {
        System.out.println("accion");
        Personaje instance = null;
        instance.accion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esImperial method, of class Personaje.
     */
    @Test
    public void testEsImperial() {
        System.out.println("esImperial");
        Personaje instance = null;
        boolean expResult = false;
        boolean result = instance.esImperial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fin method, of class Personaje.
     */
    @Test
    public void testFin() {
        System.out.println("fin");
        Personaje instance = null;
        instance.fin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accionPuerta method, of class Personaje.
     */
    @Test
    public void testAccionPuerta() {
        System.out.println("accionPuerta");
        Personaje instance = null;
        instance.accionPuerta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accionEstacion method, of class Personaje.
     */
    @Test
    public void testAccionEstacion() {
        System.out.println("accionEstacion");
        Personaje instance = null;
        instance.accionEstacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarCamino method, of class Personaje.
     */
    @Test
    public void testGenerarCamino() {
        System.out.println("generarCamino");
        Personaje instance = null;
        instance.generarCamino();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Personaje.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Personaje instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Personaje.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Personaje o = null;
        Personaje instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Personaje.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Personaje instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rutaToString method, of class Personaje.
     */
    @Test
    public void testRutaToString() {
        System.out.println("rutaToString");
        Personaje instance = null;
        String expResult = "";
        String result = instance.rutaToString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of midicloriansToString method, of class Personaje.
     */
    @Test
    public void testMidicloriansToString() {
        System.out.println("midicloriansToString");
        Personaje instance = null;
        String expResult = "";
        String result = instance.midicloriansToString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLogini method, of class Personaje.
     */
    @Test
    public void testToLogini() {
        System.out.println("toLogini");
        Personaje instance = null;
        instance.toLogini();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLog method, of class Personaje.
     */
    @Test
    public void testToLog() {
        System.out.println("toLog");
        Personaje instance = null;
        instance.toLog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PersonajeImpl extends Personaje {

        public PersonajeImpl() {
            super(' ', "", 0, 0);
        }

        public void accionPuerta() {
        }

        public void accionEstacion() {
        }

        public void generarCamino() {
        }

        public String getTipo() {
            return "";
        }
    }
    
}
