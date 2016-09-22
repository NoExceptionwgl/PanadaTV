package com.qf.administrator.xiongmao.adapters.homediabloadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.models.homemodel.DiabloModel;

import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class DiabloAdapter extends RecyclerView.Adapter<DiabloAdapter.ViewHolder> implements View.OnClickListener {

    private List<DiabloModel.DataBean.ItemsBean> data;
    private LayoutInflater inflater;
    private OnClickListener listener;
    private RecyclerView recyclerView;

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public DiabloAdapter(Context context, List<DiabloModel.DataBean.ItemsBean> data) {
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void setDataRes(List<DiabloModel.DataBean.ItemsBean> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();

    }

    public void addDataRes(List<DiabloModel.DataBean.ItemsBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.fragment_diablo_item, parent, false);
        inflate.setOnClickListener(this);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.diabloText01.setText(data.get(position).getName());
        holder.diabloText02.setText(data.get(position).getUserinfo().getNickName());
        String person_num = data.get(position).getPerson_num();
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        double v = Double.parseDouble(decimalFormat.format(Double.parseDouble(person_num) / 1000));
        holder.diabloText03.setText(v+"万");
        x.image().bind(holder.diabloImage,data.get(position).getPictures().getImg());
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void onClick(View v) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(v);
        if (listener!=null) {
            listener.OnItemClickListener(childAdapterPosition);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.diablo_image)
        ImageView diabloImage;
        @InjectView(R.id.diablo_text01)
        TextView diabloText01;
        @InjectView(R.id.diablo_text02)
        TextView diabloText02;
        @InjectView(R.id.diablo_text03)
        TextView diabloText03;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }
    public interface OnClickListener{
        void OnItemClickListener(int position);
    }
}
