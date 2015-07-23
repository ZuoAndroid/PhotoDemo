package com.zwb.photodemo;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.LinearLayout;

import com.zwb.photodemo.Utils.BitmapHelper;
import com.zwb.photodemo.Utils.DbHepler;
import com.zwb.photodemo.fragment.Message_Fragment;
import com.zwb.photodemo.fragment.SongFragment;


public class MainActivity extends ActionBarActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    private DrawerLayout draw;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigat;
    private LinearLayout head_name;
    private FragmentTransaction fragmentTransaction;
    private ActionBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        DbHepler.init(this);
        BitmapHelper.init(this);
        toggle = new ActionBarDrawerToggle(this, draw, 0, 0);
        draw.setDrawerListener(toggle);
        toggle.syncState();

        bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);
        bar.setDisplayShowHomeEnabled(true);
        bar.setLogo(R.mipmap.logo_googleplus);
        navigat = ((NavigationView) findViewById(R.id.navigat));
        navigat.setNavigationItemSelectedListener(this);

        head_name.setOnClickListener(this);


    }

    //初始化控件的方法
    private void initView() {
        draw = ((DrawerLayout) findViewById(R.id.draw));
        head_name = ((LinearLayout) findViewById(R.id.head_menu));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (menuItem.getItemId()){
            case R.id.google:
                fragmentTransaction.replace(R.id.container, new SongFragment());
                break;
        }
        fragmentTransaction.commit();
        draw.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View view) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,new Message_Fragment());
        fragmentTransaction.commit();
        draw.closeDrawer(GravityCompat.START);
    }
}
