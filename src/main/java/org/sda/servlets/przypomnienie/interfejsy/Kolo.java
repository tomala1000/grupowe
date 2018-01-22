package org.sda.servlets.przypomnienie.interfejsy;

public class Kolo implements Figura {

    private int r;

    public Kolo(int r) {
        this.r = r;
    }

    @Override
    public String przedstawSie() {
        return "Jestem kołem";
    }

    @Override
    public double policzPole() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public double policzObwod() {
        return 2 * Math.PI * r;
    }
}