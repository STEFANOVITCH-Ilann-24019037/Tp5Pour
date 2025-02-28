package cinema;

public class Film {
    private String titre;
    private int duree;

    public Film(String titre, int duree) {
        this.titre = titre;
        this.duree = duree;
    }

    public String getTitre() {
        return titre;
    }

    public int getDuree() {
        return duree;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Film film = (Film) obj;
        return duree == film.duree && titre.equals(film.titre);
    }

    @Override
    public String toString() {
        return titre + " : " + duree + " min";
    }
}
