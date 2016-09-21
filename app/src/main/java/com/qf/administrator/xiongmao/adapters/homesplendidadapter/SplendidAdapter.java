package com.qf.administrator.xiongmao.adapters.homesplendidadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.models.homemodel.HomeModel;

import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 *
 */
public class SplendidAdapter extends RecyclerView.Adapter<SplendidAdapter.ViewHolder> implements View.OnClickListener {

    private List<HomeModel.DataBean.ItemsBean> data;
    private LayoutInflater inflater;
    private RecyclerView recyclerView;
    private OneItemClicOne listener;

    public void setListener(OneItemClicOne listener) {
        this.listener = listener;
    }

    public SplendidAdapter(Context context, List<HomeModel.DataBean.ItemsBean> data) {
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }

    }

    public void setDataRes(List<HomeModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }

    }

    public void addDataRes(List<HomeModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.fragment_splendid_item, parent, false);
        inflate.setOnClickListener(this);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.splendidText01.setText(data.get(position).getName());
        holder.splendidText02.setText(data.get(position).getUserinfo().getNickName());

        String person_num = data.get(position).getPerson_num();
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        double aDouble = Double.parseDouble(decimalFormat.format(Double.parseDouble(person_num) / 10000));

        holder.splendidText03.setText(aDouble+"万");
        x.image().bind(holder.splendidImage,data.get(position).getPictures().getImg());
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
            listener.OnitemClickListener(childAdapterPosition);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.splendid_image)
        ImageView splendidImage;
        @InjectView(R.id.splendid_text01)
        TextView splendidText01;
        @InjectView(R.id.splendid_text02)
        TextView splendidText02;
        @InjectView(R.id.splendid_text03)
        TextView splendidText03;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }
    public interface OneItemClicOne{
        void OnitemClickListener(int position);
    }
}
