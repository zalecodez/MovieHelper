package com.practice.android.moviehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new MovieGridFragment())
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new MovieGridFragment())
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MovieGridFragment())
                    .commit();
    }
}
