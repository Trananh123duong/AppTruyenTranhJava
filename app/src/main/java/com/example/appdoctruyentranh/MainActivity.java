package com.example.appdoctruyentranh;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.ComponentActivity;

import com.example.appdoctruyentranh.adapter.TruyenTranhAdapter;
import com.example.appdoctruyentranh.object.TruyenTranh;

import java.util.ArrayList;

public class MainActivity extends ComponentActivity {
    GridView gdvDSTruyen;
    TruyenTranhAdapter adapter;
    ArrayList<TruyenTranh> truyenTranhArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
    }

    private void init () {
        truyenTranhArrayList = new ArrayList<>();
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Được Các Anh Trai Chiều Chuộng Tôi Trở Nên Ngang Tàng", " Chương 253 ", "https://cdnntx.com/nettruyen/thumb/duoc-cac-anh-trai-chieu-chuong-toi-tro-nen-ngang-tang.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Captain Tsubasa", " Chapter 27 ", "https://cdnntx.com/nettruyen/thumb/captain-tsubasa.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Ngạ Quỷ Tokyo", " Chapter 66 ", "https://cdnntx.com/nettruyen/thumb/nga-quy-tokyo.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Blame!", " Chapter 30 ", "https://cdnntx.com/nettruyen/thumb/blame.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Được Các Anh Trai Chiều Chuộng Tôi Trở Nên Ngang Tàng", " Chương 253 ", "https://cdnntx.com/nettruyen/thumb/duoc-cac-anh-trai-chieu-chuong-toi-tro-nen-ngang-tang.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Captain Tsubasa", " Chapter 27 ", "https://cdnntx.com/nettruyen/thumb/captain-tsubasa.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Ngạ Quỷ Tokyo", " Chapter 66 ", "https://cdnntx.com/nettruyen/thumb/nga-quy-tokyo.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Blame!", " Chapter 30 ", "https://cdnntx.com/nettruyen/thumb/blame.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Được Các Anh Trai Chiều Chuộng Tôi Trở Nên Ngang Tàng", " Chương 253 ", "https://cdnntx.com/nettruyen/thumb/duoc-cac-anh-trai-chieu-chuong-toi-tro-nen-ngang-tang.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Captain Tsubasa", " Chapter 27 ", "https://cdnntx.com/nettruyen/thumb/captain-tsubasa.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Ngạ Quỷ Tokyo", " Chapter 66 ", "https://cdnntx.com/nettruyen/thumb/nga-quy-tokyo.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Blame!", " Chapter 30 ", "https://cdnntx.com/nettruyen/thumb/blame.jpg"));

        adapter = new TruyenTranhAdapter(this, 0, truyenTranhArrayList);
    }
    private void anhXa () {
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
    }
    private void setUp () {
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick () {}
}