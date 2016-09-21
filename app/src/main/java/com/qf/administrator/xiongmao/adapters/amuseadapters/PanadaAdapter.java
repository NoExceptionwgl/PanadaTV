package com.qf.administrator.xiongmao.adapters.amuseadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.models.amusemodels.PanadaShowModel;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 *
 */
public class PanadaAdapter extends RecyclerView.Adapter<PanadaAdapter.ViewHolder> implements View.OnClickListener {


    private static final String TAG = PanadaAdapter.class.getSimpleName();
    private LayoutInflater inflater;
    private List<PanadaShowModel.DataBean.ItemsBean> data;
    private RecyclerView mRecyclerView;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PanadaAdapter(Context context, List<PanadaShowModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        inflater = LayoutInflater.from(context);
    }

    public void addRes(List<PanadaShowModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void upData(List<PanadaShowModel.DataBean.ItemsBean> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.amuse_show_item, parent, false);
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        bindData(holder, position);
    }

    private void bindData(ViewHolder holder, int position) {
        PanadaShowModel.DataBean.ItemsBean items = data.get(position);
        ImageOptions options = new ImageOptions.Builder()
                .setLoadingDrawableId(R.mipmap.bg_live_default2)
                .setFadeIn(true)
                .build();

        String picture = (String) items.getPictures().getImg();
        x.image().bind(holder.mPictures, picture, options);
        holder.mName.setText(items.getName());
        holder.mNickName.setText(items.getUserinfo().getNickName());
        //设置观看人数
        String number = items.getPerson_num();
        int persons = Integer.parseInt(number);
        if (persons >= 10000) {
            holder.mPersonNum.setText(String.format("%s万", persons / 10000));
        } else {
            holder.mPersonNum.setText(items.getPerson_num());
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

//-------------------条目点击时监听-------------------------
    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        if (listener != null) {
            listener.onItemClick(position);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.panada_show_item_contain_image)
        ImageView mPictures;
        @InjectView(R.id.panada_show_item_text)
        TextView mName;
        @InjectView(R.id.panada_show_item_goddess_image)
        ImageView mGoddess;
        @InjectView(R.id.panada_show_item_nick)
        TextView mNickName;
        @InjectView(R.id.panda_show_item_num)
        TextView mPersonNum;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

}
