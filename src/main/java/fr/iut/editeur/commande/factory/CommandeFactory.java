package fr.iut.editeur.commande.factory;

import fr.iut.editeur.commande.*;
import fr.iut.editeur.document.Document;

public class CommandeFactory {

    /**
     * Usine de Commande
     * construit des commandes
     */
    private static CommandeFactory instance;

    public static CommandeFactory getInstance() {
        if(instance == null) {
            instance = new CommandeFactory();
        }
        return instance;
    }

    private CommandeFactory() {}

    public Commande createCommand(String name, Document document, String[] parameters) {
        /**
         * creer une commandeAjouter,d'un doc et du texte de ce doc
         * seulement si mot 'ajouter' est le premier parametres
         * sinon return null
         */
        switch (name) {
            case "ajouter" : return new CommandeAjouter(document, parameters);
            case "remplacer" : return new CommandeRemplacer(document, parameters);
            case "effacer" : return new CommandeEffacer(document, parameters);
            case "majuscules" : return new CommandeMajuscule(document, parameters);
            case "clear" : return new CommandeClear(document, parameters);
            case "inserer" : return new CommandeInserer(document, parameters);
            default: return null;
        }
    }

}
