package cinema;

public class Abonne extends Spectateur {
    private double reductionAbonnement;

    public Abonne(String nom, double reductionAbonnement) {
        super(nom);
        this.reductionAbonnement = reductionAbonnement;
    }

    @Override
    public double getReduction() {
        double reductionSpectateur = super.getReduction();
        return reductionAbonnement + reductionSpectateur;
    }

    public static void main(String[] args) {
        Spectateur spectateur1 = new Spectateur("Jean");
        spectateur1.aVuLeFilm("E.T. L'extra-terrestre", 115);
        spectateur1.aVuLeFilm("Orange mécanique", 136);
        System.out.println(spectateur1);

        Spectateur spectateur2 = new Spectateur("Marie");
        System.out.println(spectateur2);

        Abonne abonne = new Abonne("Paul", 0.2);
        abonne.aVuLeFilm("Le Seigneur des Anneaux", 200);
        System.out.println(abonne);
    }
}

