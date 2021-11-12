package com.crystalstudio.handymap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaceListRecyclerAdapter extends RecyclerView.Adapter {

    //운영체제 능력을 갖고 있는 변수
    Context context;

    //대량 데이터 List
    List<Place> places;

    //생성자 - 객체가 new될때 자동으로 실행되는 메소드
    public PlaceListRecyclerAdapter(Context context, List<Place> places) {
        this.context = context;
        this.places = places;
    }

    @NonNull
    @Override
//    만드는 공장
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //운영체제로부터 불러옴 (context)
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.recycler_item_list_fragment, parent, false);
        VH vh = new VH(itemView);
        return vh;
    }
//    만든 현수막을 뷰로 보여주는 홀더
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh = (VH) holder; //형 변환

        Place place = places.get(position);
        vh.tvPlaceName.setText(place.place_name);
        if(place.road_address_name.equals("")) vh.tvAddress.setText(place.address_name);
        else vh.tvAddress.setText(place.road_address_name);
        vh.tvDistance.setText(place.distance+'m');
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    //현수막 1개 객체(아이템뷰)
    class VH extends RecyclerView.ViewHolder {

        TextView tvPlaceName;
        TextView tvDistance;
        TextView tvAddress;

        public VH(@NonNull View itemView) {
            super(itemView);

            tvPlaceName = itemView.findViewById(R.id.tv_place_name);
            tvDistance = itemView.findViewById(R.id.tv_distance);
            tvAddress = itemView.findViewById(R.id.tv_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int index = getAdapterPosition();

                    Intent intent = new Intent(context, PlaceUrlActivity.class);
                    intent.putExtra("place_url", places.get(index).place_url);
                    context.startActivity(intent);
                }
            });
        }
    }


}
