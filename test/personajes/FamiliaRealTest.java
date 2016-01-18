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
public class FamiliaRealTest {
    
    private static FamiliaReal instance;
    
    public FamiliaRealTest() {
    }
    
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
        
        instance = new FamiliaReal('F', "FamiliaRealPrueba", 0,0);
        
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
     * Test of generarCamino method, of class FamiliaReal.
     */
    @Test
    public void testGenerarCamino() {
        System.out.println("generarCamino");
        
        instance.generarCamino();
        
        System.out.println(instance.rutaToString());
        System.out.println(Galaxia.obtenerInstancia().imprimirGalaxia());
        
        assertEquals(instance.rutaToString(), " S S S E N E N E S S S E");
    }

    /**
     * Test of getTipo method, of class FamiliaReal.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        
        String expResult = "familiareal";
        String result = instance.getTipo();
        
        assertEquals(expResult, result);
    }
    
}
