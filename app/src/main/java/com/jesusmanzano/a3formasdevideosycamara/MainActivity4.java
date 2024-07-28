package com.jesusmanzano.a3formasdevideosycamara;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button AcceleRacers;
    Button AcceleRacers1;
    Button Battleforce5;
    Button Battleforce51;
    Button johnnytest;
    Button jonytest1;
    Button Jovenestitanes;
    Button thundercats;
    Button dbz;
    Button Atrasar;
    Button Adelantar;
    Button play_pause;
    Button nuevaActividadButton; // Nuevo botón
    TextView nombre;
    TextView usuarioyedad;
    Button Atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        AcceleRacers = findViewById(R.id.AcceleRacers);
        AcceleRacers1 = findViewById(R.id.AcceleRacers1);
        Battleforce5 = findViewById(R.id.Battleforce5);
        Battleforce51 = findViewById(R.id.battleforce51);
        johnnytest = findViewById(R.id.johnnytest);
        jonytest1 = findViewById(R.id.johnnytest1);
        Jovenestitanes = findViewById(R.id.losjovenestitanes);
        thundercats = findViewById(R.id.thundercats);
        dbz = findViewById(R.id.dbz);
        Atrasar = findViewById(R.id.Atrasar);
        Adelantar = findViewById(R.id.Adelantar);
        play_pause = findViewById(R.id.play_pause);
        nuevaActividadButton = findViewById(R.id.Atras);
        Atras = findViewById(R.id.Atras);

        nombre = findViewById(R.id.nombre);

        mediaPlayer = new MediaPlayer();

        play_pause.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                Toast.makeText(MainActivity4.this, "Pausa", Toast.LENGTH_SHORT).show();
            } else {
                mediaPlayer.start();
                Toast.makeText(MainActivity4.this, "Play", Toast.LENGTH_SHORT).show();
            }
        });

        Atrasar.setOnClickListener(v -> {
            int currentPosition = mediaPlayer.getCurrentPosition();
            mediaPlayer.seekTo(Math.max(0, currentPosition - 5000));
            Toast.makeText(MainActivity4.this, "Video atrasado 5 segundos", Toast.LENGTH_SHORT).show();
        });

        Adelantar.setOnClickListener(v -> {
            int currentPosition = mediaPlayer.getCurrentPosition();
            mediaPlayer.seekTo(currentPosition + 5000);
            Toast.makeText(MainActivity4.this, "Video adelantado 5 segundos", Toast.LENGTH_SHORT).show();
        });

        AcceleRacers.setOnClickListener(v -> playVideo(R.raw.acelera, R.string.AcceleRacers));
        AcceleRacers1.setOnClickListener(v -> playVideo(R.raw.go, "Go AcceleRacers"));
        Battleforce5.setOnClickListener(v -> playVideo(R.raw.bf5curiosidades, "Battle Force 5 Curiosidades"));
        Battleforce51.setOnClickListener(v -> playVideo(R.raw.drive_to_survive, "Localizado Y Perdido"));
        johnnytest.setOnClickListener(v -> playVideo(R.raw.regresoajohnny_mon, "Regreso a Johnny-mon"));
        jonytest1.setOnClickListener(v -> playVideo(R.raw.johnny_el_lanzallamas, "johnny el Lanzallamas"));
        Jovenestitanes.setOnClickListener(v -> playVideo(R.raw.jovenes, "Se Acabo La Cita"));
        thundercats.setOnClickListener(v -> playVideo(R.raw.thundercats_opening, "thundercats Opening"));
        dbz.setOnClickListener(v -> playVideo(R.raw.dragon_ball_z, "Vegeta Destruye la máquina de fuerza :("));

        // Configurar el Intent para el nuevo botón
        nuevaActividadButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity4.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void playVideo(int videoResId, int stringResId) {
        playVideo(videoResId, getString(stringResId));
    }

    private void playVideo(int videoResId, String info) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.reset();
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videoResId);
        try {
            mediaPlayer.setDataSource(this, videoUri);
            mediaPlayer.setOnPreparedListener(mp -> {
                mediaPlayer.start();
                nombre.setText(info);
            });
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity4.this, "Error al reproducir el video", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
