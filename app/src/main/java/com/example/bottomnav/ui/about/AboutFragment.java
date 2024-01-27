package com.example.bottomnav.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

import com.example.bottomnav.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private int contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        // Sample teammate data with group names
        List<Teammate> teammates = new ArrayList<>();
        teammates.add(new Teammate(R.drawable.nelpassport, "Daniel Aiman", "2022875796", "CDCS240", "Developer", "CS2405A"));
        teammates.add(new Teammate(R.drawable.allypassport, "Allysha", "2022800668", "CDCS240", "Developer", "CS2405A"));
        teammates.add(new Teammate(R.drawable.annurpassport, "Annur Baiduri", "2021465008", "CS240", "Developer", "CS2405A"));
        teammates.add(new Teammate(R.drawable.aida, "Aida Husna", "2021871368", "CS240", "Developer", "CS2405A"));

        // Add more teammates as needed

        // Create the adapter
        TeammateAdapter adapter = new TeammateAdapter(getActivity(), teammates);

        // Bind the adapter to the ListView
        ListView listView = rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        return rootView;
    }

    public void setContentView(int contentView) {
        this.contentView = contentView;
    }

    public int getContentView() {
        return contentView;
 }
}