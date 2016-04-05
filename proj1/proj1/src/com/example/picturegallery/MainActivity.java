package com.example.picturegallery;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
 
	MovingView  movingView;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {    
	     super.onCreate(savedInstanceState);    
	     setContentView(R.layout.activity_main);
	     
	     Gallery g = (Gallery) findViewById(R.id.gallery);
	     movingView = (MovingView)findViewById(R.id.movingView1);
	     g.setAdapter(new ImageAdapter(this));    
	     g.setOnItemClickListener(new AdapterView.OnItemClickListener() {        
		      public void onItemClick(AdapterView parent, View v, int position, long id) {    
		    	  Log.v("################", String.valueOf(position));
		    	  switch (position){
			    	  case 0:
			    		  movingView.setSelectedImage(BitmapFactory.decodeResource(getResources(), R.drawable.image01));
			    		  break;
			    	  case 1:
			    		  movingView.setSelectedImage(BitmapFactory.decodeResource(getResources(), R.drawable.image02));
			    		  break;
			    	  case 2:
			    		  movingView.setSelectedImage(BitmapFactory.decodeResource(getResources(), R.drawable.image03));
			    		  break;
			    	  case 3:
			    		  movingView.setSelectedImage(BitmapFactory.decodeResource(getResources(), R.drawable.image04));
			    		  break;
			    	  case 4:
			    		  movingView.setSelectedImage(BitmapFactory.decodeResource(getResources(), R.drawable.image05));
			    		  break;
			    	  case 5:
			    		  movingView.setSelectedImage(BitmapFactory.decodeResource(getResources(), R.drawable.image06));
			    		  break;
			    	  case 6:
			    		  movingView.setSelectedImage(BitmapFactory.decodeResource(getResources(), R.drawable.image07));
			    		  break;
			    	  case 7:
			    		  movingView.setSelectedImage(BitmapFactory.decodeResource(getResources(), R.drawable.image08));
			    		  break;
			    	  case 8:
			    		  movingView.setSelectedImage(BitmapFactory.decodeResource(getResources(), R.drawable.image09));
			    		  break;
			    	  case 9:
			    		  movingView.setSelectedImage(BitmapFactory.decodeResource(getResources(), R.drawable.image10));
			    		  break;
		    	  }
		    	  
		       //click event
		       //not filing
		      }    
	     });
	     
    }
}
