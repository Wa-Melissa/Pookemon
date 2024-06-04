package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsurpationTest {
    @Test
    public void test_0(){
        Pokemon p = new Pokemon();
        p.m_pouvoir = new Usurpation(p);

        Ordinateur ordi1 = new Ordinateur(true,p);
        Ordinateur ordi2 = new Ordinateur("",false);
        p.getPower().declencherPouvoir(ordi1,ordi2);
        assertNotNull(p.getPower());

    }


}