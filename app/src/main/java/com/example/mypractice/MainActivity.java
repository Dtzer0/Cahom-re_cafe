package com.example.mypractice;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Intent.ACTION_DIAL;
import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //공차
        Button cafe1 = findViewById(R.id.cafe1);

        cafe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_VIEW,
                        Uri.parse("http://www.gong-cha.co.kr/"));
                startActivity(intent);
            }
        });

        //빽다방
        Button cafe2 = findViewById(R.id.cafe2);

        cafe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_VIEW,
                        Uri.parse("http://paikdabang.com/"));
                startActivity(intent);
            }
        });

        //메가커피
        Button cafe3 = findViewById(R.id.cafe3);

        cafe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_VIEW,
                        Uri.parse("http://www.megacoffee.me/"));
                startActivity(intent);
            }
        });

        //스타벅스
        Button cafe4 = findViewById(R.id.cafe4);

        cafe4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_VIEW,
                        Uri.parse("https://www.starbucks.co.kr/"));
                startActivity(intent);
            }
        });

        //전화
        Button call = findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button2();
            }
        });

        //지도
        Button map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button3();
            }
        });

        //시작
        final Button start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

        //종료 버튼
        Button stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("정말로 종료하시겠습니까?");
                builder.setTitle("종료 알림창")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("종료 알림창");
                alert.show();
            }
        });

    }

    //바깥에 빼냈음 (함수 구조 느낌이다)
    public void Button2(){
        Intent intent = new Intent(ACTION_DIAL,
                Uri.parse("tel:0415731669"));
        startActivity(intent);
    }

    public void Button3() {
        Intent intent = new Intent(ACTION_VIEW,
                Uri.parse("https://map.naver.com/"));
        startActivity(intent);
    }

    public void start() {
        Toast.makeText(this, "시작 버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
    }
}
