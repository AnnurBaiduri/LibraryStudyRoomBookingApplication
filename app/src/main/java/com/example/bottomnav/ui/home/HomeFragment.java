package com.example.bottomnav.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.bottomnav.R;
import com.example.bottomnav.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    GridView gridView;
    String [] LibraryName = {"PTAR Undang-Undang ", "PTAR Sains dan Teknologi", "PTAR Tun Abdul Razak" , "PTAR Kejuruteraan ", "PTAR Alam Bina "};
    int[] LibraryImage = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Fix: Use root.findViewById instead of findViewById
        gridView = root.findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Fix: Use requireContext() instead of getApplicationContext()
                Intent intent = new Intent(requireContext(), GridItemActivity.class);
                intent.putExtra("name", LibraryName[i]);
                intent.putExtra("image", LibraryImage[i]);
                startActivity(intent);
            }
        });

        return root;
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return LibraryImage.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.raw_data, null);

            TextView name = view1.findViewById(R.id.libName);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(LibraryName[i]);
            image.setImageResource(LibraryImage[i]);
            return view1;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
