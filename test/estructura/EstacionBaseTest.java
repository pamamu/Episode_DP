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
import personajes.Jedi;
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
        EstacionPuerta puerta = new EstacionPuerta(24);
        
        //Creacion de una galaxia de prueba para probar el personaje
        Galaxia galaxia = Galaxia.obtenerInstancia(24, puerta, 5, 5);
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
        EstacionBase instance = new EstacionBase(3);
        int expResult = 3;
        int result = instance.getID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPersonajes method, of class EstacionBase.
     */
    @Test
    public void testGetPersonajes() {
        System.out.println("getPersonajes");
        EstacionBase instance = new EstacionBase(4);
        
        Personaje personaje = new Jedi('A', "PRUEBA", 4, 1);
        
        instance.insertarPersonaje(personaje);
        
        Object[] expResult = {(Object)personaje};
        Object[] result = instance.getPersonajes();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of getMidiclorianos method, of class EstacionBase.
     */
    @Test
    public void testGetMidiclorianos() {
        System.out.println("getMidiclorianos");
        EstacionBase instance = new EstacionBase(3);
        
        Midicloriano midi = new Midicloriano(2);
        ArrayList<Midicloriano> midis = new ArrayList();
        
        midis.add(midi);
        instance.insertarMidicloriano(midi);
        
        ArrayList<Midicloriano> expResult = midis;
        ArrayList<Midicloriano> result = instance.getMidiclorianos();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of accion method, of class EstacionBase.
     */
    @Test
    public void testAccion() {
        System.out.println("accion");
        int turno = 0;
        EstacionBase instance = new EstacionBase(5);
        instance.accion(turno);
    }

    /**
     * Test of insertarMidicloriano method, of class EstacionBase.
     */
    @Test
    public void testInsertarMidicloriano() {
        System.out.println("insertarMidiclorianos");
        EstacionBase instance = new EstacionBase(3);
        
        Midicloriano midi = new Midicloriano(6);
        ArrayList<Midicloriano> midis = new ArrayList();
        
        midis.add(midi);
        instance.insertarMidicloriano(midi);
        
        ArrayList<Midicloriano> expResult = midis;
        ArrayList<Midicloriano> result = instance.getMidiclorianos();
        assertEquals(expResult, result);
    }

    /**
     * Test of sacarMidicloriano method, of class EstacionBase.
     */
    @Test
    public void testSacarMidicloriano() {
        System.out.println("sacarMidicloriano");
        
        EstacionBase instance = new EstacionBase(3);
        
        Midicloriano midi = new Midicloriano(7);
        
        Midicloriano expResult = midi;
        
        instance.insertarMidicloriano(midi);
        Midicloriano result = instance.sacarMidicloriano();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of insertarPersonaje method, of class EstacionBase.
     */
    @Test
    public void testInsertarPersonaje() {
        System.out.println("insertarPersonaje");
        EstacionBase instance = new EstacionBase(4);
        
        Personaje personaje = new Jedi('A', "PRUEBA", 4, 1);

        instance.insertarPersonaje(personaje);
    }

    /**
     * Test of sacarPersonaje method, of class EstacionBase.
     */
    @Test
    public void testSacarPersonaje() {
        System.out.println("sacarPersonaje");
        
        EstacionBase instance = new EstacionBase(4);
        
        Personaje personaje = new Jedi('A', "PRUEBA", 4, 1);

        instance.insertarPersonaje(personaje);
        Personaje expResult = personaje;
        Personaje result = instance.sacarPersonaje();
        assertEquals(expResult, result);
    }

    /**
     * Test of esPuerta method, of class EstacionBase.
     */
    @Test
    public void testEsPuerta() {
        System.out.println("esPuerta");
        EstacionBase instance = new EstacionBase(24);
        boolean expResult = false;
        boolean result = instance.esPuerta();
        assertEquals(expResult, result); 
    }

    /**
     * Test of imprimirPersonajesMarca method, of class EstacionBase.
     */
    @Test
    public void testImprimirPersonajesMarca() {
        System.out.println("imprimirPersonajesMarca");
        EstacionBase instance = new EstacionBase(4);
        
        Personaje personaje = new Jedi('A', "PRUEBA", 4, 1);
        
        instance.insertarPersonaje(personaje);
        
        String expResult = "A";
        String result = instance.imprimirPersonajesMarca();
        assertEquals(expResult, result);
    }

    /**
     * Test of midiclorianosToString method, of class EstacionBase.
     */
    @Test
    public void testMidiclorianosToString() {
        System.out.println("midiclorianosToString");
        EstacionBase instance = new EstacionBase(4);
        
        Midicloriano midi = new Midicloriano(6);
        
        instance.insertarMidicloriano(midi);
        
        String expResult = " 6";
        String result = instance.midiclorianosToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toLog method, of class EstacionBase.
     */
    @Test
    public void testToLog() {
        System.out.println("toLog");
        EstacionBase instance = new EstacionBase(8);
        instance.toLog();
    }

    /**
     * Test of toLogPersonajes method, of class EstacionBase.
     */
    @Test
    public void testToLogPersonajes() {
        System.out.println("toLogPersonajes");
        EstacionBase instance = new EstacionBase(9);
        instance.toLogPersonajes();
    }
    
}
