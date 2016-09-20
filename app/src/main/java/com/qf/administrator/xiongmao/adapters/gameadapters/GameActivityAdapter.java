package com.qf.administrator.xiongmao.adapters.gameadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.models.GameActivityModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2016/9/20.
 */
public class GameActivityAdapter extends RecyclerView.Adapter<GameActivityAdapter.ViewHolder> {

    private List<GameActivityModel.DataBean>data;
    private LayoutInflater inflater;

    public GameActivityAdapter(List<GameActivityModel.DataBean> data, Context context) {
        inflater = LayoutInflater.from(context);
        if (data!=null) {
            this.data = data;
        }else{
            this.data = new ArrayList<>();
        }
    }

    public void updateRes(List<GameActivityModel.DataBean> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = inflater.inflate(R.layout.game_activity_item, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    static class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
