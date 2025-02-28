package exoEngins;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class ExamEnginsTest {

    @Before
    public void reset() {
        Electrique.setBaseConso(3.14);
        Electrique.setPerte(62.0);
        Thermique.setPerte(64.0);
    }

    @Test
    public void testValeurGazole() {
        int val = Carburant.ID_GAZOLE;
        int valGazole = 0;
        assertEquals(valGazole, val);
    }

    @Test
    public void testGetConsoGazole() {
        double val = Carburant.getConso(Carburant.ID_GAZOLE);
        double valAttendue = 49.3;
        assertEquals(valAttendue, val, 0);
    }

    @Test
    public void testNbCarburants() {
        int val = Carburant.nbCarburants;
        int valAttendue = 3;
        assertEquals(valAttendue, val);
    }

    @Test
    public void testNomGazole() {
        assertEquals("gazole", Carburant.nom(0));
    }

    @Test
    public void testMasseConstructionPropulsionThermiqueEssence() {
        Thermique thermique = new Thermique(10,0);
        assertEquals(47.1, Carburant.getConso(1),0.1);
    }

    @Test
    public void testEoliennetoString() {
        Eolienne eolienne = new Eolienne();
        System.out.println(eolienne.toString());
    }

    @Test
    public void testElectriqueToString() {
        Electrique electrique = new Electrique(0);
        System.out.println(electrique.toString());
    }

    @Test
    public void testThermiqueToString() {
        Thermique thermique = new Thermique(1,0);
        System.out.println(thermique.toString());
    }

    @Test
    public void testConstructionPropulsionThermiqueEssenceCarburant() {
        Thermique thermique = new Thermique(10,0);
        assertEquals(47.1, Carburant.getConso(1),0.1);
    }

    @Test
    public void testConstructionPropulsionThermiqueCarburantIllegal() {
        Thermique thermique = new Thermique(10,0);
        assertEquals(44.3, Carburant.getConso(12),0.1);
    }

    @Test
    public void testThermiqueSetCarburantIllegal() {
        Thermique thermique = new Thermique(1333,0);
    }

    @Test
    public void testThermiquePerteStatic() {
        Thermique thermique = new Thermique(0,0);
        assertEquals(64, Thermique.getPerte(),0.1);
    }

    @Test
    public void testThermiqueSetPerteStatic() {
        Thermique thermique = new Thermique(0,0);
        Thermique.setPerte(70);
        assertEquals(70, Thermique.getPerte(),0.1);
    }

    @Test
    public void testThermiqueConsommerEnergie() {
        Thermique thermique = new Thermique(10,0);
        assertEquals(49.3 * 10+ 64, thermique.consommerEnergie(),0.12);

    }

    @Test
    public void testElectriqueConsommerEnergie() {
        Electrique electrique = new Electrique(10);
        double attendu = 3.14 * 100 + 62;
        double obtenu = electrique.consommerEnergie();
        assertEquals(attendu,obtenu,0.1);
    }

    @Test
    public void testEolienneConsommerEnergie() {
        Eolienne eolienne = new Eolienne();
        assertEquals(0, eolienne.consommerEnergie(),0.0);
    }

 
    @Test
    public void testIdEnginRoulantThermique() {
        Roulant engin1 = new Roulant( new Thermique(10,0));
        Roulant engin2 = new Roulant(new Thermique(10,0));
        assertEquals(engin1.id + 1, engin2.id);
    }

    @Test
    public void testIdEnginFlottantElectrique() {
            Flottant engin = new Flottant(new Electrique(10));
            assertNotNull(engin.id);
    }

    @Test
    public void testDernierIdEngin() {
            int lastId = Engin.dernierId;
            new Roulant(new Thermique(10,0));
            assertEquals(lastId + 1, Engin.dernierId);
    }

    @Test
    public void testEnginGetPropulsion() {
            Roulant engin = new Roulant(new Thermique(10,0));
            assertTrue(engin.propulsion instanceof Thermique);
    }

    @Test
    public void testEnginToString() {
            Roulant engin = new Roulant( new Thermique(10,0));
            assertNotNull(engin.toString());
        }
    

    @Test
    public void testFlottantConduire() {
        Propulsion propulsion = new Thermique(42.0, Carburant.ID_Essence);
        Engin engin = new Flottant(propulsion);
        double valEnergie = propulsion.consommerEnergie();
        String valAttendue = String.format(
        		"Vous cosomer "+propulsion.consommerEnergie() + " Energies",
                valEnergie);
        label1: try {
            File sortieFic = new File("tmpOut.txt");
            PrintStream sortiePrintStream = new PrintStream(sortieFic);
            System.setOut(sortiePrintStream);
            engin.conduire();
            FileReader sortieFileReader = new FileReader(sortieFic);
            char[] cbuf = new char[valAttendue.length()];
            sortieFileReader.read(cbuf);
            sortieFileReader.close();
//	    System.err.println("Lu: " + String.copyValueOf(cbuf));
            String valObservee = String.copyValueOf(cbuf);
            assertEquals(valAttendue, valObservee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            label2: e.printStackTrace();
        }
    }


}