package com.example.bottomnav.ui.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.bottomnav.R;
import com.example.bottomnav.databinding.FragmentBookBinding;
import com.example.bottomnav.ui.book.BookViewModel;

public class BookFragment extends Fragment {

    private FragmentBookBinding binding;
    private EditText editText1, editText2, editText3, editText4, editText5, editTextRoomType;
    private Button button1, button2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BookViewModel bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);

        binding = FragmentBookBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize UI elements using binding
        editText1 = binding.editText1;
        editText2 = binding.editText2;
        editText3 = binding.editText3;
        editText4 = binding.editText4;
        editText5 = binding.editText5;
        editTextRoomType = binding.editTextRoomType;

        button1 = binding.button1;
        button2 = binding.button2;

        // Set onClickListener for "BOOK" button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle booking logic here
                String idNumber = editText1.getText().toString();
                String name = editText2.getText().toString();
                String date = editText3.getText().toString();
                String startTime = editText4.getText().toString();
                String endTime = editText5.getText().toString();
                String pax = editTextRoomType.getText().toString();

                DatabaseHelper dbHelper = new DatabaseHelper(requireContext());

                dbHelper.logDatabaseContent();

                // Save the booking information to the database using the saveBooking method
                long newRowId = dbHelper.saveBooking(name, idNumber, date, startTime, endTime, pax);

                // Check if required fields are not empty
                if (idNumber.isEmpty() || name.isEmpty() || date.isEmpty() ||
                        startTime.isEmpty() || endTime.isEmpty() || pax.isEmpty()) {
                    Toast.makeText(requireContext(), "Please fill in all required fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Proceed with database insertion
                    // ...

                    // Display success or error message based on newRowId
                    if (newRowId != -1) {
                        Toast.makeText(requireContext(), "Booking for " + name + " is successful!", Toast.LENGTH_SHORT).show();

                        // Clear the form fields after a successful booking
                        clearFormFields();
                    } else {
                        Toast.makeText(requireContext(), "Error saving booking.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Set onClickListener for "BACK" button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.navigation_home);
            }
        });

        return root;
    }

    private void clearFormFields() {
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        editTextRoomType.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}