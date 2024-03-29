package com.example.appdoctruyentranh;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import com.example.appdoctruyentranh.adapter.TruyenTranhAdapter;
import com.example.appdoctruyentranh.api.ApiLayTruyen;
import com.example.appdoctruyentranh.interfaces.LayTruyenVe;
import com.example.appdoctruyentranh.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends ComponentActivity implements LayTruyenVe {
    GridView gdvDSTruyen;
    TruyenTranhAdapter adapter;
    ArrayList<TruyenTranh> truyenTranhArrayList;
    EditText edtTimKiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
        new ApiLayTruyen(this).execute();
    }

    private void init () {
        truyenTranhArrayList = new ArrayList<>();

//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Được Các Anh Trai Chiều Chuộng Tôi Trở Nên Ngang Tàng", " Chương 253 ", "https://cdnntx.com/nettruyen/thumb/duoc-cac-anh-trai-chieu-chuong-toi-tro-nen-ngang-tang.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Captain Tsubasa", " Chapter 27 ", "https://cdnntx.com/nettruyen/thumb/captain-tsubasa.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Ngạ Quỷ Tokyo", " Chapter 66 ", "https://cdnntx.com/nettruyen/thumb/nga-quy-tokyo.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Blame!", " Chapter 30 ", "https://cdnntx.com/nettruyen/thumb/blame.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Được Các Anh Trai Chiều Chuộng Tôi Trở Nên Ngang Tàng", " Chương 253 ", "https://cdnntx.com/nettruyen/thumb/duoc-cac-anh-trai-chieu-chuong-toi-tro-nen-ngang-tang.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Captain Tsubasa", " Chapter 27 ", "https://cdnntx.com/nettruyen/thumb/captain-tsubasa.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Ngạ Quỷ Tokyo", " Chapter 66 ", "https://cdnntx.com/nettruyen/thumb/nga-quy-tokyo.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Blame!", " Chapter 30 ", "https://cdnntx.com/nettruyen/thumb/blame.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Được Các Anh Trai Chiều Chuộng Tôi Trở Nên Ngang Tàng", " Chương 253 ", "https://cdnntx.com/nettruyen/thumb/duoc-cac-anh-trai-chieu-chuong-toi-tro-nen-ngang-tang.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Captain Tsubasa", " Chapter 27 ", "https://cdnntx.com/nettruyen/thumb/captain-tsubasa.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Ngạ Quỷ Tokyo", " Chapter 66 ", "https://cdnntx.com/nettruyen/thumb/nga-quy-tokyo.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Truyện tranh Blame!", " Chapter 30 ", "https://cdnntx.com/nettruyen/thumb/blame.jpg"));

        adapter = new TruyenTranhAdapter(this, 0, truyenTranhArrayList);
    }
    private void anhXa () {
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
        edtTimKiem = findViewById(R.id.edtTimKiem);
    }
    private void setUp () {
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick () {
        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtTimKiem.getText().toString();
                adapter.sortTruyen(s);
            }
        });
    }

    @Override
    public void batDau() {
        Toast.makeText(this, "Đang lấy về", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            truyenTranhArrayList.clear();
            JSONArray arr = new JSONArray(data);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                truyenTranhArrayList.add(new TruyenTranh(o));
            }
            adapter = new TruyenTranhAdapter(this, 0, truyenTranhArrayList);
            gdvDSTruyen.setAdapter(adapter);
        } catch (Exception e) {

        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
    }
}