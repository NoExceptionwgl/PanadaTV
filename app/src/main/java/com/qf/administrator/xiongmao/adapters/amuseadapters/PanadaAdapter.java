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

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 *
 */
public class PanadaAdapter extends RecyclerView.Adapter<PanadaAdapter.ViewHolder> {


    private LayoutInflater inflater;
    private List<PanadaShowModel.DataBean.ItemsBean> data;

    public PanadaAdapter(Context context, List<PanadaShowModel.DataBean.ItemsBean> data) {
        this.data = data;
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
        View itemView = inflater.inflate(R.layout.panada_show_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data != null? data.size(): 0;
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {

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
        }
    }


}
