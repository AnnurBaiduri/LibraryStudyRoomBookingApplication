package com.example.bottomnav.ui.about;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bottomnav.R;

import java.util.List;

public class TeammateAdapter extends ArrayAdapter<Teammate> {

    public TeammateAdapter(Context context, List<Teammate> teammates) {
        super(context, 0, teammates);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.teammate_item, parent, false);
        }

        Teammate teammate = getItem(position);

        ImageView profileImageView = convertView.findViewById(R.id.profileImageView);
        TextView fullNameTextView = convertView.findViewById(R.id.fullNameTextView);
        TextView studentIDTextView = convertView.findViewById(R.id.studentIDTextView);
        TextView programNameTextView = convertView.findViewById(R.id.programNameTextView);
        TextView roleTextView = convertView.findViewById(R.id.roleTextView);
        TextView groupNameTextView = convertView.findViewById(R.id.groupNameTextView);  // Add this line

        if (teammate != null) {
            // Set the data to the views
            profileImageView.setImageResource(teammate.getImageResId());  // Set image resource
            fullNameTextView.setText(teammate.getFullName());
            studentIDTextView.setText(teammate.getStudentID());
            programNameTextView.setText(teammate.getProgramName());
            roleTextView.setText(teammate.getRole());
            groupNameTextView.setText(teammate.getGroupName());  // Set the group name
        }

        return convertView;
    }
}
