package com.example.music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.example.music.Photo_dau_trang.Photo;
import com.example.music.Photo_dau_trang.PhotoAdapter;
import com.example.music.all_list_usuk.AllusukActivity;
import com.example.music.all_list_viet.AllvietActivity;
import com.example.music.book.BookAdapter;
import com.example.music.book.book;
import com.example.music.book1.Book1Adapter;
import com.example.music.book1.book1;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private List<Photo> mListPhoto;
    private Timer mTimer;
    private RecyclerView rcvbook;
    private BookAdapter bookAdapter;
    private RecyclerView rcvbook1;
    private Book1Adapter book1Adapter;
    private TextView tv_vpop;
    private TextView tv_usuk1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);

        //Ánh xạ + bắt sự kiện nút usuk hits chuyển qua list nhạc usuk
        tv_usuk1 = findViewById(R.id.tv_usuk1);
        tv_usuk1.setOnClickListener( new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllusukActivity.class);
                startActivity(intent);
            }
        });

        //Ánh xạ + bắt sự kiện nút V-pop chuyển qua list nhạc việt
        tv_vpop = findViewById(R.id.tv_vpop);
        tv_vpop.setOnClickListener( new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllvietActivity.class);
                startActivity(intent);
            }
        });

        //ryceclerview usuk
        rcvbook = findViewById(R.id.rcv_book);
        bookAdapter = new BookAdapter();

        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvbook.setLayoutManager(LinearLayoutManager);

        bookAdapter.setData(getListBook());
        rcvbook.setAdapter(bookAdapter);

        //ryceclerview vpop
        rcvbook1 = findViewById(R.id.rcv_book1);
        book1Adapter = new Book1Adapter();

        LinearLayoutManager LinearLayoutManager1 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvbook1.setLayoutManager(LinearLayoutManager1);

        book1Adapter.setData(getListBook1());
        rcvbook1.setAdapter(book1Adapter);

        //photo dau trang
        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicator);

        mListPhoto = getListPhoto();

        photoAdapter = new PhotoAdapter(this, mListPhoto);
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        autoSlideImages();
    }
    private List<Photo> getListPhoto() {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.ngang_ngay_chua_giong_bao));
        list.add(new Photo(R.drawable.ngang_helo));
        list.add(new Photo(R.drawable.ngang_ngay_dau_tien));
        list.add(new Photo(R.drawable.ngang_cctvlc));

        return list;
    }

    private List<book> getListBook() {
        List<book> listBook = new ArrayList<>();

        listBook.add(new book(R.drawable.on_my_way,"On My Way"));
        listBook.add(new book(R.drawable.girllikeyou,"Girl Like You"));
        listBook.add(new book(R.drawable.someonelikeyou,"Someone Like You"));
        listBook.add(new book(R.drawable.perfect,"Perfect"));

        return listBook;
    }
    private List<book1> getListBook1() {
        List<book1> listBook1 = new ArrayList<>();

        listBook1.add(new book1(R.drawable.viet_sontung_chay_ngay_di,"Chạy ngay đi"));
        listBook1.add(new book1(R.drawable.viet_hat_chuyen_cua_mua_dong,"Chuyện của mùa đông"));
        listBook1.add(new book1(R.drawable.viet_pmq_tri_ky,"Tri Kỷ"));
        listBook1.add(new book1(R.drawable.viet_mytam_chuyen_nhu_chua_bat_dau,"Chuyện như chưa bắt đầu"));
        listBook1.add(new book1(R.drawable.viet_sontung_co_chac_yeu_la_day,"Có chắc yêu là đây"));

        return listBook1;
    }

    private void autoSlideImages(){
        if (mListPhoto == null || mListPhoto.isEmpty() || viewPager == null ){
            return;
        }

        if(mTimer == null ){
            mTimer = new Timer();
        }

        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = mListPhoto.size() - 1;
                        if(currentItem < totalItem){
                            currentItem ++;
                            viewPager.setCurrentItem(currentItem);
                        } else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });

            }
        }, 500,3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null){
            mTimer.cancel();
            mTimer = null;
        }
    }
}