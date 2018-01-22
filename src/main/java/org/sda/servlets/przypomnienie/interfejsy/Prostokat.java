package org.sda.servlets.przypomnienie.interfejsy;

public class Prostokat implements Figura {

    private int a;
    private int b;

    public Prostokat(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String przedstawSie() {
        return "Jestem prostokatem";
    }

    @Override
    public double policzPole() {
        return a * b;
    }

    @Override
    public double policzObwod() {
        return 2 * a + 2 * b;
    }

}