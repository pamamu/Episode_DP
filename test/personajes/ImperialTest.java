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
package personajes;

import estructura.Cerradura;
import estructura.EstacionPuerta;
import estructura.Galaxia;
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
 * @author Fernando Gonzalez < fernandogv.inf@gmail.com >
 */
public class ImperialTest {
    
    private static Imperial instance;
    
    public ImperialTest() {
    }
    
    /**
     * Creacion de la galaxia para poder probar un personaje
     * Se necesita crear una galaxia para crear un personaje
     */
    @BeforeClass
    public static void setUpClass() {
        EstacionPuerta puerta = new EstacionPuerta(24);
        
        //Creacion de una galaxia de prueba para probar el personaje
        Galaxia galaxia = Galaxia.obtenerInstancia(24, puerta, 5, 5);
        
        Cerradura cerradura = new Cerradura(4);

        ArrayList<Midicloriano> combinacion = galaxia.generarMidiclorianosCerradura();

        cerradura.setCombinacionInicial(combinacion);
        cerradura.generarCombinacion();
        cerradura.setEstado(false);

        galaxia.getStarsgate().setCerradura(cerradura);

        galaxia.construirGalaxia();
        galaxia.generarLaberinto();
        galaxia.getGrafo().floyd();
        galaxia.getGrafo().warshall();
        
        instance = new Imperial('I', "ImperialPrueba", Galaxia.obtenerInstancia().getStarsgate().getID(), 0);
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
     * 
     * Este test no se puede llevar a cabo ya que depende de otras clases
     * se prueba con las pruebas de integracion de varios modulos
     */
    @Test
    public void testAccionPuerta() {
        System.out.println("accionPuerta");
        
//        System.out.println(Galaxia.obtenerInstancia().imprimirGalaxia());
//        instance.accionPuerta();
//        System.out.println(Galaxia.obtenerInstancia().imprimirGalaxia());
    }

    /**
     * Test of accionEstacion method, of class Imperial.
     * 
     * Este test no se puede llevar a cabo ya que depende de otras clases
     * se prueba con las pruebas de integracion de varios modulos
     */
    @Test
    public void testAccionEstacion() {
        System.out.println("accionEstacion");
        
    }

    /**
     * Test of esImperial method, of class Imperial.
     * 
     * Prueba de funcionamiento esImperial
     */
    @Test
    public void testEsImperial() {
        System.out.println("esImperial");
        
        boolean expResult = true;
        boolean result = instance.esImperial();
        assertTrue(result);
        
    }

    /**
     * Test of generarCamino method, of class Imperial.
     */
    @Test
    public void testGenerarCamino() {
        System.out.println("generarCamino");
        
        String expected = " O N N N N E O S O S O S O N N N S S S E S O E N N E N E S S S E";
        
        instance.generarCamino();
        
        System.out.println(instance.rutaToString());
        
        assertEquals(expected, instance.rutaToString());
    }

    /**
     * Test of setMidiclorianos method, of class Imperial.
     * 
     * Prueba la insercion de una lista de midiclorianos
     */
    @Test
    public void testSetMidiclorianos() {
        System.out.println("setMidiclorianos");
        ArrayList<Midicloriano> midiclorianos = new ArrayList<>();
        Midicloriano midi = new Midicloriano(-2);
        for (int i = 0; i < 10; i++) {
            midi = new Midicloriano(i-1);
            midiclorianos.add(midi);
        }
        
        String expected = " 8 7 6 5 4 3 2 1 0 -1";
        
        instance.setMidiclorianos(midiclorianos);
        
        assertEquals(expected, instance.midicloriansToString());
        
    }

    /**
     * Test of getTipo method, of class Imperial.
     * 
     * Prueba para comprobar que la clase Imperial funciona (constructor)
     * y metodo getTipo.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        
        String expResult = "imperial";
        String result = instance.getTipo();
        assertEquals(expResult, result);
    }
    
}
