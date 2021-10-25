package com.example.veriapp;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DocFragment extends Fragment {
String link= "https://citaverificacion.edomex.gob.mx/RegistroCitas/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doc, container, false);
        TextView tv= (TextView) view.findViewById(R.id.textView10);
        tv.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        TextView tv1= (TextView) view.findViewById(R.id.textView11);
        tv1.setPaintFlags(tv.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        TextView aagendartxt = (TextView)  view.findViewById(R.id.agendartext);
        aagendartxt.setPaintFlags(aagendartxt.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        aagendartxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link = Uri.parse(link);
                Intent li = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(li);
            }
        });


        return view;

    }
}