package com.example.veriapp;

import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Tabladiinamica {
    private TableLayout tableLayout;
    private Context context;
    private ArrayList<String[]>Data;
    private TableRow tableRow;
    private TextView txtcell;


    public Tabladiinamica(TableLayout tableLayout, Context context) {
        this.tableLayout = tableLayout;
        this.context = context;
    }
    public void addData(ArrayList<String[]>Data){
        this.Data=Data;

    }
    private void newRow(){
        tableRow=new TableRow(context);

    }
    private void newcell(){
        txtcell=new TextView(context);
        txtcell.setGravity(Gravity.CENTER);
        txtcell.setTextSize(10);

    }


}
