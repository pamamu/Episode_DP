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

import etc.Logger;
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
public class CerraduraTest {
    
    public CerraduraTest() {
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
     * Test of Abierta method, of class Cerradura.
     */
    @Test
    public void testAbierta() {
        System.out.println("Abierta");
        Cerradura instance = new Cerradura(3);
        boolean expResult = true;
        boolean result = instance.Abierta();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstado method, of class Cerradura.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        
        boolean estado = false;
        
        Cerradura instance = new Cerradura(4);
        
        boolean expResult = false;
        instance.setEstado(estado);
        
        assertEquals(expResult, estado);
    }

    /**
     * Test of setCombinacionInicial method, of class Cerradura.
     */
    @Test
    public void testSetCombinacionInicial() {
        System.out.println("setCombinacionInicial");
        
        Cerradura instance = new Cerradura(4);
        
        ArrayList<Midicloriano> combinacion = 
                Galaxia.obtenerInstancia().generarMidiclorianosCerradura();
        
        instance.setCombinacionInicial(combinacion);
        
    }

    /**
     * Test of configurarCerradura method, of class Cerradura.
     */
    @Test
    public void testConfigurarCerradura() {
        System.out.println("configurarCerradura");
        
        Cerradura instance = new Cerradura(2);
        
        ArrayList<Midicloriano> midiclorianos = 
            Galaxia.obtenerInstancia().generarMidiclorianosCerradura();       
        
        instance.configurarCerradura(midiclorianos);
        
    }

    /**
     * Test of generarCombinacion method, of class Cerradura.
     */
    @Test
    public void testGenerarCombinacion() {
        System.out.println("generarCombinacion");
        Cerradura instance = new Cerradura(2);
        
        ArrayList<Midicloriano> midiclorianos = 
            Galaxia.obtenerInstancia().generarMidiclorianosCerradura();       
        
        instance.setCombinacionInicial(midiclorianos);
        
        instance.generarCombinacion();
    }

    /**
     * Test of probarMidicloriano method, of class Cerradura.
     */
    @Test
    public void testProbarMidicloriano() throws Exception {
        System.out.println("probarMidicloriano");
        
        Cerradura instance = new Cerradura(4);
        ArrayList<Midicloriano> combinacion = Galaxia.obtenerInstancia().generarMidiclorianosCerradura();

        instance.setCombinacionInicial(combinacion);
        instance.generarCombinacion();
        instance.setEstado(false);
        
        Midicloriano midicloriano = combinacion.get(0);
        
        boolean expResult = true;
        boolean result = instance.probarMidicloriano(midicloriano);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of reiniciar method, of class Cerradura.
     */
    @Test
    public void testReiniciar() {
        System.out.println("reiniciar");
        Cerradura instance = new Cerradura(2);
        instance.reiniciar();
    }

    /**
     * Test of comprobarEstado method, of class Cerradura.
     */
    @Test
    public void testComprobarEstado() {
        System.out.println("comprobarEstado");
        Cerradura instance = new Cerradura(9);
        instance.comprobarEstado();
    }

    /**
     * Test of toLog method, of class Cerradura.
     */
    @Test
    public void testToLog() {
        System.out.println("toLog");
        Cerradura instance = new Cerradura(5);
        instance.toLog();
    }
    
}
