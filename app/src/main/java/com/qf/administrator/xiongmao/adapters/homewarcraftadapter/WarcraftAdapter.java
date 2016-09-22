package com.qf.administrator.xiongmao.adapters.homewarcraftadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.models.homemodel.WarcraftModel;

import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class WarcraftAdapter extends RecyclerView.Adapter<WarcraftAdapter.ViewHolder> implements View.OnClickListener {

    private List<WarcraftModel.DataBean.ItemsBean> data;
    private LayoutInflater inflater;
    private RecyclerView recyclerView;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public WarcraftAdapter(Context context, List<WarcraftModel.DataBean.ItemsBean> data) {
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void setDataRes(List<WarcraftModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addDataRes(List<WarcraftModel.DataBean.ItemsBean> data) {
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
        View inflate = inflater.inflate(R.layout.fragment_warcraft_item, parent, false);
        inflate.setOnClickListener(this);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.warcraftText01.setText(data.get(position).getName());
        holder.warcraftText02.setText(data.get(position).getUserinfo().getNickName());
        String person_num = data.get(position).getPerson_num();
        DecimalFormat decimalFormat = new DecimalFormat("#0.0");
        double v = Double.parseDouble(decimalFormat.format(Double.parseDouble(person_num) / 1000));
        holder.warcraftText03.setText(v+"万");
        x.image().bind(holder.warcraftImage,data.get(position).getPictures().getImg());
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    @Override
    public void onClick(View v) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(v);
        if (listener!=null) {
            listener.onClickListener(childAdapterPosition);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.warcraft_image)
        ImageView warcraftImage;
        @InjectView(R.id.warcraft_text01)
        TextView warcraftText01;
        @InjectView(R.id.warcraft_text02)
        TextView warcraftText02;
        @InjectView(R.id.warcraft_text03)
        TextView warcraftText03;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }
    public interface OnItemClickListener{
        void onClickListener(int position);
    }
}
