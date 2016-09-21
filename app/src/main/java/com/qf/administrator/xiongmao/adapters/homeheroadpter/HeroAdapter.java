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

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private List<HeroModel.DataBean.ItemsBean> data;
    private LayoutInflater inflater;

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

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.heroText01.setText(data.get(position).get);
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
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

}
