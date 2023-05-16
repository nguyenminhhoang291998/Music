package com.example.music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.music.all_list_viet.ListUser;

public class phatnhac extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //fullcreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_phatnhac);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
//        ListUser listUser = (ListUser) bundle.get("object_user");
        ListUser listUser = (ListUser) bundle.get("object_user");

        // truyền ảnh, tên bài hát và ca sỹ
        ImageView img_phatnhac = findViewById(R.id.img_phatnhac);
        img_phatnhac.setImageResource(listUser.getResourceId());

        TextView tv_tenbaihat = findViewById(R.id.tenbaihat_phatnhac);
        tv_tenbaihat.setText(listUser.getTenbaihat());

        TextView tv_tencasy = findViewById(R.id.tencasy_phatnhac);
        tv_tencasy.setText(listUser.getTencasy());

    }
}