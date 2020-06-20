package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;
    Dialog myDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        myDialog = new Dialog(this);
        setSingleEvent(mainGrid);
        setToggleEvent(mainGrid);
    }


    private void setToggleEvent(GridLayout mainGrid) {
        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            final CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int final1 = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(final1 == 3)
                    {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.covidvisualizer.com"));
                        startActivity(intent);
                    }
                    else if(final1 == 2)
                    {
                        Intent intent = new Intent(MainActivity.this,com.example.gridlayout.ActivityYoutube.class);
                        startActivity(intent);

                    }
                    else if(final1 == 4)
                    {
                        Intent in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567892"));
                        startActivity(in);

                    }
                    else if(final1 == 1)
                    {

                            TextView textclose;
                            myDialog.setContentView(R.layout.custompopup);

                            textclose = (TextView) myDialog.findViewById(R.id.txtclose);

                            textclose.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    myDialog.dismiss();
                                }
                            });
                            myDialog.show();

                    }
                    else if(final1 == 0)
                    {

                        Toast.makeText(MainActivity.this, "Alarm is Set : You Will Receive Notification After Two Hours)", Toast.LENGTH_SHORT).show();

                    }
                    else if(final1 == 5)
                    {
                        Intent intent2 = new Intent(MainActivity.this,com.example.gridlayout.Activity2.class);
                        startActivity(intent2);

                    }
                }
            });
        }

    }

    private void setSingleEvent(GridLayout mainGrid) {
        //loop all childs

        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int final1 = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Clicked at index"+final1, Toast.LENGTH_SHORT).show();
                }
            });
        }



    }
}
