package com.example.music.all_list_viet;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;
import com.example.music.my_interface.IClickItem;
import com.example.music.phatnhac;

import java.util.List;

public class ListuserAdapter extends RecyclerView.Adapter<ListuserAdapter.ListViewHolder> {


    private List<ListUser> mListListUser;
    private IClickItem iClickItem;

    public ListuserAdapter( List<ListUser> mListListUser, IClickItem listener) {
        this.iClickItem = listener;
    }

    public void setData(List<ListUser> list){
        this.mListListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListuserAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_allviet,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListuserAdapter.ListViewHolder holder, int position) {
        final ListUser listUser = mListListUser.get(position);
        if (listUser == null){
            return;
        }
        holder.imageView.setImageResource(listUser.getResourceId());
        holder.textView1.setText(listUser.getTenbaihat());
        holder.textView2.setText(listUser.getTencasy());

        holder.listall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItem.onclickImage(listUser);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mListListUser != null){
            return mListListUser.size();
        }
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        private CardView listall;
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_list);
            textView1 = itemView.findViewById(R.id.ten_bai_hat);
            textView2 = itemView.findViewById(R.id.ten_ca_sy);
            listall = itemView.findViewById(R.id.list_all);
        }
    }

}
