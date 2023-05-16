package com.example.music.book1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;

import java.util.List;

public class Book1Adapter extends RecyclerView.Adapter<Book1Adapter.BookViewHolder> {
    private List<book1> mBooks;
    public void setData(List<book1> list){
        this.mBooks = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book1,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        book1 book1 = mBooks.get(position);
        if (book1 == null){
            return;
        }
        holder.imgBook1.setImageResource(book1.getResourceId());
        holder.tvTitle1.setText(book1.getTitle());
    }

    @Override
    public int getItemCount() {
        if( mBooks != null){
            return mBooks.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgBook1;
        private TextView tvTitle1;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBook1 = itemView.findViewById(R.id.img_book1);
            tvTitle1 = itemView.findViewById(R.id.tv_title1);
        }
    }
}
