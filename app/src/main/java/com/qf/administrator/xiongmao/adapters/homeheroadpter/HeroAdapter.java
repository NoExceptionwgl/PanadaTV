package com.qf.administrator.xiongmao.adapters.homeheroadpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.models.homemodel.HeroModel;

import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> implements View.OnClickListener {

    private List<HeroModel.DataBean.ItemsBean> data;
    private LayoutInflater inflater;
    private OnClickListener listener;
    private RecyclerView recyclerView;

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public HeroAdapter(Context context, List<HeroModel.DataBean.ItemsBean> data) {
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void setDataRes(List<HeroModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addDataRes(List<HeroModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.fragment_hero_item, parent, false);
        inflate.setOnClickListener(this);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.heroText01.setText(data.get(position).getName());
        holder.heroText02.setText(data.get(position).getUserinfo().getNickName());
        String person_num = data.get(position).getPerson_num();
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        double v = Double.parseDouble(decimalFormat.format(Double.parseDouble(person_num) / 1000));
        holder.heroText03.setText(v+"万");
        x.image().bind(holder.heroImage,data.get(position).getPictures().getImg());
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onClick(View v) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(v);
        if (listener!=null) {
            listener.onItemClickListener(childAdapterPosition);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.hero_image)
        ImageView heroImage;
        @InjectView(R.id.hero_text01)
        TextView heroText01;
        @InjectView(R.id.hero_text02)
        TextView heroText02;
        @InjectView(R.id.hero_text03)
        TextView heroText03;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }
    public interface OnClickListener{
        void onItemClickListener(int position);
    }
}
