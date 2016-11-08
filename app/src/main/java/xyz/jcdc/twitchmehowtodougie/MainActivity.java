package xyz.jcdc.twitchmehowtodougie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

import xyz.jcdc.twitchmehowtodougie.adapter.MotherfuckingAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MotherfuckingAdapter motherfuckingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        motherfuckingAdapter = new MotherfuckingAdapter(this, new ArrayList<Objects>());
        recyclerView.setAdapter(motherfuckingAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
