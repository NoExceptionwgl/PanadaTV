package com.qf.administrator.xiongmao.adapters.homehearthstoneadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.models.homemodel.HearthstoneModel;

import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class HearthstoneAdapter extends RecyclerView.Adapter<HearthstoneAdapter.ViewHolder> implements View.OnClickListener {

    private List<HearthstoneModel.DataBean.ItemsBean> data;

    private LayoutInflater inflater;
    private RecyclerView recyclerView;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public HearthstoneAdapter(Context context, List<HearthstoneModel.DataBean.ItemsBean> data) {
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void setDataRes(List<HearthstoneModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }

    }

    public void addDataRes(List<HearthstoneModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.fragment_hearthstone_item, parent, false);
        inflate.setOnClickListener(this);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.hearthstoneText01.setText(data.get(position).getName());
        holder.hearthstoneText02.setText(data.get(position).getUserinfo().getNickName());
        String person_num = data.get(position).getPerson_num();
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        double v = Double.parseDouble(decimalFormat.format(Double.parseDouble(person_num) / 1000));
        holder.hearthstoneText03.setText(v+"万");
        x.image().bind(holder.hearthstoneImage,data.get(position).getPictures().getImg());

    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void onClick(View v) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(v);
        if (listener!=null) {
            listener.OnClickListener(childAdapterPosition);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.hearthstone_image)
        ImageView hearthstoneImage;
        @InjectView(R.id.hearthstone_text01)
        TextView hearthstoneText01;
        @InjectView(R.id.hearthstone_text02)
        TextView hearthstoneText02;
        @InjectView(R.id.hearthstone_text03)
        TextView hearthstoneText03;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }
    public interface OnItemClickListener{
        void OnClickListener(int position);
    }

}
