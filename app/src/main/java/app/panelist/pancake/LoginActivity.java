package app.panelist.pancake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{
	Button goButton;
	EditText usernameLoginEditText;
	Intent mainIntent;
	Bundle bundleToSend;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		goButton = findViewById(R.id.goButton);
		usernameLoginEditText = findViewById(R.id.usernameLoginEditText);
		
		mainIntent = new Intent(this, MainActivity.class);
		bundleToSend = new Bundle();
		
		View.OnClickListener goListener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				bundleToSend.putString("userName", usernameLoginEditText.getText().toString());
				mainIntent.putExtras(bundleToSend);
				startActivity(mainIntent);
			}
		};
		
		goButton.setOnClickListener(goListener);
		
	}
}
