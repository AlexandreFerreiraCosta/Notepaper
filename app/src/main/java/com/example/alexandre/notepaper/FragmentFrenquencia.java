package com.example.alexandre.notepaper;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentFrenquencia extends ListFragment {
    private ListView lwMostraTodos;
    List dados;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_frequencia, container, false);
        dados = new ArrayList<>();

        TextView txt = (TextView) v.findViewById(R.id.textView3);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "bb.ttf");
        txt.setTypeface(font);

        return v;
    }

    @Override
    public void onResume(){
        super.onResume();

        Firebase.setAndroidContext(this.getContext());
        Firebase rf = new Firebase("https://notepaper-bf837.firebaseio.com/Frequencia");

        rf.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                int n = (int) dataSnapshot.getChildrenCount();

                Weather weather_data[] = new Weather[n];

                Weather d ;

                for(int i=1;i<=n;i++){
                    String j = String.valueOf(i);
                    d = new Weather(R.drawable.icone_frequencia,String.valueOf(dataSnapshot.child(j).child("Materia").getValue()),"Faltas: "+String.valueOf(dataSnapshot.child(j).child("Falta").getValue()));
                    weather_data[i-1] = d;
                }
                listview2(weather_data);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    public void listview2(Weather[] data){
        WeatherAdapter adapter = new WeatherAdapter(this.getContext(), R.layout.listview_item_row, data);

        setListAdapter(adapter);
    }
}
