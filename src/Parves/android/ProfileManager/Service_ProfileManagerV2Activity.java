package Parves.android.ProfileManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/** 
Created By Nazmus Sakib Prves on 03.05.2016
 **/

public class Service_ProfileManagerV2Activity extends Activity implements OnClickListener{

private Button start,stop;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        start=(Button)findViewById(R.id.start);
        stop=(Button) findViewById(R.id.stop);
    }
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	start.setOnClickListener(this);
    	stop.setOnClickListener(this);
    }
    

	public void onClick(View v) {
		if(v.getId()==R.id.start)
		{
			startService(new Intent(this,MySensorService.class));
			Toast.makeText(getBaseContext(), "Service started", 30).show();
		}
		
		if(v.getId()==R.id.stop)
		{
			stopService(new Intent(this,MySensorService.class));
			Toast.makeText(getBaseContext(), "Service stoped", 30).show();
		}
		
	}

}