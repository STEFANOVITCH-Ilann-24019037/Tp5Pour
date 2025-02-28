package exoEngins;

class Flottant extends Engin {


    public Flottant( Propulsion propulsion) {
        super(propulsion);
    }

    @Override
    public void conduire() {
        System.out.println("Vous cosomer "+propulsion.consommerEnergie() + " Energies");
    }
}