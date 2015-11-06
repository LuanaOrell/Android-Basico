package com.example.lulu.climaapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by LuLu on 05/11/2015.
 */
public class AdapterPais extends ArrayAdapter<Pais> {

    Context context;
    int layoutResourseId;
    Pais[] paises =null;


    public AdapterPais(Context context,int layoutResourse,Pais[] paises) {
        super(context,layoutResourse,paises);
        this.context=context;
        this.layoutResourseId=layoutResourse;
        this.paises=paises;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        PaisHolder paisHolder = null;
        if (v == null) {
            LayoutInflater inf = ((Activity)context).getLayoutInflater();
            v = inf.inflate(layoutResourseId,parent,false);

            paisHolder=new PaisHolder();
            paisHolder.imagen=(ImageView)v.findViewById(R.id.img_bandera);
            paisHolder.texto=(TextView)v.findViewById(R.id.nomPais);
            v.setTag(paisHolder);

        }else {

            paisHolder=(PaisHolder)v.getTag();
        }
        Pais pais=paises[position];
        paisHolder.imagen.setImageResource(pais.bandera);
        paisHolder.texto.setText(pais.nomPais);

        return v;


    }
        static class PaisHolder{
            ImageView imagen;
            TextView texto;
     }

}
