package model;

import java.util.Scanner;

public class NombreMystereJeu {
    private int nombreMystere;
    private int tentativesRestantes;
    private boolean modeDevine;

    public NombreMystereJeu(boolean modeDevine) {
        this.modeDevine = modeDevine;
        if (!modeDevine) {
            // L'ordinateur génère un nombre mystère à deviner
            nombreMystere = (int) (Math.random() * 10000);
            this.tentativesRestantes = 10;
        } else {
            // Le joueur choisit le nombre mystère
            System.out.print("Entrez le nombre mystère à deviner (entre 0 et 9999) : ");
            nombreMystere = new Scanner(System.in).nextInt();
            while (nombreMystere < 0 || nombreMystere > 9999) {
                System.out.print("Nombre mystère invalide. Veuillez entrer un nombre entre 0 et 9999 : ");
                nombreMystere = new Scanner(System.in).nextInt();
            }
            this.tentativesRestantes = 10;
        }
    }

    public void jouer() {
        if (!modeDevine) {
            Joueur joueur = new Joueur();
            nombreMystereDevine(joueur);
        } else {
            ordinateurDevineNombre();
        }
    }

    public void nombreMystereDevine(Joueur joueur) {
        while (!estPartieTerminee()) {
            int proposition = joueur.faireProposition();
            String reponse = comparerProposition(proposition);
            joueur.afficherReponse(reponse);
            reduireTentatives();
        }

        // La partie est terminée, affichage de la solution (si le joueur n'a pas gagné)
        if (!nombreMystereTrouve()) {
            joueur.afficherSolution(nombreMystere);
        }
    }

    public void ordinateurDevineNombre() {
        int min = 0;
        int max = 9999;
        int tentatives = 0; // Ajout du compteur de tentatives
        Joueur joueur = new Joueur();

        System.out.println("Pensez à un nombre entre 0 et 9999.");
        System.out.println("L'ordinateur va essayer de le deviner.");

        while (!nombreMystereTrouve() && tentatives < 10) {
            int proposition = min + (max - min) / 2;
            System.out.println("L'ordinateur propose le nombre : " + proposition);

            String reponse = joueur.faireReponse();
            if (reponse.equals("=")) {
                System.out.println("L'ordinateur a trouvé le nombre mystère !");
                break;
            } else if (reponse.equals("-")) {
                max = proposition - 1;
            } else {
                min = proposition + 1;
            }

            tentatives++; // Incrémenter le compteur de tentatives
        }

        if (tentatives >= 10 && !nombreMystereTrouve()) {
            System.out.println("L'ordinateur n'a pas réussi à trouver le nombre mystère en 10 tentatives.");
        }
    }

    public boolean estModeDevine() {
        return modeDevine;
    }

    public int getTentativesRestantes() {
        return tentativesRestantes;
    }

    public boolean estPartieTerminee() {
        return tentativesRestantes == 0 || nombreMystereTrouve();
    }

    public boolean nombreMystereTrouve() {
        return tentativesRestantes == 0;
    }

    public String comparerProposition(int proposition) {
        if (proposition == nombreMystere) {
            return "=";
        } else if (proposition < nombreMystere) {
            return "+";
        } else {
            return "-";
        }
    }

    public void reduireTentatives() {
        tentativesRestantes--;
    }
}
