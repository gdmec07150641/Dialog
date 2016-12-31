package com.example.shana.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.net.DatagramPacket;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2,et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et_charactor);
        et2=(EditText)findViewById(R.id.et_date);
        et3=(EditText)findViewById(R.id.et_time);

    }
    public void charactorDialog(View V){
        final String options="0123456789*#";
       CharacterPickerDialog cpd=new CharacterPickerDialog(this,new View(this),null,options,false){
           @Override
           public void onClick(View v) {
               et1.append(((Button)v).getText().toString());
               if(((Button)v).getText().toString().equals("")){
                   dismiss();
               }
           }
       };
        cpd.show();
    }
    public void dataDialog(View V){
        DatePickerDialog dpd=new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                et2.setText(year+"年"+monthOfYear+1+"月"+dayOfMonth+"日");
            }
        },2016,20,0) ;
        dpd.show();



    }
    public void timeDialog(View V){
        TimePickerDialog tpd=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                et3.setText(hourOfDay+":"+minute);
            }
        },9,15,true);

        tpd.show();
    }


    public void progressdialog(View V){
       final ProgressDialog pd=ProgressDialog.show(this,"3秒后结束加载","正在加载...");
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    pd.dismiss();
                }
            }
        }.start();
    }
}
