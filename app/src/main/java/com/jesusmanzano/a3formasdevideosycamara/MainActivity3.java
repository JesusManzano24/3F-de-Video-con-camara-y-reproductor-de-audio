package com.jesusmanzano.a3formasdevideosycamara;

import android.content.Intent;
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
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity implements SurfaceHolder.Callback {

    MediaPlayer mediaPlayer;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    Button Avengers;
    Button deadpool;
    Button Avengers1;
    Button IronMan;
    Button galaga;
    Button ungenio;
    Button yosoy;
    Button ultron;
    Button ultron2;
    Button Atrasar;
    Button Adelantar;
    Button play_pause;
    Button nuevaActividadButton; // Nuevo botón
    TextView nombre;
    TextView usuarioyedad;
    Uri currentVideoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        surfaceView = findViewById(R.id.video2);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);

        deadpool = findViewById(R.id.b1);
        Avengers = findViewById(R.id.b2);
        Avengers1 = findViewById(R.id.b3);
        IronMan = findViewById(R.id.b4);
        galaga = findViewById(R.id.b5);
        ungenio = findViewById(R.id.b6);
        yosoy = findViewById(R.id.b7);
        ultron = findViewById(R.id.b8);
        ultron2 = findViewById(R.id.b9);
        Atrasar = findViewById(R.id.Atrasar);
        Adelantar = findViewById(R.id.Adelantar);
        play_pause = findViewById(R.id.play_pause);
        nuevaActividadButton = findViewById(R.id.menu);

        nombre = findViewById(R.id.nombre);

        // Configuración de los botones
        deadpool.setOnClickListener(v -> playVideo(R.raw.deadpool, R.string.Deadpool));
        Avengers.setOnClickListener(v -> playVideo(R.raw.avengers, R.string.avengers));
        Avengers1.setOnClickListener(v -> playVideo(R.raw.avenger1, R.string.avengers1));
        IronMan.setOnClickListener(v -> playVideo(R.raw.nuevomark50, R.string.ironman));
        galaga.setOnClickListener(v -> playVideo(R.raw.galaga, R.string.galaga));
        ungenio.setOnClickListener(v -> playVideo(R.raw.ungenio, R.string.ungenio));
        yosoy.setOnClickListener(v -> playVideo(R.raw.yosoyironman, R.string.yosoy));
        ultron.setOnClickListener(v -> playVideo(R.raw.avengersageofultron, R.string.ultron));
        ultron2.setOnClickListener(v -> playVideo(R.raw.eradeultron, R.string.ultron2));

        play_pause.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    Toast.makeText(MainActivity3.this, "Pausa", Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayer.start();
                    Toast.makeText(MainActivity3.this, "Play", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Atrasar.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                mediaPlayer.seekTo(Math.max(0, currentPosition - 5000));
                Toast.makeText(MainActivity3.this, "Video atrasado 5 segundos", Toast.LENGTH_SHORT).show();
            }
        });

        Adelantar.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                mediaPlayer.seekTo(currentPosition + 5000);
                Toast.makeText(MainActivity3.this, "Video adelantado 5 segundos", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar el Intent para el nuevo botón
        nuevaActividadButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void playVideo(int videoResId, int textResId) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        String videoPath = "android.resource://" + getPackageName() + "/" + videoResId;
        currentVideoUri = Uri.parse(videoPath);
        mediaPlayer = MediaPlayer.create(this, currentVideoUri);
        mediaPlayer.setDisplay(surfaceHolder);
        mediaPlayer.start();
        nombre.setText(textResId);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Reproducir el video actual si existe
        if (currentVideoUri != null) {
            mediaPlayer = MediaPlayer.create(this, currentVideoUri);
            mediaPlayer.setDisplay(surfaceHolder);
            mediaPlayer.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // No hace nada
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
