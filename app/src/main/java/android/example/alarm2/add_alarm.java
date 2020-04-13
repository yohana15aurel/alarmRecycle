package android.example.alarm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class add_alarm extends AppCompatActivity {
    boolean check = false;
    private CheckBox mon, tue, wed, thurs, fri, sat, sun;
    private TextView tv1;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        //Get the widgets reference from XML layout
        final TextView tv = (TextView) findViewById(R.id.tv);

        final TimePicker tp = (TimePicker) findViewById(R.id.tp);

        Button btn = (Button) findViewById(R.id.btn);
        mon = (CheckBox) findViewById(R.id.mon);
        tue = (CheckBox) findViewById(R.id.tue);
        wed = (CheckBox) findViewById(R.id.wed);
        thurs = (CheckBox) findViewById(R.id.thurs);
        fri = (CheckBox) findViewById(R.id.fri);
        sat = (CheckBox) findViewById(R.id.sat);
        sun = (CheckBox) findViewById(R.id.sun);
        tv1 = findViewById(R.id.tv1);

        //Set the TimePicker view to 24 hour view
        tp.setIs24HourView(true);

        //Set a TimeChangedListener for TimePicker widget
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                //Display the new time to app interface
                String AMPM = "AM";
                if(hourOfDay>11)
                {
                    hourOfDay = hourOfDay;
                    AMPM = "PM";
                }
                tv.setText("" + hourOfDay + ":" + minute + " " + AMPM);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            String msg="";
            @Override
            public void onClick(View v) {
                int hourOfDay = tp.getCurrentHour(); //Get TimePicker current hour
                int minute = tp.getCurrentMinute(); //Get TimePicker current minute

                //Display the TimePicker current time to app interface
                String AMPM = "AM";
                if(hourOfDay>11)
                {
                    //Get the current hour as AM PM 12 hour format
                    hourOfDay = hourOfDay;
                    AMPM = "PM";
                }
                tv.setText(hourOfDay + ":" + minute + " " +AMPM );
                if(mon.isChecked())
                    msg = msg + " Mon, ";
                else
                    msg="";
                if(tue.isChecked())
                    msg = msg + " Tue, ";
                if(wed.isChecked())
                    msg = msg + " Wed, ";
                if(thurs.isChecked())
                    msg = msg + " Thu, ";
                if(fri.isChecked())
                    msg = msg + " Fri, ";
                if(sat.isChecked())
                    msg = msg + " Sat, ";
                if(sun.isChecked())
                    msg = msg + " Sun, ";
                tv1.setText(msg);
            }
        });

    }

    public void onCheckBoxChecked(View view) {
        CheckBox checkBox = findViewById(view.getId());
    }
}



