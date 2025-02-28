package cinema;

import java.util.ArrayList;
import java.util.List;

public class Spectateur {
    private String nom;
    private List<Film> filmsVus;

    public Spectateur(String nom) {
        this.nom = nom;
        this.filmsVus = new ArrayList<>();
    }

    public List<Film> getFilmsVus() {
        return filmsVus;
    }

    public boolean aVuLeFilm(String titre, int duree) {
        for (Film film : filmsVus) {
            if (film.getTitre().equals(titre) && film.getDuree() == duree) {
                return true;
            }
        }
        filmsVus.add(new Film(titre, duree));
        return false;
    }

    public Film getLeFilmLePlusLong() {
        if (filmsVus.isEmpty()) {
            return null;
        }
        Film filmLePlusLong = filmsVus.get(0);
        for (Film film : filmsVus) {
            if (film.getDuree() > filmLePlusLong.getDuree()) {
                filmLePlusLong = film;
            }
        }
        return filmLePlusLong;
    }

    public double getReduction() {
        Film filmLePlusLong = getLeFilmLePlusLong();
        if (filmLePlusLong != null && filmLePlusLong.getDuree() > 120) {
            return 0.1;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        if (filmsVus.isEmpty()) {
            return "Le spectateur " + nom + " bénéficie d'une réduction de " + getStringReduction() + "\nPas de film vu à ce jour";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Le spectateur ").append(nom).append(" bénéficie d'une réduction de ").append(getStringReduction()).append("\nListe des films vus :\n");
        for (Film film : filmsVus) {
            sb.append(film).append("\n");
        }
        return sb.toString();
    }

    public String getStringReduction() {
        return (getReduction() * 100) + " %";
    }
}

