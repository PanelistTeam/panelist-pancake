package app.panelist.pancake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

public class CreateAskroomActivity extends AppCompatActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_askroom);
		
		android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(true);
		getSupportActionBar().setIcon(R.drawable.ic_arrow_back_black_24dp);
	}
	
}
