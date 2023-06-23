package com.example.mobilmotors.ui.compart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobilmotors.R;
import com.example.mobilmotors.databinding.FragmentCompartBinding;

public class CompartFragment extends Fragment {

    private FragmentCompartBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentCompartBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View v, Bundle bundle){
        super.onViewCreated(v, bundle);

        binding.btCompart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Compatilhe em todas nas redes sociais !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}