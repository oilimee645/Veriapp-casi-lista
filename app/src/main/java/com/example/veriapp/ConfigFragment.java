package com.example.veriapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;


public class ConfigFragment extends Fragment {
    int p;
    String texto="";
    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_config, container, false);


        p = cargarpreferencias();

        Switch switch1 = (Switch) view.findViewById(R.id.switch1);
        Switch switch2 = (Switch) view.findViewById(R.id.switch2);
        Switch switch3 = (Switch) view.findViewById(R.id.switch3);
        Switch switch4 = (Switch) view.findViewById(R.id.switch4);
        Switch switch5 = (Switch) view.findViewById(R.id.switch5);


        if (p == 1 || p == 10) {

            switch5.setChecked(true);
            texto = " 0 y 9";
            createNotification(texto);
            createNotificationChannel();



        } else if (p == 2 || p == 3) {
            switch4.setChecked(true);
            texto = " 1 y 2";
            createNotification(texto);
            createNotificationChannel();


        } else if (p == 4 || p == 5) {
            switch3.setChecked(true);
            texto = " 3 y 4";
            createNotification(texto);
            createNotificationChannel();


        } else if (p == 6 || p == 7) {
            switch1.setChecked(true);
            texto = " 5 y 6";
            createNotification(texto);
            createNotificationChannel();


        } else if (p == 8 || p == 9) {
            switch2.setChecked(true);
            texto = " 7 y 8";
            createNotification(texto);
            createNotificationChannel();


        }


        return view;
    }


    public int cargarpreferencias() {
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);


        int defaultValue = 0;


        int valorRecuperado = sharedPref.getInt("ValorPrueba", defaultValue);

        System.out.println(valorRecuperado);

        return valorRecuperado;


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Noticacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    void createNotification(String texto) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity().getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentTitle("Informacion Pendiente");
        builder.setContentText("Recuerda que inicia el periodo de verificación vehicular de la terminación de placa "+ texto +" primer semestre");
        builder.setColor(Color.BLUE);
        builder.setStyle(new NotificationCompat.BigTextStyle()
                .bigText("Recuerda que inicia el periodo de verificación vehicular de la terminación de placa "+ texto +" primer semestre"));
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.MAGENTA, 1000, 1000);
        builder.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getActivity().getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());

    }

}
