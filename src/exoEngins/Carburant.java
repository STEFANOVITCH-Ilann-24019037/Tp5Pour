package exoEngins;

public abstract class Carburant {

     public static final int ID_GAZOLE = 0,ID_Essence = 1, ID_ETHANOL = 2,nbCarburants = 3;
     static double consoGazole = 49.3;
     static double consoEssence = 47.1;
     static double consoEthanol = 44.3;
     static double consoPardefaut = 3.14;

    public static String nom(int id) {
        switch(id) {
            case 0 :
                return "gazole";
            case 1 :
                return "Essence";
            case 2 :
                return "Ethanol";
            default :
                return "Ethanol";
        }



    }
    public static double getConso(int id) {
        switch(id) {
            case 0 :
                return consoGazole;
            case 1 :
                return consoEssence;
            case 2:
                return consoEthanol;
            default :
                return consoEthanol;
        }
    }
}
