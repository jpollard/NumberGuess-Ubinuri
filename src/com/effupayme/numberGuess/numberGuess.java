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
	public Button oneButton;
	public Button twoButton;
	public Button threeButton;
	public Button fourButton;
	public Button fiveButton;
	public Button sixButton;
	public Button sevenButton;
	public Button eightButton;
	public Button nineButton;
	public Button zeroButton;
	public Button clrButton;
	public EditText numText;
	public int randNum;
	public int count = 5;
	public int guess = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        randNum = (int)((Math.random() * 100) + 1);
        
        guessButton = (Button) findViewById(R.id.guessButton);
        oneButton = (Button)findViewById(R.id.one);
        twoButton = (Button)findViewById(R.id.two);
        threeButton = (Button)findViewById(R.id.three);
        fourButton = (Button)findViewById(R.id.four);
        fiveButton = (Button)findViewById(R.id.five);
        sixButton = (Button)findViewById(R.id.six);
        sevenButton = (Button)findViewById(R.id.seven);
        eightButton = (Button)findViewById(R.id.eight);
        nineButton = (Button)findViewById(R.id.nine);
        zeroButton = (Button)findViewById(R.id.zero);
        clrButton = (Button)findViewById(R.id.clr);
        
        numText = (EditText) findViewById(R.id.number);
        guessButton.setOnClickListener(this);
        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        zeroButton.setOnClickListener(this);
        clrButton.setOnClickListener(this);
        
    }
    
    public void onClick(View v){
    	
    	Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
    	toast.setGravity(Gravity.CENTER, 0, 0);
    	
    	switch(v.getId()){
    		case R.id.guessButton:
    			if(numText.getText().toString() != null){
    				try{
    					guess = Integer.parseInt(numText.getText().toString());
    					if(guess == randNum){
    						toast.setText("Correct. New number picked.");
    						numText.setHint("Guess a number between 1 and 100");
    						randNum = (int)((Math.random() * 100) + 1);
    						count = 5;
    					} else if(guess > randNum ){
    						count--;
    						toast.setText("Too high, " + count + " tries left.");
    						numText.setHint("My number is lower than " + guess);
    					} else if(guess < randNum){
    						count--;
    						toast.setText("Too low, " + count + " tries left.");
    						numText.setHint("My number is higher than " + guess);
    					}
    		
    					if(count == 0){
    						toast.setDuration(Toast.LENGTH_LONG);
    						toast.setText("The number was " + randNum + ". New number picked.");
    						randNum = (int)((Math.random() * 100) + 1);
    						count = 5;
    						numText.setHint("Guess a number between 1 and 100");
    					}
    				} catch (Exception e) {
    					toast.setText("Try putting in a number.");
    					toast.setDuration(Toast.LENGTH_LONG);
    				}
    				toast.show();
    				numText.setText("");
    			}
    			break;
    		case R.id.one:
    			numText.append("1");
    			break;
    		case R.id.two:
    			numText.append("2");
    			break;
    		case R.id.three:
    			numText.append("3");
    			break;
    		case R.id.four:
    			numText.append("4");
    			break;
    		case R.id.five:
    			numText.append("5");
    			break;
    		case R.id.six:
    			numText.append("6");
    			break;
    		case R.id.seven:
    			numText.append("7");
    			break;
    		case R.id.eight:
    			numText.append("8");
    			break;
    		case R.id.nine:
    			numText.append("9");
    			break;
    		case R.id.zero:
    			numText.append("0");
    			break;
    		case R.id.clr:
    			numText.setText("");
    			break;
    	}
    }
}