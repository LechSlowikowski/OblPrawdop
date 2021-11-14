package com.example.oblprawdop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private double obliczSilnie(int n){
        double silnia = 1;
        for (int i = 1; i <= n; i++) {
            silnia = silnia * i;
        }
        return silnia;
    }

    private double obliczKombinacje(int n, int k){
        double silniaN = obliczSilnie(n);
        double silniaK = obliczSilnie(k);
        double silniaNminusK = obliczSilnie(n-k);
        return silniaN/(silniaK*silniaNminusK);
    }


    public void oblicz(View view) {
        EditText liczbaKul = (EditText) findViewById(R.id.liczbaKul);
        String liczbaKulStr = liczbaKul.getText().toString();
        if(liczbaKulStr.length()==0) {
            liczbaKulStr = "0";
        }
        int liczbaKulInt = Integer.parseInt(liczbaKulStr);

        EditText liczbaLosowanych = (EditText) findViewById(R.id.liczbaLosowanych);
        String liczbaLosowanychStr = liczbaLosowanych.getText().toString();
        if(liczbaLosowanychStr.length()==0){
            liczbaLosowanychStr = "0";
        }
        int liczbaLosowanychInt = Integer.parseInt(liczbaLosowanychStr);

        TextView komunikat = (TextView) findViewById(R.id.komunikat);
         String komunikatStr = "" ;

        if(liczbaKulInt==0) {
            komunikatStr = "Liczba kul jest wymagana. ";
        }
        if(liczbaLosowanychInt==0) {
            komunikatStr += "Liczba losowanych jest wymagana";
        }

        if(liczbaKulInt < liczbaLosowanychInt){
            komunikatStr += "Liczba kul musi być większa od liczby losowanych";
        }

        if(komunikatStr.length()==0){
            double wynik = obliczKombinacje(liczbaKulInt, liczbaLosowanychInt);
            long wynikL = Math.round(wynik);
            komunikatStr = "Liczba możliwych kombinacji wynosi: " + wynikL;
        }

        komunikat.setText(komunikatStr);

    }
}