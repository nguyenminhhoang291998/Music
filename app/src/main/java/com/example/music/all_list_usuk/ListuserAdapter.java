package com.example.music.all_list_usuk;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;
import com.example.music.my_interface.IClickItemusuk;

import java.util.List;

public class ListuserAdapter extends RecyclerView.Adapter<ListuserAdapter.ListViewHolder> {

    private Context mContext;
    private List<ListUser> mListListUser;

    public ListuserAdapter(Context mContext) {
        this.mContext = mContext;
    }


   public void setData(List<ListUser> list){
       this.mListListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListuserAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_allusuk,parent,false);
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

//        holder.listall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iClickItemusuk.onclickImage(listUser );

//            }
//        });
    }

    @Override
    public int getItemCount() {
        if(mListListUser != null){
            return mListListUser.size();
        }
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

//        private RecyclerView listall;
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_list1);
            textView1 = itemView.findViewById(R.id.ten_bai_hat1);
            textView2 = itemView.findViewById(R.id.ten_ca_sy1);
//            listall = itemView.findViewById(R.id.list_usuk);
        }
    }

}
