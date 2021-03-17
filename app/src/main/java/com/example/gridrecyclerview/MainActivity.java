package com.example.gridrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Picture> pictureList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPictures();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //第一个参数是getContext()取得上下文
        //第二参数是控制显示多少列
        //第三个参数是控制滚动方向和LinearLayout一样
        //第四个参数是控制是否反向排列单这个分很多种情况
        GridLayoutManager layoutManager = new GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        PictureAdapter adapter = new PictureAdapter(pictureList);
        recyclerView.setAdapter(adapter);
    }

    private void initPictures(){
        for(int i = 0; i < 5; i++){
            Picture pic1 = new Picture(getRandomLengthName("Pic1"), R.drawable.timg3);
            pictureList.add(pic1);

            Picture pic2 = new Picture(getRandomLengthName("Pic2"), R.drawable.timg14);
            pictureList.add(pic2);

            Picture pic3 = new Picture(getRandomLengthName("Pic3"), R.drawable.timg22);
            pictureList.add(pic3);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i = 2; i < length; i++){
            builder.append(name);
        }
        return builder.toString();
    }


}
