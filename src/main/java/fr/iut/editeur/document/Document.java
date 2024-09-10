package fr.iut.editeur.document;

public class Document {

    private String texte;

    public Document() {
        this.texte = "";
    }
	
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void ajouter(String texte) {
        this.texte += texte;
    }

    public void remplacer(int debut, int fin, String remplacement) {
        String partieGauche = texte.substring(0, debut);
        String partieDroite = texte.substring(fin + 1);
        texte = partieGauche + remplacement + partieDroite;
    }

    /**
     * Met en majuscules une portion du texte
     * @param debut
     * @param fin
     */
    public void majuscules(int debut, int fin) {
        String partie = texte.substring(debut, fin);
        partie = partie.toUpperCase();
        remplacer(debut, fin, partie);
    }

    @Override
    public String toString() {
        return this.texte;
    }
}
