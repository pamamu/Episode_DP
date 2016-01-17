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

import edd.Grafo;
import java.util.ArrayList;
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
public class GalaxiaTest {
    
    public GalaxiaTest() {
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
     * Test of obtenerInstancia method, of class Galaxia.
     */
    @Test
    public void testObtenerInstancia_4args() {
        System.out.println("obtenerInstancia");
        int idEstacionPuerta = 0;
        EstacionPuerta starsgate = null;
        int dimX = 0;
        int dimY = 0;
        Galaxia expResult = null;
        Galaxia result = Galaxia.obtenerInstancia(idEstacionPuerta, starsgate, dimX, dimY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerInstancia method, of class Galaxia.
     */
    @Test
    public void testObtenerInstancia_0args() {
        System.out.println("obtenerInstancia");
        Galaxia expResult = null;
        Galaxia result = Galaxia.obtenerInstancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDimX method, of class Galaxia.
     */
    @Test
    public void testGetDimX() {
        System.out.println("getDimX");
        Galaxia instance = null;
        int expResult = 0;
        int result = instance.getDimX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDimY method, of class Galaxia.
     */
    @Test
    public void testGetDimY() {
        System.out.println("getDimY");
        Galaxia instance = null;
        int expResult = 0;
        int result = instance.getDimY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrafo method, of class Galaxia.
     */
    @Test
    public void testGetGrafo() {
        System.out.println("getGrafo");
        Galaxia instance = null;
        Grafo expResult = null;
        Grafo result = instance.getGrafo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdEstacionPuerta method, of class Galaxia.
     */
    @Test
    public void testGetIdEstacionPuerta() {
        System.out.println("getIdEstacionPuerta");
        Galaxia instance = null;
        int expResult = 0;
        int result = instance.getIdEstacionPuerta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstacionLiberty method, of class Galaxia.
     */
    @Test
    public void testGetEstacionLiberty() {
        System.out.println("getEstacionLiberty");
        Galaxia instance = null;
        EstacionBase expResult = null;
        EstacionBase result = instance.getEstacionLiberty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStarsgate method, of class Galaxia.
     */
    @Test
    public void testGetStarsgate() {
        System.out.println("getStarsgate");
        Galaxia instance = null;
        EstacionPuerta expResult = null;
        EstacionPuerta result = instance.getStarsgate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPasosPorEstaciones method, of class Galaxia.
     */
    @Test
    public void testSetPasosPorEstaciones() {
        System.out.println("setPasosPorEstaciones");
        ArrayList<Integer> pasosPorEstaciones = null;
        Galaxia instance = null;
        instance.setPasosPorEstaciones(pasosPorEstaciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonajes method, of class Galaxia.
     */
    @Test
    public void testSetPersonajes() {
        System.out.println("setPersonajes");
        ArrayList<Object> personajes = null;
        Galaxia instance = null;
        instance.setPersonajes(personajes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of construirGalaxia method, of class Galaxia.
     */
    @Test
    public void testConstruirGalaxia() {
        System.out.println("construirGalaxia");
        Galaxia instance = null;
        instance.construirGalaxia();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarLaberinto method, of class Galaxia.
     */
    @Test
    public void testGenerarLaberinto() {
        System.out.println("generarLaberinto");
        Galaxia instance = null;
        instance.generarLaberinto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarMidiclorianosCerradura method, of class Galaxia.
     */
    @Test
    public void testGenerarMidiclorianosCerradura() {
        System.out.println("generarMidiclorianosCerradura");
        Galaxia instance = null;
        ArrayList<Midicloriano> expResult = null;
        ArrayList<Midicloriano> result = instance.generarMidiclorianosCerradura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarMidiclorianosGalaxia method, of class Galaxia.
     */
    @Test
    public void testGenerarMidiclorianosGalaxia() {
        System.out.println("generarMidiclorianosGalaxia");
        Galaxia instance = null;
        ArrayList<Midicloriano> expResult = null;
        ArrayList<Midicloriano> result = instance.generarMidiclorianosGalaxia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of repartirMidiclorianos method, of class Galaxia.
     */
    @Test
    public void testRepartirMidiclorianos() {
        System.out.println("repartirMidiclorianos");
        ArrayList<Midicloriano> midiclorianos = null;
        Galaxia instance = null;
        instance.repartirMidiclorianos(midiclorianos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accion method, of class Galaxia.
     */
    @Test
    public void testAccion() {
        System.out.println("accion");
        int turno = 0;
        Galaxia instance = null;
        instance.accion(turno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IDtoCoordenadas method, of class Galaxia.
     */
    @Test
    public void testIDtoCoordenadas() {
        System.out.println("IDtoCoordenadas");
        int ID = 0;
        Galaxia instance = null;
        int[] expResult = null;
        int[] result = instance.IDtoCoordenadas(ID);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of coordenadastoID method, of class Galaxia.
     */
    @Test
    public void testCoordenadastoID() {
        System.out.println("coordenadastoID");
        int fila = 0;
        int columna = 0;
        Galaxia instance = null;
        int expResult = 0;
        int result = instance.coordenadastoID(fila, columna);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstacion method, of class Galaxia.
     */
    @Test
    public void testGetEstacion_int() {
        System.out.println("getEstacion");
        int ID = 0;
        Galaxia instance = null;
        EstacionBase expResult = null;
        EstacionBase result = instance.getEstacion(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstacion method, of class Galaxia.
     */
    @Test
    public void testGetEstacion_int_int() {
        System.out.println("getEstacion");
        int fila = 0;
        int columna = 0;
        Galaxia instance = null;
        EstacionBase expResult = null;
        EstacionBase result = instance.getEstacion(fila, columna);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimirGalaxia method, of class Galaxia.
     */
    @Test
    public void testImprimirGalaxia() {
        System.out.println("imprimirGalaxia");
        Galaxia instance = null;
        String expResult = "";
        String result = instance.imprimirGalaxia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLog method, of class Galaxia.
     */
    @Test
    public void testToLog() {
        System.out.println("toLog");
        int turno = 0;
        Galaxia instance = null;
        instance.toLog(turno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
