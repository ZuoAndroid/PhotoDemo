package com.zwb.photodemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zwb.photodemo.R;
import com.zwb.photodemo.Utils.BitmapHelper;
import com.zwb.photodemo.bean.Songs;

import java.util.Collection;
import java.util.List;

/**
 * Created by ZuoWenBin on 2015/7/22 0022.
 * Email: zuoandroid@gmail.com
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>{
    private Context context;
    private List<Songs> list;

    public SongAdapter(Context context, List<Songs> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Songs songs = list.get(position);
        Log.d("TAG",songs.toString());
        holder.song_title.setText("歌名：" + songs.getSong_title());
        holder.album_title.setText("专辑：" + songs.getAlbum_title());
        holder.artist_name.setText("歌手："+songs.getArtist_name());
        BitmapHelper.getUtils().display(holder.songImg,songs.getPicture_300_300());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addAll(Collection<? extends Songs> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        @ViewInject(R.id.song_Img)
        private ImageView songImg;
        @ViewInject(R.id.song_title)
        private TextView song_title;
        @ViewInject(R.id.album_title)
        private TextView album_title;
        @ViewInject(R.id.artist_name)
        private TextView artist_name;
        public ViewHolder(View itemView) {
            super(itemView);
            ViewUtils.inject(this,itemView);
        }
    }
}
