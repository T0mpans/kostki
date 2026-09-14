package com.example.kostki;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button przyciskRzuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        przyciskRzuc.findViewById(R.id.buttonrzuc);

        przyciskRzuc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println(losujKostke(5));
                    }
                }
        );

    }
    public static int losujKostke(int ileKostek) {
        Random random = new Random();

        int[] lista = new int[ileKostek];

        for (int i = 1; i <= ileKostek; i++) {
            int wynikRzutu = random.nextInt(6)+1;
            System.out.println("Kostka " + i + ": " + wynikRzutu);
            lista[i - 1] = wynikRzutu;
        }
        return obliczPunkty(lista);
    }

    public static int obliczPunkty(int[] lista) {
        int[] indeksy = new int[]{0, 0, 0, 0, 0, 0};
        int wynik2 = 0;
        for (int i = 0; i < lista.length; i++) {
            indeksy[lista[i] - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (indeksy[i] >= 2) {
                wynik2 += (i + 1) * indeksy[i];
            }
        }
        return wynik2;
    }
}