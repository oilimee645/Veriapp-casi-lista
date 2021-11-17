package com.example.veriapp;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;


public class ConfigFragment extends Fragment {
    boolean s1, s2, s3, s4, s5;
    int p=0;
    String texto = "";
    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_config, container, false);
        SharedPreferences preferencias = getActivity().getPreferences(Context.MODE_PRIVATE);
        boolean valorSwitch5 = preferencias.getBoolean("switch5", false /* Valor default*/);
        boolean valorSwitch4 = preferencias.getBoolean("switch4", false /* Valor default*/);
        boolean valorSwitch3 = preferencias.getBoolean("switch3", false /* Valor default*/);
        boolean valorSwitch2 = preferencias.getBoolean("switch2", false /* Valor default*/);
        boolean valorSwitch1 = preferencias.getBoolean("switch1", false /* Valor default*/);

        p = cargarpreferencias();

        Switch switch1 = (Switch) view.findViewById(R.id.switch1);
        Switch switch2 = (Switch) view.findViewById(R.id.switch2);
        Switch switch3 = (Switch) view.findViewById(R.id.switch3);
        Switch switch4 = (Switch) view.findViewById(R.id.switch4);
        Switch switch5 = (Switch) view.findViewById(R.id.switch5);

        switch5.setChecked(valorSwitch5);
        switch4.setChecked(valorSwitch4);
        switch3.setChecked(valorSwitch3);
        switch1.setChecked(valorSwitch1);
        switch2.setChecked(valorSwitch2);


        if (p == 1 || p == 10) {

            switch5.setChecked(true);
            FirebaseMessaging.getInstance().subscribeToTopic("5");
            texto = " 0 y 9 ";

        } else if (p == 2 || p == 3) {
            switch4.setChecked(true);
            FirebaseMessaging.getInstance().subscribeToTopic("4");
            texto = " 1 y 2";

        } else if (p == 4 || p == 5) {
            switch3.setChecked(true);
            FirebaseMessaging.getInstance().subscribeToTopic("3");
            texto = " 3 y 4";

        } else if (p == 6 || p == 7) {
            switch1.setChecked(true);
            FirebaseMessaging.getInstance().subscribeToTopic("1");
            texto = " 5 y 6";

        } else if (p == 8 || p == 9) {
            switch2.setChecked(true);
            FirebaseMessaging.getInstance().subscribeToTopic("2");
            texto = " 7 y 8";

        }


        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (switch1.isChecked()) {

                    FirebaseMessaging.getInstance().subscribeToTopic("1");
                    s1 = true;

                } else {

                    FirebaseMessaging.getInstance().unsubscribeFromTopic("1");
                    s1 = false;

                }
                Guardarswitch1(s1);

            }
        });
        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (switch2.isChecked()) {

                    FirebaseMessaging.getInstance().subscribeToTopic("2");
                    s2 = true;

                } else {

                    FirebaseMessaging.getInstance().unsubscribeFromTopic("2");
                    s2 = false;

                }
                Guardarswitch2(s2);

            }
        });
        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (switch3.isChecked()) {

                    FirebaseMessaging.getInstance().subscribeToTopic("3");
                    s3 = true;

                } else {

                    FirebaseMessaging.getInstance().unsubscribeFromTopic("3");
                    s3 = false;

                }
                Guardarswitch3(s3);

            }
        });
        switch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (switch4.isChecked()) {

                    FirebaseMessaging.getInstance().subscribeToTopic("4");
                    s4 = true;

                } else {

                    FirebaseMessaging.getInstance().unsubscribeFromTopic("4");
                    s4 = false;

                }
                Guardarswitch4(s4);

            }
        });
        switch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (switch5.isChecked()) {

                    FirebaseMessaging.getInstance().subscribeToTopic("5");
                    s5 = true;

                } else {

                    FirebaseMessaging.getInstance().unsubscribeFromTopic("5");
                    s5 = false;

                }
                Guardarswitch5(s5);

            }
        });


        return view;
    }


    public int cargarpreferencias() {
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);


        int defaultValue = 0;


        int valorRecuperado = sharedPref.getInt("ValorPrueba", defaultValue);

        System.out.println(valorRecuperado);

        return valorRecuperado;


    }

    public void Guardarswitch1(boolean s1) {
        SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();

        editor.putBoolean("switch1", s1);
        editor.commit();
    }

    public void Guardarswitch2(boolean s2) {
        SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();

        editor.putBoolean("switch2", s2);
        editor.commit();
    }

    public void Guardarswitch3(boolean s3) {
        SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();

        editor.putBoolean("switch3", s3);
        editor.commit();
    }

    public void Guardarswitch4(boolean s4) {
        SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();

        editor.putBoolean("switch4", s4);
        editor.commit();
    }

    public void Guardarswitch5(boolean s5) {
        SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();

        editor.putBoolean("switch5", s5);
        editor.commit();
    }
}

