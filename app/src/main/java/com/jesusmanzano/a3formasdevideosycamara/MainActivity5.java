package com.jesusmanzano.a3formasdevideosycamara;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {

    Button play_pause;
    Button Monaco;
    Button NadieSabe;
    Button Fina;
    Button Hibiki;
    Button MR_OCTOBER;
    Button CYBERTRUCK;
    Button VOU_787;
    Button SEDA;
    Button GRACIAS_POR_NADA;
    MediaPlayer mp;
    ImageView imageView;
    TextView nombre;
    boolean isPlaying = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        play_pause = findViewById(R.id.play_pause);
        Monaco = findViewById(R.id.Monaco);
        NadieSabe =findViewById(R.id.NadieSabe1);
        Fina = findViewById(R.id.Fina);
        Hibiki = findViewById(R.id.Hibiki);
        MR_OCTOBER= findViewById(R.id.MR_OCTOBER);
        CYBERTRUCK= findViewById(R.id.CYBERTRUCK);
        VOU_787= findViewById(R.id.VOU_787);
        SEDA = findViewById(R.id.SEDA);
        GRACIAS_POR_NADA= findViewById(R.id.GRACIAS_POR_NADA);
        mp = MediaPlayer.create(this, R.raw.n1);

        imageView = findViewById(R.id.image);

        nombre= findViewById(R.id.nombre);

        play_pause.setOnClickListener(v -> {
            if (isPlaying) {
                mp.pause();
                Toast.makeText(MainActivity5.this, "Pausa", Toast.LENGTH_SHORT).show();
            } else {
                mp.start();
                Toast.makeText(MainActivity5.this, "Play", Toast.LENGTH_SHORT).show();
            }
            isPlaying = !isPlaying; // Cambia el estado de reproducción
        });

        NadieSabe.setOnClickListener(v -> {
            mp.release(); // Libera la memoria de la canción anterior
            mp = MediaPlayer.create(MainActivity5.this, R.raw.n1);
            mp.start();
            Toast.makeText(MainActivity5.this, "Reproduciendo otra canción", Toast.LENGTH_SHORT).show();
            isPlaying = true; // Establece el estado de reproducción
            imageView.setImageResource(R.drawable.nadiesabe);
            String info = " Nadie Sabe";
            nombre.setText(info);

        });
        Monaco.setOnClickListener(v -> {
            mp.release();
            mp = MediaPlayer.create(MainActivity5.this, R.raw.monaco);
            mp.start();
            Toast.makeText(MainActivity5.this, "Reproduciendo otra canción", Toast.LENGTH_SHORT).show();
            isPlaying = true;
            imageView.setImageResource(R.drawable.monaco);
            String info = " Monaco";
            nombre.setText(info);
        });
        Fina.setOnClickListener(v -> {
            mp.release();
            mp = MediaPlayer.create(MainActivity5.this, R.raw.fina);
            mp.start();
            Toast.makeText(MainActivity5.this, "Reproduciendo otra canción", Toast.LENGTH_SHORT).show();
            isPlaying = true;
            imageView.setImageResource(R.drawable.fina);
            String info = " Fina";
            nombre.setText(info);
        });
        Hibiki.setOnClickListener(v -> {
            mp.release();
            mp = MediaPlayer.create(MainActivity5.this, R.raw.hibiki);
            mp.start();
            Toast.makeText(MainActivity5.this, "Reproduciendo otra canción", Toast.LENGTH_SHORT).show();
            isPlaying = true;
            imageView.setImageResource(R.drawable.hibiki);
            String info = " HIBIKI";
            nombre.setText(info);
        });
        MR_OCTOBER.setOnClickListener(v -> {
            mp.release();
            mp = MediaPlayer.create(MainActivity5.this, R.raw.mroctober);
            mp.start();
            Toast.makeText(MainActivity5.this, "Reproduciendo otra canción", Toast.LENGTH_SHORT).show();
            isPlaying = true;
            imageView.setImageResource(R.drawable.mroctober);
            String info = " MR.OCTOBER";
            nombre.setText(info);
        });
        CYBERTRUCK.setOnClickListener(v -> {
            mp.release();
            mp = MediaPlayer.create(MainActivity5.this, R.raw.cybertruck);
            mp.start();
            Toast.makeText(MainActivity5.this, "Reproduciendo otra canción", Toast.LENGTH_SHORT).show();
            isPlaying = true;
            imageView.setImageResource(R.drawable.cybertruck);
            String info = " CYBERTUCK";
            nombre.setText(info);
        });
        VOU_787.setOnClickListener(v -> {
            mp.release();
            mp = MediaPlayer.create(MainActivity5.this, R.raw.vou787);
            mp.start();
            Toast.makeText(MainActivity5.this, "Reproduciendo otra canción", Toast.LENGTH_SHORT).show();
            isPlaying = true;
            imageView.setImageResource(R.drawable.vou787);
            String info = " VOU 787";
            nombre.setText(info);
        });
        SEDA.setOnClickListener(v -> {
            mp.release();
            mp = MediaPlayer.create(MainActivity5.this, R.raw.seda);
            mp.start();
            Toast.makeText(MainActivity5.this, "Reproduciendo otra canción", Toast.LENGTH_SHORT).show();
            isPlaying = true;
            imageView.setImageResource(R.drawable.seda);
            String info = " SEDA";
            nombre.setText(info);
        });
        GRACIAS_POR_NADA.setOnClickListener(v -> {
            mp.release();
            mp = MediaPlayer.create(MainActivity5.this, R.raw.graciaspornada);
            mp.start();
            Toast.makeText(MainActivity5.this, "Reproduciendo otra canción", Toast.LENGTH_SHORT).show();
            isPlaying = true;
            imageView.setImageResource(R.drawable.graciaspornada);
            String info = " GRACIAS POR NADA";
            nombre.setText(info);
        });
    }
}