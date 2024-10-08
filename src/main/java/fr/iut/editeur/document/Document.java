package fr.iut.editeur.document;

/**
 * Cette classe permet de créer un document et définit les méthodes que l'ont peut utiliser sur celui-ci
 * - Un Document est définit par un attribut de type texte (String)
 */
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

    public void effacer(int debut, int fin) {
        remplacer(debut, fin, "");
    }

    public void inserer(Integer position, String plus){
        String partieGauche = texte.substring(0, position);
        String partieDroite = texte.substring(position);
        texte = partieGauche + plus + partieDroite;
    }

    /**
     * Met en majuscules une portion du texte
     * @param debut
     * @param fin
     */
    public void majuscules(int debut, int fin) {
        String partie = texte.substring(debut, fin);
        partie = partie.toUpperCase();
        remplacer(debut, fin-1, partie);
    }

    public void clear() {
        effacer(0,texte.length()-1);
    }

    @Override
    public String toString() {
        return this.texte;
    }
}
