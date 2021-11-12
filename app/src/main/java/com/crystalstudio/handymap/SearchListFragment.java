package com.crystalstudio.handymap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class SearchListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_list, container, false);
    }

    RecyclerView recyclerView;
    PlaceListRecyclerAdapter placeListRecyclerAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);

        //MainActivity의 Place데이터를 가져오기 위해 MainActivity를 참조
        MainActivity ma = (MainActivity) getActivity();
        if(ma.searchApiResponse==null)return;

        placeListRecyclerAdapter = new PlaceListRecyclerAdapter(getActivity(), ma.searchApiResponse.documents);
        recyclerView.setAdapter(placeListRecyclerAdapter);

    }
}
