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
    						toast.setText(this.getString(R.string.correct));
    						numText.setHint(this.getString(R.string.hint));
    						randNum = (int)((Math.random() * 100) + 1);
    						count = 5;
    					} else if(guess > randNum ){
    						count--;
    						toast.setText(this.getString(R.string.high) + count + " " + this.getString(R.string.triesLeft));
    						numText.setHint(this.getString(R.string.lowerHint) + " " + guess);
    					} else if(guess < randNum){
    						count--;
    						toast.setText(this.getString(R.string.low) + count + " " + this.getString(R.string.triesLeft));
    						numText.setHint(this.getString(R.string.higherHint) + " " + guess);
    					}
    		
    					if(count == 0){
    						toast.setDuration(Toast.LENGTH_LONG);
    						toast.setText(this.getString(R.string.answer) + " " + randNum + "." + this.getString(R.string.newNum));
    						randNum = (int)((Math.random() * 100) + 1);
    						count = 5;
    						numText.setHint(this.getString(R.string.hint));
    					}
    				} catch (Exception e) {
    					toast.setText(this.getString(R.string.error));
    					toast.setDuration(Toast.LENGTH_LONG);
    				}
    				toast.show();
    				
    				/* Clear guess */
    				numText.setText("");
    			}
    			break;
    		case R.id.one:
    			numText.append(this.getString(R.string.one));
    			break;
    		case R.id.two:
    			numText.append(this.getString(R.string.two));
    			break;
    		case R.id.three:
    			numText.append(this.getString(R.string.three));
    			break;
    		case R.id.four:
    			numText.append(this.getString(R.string.four));
    			break;
    		case R.id.five:
    			numText.append(this.getString(R.string.five));
    			break;
    		case R.id.six:
    			numText.append(this.getString(R.string.six));
    			break;
    		case R.id.seven:
    			numText.append(this.getString(R.string.seven));
    			break;
    		case R.id.eight:
    			numText.append(this.getString(R.string.eight));
    			break;
    		case R.id.nine:
    			numText.append(this.getString(R.string.nine));
    			break;
    		case R.id.zero:
    			numText.append(this.getString(R.string.zero));
    			break;
    		case R.id.clr:
    			numText.setText("");
    			break;
    	}
    }
}