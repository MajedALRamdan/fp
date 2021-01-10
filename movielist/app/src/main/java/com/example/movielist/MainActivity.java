package com.example.movielist;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Moive> movielibrary = new ArrayList<>();
        Moive d = new Moive("spiderman", 1.35, 4.3, "Adventure", 2017, false, R.drawable.spidermanhc,"https://www.movs4u.ws/movie/%D9%85%D8%AA%D8%B1%D8%AC%D9%85-spider-man-far-from-home-%D9%81%D9%8A%D9%84%D9%85/");
        Moive b = new Moive("badboys3", 2, 4.8, "Action", 2019, false, R.drawable.badboys3,"https://www.movs4u.ws/movie/%D9%85%D8%AA%D8%B1%D8%AC%D9%85-bad-boys-for-life-%D9%81%D9%8A%D9%84%D9%85/");
        Moive c = new Moive("lionking", 1.5, 4, "kids", 1994, true, R.drawable.lionking1994,"https://www.movs4u.ws/movie/%D9%85%D8%AA%D8%B1%D8%AC%D9%85-the-lion-king-%D9%81%D9%8A%D9%84%D9%85/");
        Moive a = new Moive("Ford VS Ferrari", 1.5, 5, "Racing", 2019, false, R.drawable.fvf3,"https://www.movs4u.ws/movie/%D9%85%D8%AA%D8%B1%D8%AC%D9%85-ford-v-ferrari-%D9%81%D9%8A%D9%84%D9%85/");

        movielibrary.add(a);//
        movielibrary.add(b);//
        movielibrary.add(c);//
        movielibrary.add(d);//
        RecyclerView movies = findViewById(R.id.rv);

        movies.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        movies.setLayoutManager(lm);

       final RelativeLayout rl=findViewById(R.id.rl1);
        ma MA = new ma(movielibrary, MainActivity.this,rl);
        movies.setAdapter(MA);

        Toolbar tb=findViewById(R.id.tb3);
        LinearLayout RL=findViewById(R.id.RL);


        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withIcon(R.drawable.ic_baseline_home_24).withName("Home");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withIcon(R.drawable.ic_baseline_settings_24).withName("Settings");
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withIcon(R.drawable.ic_baseline_sd_storage_24).withName("Storage");

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(tb)
                .addDrawerItems(
                        item1,
                        item2,
                        new DividerDrawerItem(),
                        item3)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        if(drawerItem.getIdentifier() ==1){
                            Toast.makeText(MainActivity.this, "Cliked on Home " , Toast.LENGTH_SHORT).show();

                        }
                        else if(drawerItem.getIdentifier() ==2){
                            Toast.makeText(MainActivity.this, "Cliked on Settings " , Toast.LENGTH_SHORT).show();
                        }

                        else if(drawerItem.getIdentifier() ==3){
                            Toast.makeText(MainActivity.this, "Cliked on Storge " , Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                })
                .build();

  }

    }
