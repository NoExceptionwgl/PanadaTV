package com.qf.administrator.xiongmao.adapters.gameadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.models.GameActivityModel;

import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by a on 2016/9/20.
 */
public class GameActivityAdapter extends RecyclerView.Adapter<GameActivityAdapter.ViewHolder> implements View.OnClickListener {

    private List<GameActivityModel.DataBean.ItemsBean> data;
    private LayoutInflater inflater;

    private OnItemClickOne onItemClickOne;
    private RecyclerView mRecyclerView;

    public void setOnItemClickOne(OnItemClickOne onItemClickOne) {
        this.onItemClickOne = onItemClickOne;
    }

    public GameActivityAdapter(List<GameActivityModel.DataBean.ItemsBean> data, Context context) {
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void updateRes(List<GameActivityModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addRes(List<GameActivityModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = inflater.inflate(R.layout.game_activity_item, parent, false);
        layout.setOnClickListener(this);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mShowTime.setText(data.get(position).getName());
        holder.mName.setText(data.get(position).getUserinfo().getNickName());
        String person_num = data.get(position).getPerson_num();
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        double parseDouble = Double.parseDouble(decimalFormat.format(Double.parseDouble(person_num)/10000));
        holder.mShowcount.setText(parseDouble+"万");
        x.image().bind(holder.iv,data.get(position).getPictures().getImg());
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        if (onItemClickOne!=null) {
            onItemClickOne.onType(position);
        }
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.stu_game_activity_item_iv)
        ImageView iv;
        @InjectView(R.id.stu_game_activity_item_showtime)
        TextView mShowTime;
        @InjectView(R.id.stu_game_activity_item_name)
        TextView mName;
        @InjectView(R.id.stu_game_activity_item_showcount)
        TextView mShowcount;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
    public interface OnItemClickOne{
        void onType(int position);
    }
}
