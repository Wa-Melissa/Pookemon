package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class Berserk extends Power {
    private Pokemon m_receveur;

    protected Berserk(){
        m_nom = "Berserk";
        m_estUtilisable = true;
    }

    /**
     * produit tous les effets du pouvoir
     * @param soi, le Joueur qui déclenche un pouvoir
     * @param adv, son adversaire
     */
    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        m_receveur = soi.trouverPokemon(soi.getTerrain(), "rendre Berserk");
        m_receveur.m_attaque *= 2;
        m_estUtilisable = false;

        AffichagePouvoirs.afficherResultatAction(m_receveur.getNom()+" est passé en mode Berserk et inflige pour ce tour "+m_receveur.getAttaque()+" dégats !");
    }

    /**
     * met fin a l'action du pouvoir
     */
    @Override
    public void finEffetPouvoir(){
        if (!m_estUtilisable){
            m_receveur.m_attaque /= 2;
            AffichagePouvoirs.afficherResultatAction("! Le pouvoir Berserk a fini sont effet, "+m_receveur.getNom()+" n'inflige de nouveau plus que "+m_receveur.getAttaque()+" dégats");
        }
    }

    @Override
    public String toString(){
        if (m_receveur != null){
            return super.toString() + "Ce pouvoir a été utilisé sur "+m_receveur.getNom();
        }else {
            return super.toString();
        }
    }
}
