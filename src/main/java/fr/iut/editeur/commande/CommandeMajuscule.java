package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeMajuscule extends CommandeDocument {

    public CommandeMajuscule(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 2) {
            System.err.println("Format attendu : remplacer;debut;fin");
            return;
        }
        //ajout commentaire pour commit
        String debut = parameters[1];
        String fin = parameters[2];
        this.document.majuscules(Integer.parseInt(debut), Integer.parseInt(fin));
        super.executer();
    }
}
