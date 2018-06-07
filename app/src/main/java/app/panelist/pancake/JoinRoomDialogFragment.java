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

public class JoinRoomDialogFragment extends DialogFragment {
	
	Button button_dialogJoinRoom_joinByLink;
	EditText editText_dialogJoinRoom_joinByLink;
	Button button_dialogJoinRoom_joinByQrCode;
	Button button_dialogJoinRoom_createRoom;
	Intent createAskroomIntent;
	
	public JoinRoomDialogFragment() {
		// Required empty public constructor
	}
	
	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		View view = inflater.inflate(R.layout.dialog_join_room, null);
		getElementsByIdFromView(view);
		createAskroomIntent = new Intent(this.getContext(), CreateAskroomActivity.class);
		setListeners();
		builder.setView(view);
		
		return builder.create();
	}
	
	public void getElementsByIdFromView(View view)
	{
		button_dialogJoinRoom_joinByLink = view.findViewById(R.id.button_dialogJoinRoom_joinByLink);
		editText_dialogJoinRoom_joinByLink = view.findViewById(R.id.editText_dialogJoinRoom_joinByLink);
		button_dialogJoinRoom_joinByQrCode = view.findViewById(R.id.button_dialogJoinRoom_joinByQrCode);
		button_dialogJoinRoom_createRoom = view.findViewById(R.id.button_dialogJoinRoom_createRoom);
	}
	
	
	
	public void setListeners()
	{
		button_dialogJoinRoom_joinByLink.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// tu przejscie do wyszukiwania poprzez link (polaczyc sie z baza trzeba)
			}
		});
		
		button_dialogJoinRoom_joinByQrCode.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// tu przejscie to modulu czytajacego kod QR
			}
		});
		
		button_dialogJoinRoom_createRoom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(createAskroomIntent);
			}
		});
	}
	
	
	public static JoinRoomDialogFragment newInstance() {
		return new JoinRoomDialogFragment();
	}
}
