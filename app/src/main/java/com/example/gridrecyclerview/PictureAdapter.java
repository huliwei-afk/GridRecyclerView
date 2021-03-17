package com.example.gridrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//继承RecyclerView.Adapter就必须重写 onCreateViewHolder()，onBindViewHolder(), getItemCount()三个方法
public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {

    private List<Picture> mPictureList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pictureImage;
        TextView pictureName;

        public ViewHolder(View view){
            super(view);
            pictureImage = (ImageView)view.findViewById(R.id.picture_image);
            pictureName = (TextView)view.findViewById(R.id.picture_name);
        }
    }

    public PictureAdapter(List<Picture> pictureList){
        mPictureList = pictureList;
    }

    //创建viewHolder实例
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.picture_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //对RecyclerView子项的数据进行赋值
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picture picture = mPictureList.get(position);
        holder.pictureImage.setImageResource(picture.getImageId());
        holder.pictureName.setText(picture.getName());
    }

    //返回RecyclerView的总子项数量
    @Override
    public int getItemCount() {
        return mPictureList.size();
    }
}
