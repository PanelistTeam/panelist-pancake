package app.panelist.pancake.ViewAskroomPage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.panelist.pancake.Models.Question;
import app.panelist.pancake.R;

public class AskroomAdapter extends RecyclerView.Adapter<AskroomAdapter.QuestionViewHolder> {
	
	private ArrayList<Question> questions;
	
	static class QuestionViewHolder extends RecyclerView.ViewHolder {
		TextView questionTextView;
		TextView questionerTextView;
		TextView scoreTextView;
		ImageView likeImageView;
		ImageView dislikeImageView;
		
		QuestionViewHolder(View view) {
			super(view);
			questionTextView = view.findViewById(R.id.textView_itemQuestion_question);
			questionerTextView = view.findViewById(R.id.textView_itemQuestion_questioner);
			scoreTextView = view.findViewById(R.id.textView_itemQuestion_score);
			
			likeImageView = view.findViewById(R.id.imageView_itemQuestion_like);
			dislikeImageView = view.findViewById(R.id.imageView_itemQuestion_dislike);
		}
		
		void setLikeImageView(final ArrayList<Question> questions) {
			likeImageView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					int newScore = questions.get(getAdapterPosition()).getScore() + 1;
					questions.get(getAdapterPosition()).setScore(newScore);
					scoreTextView.setText(Integer.toString(questions.get(getAdapterPosition()).getScore()));
				}
			});
		}
		
		void setDislikeImageView(final ArrayList<Question> questions) {
			dislikeImageView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					int newScore = questions.get(getAdapterPosition()).getScore() - 1;
					questions.get(getAdapterPosition()).setScore(newScore);
					scoreTextView.setText(Integer.toString(questions.get(getAdapterPosition()).getScore()));
				}
			});
		}
	}
	
	AskroomAdapter(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	@NonNull
	@Override
	public AskroomAdapter.QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_question, parent, false);
		
		AskroomAdapter.QuestionViewHolder vh = new AskroomAdapter.QuestionViewHolder(view);
		vh.setLikeImageView(questions);
		vh.setDislikeImageView(questions);
		return vh;
	}
	
	@Override
	public void onBindViewHolder(@NonNull AskroomAdapter.QuestionViewHolder holder, final int position) {
		holder.questionTextView.setText(questions.get(position).getContent());
		holder.questionerTextView.setText(Integer.toString(questions.get(position).getSubmittedBy()));
		holder.scoreTextView.setText(Integer.toString(questions.get(position).getScore()));
	}
	
	@Override
	public int getItemCount() {
		return questions.size();
	}
}
