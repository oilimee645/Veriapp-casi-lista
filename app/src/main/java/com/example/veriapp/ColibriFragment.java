package com.example.veriapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;


public class ColibriFragment extends Fragment {
    Handler hand = new Handler();
    private TableLayout tableLayout;
    private TableRow tableRow;
    private int o;
    private boolean firstTime = true;
    private TextView r;
    String M;
    String T;
    String sp;

    private String[] Vyt;
    String[] Muni;
    String[] Tamuni;
    String[] Gas;
    Spinner spinner, spinner2, spinner3, spinner4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Utilidades utilidades = new Utilidades();
        View view = inflater.inflate(R.layout.fragment_colibri, container, false);


        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layautparatabla);
        ImageView imageView = (ImageView) view.findViewById(R.id.f3i);
        imageView.setVisibility(View.INVISIBLE);

        r = (TextView) view.findViewById(R.id.textreq);


        r.setGravity(Gravity.CENTER);


        cargarpreferencias();
        System.out.println("-----------------------------");
        System.out.println(M);
        System.out.println("-------------------------------");
        System.out.println(sp);
        System.out.println("----------------------------");
        System.out.println(T);
        System.out.println("----------------------------");


        //spinner1

        spinner = (Spinner) view.findViewById(R.id.spinner);

        spinner.setGravity(Gravity.CENTER);

        Vyt = getResources().getStringArray(R.array.Veri);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity())
                .getApplicationContext(),
                android.R.layout.simple_spinner_item, Vyt);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //spinner2

        spinner2 = (Spinner) view.findViewById(R.id.spinner2);

        spinner2.setGravity(Gravity.CENTER);

        Muni = getResources().getStringArray(R.array.Municipios);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity()
                .getApplicationContext(),
                android.R.layout.simple_spinner_item, Muni);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //Spinner 4

        spinner4 = (Spinner) view.findViewById(R.id.spinner4);

        Tamuni = getResources().getStringArray(R.array.Tmuniciipios);

        ArrayAdapter<String> adapter2T = new ArrayAdapter<>(getActivity()
                .getApplicationContext(),
                android.R.layout.simple_spinner_item, Tamuni);

        adapter2T.setDropDownViewResource(android.R.layout.simple_spinner_item);


        //spinner3

        spinner3 = (Spinner) view.findViewById(R.id.spinner3);

        spinner3.setGravity(Gravity.CENTER);

        Gas = getResources().getStringArray(R.array.GAS);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(Objects.requireNonNull(getActivity())
                .getApplicationContext(),
                android.R.layout.simple_spinner_item, Gas);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);


        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );


        spinner.setAdapter(adapter);

        spinner2.setAdapter(adapter2);

        spinner3.setEnabled(false);
        spinner3.setClickable(false);
        imageView.setVisibility(View.INVISIBLE);
        spinner3.setVisibility(View.INVISIBLE);
        spinner3.setAdapter(adapter3);
        spinner4.setVisibility(View.INVISIBLE);
        spinner4.setAdapter(adapter2T);
        spinner4.setEnabled(false);
        spinner4.setClickable(false);


        String jsonFileContent = null;

        try {
            jsonFileContent = Utilidades.LeerJson(getActivity()
                    .getApplicationContext(), "ListaVeri.json");
            JSONArray jsonArray = new JSONArray(jsonFileContent);


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);


                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                String link = jsonObject.getString("link");
                String type = jsonObject.getString("type");
                String locality = jsonObject.getString("locality");
                String speciality = jsonObject.getString("speciality");
                if (T.equals("Todos")) {
                    sp = "default";
                } else if (T.equals("Taller")) {
                    sp = "default";
                }


                if (T.equals("Todos") && M.equals("default") && sp.equals("default")) {
                    spinner3.setEnabled(false);
                    r.setText("Todos");
                    spinner3.setClickable(false);
                    spinner3.setVisibility(View.INVISIBLE);
                    spinner4.setEnabled(false);
                    imageView.setVisibility(View.INVISIBLE);
                    Crearceldas(name, id, lp, link, linearLayout);


                } else if (type.equals(T) && M.equals("default") && sp.equals("default")) {
                    insertsp3(type, imageView, adapter2T,speciality);
                    r.setText(T);

                    Crearceldas(name, id, lp, link, linearLayout);


                } else if (type.equals(T) && locality.equals(M) && sp.equals("default")) {

                    insertsp3(type, imageView, adapter2T,speciality);
                    Crearceldas(name, id, lp, link, linearLayout);

                } else if (type.equals(T) && locality.equals(M) && speciality.equals(sp)) {

                    insertsp3(type, imageView, adapter2T,speciality);
                    Crearceldas(name, id, lp, link, linearLayout);

                } else if (type.equals(T) && M.equals("default") && speciality.equals(sp)) {
                    insertsp3(type, imageView, adapter2T,speciality);
                    Crearceldas(name, id, lp, link, linearLayout);
                } else if (T.equals("Todos") && locality.equals(M)) {

                    Crearceldas(name, id, lp, link, linearLayout);
                } else if (T.equals("Todos") && speciality.equals(sp)) {
                    insertsp3(type, imageView, adapter2T,speciality);
                    Crearceldas(name, id, lp, link, linearLayout);
                } else if (type.equals(T) && M.equals("default") && speciality.equals("default")) {
                    insertsp3(type, imageView, adapter2T,speciality);
                    Crearceldas(name, id, lp, link, linearLayout);
                }


                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (firstTime) {
                            firstTime = false;


                        } else {


                            if (i > 1) {
                                Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(), "Has elejido (" +
                                        Vyt[i] + ")" + " Selecciona el municipio", Toast.LENGTH_LONG).show();


                                T = spinner.getSelectedItem().toString();
                                r.setText(spinner.getSelectedItem().toString());
                                guardarpreferencias();

                            } else {
                                T = "default";

                            }
                            refrescar();


                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int s, long l) {
                        if (firstTime) {
                            firstTime = false;


                        } else {


                            if (s > 1) {
                                M = spinner2.getSelectedItem().toString();

                                r.setText(spinner.getSelectedItem().toString());
                                guardarpreferencias();
                                refrescar();


                            } else {
                                M="default";


                            }


                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (firstTime) {
                            firstTime = false;

                        } else {


                            if (i > 1) {
                                cargarpreferencias();
                                sp = spinner3.getSelectedItem().toString();
                                System.out.println(sp);
                                System.out.println("____________________");
                                System.out.println(cargarpreferenciasl());
                                System.out.println("____________________");

                                r.setText(spinner.getSelectedItem().toString());

                                guardarpreferencias();
                                System.out.println(spinner2.getSelectedItem().toString());
                               refrescar();



                            }if (i==1){
                                r.setText("default");
                                guardarpreferencias();
                            }

                        }


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int s, long l) {
                        if (firstTime) {
                            firstTime = false;


                        } else {


                            if (s > 1) {
                                M = spinner4.getSelectedItem().toString();
                                System.out.println(M);

                                refrescar();
                                r.setText(spinner.getSelectedItem().toString());
                                guardarpreferencias();


                            } else if (s == 0) {
                                M = "default";


                            }


                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }


        return view;
    }


    public void cargarpreferencias() {
        SharedPreferences sharedPref = Objects.requireNonNull(getContext())
                .getSharedPreferences("preferencias", Context.MODE_PRIVATE);


        String type = sharedPref.getString("tipo", "Todos");
        String local = sharedPref.getString("locality", "default");
        String speciality = sharedPref.getString("speciality", "default");



        T = type;
        M = local;
        sp = speciality;


    }
    public String cargarpreferenciasl() {
        SharedPreferences sharedPref = Objects.requireNonNull(getContext())
                .getSharedPreferences("preferencias", Context.MODE_PRIVATE);



        String local = sharedPref.getString("locality", "default");



        M = local;
        return M;


    }

    public void guardarpreferencias() {
        SharedPreferences sharedPref = Objects.requireNonNull(getContext())
                .getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        String type = T;
        String local = M;
        String speciality = sp;

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("tipo", type);
        editor.putString("locality", local);
        editor.putString("speciality", speciality);
        editor.apply();


    }

    public void Crearceldas(String name, int id, LinearLayout.LayoutParams lp, String link, LinearLayout linearLayout) {
        Button btn = new Button(Objects.requireNonNull(getActivity()).getApplicationContext());
        btn.setLayoutParams(lp);
        btn.setBackgroundResource(R.drawable.borde2);
        btn.setText(name);
        btn.setId(id);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(link);
                Intent li = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(li);
            }
        });
        linearLayout.addView(btn);
    }

    public void refrescar() {
        ColibriFragment f2 = new ColibriFragment();
        assert getFragmentManager() != null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentblank, f2);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void insertsp3(String type, ImageView imageView, ArrayAdapter adapter2T, String speciality) {
        if (type.equals("Verificentros")) {
            spinner3.setEnabled(true);
            spinner3.setClickable(true);
            spinner3.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.VISIBLE);
        } else if (type.equals("Taller")) {

            spinner3.setEnabled(false);
            spinner3.setClickable(false);
            spinner4.setVisibility(View.VISIBLE);
            spinner4.setAdapter(adapter2T);
            spinner4.setEnabled(true);
            spinner4.setClickable(true);
            spinner2.setVisibility(View.INVISIBLE);

            spinner2.setEnabled(false);
            spinner2.setClickable(false);
            spinner3.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.INVISIBLE);

        }else if (type.equals("Verificentros") && speciality.equals(sp)){
            spinner3.setEnabled(true);
            spinner3.setClickable(true);
            spinner3.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.VISIBLE);

        }
    }
}

