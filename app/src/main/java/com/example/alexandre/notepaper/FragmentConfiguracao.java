package com.example.alexandre.notepaper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class FragmentConfiguracao extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_configuracao, container, false);

        return v;
    }

    public void onResume(){
        super.onResume();
        Weather_c weather_data[] = new Weather_c[5];
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Armazenamento");
        lista.add("Notificação");
        lista.add("Idioma");
        lista.add("Segurança");
        lista.add("Gerais");

        Weather_c A = new Weather_c(R.drawable.icone_arm,"Armazenamento");
        weather_data[0] = A;

        Weather_c B = new Weather_c(R.drawable.icone_not,"Notificação");
        weather_data[1] = B;

        Weather_c C = new Weather_c(R.drawable.icone_id,"Idioma");
        weather_data[2] = C;

        Weather_c D = new Weather_c(R.drawable.icone_seg,"Segurança");
        weather_data[3] = D;

        Weather_c E = new Weather_c(R.drawable.icone_ger,"Gerais");
        weather_data[4] = E;

        listview2(weather_data);

    }
    public void listview2(Weather_c[] data){
        WeatherAdapter_c adapter = new WeatherAdapter_c(this.getContext(), R.layout.listview_item_row_c, data);

        setListAdapter(adapter);
    }
}
