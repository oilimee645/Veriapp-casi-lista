package com.example.veriapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class calendarioFragment extends Fragment {
    int p=0;
    String texto="";
    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 0;
    String link="https://drive.google.com/file/d/1ynXRFEOkUbSuGgGkPIzYJWT0KcebC4Pz/view";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferencias preferencias=new preferencias();


        ConfigFragment configFragment=new ConfigFragment();
        View view = inflater.inflate(R.layout.fragment_calendario, container, false);
        TableRow tableRow1 = (TableRow) view.findViewById(R.id.celda1);
        TableRow tableRow2 = (TableRow) view.findViewById(R.id.celda2);
        TableRow tableRow3 = (TableRow) view.findViewById(R.id.celda3);
        TableRow tableRow4 = (TableRow) view.findViewById(R.id.celda4);
        TableRow tableRow5 = (TableRow) view.findViewById(R.id.celda5);
        TextView gacetatxt= (TextView) view.findViewById(R.id.gacetatxt);

        gacetatxt.setPaintFlags(gacetatxt.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        gacetatxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(link);
                Intent li = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(li);
            }
        });

        Spinner opciones = (Spinner) view.findViewById(R.id.sp01);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.Opciones, android.R.layout.simple_spinner_item);

        p = preferencias.cargarpreferencias();
        opciones.setAdapter(adapter);
        if (p==0){
            tableRow2.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow3.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow4.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow5.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow1.setBackgroundColor(Color.parseColor("#ffffff"));

        }else
        if (p == 1 || p ==10){
            tableRow2.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow3.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow4.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow5.setBackgroundColor(Color.parseColor("#084CDF"));
            tableRow1.setBackgroundColor(Color.parseColor("#ffffff"));
            texto = " Mayo-Junio Noviembre-Diciembre";



        }else if(p==2 ||  p==3){
            tableRow3.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow4.setBackgroundColor(Color.parseColor("#37D909"));
            tableRow5.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow1.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow2.setBackgroundColor(Color.parseColor("#ffffff"));
            texto = " Abril-Mayo Octubre-Noviembre";


        }else if(p==6 ||  p==7) {
            tableRow4.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow5.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow1.setBackgroundColor(Color.parseColor("#FFED33"));
            tableRow2.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow3.setBackgroundColor(Color.parseColor("#ffffff"));
            texto = "Enero-Febrero Julio-Agosto";


        }else if(p==4 ||  p==5) {
            tableRow5.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow1.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow2.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow3.setBackgroundColor(Color.parseColor("#DF0808"));
            tableRow4.setBackgroundColor(Color.parseColor("#ffffff"));
            texto = "Marzo-Abril Septiembre-Octubre";


        }else if(p==8 ||  p==9) {
            tableRow1.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow2.setBackgroundColor(Color.parseColor("#FF33BB"));
            tableRow3.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow4.setBackgroundColor(Color.parseColor("#ffffff"));
            tableRow5.setBackgroundColor(Color.parseColor("#ffffff"));
            texto = "Febrero-Marzo Agosto-Septiembre";




        }

        opciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {




            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                p=i;

                if(i>0){
                    if (i == 1 || i ==10){
                        tableRow2.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow3.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow4.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow5.setBackgroundColor(Color.parseColor("#084CDF"));
                        tableRow1.setBackgroundColor(Color.parseColor("#ffffff"));
                        texto = " Mayo-Junio Noviembre-Diciembre";

                        preferencias.Guardarpreferencias(opciones.getSelectedItemPosition());
                    }else if(i==2 ||  i==3){
                        tableRow3.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow4.setBackgroundColor(Color.parseColor("#37D909"));
                        tableRow5.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow1.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow2.setBackgroundColor(Color.parseColor("#ffffff"));
                        texto = " Abril-Mayo Octubre-Noviembre";

                        preferencias.Guardarpreferencias(opciones.getSelectedItemPosition());
                    }else if(i==6 ||  i==7) {
                        tableRow4.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow5.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow1.setBackgroundColor(Color.parseColor("#FFED33"));
                        tableRow2.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow3.setBackgroundColor(Color.parseColor("#ffffff"));
                        texto = "Enero-Febrero Julio-Agosto";

                        preferencias.Guardarpreferencias(opciones.getSelectedItemPosition());
                    }else if(i==4 ||  i==5) {
                        tableRow5.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow1.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow2.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow3.setBackgroundColor(Color.parseColor("#DF0808"));
                        tableRow4.setBackgroundColor(Color.parseColor("#ffffff"));
                        texto = "Marzo-Abril Septiembre-Octubre";

                        preferencias.Guardarpreferencias(opciones.getSelectedItemPosition());
                    }else if(i==8 ||  i==9) {
                        tableRow1.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow2.setBackgroundColor(Color.parseColor("#FF33BB"));
                        tableRow3.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow4.setBackgroundColor(Color.parseColor("#ffffff"));
                        tableRow5.setBackgroundColor(Color.parseColor("#ffffff"));
                        texto = "Febrero-Marzo Agosto-Septiembre";

                        preferencias.Guardarpreferencias(opciones.getSelectedItemPosition());


                    }




                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }



        });return view;


    }


    public class preferencias{
        public void Guardarpreferencias(int position){
            SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();


            editor.putInt("ValorPrueba", position);


            editor.commit();



        }
        public int cargarpreferencias(){
            SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);


            int defaultValue = 0;


            int valorRecuperado = sharedPref.getInt("ValorPrueba", defaultValue);

            System.out.println(valorRecuperado);

            return valorRecuperado;



        }

    }



}


