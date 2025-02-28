package exoEngins;

class Thermique extends Propulsion {
	
    private int carburant;
    private static double perte = 64;
    private double masse;

    //Constructor
    public Thermique(double masse, int carburant) {
        this.masse = masse;
        this.carburant = carburant;
    }


	//Getter/Setter
    public static double getPerte() {
        return perte;
    }
    public static void setPerte(double p) {
        perte = p;
    }
    public int getCarburant() {
        return carburant;
    }
    public void setCarburant(int carburant) {
        this.carburant = carburant;
    }
    public double getMasse() {
        return masse;
    }
    public void setMasse(double masse) {
        this.masse = masse;
    }

    //Fonction
    @Override
    public double consommerEnergie() {
        return Carburant.getConso(carburant) * masse + perte;
    }

    @Override
    public String toString() {
        return "Thermique{" +
                "carburant=" + carburant +
                ", masse=" + masse +
                '}';
    }

}
