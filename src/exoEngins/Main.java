package exoEngins;

public class Main {

    public static void main(String[] args) {
        Propulsion moteur = new Electrique(13);
        System.out.println(moteur);
        moteur = new Thermique(51, Carburant.ID_GAZOLE);
        System.out.println(moteur);
        Engin tractopelle = new Roulant(new Thermique(27, Carburant.ID_ETHANOL));
        System.out.println(tractopelle);
        tractopelle.conduire();
        Engin vaisseau = new Flottant(new Electrique(64));
        vaisseau.conduire();
    }

}