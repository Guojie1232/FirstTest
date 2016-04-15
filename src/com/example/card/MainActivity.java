package com.example.card;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends Activity {
	
	private ImageView mPhoto;
	private EditText mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhoto = (ImageView) findViewById(R.id.photo);
        mText= (EditText) findViewById(R.id.edT);
        
        mText.setTypeface(Typeface.createFromAsset(getAssets(), "font/test.ttf"));
        
        mPhoto.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent inten = new Intent(Intent.ACTION_PICK,null);
				inten.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
				startActivityForResult(inten,100);
				
				
			}
		});


       
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	if(resultCode== RESULT_OK && requestCode == 100)
    	{
    		if(data!=null)
    		{
    			mPhoto.setImageURI(data.getData());
    		}
    		
    	}
    	
    	
    }


  

}
