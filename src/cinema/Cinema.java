package cinema;

public class Cinema {
    public static void main(String[] args) {
        Film film1 = new Film("E.T. L'extra-terrestre", 115);
        Film film2 = new Film("Orange mécanique", 136);

        System.out.println("Les films sont égaux : " + film1.equals(film2));
        System.out.println(film1);
        System.out.println(film2);
    }
}
