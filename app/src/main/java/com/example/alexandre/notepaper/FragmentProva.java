package com.example.alexandre.notepaper;

import android.content.Intent;
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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class FragmentProva extends ListFragment{
    List dados;
    //FragmentManager fm = getSupportFragmentManager();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_prova, container, false);
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
        Firebase rf = new Firebase("https://notepaper-bf837.firebaseio.com/Prova");

        rf.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                int n = (int) dataSnapshot.getChildrenCount();

                Weather weather_data[] = new Weather[n];

                Weather d ;

                for(int i=1;i<=n;i++){
                    String j = String.valueOf(i);
                    d = new Weather(R.drawable.res,String.valueOf(dataSnapshot.child(j).child("Materia").getValue()),String.valueOf(dataSnapshot.child(j).child("Data").getValue()));
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
        /*Intent intent = new Intent(getContext(), ViewProva.class);
        startActivity(intent);*/

        FragmentManager fm = getActivity().getSupportFragmentManager();

        ViewProva frag7 = new ViewProva();

        id += 1;
        Bundle args = new Bundle();
        args.putString("arg",String.valueOf(id));
        frag7.setArguments(args);

        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack("pilha");
        ft.replace(R.id.content_menu,frag7,"7");
        ft.commit();
    }

}