package com.example.alexandre.notepaper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class ViewProva extends Fragment{
    View v;
    String p ;
    TextView txtMateria;
    TextView txtProfessor;
    TextView txtTema;
    TextView txtData;
    TextView txtValor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_view_prova, container, false);

        Bundle args = getArguments();

        p =  args.getString("arg");

        txtMateria = (TextView) v.findViewById(R.id.textView);
        txtProfessor = (TextView) v.findViewById(R.id.txt2);
        txtTema = (TextView) v.findViewById(R.id.txt3);
        txtData = (TextView) v.findViewById(R.id.textView4);
        txtValor = (TextView) v.findViewById(R.id.textView5);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "bb.ttf");
        txtMateria.setTypeface(font);

        return v;
    }

    @Override
    public void onResume(){
        super.onResume();

        Firebase.setAndroidContext(this.getContext());
        Firebase rf = new Firebase("https://notepaper-bf837.firebaseio.com/Prova");

        rf.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                txtMateria.setText(String.valueOf(dataSnapshot.child(p).child("Materia").getValue()));
                txtProfessor.setText("Professor: "+String.valueOf(dataSnapshot.child(p).child("Professor").getValue()));
                txtTema.setText("Tema: "+String.valueOf(dataSnapshot.child(p).child("Tema").getValue()));
                txtData.setText("Data: "+String.valueOf(dataSnapshot.child(p).child("Data").getValue()));
                txtValor.setText("Valor: "+String.valueOf(dataSnapshot.child(p).child("Valor").getValue()));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}