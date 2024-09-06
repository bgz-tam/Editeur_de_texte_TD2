package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeRemplacer extends CommandeDocument {

    public CommandeRemplacer(Document document, String[] parameters) {
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
        String texte="";
        if (parameters.length>3) {
            texte= parameters[3];
        }
        this.document.remplacer(Integer.parseInt(debut), Integer.parseInt(fin),texte);
        super.executer();
    }

}
