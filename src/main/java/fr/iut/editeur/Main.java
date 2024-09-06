package fr.iut.editeur;

import fr.iut.editeur.commande.Commande;
import fr.iut.editeur.commande.invoker.CommandeInvoker;
import fr.iut.editeur.document.Document;
import fr.iut.editeur.commande.factory.CommandeFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // recup ce que l'utilisateur écrit
        Document document = new Document(); // crée un nv doc
        CommandeInvoker invoker = CommandeInvoker.getInstance(); // construit un executeur de commande
        CommandeFactory factory = CommandeFactory.getInstance(); // construit une usine de commande
        while(true) {
            String input = scanner.nextLine(); //retourne la ligne qui vient d'être écrite pusi sautée
            String[] parameters = input.split(";"); // recup tableau avec chaque bout de string qui était séparé par des ';'
            String nomCommande = parameters[0]; // le premier mot du taleau est attribué à la variable  nomCommande
            Commande commande = factory.createCommand(nomCommande, document, parameters); //création d'une commande
            if(commande != null) {
                invoker.executer(commande); //création d'un doc seulement si nomCommande == ajouter true
            }
            else {
                System.err.println("Cette commande n'existe pas!");
            }
        }
    }
}