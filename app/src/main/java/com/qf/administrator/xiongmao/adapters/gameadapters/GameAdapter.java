package com.qf.administrator.xiongmao.adapters.gameadapters;

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
public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> implements View.OnClickListener {


    //
    private List<GameModel.DataBean> data;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;
    private OnItemClick listener;

    public void setListener(OnItemClick listener) {
        this.listener = listener;
    }

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
        layout.setOnClickListener(this);
        return new ViewHolder(layout);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
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

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        String cname = data.get(position).getCname();
        String ename = data.get(position).getEname();
        if (listener!=null) {
            listener.onItem(position,cname,ename);
        }
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

    public interface OnItemClick{
        void onItem(int position,String cname,String ename);
    }
}
