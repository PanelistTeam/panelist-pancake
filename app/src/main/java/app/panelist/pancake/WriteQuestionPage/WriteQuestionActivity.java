package app.panelist.pancake.WriteQuestionPage;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.security.cert.CRLException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import app.panelist.pancake.Models.Question;
import app.panelist.pancake.R;

public class WriteQuestionActivity extends AppCompatActivity {
	
	FloatingActionButton addQuestionButton;
	EditText editTextQuestionContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write_question);
		
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		setTitle(R.string.title_writeQuestionActivity);
		
		editTextQuestionContent = findViewById(R.id.editText_enterQuestion);
		addQuestionButton = findViewById(R.id.floatingActionButton_activity_write_question_createQuestion);
		addQuestionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CreateQuestion();
			}
		});
		
	}
	
	public void CreateQuestion()
	{
		Question createdQuestion = new Question();
		createdQuestion.setContent(editTextQuestionContent.getText().toString());
		createdQuestion.setCurrentVersionId(1);
		createdQuestion.setPreviousVersionId(0);
		createdQuestion.setScore(0);
		createdQuestion.setTimeSubmitted(new Timestamp(System.currentTimeMillis()));
		createdQuestion.setSubmittedBy(0); //TODO
		createdQuestion.setAskroomId(0); //TODO
		createdQuestion.setId(0); //TODO
	}
	
	@Override
	public boolean onSupportNavigateUp() {
		onBackPressed();
		return true;
	}
}
