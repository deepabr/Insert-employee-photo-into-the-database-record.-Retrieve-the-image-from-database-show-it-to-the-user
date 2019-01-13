package com.example.deepa.image_retrieve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private DBhelper DbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHelper = new DBhelper(this);
        Employee employee_One = new Employee(BitmapFactory.decodeResource(
                getResources(), R.drawable.ic_launcher), "SAI ", 25);
        DbHelper.open();
        DbHelper.insertEmpDetails(employee_One);
        DbHelper.close();
        employee_One = null;
        DbHelper.open();
        employee_One = DbHelper.retriveEmpDetails();
        DbHelper.close();

        TextView empname = (TextView) findViewById(R.id.name);
        empname.setText(employee_One.getName());
        ImageView empphoto = (ImageView) findViewById(R.id.photo);
        empphoto.setImageBitmap(employee_One.getBitmap());
        TextView empage = (TextView) findViewById(R.id.age);
        empage.setText("" + employee_One.getAge());
    }
}





