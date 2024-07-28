package com.jesusmanzano.a3formasdevideosycamara;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    VideoView videoView;
    Button PeroYaNo;
    Button siestuviesemosjuntos;
    Button Solia1;
    Button Tuyo;
    Button EnergiaBacana;
    Button dondeseaprendeaquerer;
    Button Adios;
    Button Tarde;
    Button TeMarquePedo;
    Button Atrasar;
    Button Adelantar;
    Button play_pause;
    TextView nombre;
    boolean isPlaying = false;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        videoView = findViewById(R.id.video1);
        PeroYaNo = findViewById(R.id.peroyano);
        siestuviesemosjuntos = findViewById(R.id.siestuviesemosjuntos);
        Solia1 =findViewById(R.id.Solia);
        Tuyo = findViewById(R.id.Tuyo);
        EnergiaBacana = findViewById(R.id.EnergiaBacana);
        Adios =findViewById(R.id.Adios);
        Tarde = findViewById(R.id.Tarde);
        dondeseaprendeaquerer =findViewById(R.id.DondeSeAprendeAQuerer);
        TeMarquePedo = findViewById(R.id.TeMarquePedo);
        Atrasar=findViewById(R.id.Atrasar);
        Adelantar = findViewById(R.id.Adelantar);
        play_pause = findViewById(R.id.play_pause);

        nombre = findViewById(R.id.nombre);


        // Carga el archivo de video inicial
        String initialVideoPath = "android.resource://" + getPackageName() + "/" + R.raw.pero_ya_no;
        videoView.setVideoURI(Uri.parse(initialVideoPath));

        play_pause.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause();
                Toast.makeText(MainActivity2.this, "Pausa", Toast.LENGTH_SHORT).show();
            } else {
                videoView.start();
                Toast.makeText(MainActivity2.this, "Play", Toast.LENGTH_SHORT).show();
            }
        });
        Atrasar.setOnClickListener(v -> {
            int currentPosition = videoView.getCurrentPosition();
            if (videoView.isPlaying()) {
                videoView.seekTo(Math.max(0, currentPosition - 5000));
                Toast.makeText(MainActivity2.this, "Video atrasado 5 segundos", Toast.LENGTH_SHORT).show();
            }
        });
        Adelantar.setOnClickListener(v -> {
            int currentPosition = videoView.getCurrentPosition();
            if (videoView.isPlaying()) {
                videoView.seekTo(currentPosition + 5000);
                Toast.makeText(MainActivity2.this, "Video adelantado 5 segundos", Toast.LENGTH_SHORT).show();
            }
        });

        PeroYaNo.setOnClickListener(v -> {
            videoView.setVideoURI(Uri.parse(initialVideoPath));
            videoView.start();
            nombre.setText(R.string.pero_ya_no);
        });

        siestuviesemosjuntos.setOnClickListener(v -> {
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.si_estuviesemos_juntos;
            videoView.setVideoURI(Uri.parse(videoPath));
            videoView.start();
            String info = "Si Estuviésemos Juntos";
            nombre.setText(info);
        });
        Solia1.setOnClickListener(v -> {
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.solia;
            videoView.setVideoURI(Uri.parse(videoPath));
            videoView.start();
            String info = "Solía";
            nombre.setText(info);
        });
        Tuyo.setOnClickListener(v -> {
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.tuyo;
            videoView.setVideoURI(Uri.parse(videoPath));
            videoView.start();
            String info = "Tuyo";
            nombre.setText(info);
        });
        EnergiaBacana.setOnClickListener(v -> {
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.energia_bacana;
            videoView.setVideoURI(Uri.parse((videoPath)));
            videoView.start();
            String info = "Energia Bacana";
            nombre.setText(info);
        });
        dondeseaprendeaquerer.setOnClickListener(v -> {
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.donde_se_aprende_a_querer;
            videoView.setVideoURI(Uri.parse((videoPath)));
            videoView.start();
            String info = "Donde Se Aprende A Querer";
            nombre.setText(info);
        });
        Adios.setOnClickListener(v -> {
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.adios;
            videoView.setVideoURI(Uri.parse((videoPath)));
            videoView.start();
            String info = "Adios";
            nombre.setText(info);
        });
        Tarde.setOnClickListener(v -> {
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.tarde;
            videoView.setVideoURI(Uri.parse((videoPath)));
            videoView.start();
            String info = "Tarde";
            nombre.setText(info);
        });
        TeMarquePedo.setOnClickListener(v -> {
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.te_marque_pedo;
            videoView.setVideoURI(Uri.parse((videoPath)));
            videoView.start();
            String info = "Te Marque Pedo :(";
            nombre.setText(info);
        });


    }
}