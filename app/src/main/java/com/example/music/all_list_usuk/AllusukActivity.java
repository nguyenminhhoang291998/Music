package com.example.music.all_list_usuk;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;
import com.example.music.my_interface.IClickItemusuk;
import com.example.music.phatnhac;

import java.util.ArrayList;
import java.util.List;

public class AllusukActivity extends AppCompatActivity {

    private RecyclerView rcvview;
    private ListuserAdapter mlistuserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_allusuk);

        rcvview = findViewById(R.id.list_usuk);
        mlistuserAdapter = new ListuserAdapter(this);
//        mlistuserAdapter = new ListuserAdapter(getListListuser(), new IClickItemusuk() {
//            @Override
//            public void onclickImage(ListUser listUser) {
//                onClickGoTophatnhac(listUser);
//            }
//        });


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvview.setLayoutManager(gridLayoutManager);

        mlistuserAdapter.setData(getListListuser());
        rcvview.setAdapter(mlistuserAdapter);
    }

    private List<ListUser> getListListuser() {
        List<ListUser> list = new ArrayList<>();

        list.add(new ListUser(R.drawable.usuk_despacito,"Despacito","Luis Fonsi"));
        list.add(new ListUser(R.drawable.usuk_dont_start_now,"Don't start now","Dua Lipa"));
        list.add(new ListUser(R.drawable.usuk_girllikeyou,"Girl like you","Maroon 5"));
        list.add(new ListUser(R.drawable.usuk_hello,"Hello","Adele"));
        list.add(new ListUser(R.drawable.usuk_it_will_rain,"It will rain","Bruno Mars"));
        list.add(new ListUser(R.drawable.usuk_let_you_love_me,"Let you love me","Rita Ora"));
        list.add(new ListUser(R.drawable.usuk_on_my_way,"On my way","Alan Walker"));
        list.add(new ListUser(R.drawable.usuk_photograph,"Photograph","Ed Sheeran"));
        list.add(new ListUser(R.drawable.usuk_see_you_again,"See you again","Wiz Khalifa"));
        list.add(new ListUser(R.drawable.usuk_someonelikeyou,"Someone like you","Adele"));
        list.add(new ListUser(R.drawable.usuk_we_dont_talk_anymore,"We don't talk anymore","Charlie Puth"));


        return list;
    }
    private void onClickGoTophatnhac(ListUser listUser){
        Intent intent = new Intent(this, phatnhac.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user1", listUser);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}