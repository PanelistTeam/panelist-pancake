package app.panelist.pancake.ViewAskroomPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.panelist.pancake.Models.Askroom;
import app.panelist.pancake.Models.Question;
import app.panelist.pancake.R;
import app.panelist.pancake.WriteQuestionPage.WriteQuestionActivity;

public class AskroomFragment extends Fragment {

	FloatingActionButton addQuestionButton;
	Intent createQuestionIntent;
	
	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private RecyclerView.LayoutManager layoutManager;
	
	public AskroomFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		final View view = inflater.inflate(R.layout.fragment_askroom, container, false);
		recyclerView = view.findViewById(R.id.recyclerView_fragmentAskroom);
		recyclerView.setHasFixedSize(true);
		
		layoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(layoutManager);
		
		DividerItemDecoration itemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
		recyclerView.addItemDecoration(itemDecoration);
		
		ArrayList<Question> questions = new ArrayList<>();
		Question testQuestion = new Question();
		testQuestion.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		testQuestion.setSubmittedBy(1234);
		testQuestion.setScore(-50);
		questions.add(testQuestion);
		questions.add(testQuestion);
		questions.add(testQuestion);
		
		adapter = new AskroomAdapter(questions);
		recyclerView.setAdapter(adapter);
		
		return view;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Bundle bundle = this.getArguments();
		getActivity().setTitle(bundle.getString("title"));
		
		createQuestionIntent = new Intent(this.getContext(), WriteQuestionActivity.class);
		
		addQuestionButton = view.findViewById(R.id.floatingActionButton_fragmentAskroom_askQuestion);
		addQuestionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(createQuestionIntent);
			}
		});
		
	}
}
