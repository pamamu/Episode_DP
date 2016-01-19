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
import personajes.Jedi;
import personajes.Personaje;

/**
 *
 * @author Fernando Gonzalez < fernandogv.inf@gmail.com >
 */
public class GalaxiaTest {
    
    public GalaxiaTest() {
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
        
        System.out.println(galaxia.imprimirGalaxia());
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
        EstacionPuerta puerta = new EstacionPuerta(5);
        Galaxia expResult = Galaxia.obtenerInstancia(5, puerta, 8, 8);
        Galaxia result = Galaxia.obtenerInstancia();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerInstancia method, of class Galaxia.
     */
    @Test
    public void testObtenerInstancia_0args() {
        System.out.println("obtenerInstancia");
        Galaxia expResult = Galaxia.obtenerInstancia();
        Galaxia result = Galaxia.obtenerInstancia();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDimX method, of class Galaxia.
     */
    @Test
    public void testGetDimX() {
        System.out.println("getDimX");
        
        int expResult = 5;
        int result = Galaxia.obtenerInstancia().getDimX();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDimY method, of class Galaxia.
     */
    @Test
    public void testGetDimY() {
        System.out.println("getDimY");
        
        int expResult = 5;
        int result = Galaxia.obtenerInstancia().getDimY();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getGrafo method, of class Galaxia.
     */
    @Test
    public void testGetGrafo() {
        System.out.println("getGrafo");
        Galaxia instance = Galaxia.obtenerInstancia();
        Grafo expResult = Galaxia.obtenerInstancia().getGrafo();
        Grafo result = instance.getGrafo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTurno method, of class Galaxia.
     */
    @Test
    public void testGetTurno() {
        System.out.println("getTurno");
        Galaxia instance = Galaxia.obtenerInstancia();        
        
        int expResult = 0;
        if(instance.getTurno() != 0)
             expResult = 1;
        
        int result = instance.getTurno();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdEstacionPuerta method, of class Galaxia.
     */
    @Test
    public void testGetIdEstacionPuerta() {
        System.out.println("getIdEstacionPuerta");
        Galaxia instance = Galaxia.obtenerInstancia();
        int expResult = 24;
        int result = instance.getIdEstacionPuerta();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstacionLiberty method, of class Galaxia.
     */
    @Test
    public void testGetEstacionLiberty() {
        System.out.println("getEstacionLiberty");
        Galaxia instance = Galaxia.obtenerInstancia();
        EstacionBase expResult = Galaxia.obtenerInstancia().getEstacionLiberty();
        EstacionBase result = instance.getEstacionLiberty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStarsgate method, of class Galaxia.
     */
    @Test
    public void testGetStarsgate() {
        System.out.println("getStarsgate");
        Galaxia instance = Galaxia.obtenerInstancia();
        EstacionPuerta expResult = (EstacionPuerta)Galaxia.obtenerInstancia().getEstacion(
                instance.getIdEstacionPuerta());
        EstacionPuerta result = instance.getStarsgate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPersonajes method, of class Galaxia.
     */
    @Test
    public void testGetPersonajes() {
        System.out.println("getPersonajes");
        Galaxia instance = Galaxia.obtenerInstancia();
        ArrayList<Personaje> expResult = new ArrayList<>();
        if(!instance.getPersonajes().isEmpty()){
            Jedi personaje = new Jedi('P', "PersonajeJediPrueba", 8, 4);
            expResult.add(personaje);
        }
        ArrayList<Personaje> result = instance.getPersonajes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPersonajes method, of class Galaxia.
     */
    @Test
    public void testSetPersonajes() {
        System.out.println("setPersonajes");
        ArrayList<Object> personajes = new ArrayList<>();
        Jedi personaje = new Jedi('P', "PersonajeJediPrueba", 8, 4);
        
        personajes.add(personaje);
        
        Galaxia instance = Galaxia.obtenerInstancia();
        instance.setPersonajes(personajes);
    }

    /**
     * Test of construirGalaxia method, of class Galaxia.
     */
    @Test
    public void testConstruirGalaxia() {
        System.out.println("construirGalaxia");
        Galaxia instance = Galaxia.obtenerInstancia();
        instance.construirGalaxia();
    }

    /**
     * Test of generarLaberinto method, of class Galaxia.
     */
    @Test
    public void testGenerarLaberinto() {
        System.out.println("generarLaberinto");
        Galaxia instance = Galaxia.obtenerInstancia();
        instance.generarLaberinto();
    }

    /**
     * Test of generarMidiclorianosCerradura method, of class Galaxia.
     */
    @Test
    public void testGenerarMidiclorianosCerradura() {
        System.out.println("generarMidiclorianosCerradura");
        Galaxia instance = Galaxia.obtenerInstancia();
        String expResult = "[1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29]";
        String result = instance.generarMidiclorianosCerradura().toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of generarMidiclorianosGalaxia method, of class Galaxia.
     */
    @Test
    public void testGenerarMidiclorianosGalaxia() {
        System.out.println("generarMidiclorianosGalaxia");
        Galaxia instance = Galaxia.obtenerInstancia();
        String expResult = "[0, 1, 1, 2, 3, 3, 4, 5, 5, 6, 7, 7, 8, 9, 9, 10, 11, 11, 12, 13, 13, 14, 15, 15, 16, 17, 17, 18, 19, 19, 20, 21, 21, 22, 23, 23, 24, 25, 25, 26, 27, 27, 28, 29, 29]";
        String result = instance.generarMidiclorianosGalaxia().toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of repartirMidiclorianos method, of class Galaxia.
     */
    @Test
    public void testRepartirMidiclorianos() {
        System.out.println("repartirMidiclorianos");
        Galaxia instance = Galaxia.obtenerInstancia();
        ArrayList<Midicloriano> midiclorianos = instance.generarMidiclorianosGalaxia();
        instance.repartirMidiclorianos(midiclorianos);
    }

    /**
     * Test of accion method, of class Galaxia.
     */
    @Test
    public void testAccion() {
        System.out.println("accion");
        int turno = 1;
        Galaxia instance = Galaxia.obtenerInstancia();
        instance.accion(turno);
    }

    /**
     * Test of IDtoCoordenadas method, of class Galaxia.
     */
    @Test
    public void testIDtoCoordenadas() {
        System.out.println("IDtoCoordenadas");
        int ID = 0;
        Galaxia instance = Galaxia.obtenerInstancia();
        int[] expResult = {0,0};
        int[] result = instance.IDtoCoordenadas(ID);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of coordenadastoID method, of class Galaxia.
     */
    @Test
    public void testCoordenadastoID() {
        System.out.println("coordenadastoID");
        int fila = 4;
        int columna = 3;
        Galaxia instance = Galaxia.obtenerInstancia();
        int expResult = 23;
        int result = instance.coordenadastoID(fila, columna);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstacion method, of class Galaxia.
     */
    @Test
    public void testGetEstacion_int() {
        System.out.println("getEstacion");
        int ID = 8;
        Galaxia instance = Galaxia.obtenerInstancia();
        EstacionBase expResult = Galaxia.obtenerInstancia().getEstacion(1, 3);
        EstacionBase result = instance.getEstacion(ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstacion method, of class Galaxia.
     */
    @Test
    public void testGetEstacion_int_int() {
        System.out.println("getEstacion");
        Galaxia instance = Galaxia.obtenerInstancia();
        EstacionBase expResult = instance.getEstacion(10);
        EstacionBase result = instance.getEstacion(2, 0);
        assertEquals(expResult, result);
    }

    /**
     * Test of simular method, of class Galaxia.
     */
    @Test
    public void testSimular() {
        System.out.println("simular");
        Galaxia instance = Galaxia.obtenerInstancia();
        instance.simular();
    }

    /**
     * Test of imprimirGalaxia method, of class Galaxia.
     */
    @Test
    public void testImprimirGalaxia() {
        System.out.println("imprimirGalaxia");
        Galaxia instance = Galaxia.obtenerInstancia();
        String expResult = Galaxia.obtenerInstancia().imprimirGalaxia();
        String result = instance.imprimirGalaxia();
        assertEquals(expResult, result);
    }

    /**
     * Test of toLog method, of class Galaxia.
     */
    @Test
    public void testToLog() {
        System.out.println("toLog");
        int turno = 0;
        
        Galaxia.obtenerInstancia().toLog(turno);
    }
    
}
