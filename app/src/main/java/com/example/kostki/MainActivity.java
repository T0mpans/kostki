package com.example.kostki;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button przyciskRzuc;
    ImageView kostka1, kostka2, kostka3, kostka4,kostka5;
    TextView textViewWynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        przyciskRzuc = findViewById(R.id.buttonrzuc);
        kostka1 = findViewById(R.id.imageView1);
        kostka2 = findViewById(R.id.imageView2);
        kostka3 = findViewById(R.id.imageView3);
        kostka4 = findViewById(R.id.imageView4);
        kostka5 = findViewById(R.id.imageView5);
        textViewWynik = findViewById(R.id.textViewWynik);

        int[]listaZdjec = new int[]{
                R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6
        };

        ArrayList<ImageView> obrazki = new ArrayList<>();
        obrazki.add(kostka1);
        obrazki.add(kostka2);
        obrazki.add(kostka3);
        obrazki.add(kostka4);
        obrazki.add(kostka5);

        przyciskRzuc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println(losujKostke(5, textViewWynik, listaZdjec, obrazki));
                    }
                }
        );

    }
    public static int losujKostke(int ileKostek, TextView textViewWynik, int[]listaZdjec, ArrayList<ImageView> obrazki) {
        Random random = new Random();

        int[] lista = new int[ileKostek];

        for (int i = 1; i <= ileKostek; i++) {
            int wynikRzutu = random.nextInt(6)+1;
            System.out.println("Kostka " + i + ": " + wynikRzutu);
            lista[i - 1] = wynikRzutu;
            obrazki.get(i - 1).setImageResource(listaZdjec[wynikRzutu-1]);
        }
        return obliczPunkty(lista, textViewWynik);
    }

    public static int obliczPunkty(int[] lista, TextView textViewWynik) {
        int[] indeksy = new int[]{0, 0, 0, 0, 0, 0};
        int wynik2 = 0;
        for (int i = 0; i < lista.length; i++) {
            indeksy[lista[i]-1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (indeksy[i] >= 2) {
                wynik2 += (i + 1) * indeksy[i];
            }
        }
        textViewWynik.setText("Wynik tego losowania: "+wynik2);
        return wynik2;
    }
}