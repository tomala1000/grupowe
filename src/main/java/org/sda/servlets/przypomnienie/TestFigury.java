package org.sda.servlets.przypomnienie;



import org.sda.servlets.przypomnienie.interfejsy.Figura;
import org.sda.servlets.przypomnienie.interfejsy.Kolo;
import org.sda.servlets.przypomnienie.interfejsy.Prostokat;

import java.util.ArrayList;
import java.util.List;

public class TestFigury {

    public static void main(String[] args){
        Figura figura1 = new Prostokat(2, 3);
        Figura figura2 = new Kolo(3);

        List<Figura> figury = new ArrayList<>();
        figury.add(figura1);
        figury.add(figura2);

        for (Figura figura : figury) {
            System.out.println(figura.przedstawSie());
            System.out.println(figura.policzPole());
            System.out.println(figura.policzObwod());
            System.out.println("------");
        }

        for (int i = 0; i < figury.size(); i++) {
            System.out.println(figury.get(i).przedstawSie());
            System.out.println(figury.get(i).policzPole());
            System.out.println(figury.get(i).policzObwod());
            System.out.println("------");
        }

        figury.forEach(figura -> {
            System.out.println(figura.przedstawSie());
            System.out.println(figura.policzPole());
            System.out.println(figura.policzObwod());
        });
    }
}
