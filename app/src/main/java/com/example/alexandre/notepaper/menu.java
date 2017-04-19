package com.example.alexandre.notepaper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth auth;

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (findViewById(R.id.content_menu) != null) {

            if (savedInstanceState != null) {
                return;
            }

            FragmentProva firstFragment = new FragmentProva();

            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_menu, firstFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        auth = FirebaseAuth.getInstance();

        if (id == R.id.action_sair) {
            auth.signOut();
            startActivity(new Intent(menu.this, LoginActivity.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        auth = FirebaseAuth.getInstance();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (id == R.id.nav_sair) {
            auth.signOut();
            startActivity(new Intent(menu.this, LoginActivity.class));
            finish();
        }
        else if (id == R.id.nav_prova) {
            FragmentProva frag1 = new FragmentProva();

            Bundle args = new Bundle();
            args.putInt("frag1",id);
            frag1.setArguments(args);

            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack("pilha");
            ft.replace(R.id.content_menu,frag1,"frag1");
            ft.commit();
        }
        else if (id == R.id.nav_trabalho) {
            FragmentTrabalho frag2 = new FragmentTrabalho();

            Bundle args = new Bundle();
            args.putInt("frag2",id);
            frag2.setArguments(args);

            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack("pilha");
            ft.replace(R.id.content_menu,frag2,"frag2");
            ft.commit();
        }
        else if (id == R.id.nav_frequencia) {
            FragmentFrenquencia frag3 = new FragmentFrenquencia();

            Bundle args = new Bundle();
            args.putInt("frag3",id);
            frag3.setArguments(args);

            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack("pilha");
            ft.replace(R.id.content_menu,frag3,"frag3");
            ft.commit();
        }
        else if (id == R.id.nav_calendario) {
            FragmentCalendario frag4 = new FragmentCalendario();

            Bundle args = new Bundle();
            args.putInt("frag4",id);
            frag4.setArguments(args);

            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack("pilha");
            ft.replace(R.id.content_menu,frag4,"frag4");
            ft.commit();
        }
        else if (id == R.id.nav_configuracao) {
            FragmentConfiguracao frag5 = new FragmentConfiguracao();

            Bundle args = new Bundle();
            args.putInt("frag5",id);
            frag5.setArguments(args);

            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack("pilha");
            ft.replace(R.id.content_menu,frag5,"frag5");
            ft.commit();
        }else if (id == R.id.nav_mapa) {
            MapsActivity frag6 = new MapsActivity();

            Bundle args = new Bundle();
            args.putInt("frag6",id);
            frag6.setArguments(args);

            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack("pilha");
            ft.replace(R.id.content_menu,frag6,"frag6");
            ft.commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
