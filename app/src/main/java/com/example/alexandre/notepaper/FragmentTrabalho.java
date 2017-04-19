package com.example.alexandre.notepaper;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentTrabalho extends ListFragment {
    private ListView lwMostraTodos;
    List dados;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_trabalho, container, false);
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
        Firebase rf = new Firebase("https://notepaper-bf837.firebaseio.com/Trabalho");

        rf.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                int n = (int) dataSnapshot.getChildrenCount();

                Weather weather_data[] = new Weather[n];

                Weather d ;

                for(int i=1;i<=n;i++){
                    String j = String.valueOf(i);
                    d = new Weather(R.drawable.icone_trabalho,String.valueOf(dataSnapshot.child(j).child("Materia").getValue()),String.valueOf(dataSnapshot.child(j).child("Data").getValue()));
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

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Object o = this.getListAdapter().getItem(position);

        Toast.makeText(this.getContext().getApplicationContext(), "Você clicou no "+position, Toast.LENGTH_SHORT).show();

        FragmentManager fm = getActivity().getSupportFragmentManager();

        ViewTrabalho frag8 = new ViewTrabalho();

        id += 1;
        Bundle args = new Bundle();
        args.putString("arg",String.valueOf(id));
        frag8.setArguments(args);

        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack("pilha");
        ft.replace(R.id.content_menu,frag8,"8");
        ft.commit();
    }
}