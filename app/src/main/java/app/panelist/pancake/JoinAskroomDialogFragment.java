package app.panelist.pancake;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class JoinAskroomDialogFragment extends DialogFragment {
	
	Button button_dialogJoinAskroom_joinByLink;
	EditText editText_dialogJoinAskroom_joinByLink;
	Button button_dialogJoinAskroom_joinByQrCode;
	Button button_dialogJoinAskroom_createAskroom;
	Intent createAskroomIntent;
	
	public JoinAskroomDialogFragment() {
		// Required empty public constructor
	}
	
	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		View view = inflater.inflate(R.layout.dialog_join_askroom, null);
		getElementsByIdFromView(view);
		createAskroomIntent = new Intent(this.getContext(), CreateAskroomActivity.class);
		setListeners();
		builder.setView(view);
		
		return builder.create();
	}
	
	public void getElementsByIdFromView(View view)
	{
		button_dialogJoinAskroom_joinByLink = view.findViewById(R.id.button_dialogJoinAskroom_joinByLink);
		editText_dialogJoinAskroom_joinByLink = view.findViewById(R.id.editText_dialogJoinAskroom_joinByLink);
		button_dialogJoinAskroom_joinByQrCode = view.findViewById(R.id.button_dialogJoinAskroom_joinByQrCode);
		button_dialogJoinAskroom_createAskroom = view.findViewById(R.id.button_dialogJoinAskroom_createAskroom);
	}
	
	public void setListeners() {
		button_dialogJoinAskroom_joinByLink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// tu przejscie do wyszukiwania poprzez link (polaczyc sie z baza trzeba)
			}
		});
		
		button_dialogJoinAskroom_joinByQrCode.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// tu przejscie to modulu czytajacego kod QR
			}
		});
		
		button_dialogJoinAskroom_createAskroom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(createAskroomIntent);
			}
		});
	}
	
	public static JoinAskroomDialogFragment newInstance() {
		return new JoinAskroomDialogFragment();
	}
}
