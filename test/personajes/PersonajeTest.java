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
import estructura.EstacionBase;
import estructura.EstacionPuerta;
import estructura.Galaxia;
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
 * @author Fernando Gonzalez < fernandogv.inf@gmail.com >
 */
public class PersonajeTest {
    
    private static Personaje instance;
    
    public PersonajeTest() {
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
        
        instance = new Jedi('P', "PersonajeJediPrueba", 8, 4);
        
        System.out.println(galaxia.imprimirGalaxia());
    }
    
    @AfterClass
    public static void tearDownClass() {
        int estaciones = Galaxia.obtenerInstancia().getIdEstacionPuerta();
        
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
        
        Personaje personaje = new Imperial('K', "PersonajeImperialPrueba", 14, 8);
        
        int expResult = 8;
        int result = personaje.getTurno();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstacionPosicion method, of class Personaje.
     */
    @Test
    public void testGetEstacionPosicion() {
        System.out.println("getEstacionPosicion");
        
        Personaje personaje = new Imperial('I', "PersonajeImperialPrueba", 14, 4);
        
        int expResult = 14;
        int result = personaje.getEstacionPosicion().getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMarcaClase method, of class Personaje.
     */
    @Test
    public void testGetMarcaClase() {
        System.out.println("getMarcaClase");
        
        char expResult = 'P';
        char result = instance.getMarcaClase();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isGanador method, of class Personaje.
     */
    @Test
    public void testIsGanador() {
        System.out.println("isGanador");
        
        Personaje personaje = new FamiliaReal('F', "PersonajeFRealPrueba", 1, 4);

        boolean expResult = false;
        boolean result = personaje.isGanador();
        assertEquals(expResult, result);
        
        personaje.moverA(Galaxia.obtenerInstancia().getEstacionLiberty());
        personaje.ganador = true;
        expResult = true;
        
        result = personaje.isGanador();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getRuta method, of class Personaje.
     */
    @Test
    public void testGetRuta() {
        System.out.println("getRuta");
        
        Personaje personaje = new Contrabandista('Z', "PersonajeContrabandistaPrueba", 10, 1);

        ArrayList<Integer> camino = new ArrayList<>();
        
        //Seteamos un camino de ejemplo: mover el personaje hasta la posicion de la puerta desde la pos 8
        //camino.add(10);
        camino.add(10+5);        //Mueve al sur
        camino.add(10+5+1);      
        
        personaje.setRuta(camino);
        
        System.out.println(Galaxia.obtenerInstancia().imprimirGalaxia());
        
        System.out.println(personaje.getRuta().toString());
        
        String expResult = "[S, E]";
        String result = personaje.getRuta().toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setRuta method, of class Personaje.
     */
    @Test
    public void testSetRuta_LinkedList() {
        System.out.println("setRuta");
        
        LinkedList<Camino> ruta = new LinkedList<>();
        
        String expected = "[O, N, S, O, N, S, E]";
        
        //Seteamos una ruta de ejemplo: O, N, S, O, N, S, E
        ruta.add(Camino.OESTE);
        ruta.add(Camino.NORTE);
        ruta.add(Camino.SUR);
        ruta.add(Camino.OESTE);
        ruta.add(Camino.NORTE);
        ruta.add(Camino.SUR);
        ruta.add(Camino.ESTE);
        
        instance.setRuta(ruta);
        
        assertEquals(expected, ruta.toString());
    }

    /**
     * Test of setRuta method, of class Personaje.
     */
    @Test
    public void testSetRuta_ArrayList() {
        System.out.println("setRuta");
        
        Personaje personaje = new Contrabandista('C', "PersonajeContrabandistaPrueba", 11, 1);

        String expected = "[S, S, S]";
        ArrayList<Integer> camino = new ArrayList<>();
        
        //Seteamos un camino de ejemplo: mover el personaje hasta la posicion de la puerta desde la pos 8
        
        camino.add(11+5);        //Mueve al sur
        camino.add(11+5+5);      //Mueve al sur
        camino.add(11+5+5+5);    //Mueve al sur
        
        System.err.println(personaje.rutaToString());
        
        personaje.setRuta(camino);
        
        assertEquals(expected, personaje.getRuta().toString());
    }

    /**
     * Test of recogerMidicloriano method, of class Personaje.
     */
    @Test
    public void testRecogerMidicloriano() {
        System.out.println("recogerMidicloriano");
        Midicloriano midicloriano = new Midicloriano(42);
        
        String expected = " 42";
        
        instance.recogerMidicloriano(midicloriano);
    }

    /**
     * Test of mover method, of class Personaje.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        
        if(!instance.getRuta().isEmpty()){
            instance.mover();
            System.err.println("Movido");
        }
    }

    /**
     * Test of accion method, of class Personaje.
     */
    @Test
    public void testAccion() {
        System.out.println("accion");
        instance.accion();
    }

    /**
     * Test of esImperial method, of class Personaje.
     */
    @Test
    public void testEsImperial() {
        System.out.println("esImperial");
        
        Personaje personaje = new FamiliaReal('F', "PersonajeFRealPrueba", 1, 4);
        
        boolean expResult = false;
        boolean result = instance.esImperial();
        assertEquals(expResult, result);
    }

    /**
     * Test of fin method, of class Personaje.
     */
    @Test
    public void testFin() {
        System.out.println("fin");
        
        Personaje personaje = new FamiliaReal('F', "PersonajeFRealPrueba", 1, 4);
        
        personaje.fin();
    }

    /**
     * Test of accionPuerta method, of class Personaje.
     */
    @Test
    public void testAccionPuerta() {
        System.out.println("accionPuerta");
        Personaje personaje = new Jedi('G', "PersonajeJediPrueba", 24, 4);
        personaje.accionPuerta();
        
    }

    /**
     * Test of accionEstacion method, of class Personaje.
     */
    @Test
    public void testAccionEstacion() {
        System.out.println("accionEstacion");
        
        instance.accionEstacion();
    }

    /**
     * Test of generarCamino method, of class Personaje.
     */
    @Test
    public void testGenerarCamino() {
        System.out.println("generarCamino");
        
        Personaje personaje = new Contrabandista('h', "PersonajeFRealPrueba", 20, 4);
        
        personaje.generarCamino();
    }

    /**
     * Test of getTipo method, of class Personaje.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        
        String expResult = "jedi";
        String result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Personaje.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Personaje o = new FamiliaReal('F', "PersonajeFRealPrueba", 1, 4);
        
        int expResult = 1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Personaje.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "P";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of rutaToString method, of class Personaje.
     */
    @Test
    public void testRutaToString() {
        System.out.println("rutaToString");
        
        LinkedList<Camino> ruta = new LinkedList<>();
        
        ruta.add(Camino.SUR);
        ruta.add(Camino.NORTE);
        ruta.add(Camino.NORTE);
        ruta.add(Camino.OESTE);
        
        instance.setRuta(ruta);
        
        String expResult = " S N N O";
        String result = instance.rutaToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of midicloriansToString method, of class Personaje.
     */
    @Test
    public void testMidicloriansToString() {
        System.out.println("midicloriansToString");
        
        Midicloriano midi = new Midicloriano(4);
        
        System.err.println(instance.midicloriansToString());
        
        String expResult;
        if(!instance.midiclorianos.isEmpty()){
            expResult = " 42";
        }else{
            instance.recogerMidicloriano(midi);
            expResult = " 4";
        }
        String result = instance.midicloriansToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toLogini method, of class Personaje.
     */
    @Test
    public void testToLogini() {
        System.out.println("toLogini");
        
        instance.toLogini();
    }

    /**
     * Test of toLog method, of class Personaje.
     */
    @Test
    public void testToLog() {
        System.out.println("toLog");
        
        instance.toLog();
    }

    
}
