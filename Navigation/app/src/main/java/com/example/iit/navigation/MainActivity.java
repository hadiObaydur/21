package com.example.iit.navigation;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
     ArrayList<String>arrayList;
     ArrayList<String>arrayListAll;
     ArrayList<String>arr;


    private ArrayList<String> mArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList=new ArrayList<String>();
        arrayListAll=new ArrayList<String>();
        arr=new ArrayList<String>();
        mArray = new ArrayList<String>();
        mArray.add("Us");
        mArray.add("arabic");


        arrayListAll.add("topStories");
        arrayListAll.add("entertainment");
        arrayListAll.add("business");
        arrayListAll.add("tech");
        arrayListAll.add("top");
        arrayListAll.add("health");
        arrayList.add("topStories"); //jodi account thake taile account theke load korbe naile default theke load korbe category
        arrayList.add("entertainment");
        arrayList.add("business");
        arrayList.add("tech");
       arrayList.add("top");
       arrayList.remove(4);
        for(String name : arrayList)
        {
            arr.add(name);
        }
       //arr=arrayList;
        //arrayList.clear();
        for(int i=0;i<arrayListAll.size();i++){
            if(!arr.contains(arrayListAll.get(i))){
                arr.add(arrayListAll.get(i));
            }
        }

        //arrayList.remove("top");
        //Toast.makeText(getApplicationContext(),"size"+arrayList.size(),Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void addCategory(String categoryName){
        arrayList.add(categoryName);
    }
    public void deleteCategory(String categoryName){
        arrayList.remove(categoryName);
    }
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            Toast.makeText(getApplicationContext(),"AMI JAITeci",Toast.LENGTH_LONG).show();
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        if (id == R.id.headlinesection) {
            bundle.putStringArrayList("arraylist",arr);
            bundle.putInt("count",arrayList.size());
            fragment = new ItemCategoryList();
            fragment.setArguments(bundle);
        }
        if (id == R.id.language) {
            bundle.putStringArrayList("mArray",mArray);
           // bundle.putInt("count",arrayList.size());
            fragment = new LanguageFragment();
            fragment.setArguments(bundle);
        }


        if (id == R.id.fb) {
            /*
            bundle.putString("url", "https://www.facebook.com/androidhungerAH");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);*/
            Intent detail = new Intent(getApplicationContext(),DetailArticle.class);
            detail.putExtra("webURL","https://www.facebook.com/");
            detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(detail);
        } else if (id == R.id.gplus) {
            bundle.putString("url", "https://plus.google.com/");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.twitter) {
            bundle.putString("url", "https://www.twitter.com/");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.github) {
            bundle.putString("url", "https://github.com/hadiobaydur");
            fragment = new WebViewFragment();
            fragment.setArguments(bundle);
        } else if (id == R.id.youtube) {
            Intent detail = new Intent(getApplicationContext(),DetailArticle.class);
            detail.putExtra("webURL","https://www.youtube.com/");
            detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(detail);
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
