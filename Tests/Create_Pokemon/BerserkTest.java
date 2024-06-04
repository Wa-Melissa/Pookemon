package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BerserkTest {

    @Test
    public void test_0(){
        Pokemon berserk = new Pokemon();
        berserk.m_pouvoir = new Berserk();
        Ordinateur ordi = new Ordinateur(true,berserk);

        Pokemon p = new Pokemon();
        p.m_pouvoir = null;
        Ordinateur j = new Ordinateur(false,p);

        int attaqueInit = berserk.m_attaque ;

    }

}