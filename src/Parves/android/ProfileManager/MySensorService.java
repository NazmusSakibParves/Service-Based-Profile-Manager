package Parves.android.ProfileManager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.IBinder;

/** 
Created By Nazmus Sakib Prves on 03.05.2016
 **/

public class MySensorService extends Service implements SensorEventListener {

	private SensorManager sensor_manager;
	private Sensor sensor;
	private AudioManager audio_manager;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
			sensor_manager=(SensorManager) getSystemService(SENSOR_SERVICE);
	        
	        audio_manager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		
		super.onStart(intent, startId);
		 sensor=sensor_manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		 sensor_manager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	public void onAccuracyChanged(Sensor s, int arg1) {
		
		
	}

	public void onSensorChanged(SensorEvent s_event) {
		float x=s_event.values[0];
		float y=s_event.values[1];
		float z=s_event.values[2];
		
		if(x<1 && x>-2 ){
			audio_manager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
          
			
		}
	
	else if(x>9){
		audio_manager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
      
	
	}
	 
	else if(x<-7){
		audio_manager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
      
	
	}
	 
	else if(z<0){
		   audio_manager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            
		
		}
		
		
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		sensor_manager.unregisterListener(this);
	}


}
