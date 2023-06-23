package com.example.mobilmotors.ui.avaliar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobilmotors.R;
import com.example.mobilmotors.databinding.FragmentAvaliarBinding;

public class AvaliarFragment extends Fragment {

    private FragmentAvaliarBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentAvaliarBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View v, Bundle bundle){
        super.onViewCreated(v, bundle);

        binding.btAvaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Obrigado por avaliar !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}