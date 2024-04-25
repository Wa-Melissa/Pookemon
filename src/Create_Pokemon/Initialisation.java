package Create_Pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class Initialisation
{
    private static int m_index = -1;
    private static ArrayList<String> m_listePokemon = new ArrayList<>(Arrays.asList(
            "Bulbizarre", "Herbizarre", "Florizarre", "Salamèche", "Reptincel",
            "Dracaufeu", "Carapuce", "Carabaffe", "Tortank", "Chenipan",
            "Chrysacier", "Papilusion", "Aspicot", "Coconfort", "Dardargnan",
            "Roucool", "Roucoups", "Roucarnage", "Rattata", "Rattatac",
            "Piafabec", "Rapasdepic", "Abo", "Arbok", "Pikachu",
            "Raichu", "Sabelette", "Sablaireau", "Nidoran♀", "Nidorina",
            "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Mélofée",
            "Mélodelfe", "Goupix", "Feunard", "Rondoudou", "Grodoudou","Nosferalto"));

    public static String getNom()
    {
        m_index ++;
        return m_listePokemon.get(m_index);
    }
}
