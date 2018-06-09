package app.panelist.pancake.ViewAskroomPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.panelist.pancake.R;
import app.panelist.pancake.WriteQuestionPage.WriteQuestionActivity;

public class AskroomFragment extends Fragment {

	FloatingActionButton addQuestionButton;
	Intent createQuestionIntent;
	
	public AskroomFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_askroom, container, false);
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
