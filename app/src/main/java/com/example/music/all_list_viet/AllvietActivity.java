package com.example.music.all_list_viet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telecom.Call;
import android.view.WindowManager;

import com.example.music.R;
import com.example.music.my_interface.IClickItem;
import com.example.music.phatnhac;

import java.util.ArrayList;
import java.util.List;

public class AllvietActivity extends AppCompatActivity {

    private RecyclerView rcvview;
    private ListuserAdapter listuserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_allviet);

        rcvview = findViewById(R.id.list_viet);
        listuserAdapter = new ListuserAdapter(getListListuser(), new IClickItem() {
            @Override
            public void onclickImage(ListUser listUser) {
                onClickGoTophatnhac(listUser);
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvview.setLayoutManager(linearLayoutManager);

        // viền khung giữa các view trong ryceclerview
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvview.addItemDecoration(itemDecoration);

        listuserAdapter.setData(getListListuser());
        rcvview.setAdapter(listuserAdapter);
    }

    private List<ListUser> getListListuser() {
        List<ListUser> list = new ArrayList<>();

        list.add(new ListUser(R.drawable.viet_hat_chuyen_cua_mua_dong,"Chuyện của mùa đông","Hà Anh Tuấn"));
        list.add(new ListUser(R.drawable.viet_pmq_co_chang_trai_viet_len_cay,"Có chàng trai viết lên cây","Phan Mạnh Quỳnh"));
        list.add(new ListUser(R.drawable.viet_sontung_chay_ngay_di,"Chạy ngay đi","Sơn Tùng MTP"));
        list.add(new ListUser(R.drawable.viet_pmq_vo_nguoi_ta,"Vợ người ta","Phan Mạnh Quỳnh"));
        list.add(new ListUser(R.drawable.viet_sontung_chung_ta_cua_hien_tai,"Chúng ta của hiện tại","Sơn Tùng MTP"));
        list.add(new ListUser(R.drawable.viet_hat_thang_tu_la_loi_noi_doi_cua_em,"Tháng tư là lời nói dối của em","Hà Anh Tuấn"));
        list.add(new ListUser(R.drawable.viet_hat_ve_di_em,"Về đi em","Hà Anh Tuấn"));
        list.add(new ListUser(R.drawable.viet_mytam_dung_hoi_em,"Đừng hỏi em","Mỹ Tâm"));
        list.add(new ListUser(R.drawable.viet_pmq_khi_phai_quen_di,"Khi phải quên đi","Phan Mạnh Quỳnh"));
        list.add(new ListUser(R.drawable.viet_mytam_dau_chi_rieng_em,"Đâu chỉ riêng em","Mỹ Tâm"));
        list.add(new ListUser(R.drawable.viet_sontung_hay_trao_cho_anh,"Hãy trao cho anh","Sơn Tùng MTP"));
        list.add(new ListUser(R.drawable.viet_pmq_hay_ra_khoi_nguoi_do_di,"Hãy ra khỏi người đó đi","Phan Mạnh Quỳnh"));
        list.add(new ListUser(R.drawable.viet_hat_nguoi_tinh_mua_dong,"Người tình mùa đông","Hà Anh Tuấn"));
        list.add(new ListUser(R.drawable.viet_sontung_lac_troi,"Lạc trôi","Sơn Tùng MTP"));
        list.add(new ListUser(R.drawable.viet_mytam_hen_uoc_tu_hu_vo,"Hẹn ước từ hư vô","Mỹ Tâm"));
        list.add(new ListUser(R.drawable.viet_sontung_nhu_ngay_hom_qua,"Như ngày hôm qua","Sơn Tùng MTP"));
        list.add(new ListUser(R.drawable.viet_pmq_khi_nguoi_minh_yeu_khoc,"Khi người mình yêu khóc","Phan Mạnh Quỳnh"));
        list.add(new ListUser(R.drawable.viet_sontung_noi_nay_co_anh,"Nơi này có anh","Sơn Tùng MTP"));
        list.add(new ListUser(R.drawable.viet_hat_nguoi_con_gai_ta_thuong,"Người con gái ta thương","Hà Anh Tuấn"));
        list.add(new ListUser(R.drawable.viet_mytam_chuyen_nhu_chua_bat_dau,"Chuyện như chưa bắt đầu","Mỹ Tâm"));
        list.add(new ListUser(R.drawable.viet_pmq_nuoc_ngoai,"Nước ngoài","Phan Mạnh Quỳnh"));
        list.add(new ListUser(R.drawable.viet_hat_thang_may_em_nho_anh,"Tháng mấy em nhớ anh","Hà Anh Tuấn"));
        list.add(new ListUser(R.drawable.viet_mytam_nhu_mot_giac_mo,"Như một giấc mơ","Mỹ Tâm"));
        list.add(new ListUser(R.drawable.viet_sontung_am_tham_ben_em,"Âm thầm bên em","Sơn Tùng MTP"));
        list.add(new ListUser(R.drawable.viet_sontung_buong_doi_tay_nhau_ra,"Buông đôi tay nhau ra","Sơn Tùng MTP"));
        list.add(new ListUser(R.drawable.viet_pmq_nhat,"Nhạt","Phan Mạnh Quỳnh"));
        list.add(new ListUser(R.drawable.viet_pmq_tri_ky,"Tri kỷ","Phan Mạnh Quỳnh"));
        list.add(new ListUser(R.drawable.viet_sontung_co_chac_yeu_la_day,"Có chắc yêu là đây","Sơn Tùng MTP"));
        list.add(new ListUser(R.drawable.viet_pmq_anh_ghet_lam_ban_em,"Anh ghét làm bạn em","Phan Mạnh Quỳnh"));

        return list;
    }

    private void onClickGoTophatnhac(ListUser listUser){
        Intent intent = new Intent(this, phatnhac.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", listUser);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}