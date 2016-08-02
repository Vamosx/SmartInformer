package com.vpi.viraj.smartinformer;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //off by default
        PackageManager pm = getPackageManager();
        ComponentName compName =
                new ComponentName(getApplicationContext(),
                        Callstatus.class);
        pm.setComponentEnabledSetting(
                compName,
                PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
                PackageManager.DONT_KILL_APP);
        //moveTaskToBack(true);

       // Callstatus call = new Callstatus();

        Switch sButton = (Switch) findViewById(R.id.switchButton);
        Switch sButton2 = (Switch) findViewById(R.id.switchButton2);

        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((Switch) v).isChecked();
                if (on) {
                  //  moveTaskToBack(true);

                    Toast.makeText(MainActivity.this,
                            "Service On", Toast.LENGTH_LONG).show();

                    PackageManager pm = getPackageManager();
                    ComponentName compName =
                            new ComponentName(getApplicationContext(),
                                    Callstatus.class);
                    pm.setComponentEnabledSetting(
                            compName,
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                }
               else
                {

                    Toast.makeText(MainActivity.this,
                            "Service Off", Toast.LENGTH_LONG).show();

                    PackageManager pm = getPackageManager();
                    ComponentName compName =
                            new ComponentName(getApplicationContext(),
                                    Callstatus.class);
                    pm.setComponentEnabledSetting(
                            compName,
                            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                            PackageManager.DONT_KILL_APP);
                }
            }
        });


        sButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = ((Switch) v).isChecked();

                if (on) {

                    Toast.makeText(MainActivity.this,
                            "Alarm activated", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,
                            "Alarm Off", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}


