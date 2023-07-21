import model.NombreMystereJeu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choisissez un mode de jeu :");
        System.out.println("1) Le programme génère un nombre mystère et vous devez le deviner.");
        System.out.println("2) Vous indiquez un nombre mystère et l’ordinateur doit le deviner.");

        int choix = new java.util.Scanner(System.in).nextInt();

        if (choix == 1) {
            NombreMystereJeu jeu = new NombreMystereJeu(false);
            jeu.jouer();
        } else if (choix == 2) {
            NombreMystereJeu jeu = new NombreMystereJeu(true);
            jeu.jouer();
        } else {
            System.out.println("Choix invalide. Veuillez choisir le mode 1 ou 2.");
        }
    }
}
