package com.sabbir.admin.sensorappsabbir.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sabbir.admin.sensorappsabbir.R;
import com.sabbir.admin.sensorappsabbir.attitude.AttitudeIndicator;
import com.sabbir.admin.sensorappsabbir.orientation.Orientation;

public class MainActivity extends AppCompatActivity implements Orientation.Listener{
    private Orientation mOrientation;
    private AttitudeIndicator mAttitudeIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOrientation=new Orientation(this);
        mAttitudeIndicator=(AttitudeIndicator)findViewById(R.id.attitude_indicator);
    }
    @Override
    protected void onStart(){
        super.onStart();
        mOrientation.startListening(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mOrientation.stopListening();
    }

    @Override
    public void onOrientationChanged(float pitch, float roll) {
        mAttitudeIndicator.setAttitude(pitch, roll);
    }
}
