package Create_Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Initialisation
{
    /**
     * Liste contenant tous les Pokémons qui peuvent être utilisé dans la partie
     */
    private static ArrayList<String> m_listePokemon = new ArrayList<>(Arrays.asList(
            "Bulbizarre", "Herbizarre", "Florizarre", "Salamèche", "Reptincel",
            "Dracaufeu", "Carapuce", "Carabaffe", "Tortank", "Chenipan", "Chrysacier",
            "Papilusion", "Aspicot", "Coconfort", "Dardargnan", "Roucool", "Roucoups",
            "Roucarnage", "Rattata", "Rattatac", "Piafabec", "Rapasdepic", "Abo", "Arbok",
            "Pikachu", "Raichu", "Sabelette", "Sablaireau", "Nidoran", "Nidorina", "Nidoqueen",
            "Nidorino", "Nidoking", "Mélofée", "Mélodelfe", "Goupix", "Feunard",
            "Rondoudou", "Grodoudou", "Nosferapti", "Nosferalto", "Mystherbe", "Ortide",
            "Rafflesia", "Paras", "Parasect", "Mimitoss", "Aéromite", "Taupiqueur",
            "Triopikeur", "Miaouss", "Persian", "Psykokwak", "Akwakwak", "Férosinge",
            "Colossinge", "Caninos", "Arcanin", "Ptitard", "Têtarte", "Tartard", "Abra",
            "Kadabra", "Alakazam", "Machoc", "Machopeur", "Mackogneur", "Chétiflor",
            "Boustiflor", "Empiflor", "Tentacool", "Tentacruel", "Racaillou", "Gravalanch",
            "Grolem", "Ponyta", "Galopa", "Ramoloss", "Flagadoss", "Magnéti", "Magnéton",
            "Canarticho", "Doduo", "Dodrio", "Otaria", "Lamantine", "Tadmorv", "Grotadmorv",
            "Kokiyas", "Crustabri", "Fantominus", "Spectrum", "Ectoplasma", "Onix", "Soporifik",
            "Hypnomade", "Krabby", "Krabboss", "Voltorbe", "Électrode", "Noeunoeuf", "Noadkoko",
            "Osselait", "Ossatueur", "Kicklee", "Tygnon", "Excelangue", "Smogo", "Smogogo", "Rhinocorne",
            "Rhinoféros", "Leveinard", "Saquedeneu", "Kangourex", "Hypotrempe", "Hypocéan", "Poissirène",
            "Poissoroy", "Stari", "Staross", "M. Mime", "Insécateur", "Lippoutou", "Élektek", "Magmar",
            "Scarabrute", "Tauros", "Léviator", "Lokhlass", "Métamorph", "Évoli", "Aquali", "Voltali",
            "Pyroli", "Porygon", "Amonita", "Amonistar", "Kabuto", "Kabutops", "Ptéra", "Ronflex",
            "Artikodin", "Électhor", "Sulfura", "Minidraco", "Draco", "Dracolosse", "Mewtwo", "Mew",
            "Germignon", "Macronium", "Méganium", "Héricendre", "Feurisson", "Typhlosion", "Kaiminus",
            "Crocrodil", "Aligatueur", "Fouinette", "Fouinar", "Hoothoot", "Noarfang", "Coxy",
            "Coxyclaque", "Mimigal", "Migalos", "Nostenfer", "Loupio", "Lanturn", "Pichu"));

    private static ArrayList<String> m_listePouvoirs = new ArrayList<>(Arrays.asList("Berserk", "Soin simple",
            "Soin de zone","Kamikaze", "Peur", "Regeneration","Usurpation","Extension du territoire"));


    /**
     * Méthode getNom() : Affiche le nom du Pokémon
     * @return m_listePokemon.get(m_index) : Le nom du Pokémon
     */
    static String getNom()
    {
        Random rdt = new Random();
        return m_listePokemon.remove(rdt.nextInt(m_listePokemon.size()));
    }

    static String getPouvoir()
    {
        if (!m_listePouvoirs.isEmpty()){
            Random rdt = new Random();
            return m_listePouvoirs.remove(rdt.nextInt(m_listePouvoirs.size()));
        }
        return null;
    }
}
