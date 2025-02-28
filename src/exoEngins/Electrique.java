package exoEngins;


    class Electrique extends Propulsion {
        private static double perte = 62;
        private static double baseConso = 3.14;
        private double masse;

        //Constructor
        public Electrique(double poids) {
            this.masse = poids*10;
        }
        //Mes Getter/Setter
        public double getMasse() {
            return masse;
        }
        public void setMasse(double masse) {
            this.masse = masse;
        }
        public static double getPerte() {
            return perte;
        }
        public static void setPerte(double perte) {
            Electrique.perte = perte;
        }
        public static double getBaseConso() {
            return baseConso;
        }
        public static void setBaseConso(double baseConso) {
            Electrique.baseConso = baseConso;
        }

        //Mes fonction apart
        @Override
        public double consommerEnergie() {
            return baseConso * masse + perte;
        }

        @Override
        public String toString() {
            return "Electrique [ "+masse+"]";
        }
    }

