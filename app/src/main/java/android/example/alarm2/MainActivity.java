package android.example.alarm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        RecyclerView alarmRecycle = findViewById(R.id.alarmRecycle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Alarm");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        cardView = findViewById(R.id.card);
//        cardView.setCardBackgroundColor(R.drawable.bgalarm);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        alarmRecycle.setLayoutManager(gridLayoutManager);

        List<Alarm_item> alarm_items = new ArrayList<>();


        alarm_items.add(
                new Alarm_item(getResources().getString(R.string.time), getResources().getString(R.string.date)));
        alarm_items.add(
                new Alarm_item(getResources().getString(R.string.time), getResources().getString(R.string.date)));
        alarm_items.add(
                new Alarm_item(getResources().getString(R.string.time), getResources().getString(R.string.date)));
        alarm_items.add(
                new Alarm_item(getResources().getString(R.string.time), getResources().getString(R.string.date)));
        alarm_items.add(
                new Alarm_item(getResources().getString(R.string.time), getResources().getString(R.string.date)));

        alarmRecycle.setAdapter(new Alarm_adapter(alarm_items));

        FloatingActionButton fab = findViewById(R.id.fab_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Add Alarm", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,add_alarm.class);
                startActivity(intent);
            }
        });

    }
}
