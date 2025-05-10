public class Jeu {
    private final Banque banque;
    private boolean estOuvert;

    public Jeu(Banque labanque) {
        this.banque = labanque;
        this.estOuvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!estOuvert) {
            throw new JeuFermeException("Le jeu est fermé");
        }

        int mise = joueur.mise();
        try {
            joueur.debiter(mise);
        } catch (DebitImpossibleException e) {
            return;
        }

        banque.crediter(mise);

        int somme = de1.lancer() + de2.lancer();

        if (somme == 7) {
            int gain = mise * 2;
            banque.debiter(gain);
            joueur.crediter(gain);

            if (!banque.est_solvable()) {
                fermer();
            }
        }
    }

    public void fermer() {
        estOuvert = false;
    }

    public boolean estOuvert() {
        return estOuvert;
    }
}