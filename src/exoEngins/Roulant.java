package exoEngins;

class Roulant extends Engin {
    public Roulant( Propulsion propulsion) {
        super(propulsion);
    }

    @Override
    public void conduire() {
        System.out.println("(SIMULATION) Conduire cet engin roulant nécessite un moteur à propulsion " +
                getPropulsion().getClass().getSimpleName() +
                " dont la consommation d'énergie est de " + getPropulsion().consommerEnergie() + ".");
    }
}
