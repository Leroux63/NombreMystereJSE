package model;

import java.util.Scanner;

public class Joueur {
    private Scanner scanner;

    public Joueur() {
        scanner = new Scanner(System.in);
    }

    public int faireProposition() {
        System.out.print("Entrez votre proposition : ");
        String propositionStr = scanner.next();
        while (propositionStr.length() != 4 || !propositionStr.matches("[0-9]+")) {
            System.out.print("Proposition invalide. Veuillez entrer un nombre à 4 chiffres : ");
            propositionStr = scanner.next();
        }
        return Integer.parseInt(propositionStr);
    }

    public String faireReponse() {
        System.out.print("Indiquez si c'est (+) plus grand, (-) plus petit ou (=) égal : ");
        return scanner.nextLine();
    }

    public void afficherReponse(String reponse) {
        System.out.println("Réponse : " + reponse);
    }

    public void afficherSolution(int nombreMystere) {
        System.out.println("Le nombre mystère était : " + nombreMystere);
    }

    public void afficherGagne() {
        System.out.println("Félicitations, vous avez trouvé le nombre mystère !");
    }

    public void afficherPerdu(int nombreMystere) {
        System.out.println("Dommage, vous avez épuisé toutes vos tentatives. Le nombre mystère était : " + nombreMystere);
    }
}
