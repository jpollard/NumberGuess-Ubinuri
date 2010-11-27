package com.effupayme.numberGuess;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class numberGuess extends Activity implements OnClickListener {
	public Button guessButton;
	public EditText numText;
	public int randNum;
	public int count = 5;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        randNum = (int)((Math.random() * 100) + 1);
        
        guessButton = (Button) findViewById(R.id.guessButton);
        numText = (EditText) findViewById(R.id.number);
        guessButton.setOnClickListener(this);
    }
    
    public void onClick(View v){
    	
    	Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
    	toast.setGravity(Gravity.CENTER, 0, 0);
    	
    	if(numText.getText().toString() != null){
    		
    		try{
    		if(Integer.parseInt(numText.getText().toString()) == randNum){
    			toast.setText("Correct. New number picked.");
    			randNum = (int)((Math.random() * 100) + 1);
    			count = 5;
     		} else if(Integer.parseInt(numText.getText().toString()) > randNum ){
     			count--;
     			toast.setText("Too high, " + count + " tries left.");
     		} else if(Integer.parseInt(numText.getText().toString()) < randNum){
    			count--;
    			toast.setText("Too low, " + count + " tries left.");
    		}
    		
    		if(count == 0){
    			toast.setDuration(Toast.LENGTH_LONG);
    			toast.setText("The number was " + randNum + ". New number picked.");
    			randNum = (int)((Math.random() * 100) + 1);
    			count = 5;
    		}
    		} catch (Exception e) {
    			toast.setText("Try putting in a number.");
    			toast.setDuration(Toast.LENGTH_LONG);
    		}
    		toast.show();
    	}
    	numText.setText("");
    }
}