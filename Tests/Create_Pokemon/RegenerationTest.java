package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegenerationTest {
    /**
     * Teste si le pouvoir devient unitilisable après avoir été utilisé
     */
    @Test
    public void test_0(){
        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);

        Power vacances = new Regeneration();

        vacances.declencherPouvoir(ordi1,ordi2);
        assertFalse(vacances.isUtilisable());
    }

}