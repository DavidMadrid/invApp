package com.example.david.invapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.david.invapp.fragments.DatosFragment;
import com.example.david.invapp.fragments.EntradaFragment;
import com.example.david.invapp.fragments.EnviarFragment;
import com.example.david.invapp.fragments.FormParentFragment;
import com.example.david.invapp.fragments.RecuentosFragment;
import com.example.david.invapp.modeloDAO.DatabaseHandler;
import com.example.david.invapp.pojos.pojoLogin.LoginResult;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    public static ViewPager viewPager;
    public static LoginResult loginApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        String idLogin = getIntent().getStringExtra("ID_LOGIN");
        InitApp initApp = (InitApp) getApplication();
        DatabaseHandler dbHandler = initApp.getDbHandler();
        loginApp = dbHandler.getLoginResult(idLogin);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RecuentosFragment(), "Recuentos");
        adapter.addFragment(new DatosFragment(), "Datos");
        adapter.addFragment(new EntradaFragment(), "Entrada");
        adapter.addFragment(new EnviarFragment(), "Enviar");
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() != 0 && RecuentosFragment.recuento == null){
                    Toast.makeText(PrincipalActivity.this, "Debe seleccionar un recuento antes de avanzar", Toast.LENGTH_LONG).show();
                    tabLayout.getTabAt(0).select();
                }else {
                    viewPager.setCurrentItem(tab.getPosition());
                    FormParentFragment fragment = (FormParentFragment) ((FragmentPagerAdapter) PrincipalActivity.viewPager.getAdapter()).getItem(PrincipalActivity.viewPager.getCurrentItem());
                    fragment.onFragmentVisible();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.itTipoLectura:
                Intent intent = new Intent(PrincipalActivity.this, CentroLecturaActivity.class);
                startActivity(intent);
                break;
            case R.id.itAcercaDe:
                Intent intent1 = new Intent(PrincipalActivity.this, AcercaDeActivity.class);
                startActivity(intent1);
                break;
            case R.id.itCentro:
                Intent intent2 = new Intent(PrincipalActivity.this, CentrosActivity.class);
                startActivity(intent2);
                break;
            case R.id.itSalir:
                SharedPreferences preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
                preferences.edit().remove("id_login").commit();
                startActivity(new Intent(PrincipalActivity.this, LoginActivity.class));
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
