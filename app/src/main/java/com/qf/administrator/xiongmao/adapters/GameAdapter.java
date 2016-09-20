package com.qf.administrator.xiongmao.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.models.GameModel;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by a on 2016/9/20.
 */
public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private List<GameModel.DataBean> data;
    private LayoutInflater inflater;

    public GameAdapter(Context context, List<GameModel.DataBean> data) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        inflater = LayoutInflater.from(context);
    }

    public void updateRes(List<GameModel.DataBean> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = inflater.inflate(R.layout.game_item, parent, false);
        return new ViewHolder(layout);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getCname());
        x.image().bind(holder.iv,data.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.stu_game_item_iv)
        ImageView iv;
        @InjectView(R.id.stu_game_item_tv)
        TextView tv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
