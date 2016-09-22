package com.qf.administrator.xiongmao.adapters.gameadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.models.WeekModel;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by a on 2016/9/22.
 */
public class TotleAdapter extends RecyclerView.Adapter<TotleAdapter.ViewHolder> {


    private LayoutInflater inflater;
    private List<WeekModel> data;

    private int[] number = {R.mipmap.cn_longhubangone, R.mipmap.cn_longhubangtwo, R.mipmap.cn_longhubangthree,
            R.mipmap.number4, R.mipmap.number, R.mipmap.number6, R.mipmap.number7, R.mipmap.number8
            , R.mipmap.number9, R.mipmap.number10};

    private int duanwei[] = {R.mipmap.gift_rank_qingtong05, R.mipmap.gift_rank_qingtong04, R.mipmap.gift_rank_qingtong02
            , R.mipmap.gift_rank_qingtong02, R.mipmap.gift_rank_qingtong01, R.mipmap.gift_rank_baiyin05,
            R.mipmap.gift_rank_baiyin04, R.mipmap.gift_rank_baiyin05, R.mipmap.gift_rank_baiyin04
            , R.mipmap.gift_rank_baiyin01, R.mipmap.gift_rank_huangjin05, R.mipmap.gift_rank_huangjin04,
            R.mipmap.gift_rank_huangjin05, R.mipmap.gift_rank_huangjin04, R.mipmap.gift_rank_huangjin01,
            R.mipmap.gift_rank_bojin05, R.mipmap.gift_rank_bojin03, R.mipmap.gift_rank_bojin03,
            R.mipmap.gift_rank_bojin02, R.mipmap.gift_rank_bojin02, R.mipmap.gift_rank_zuanshi05,
            R.mipmap.gift_rank_zuanshi05, R.mipmap.gift_rank_zuanshi03, R.mipmap.gift_rank_zuanshi02,
            R.mipmap.gift_rank_zuanshi01, R.mipmap.gift_rank_zongshi03, R.mipmap.gift_rank_zongshi03, R.mipmap.gift_rank_zongshi03
            , R.mipmap.gift_rank_zongshi03, R.mipmap.gift_rank_zongshi03, R.mipmap.gift_rank_wangzhe04, R.mipmap.gift_rank_wangzhe04
            , R.mipmap.gift_rank_wangzhe03, R.mipmap.gift_rank_wangzhe03, R.mipmap.gift_rank_wangzhe01,
            R.mipmap.gift_rank_zhizun05, R.mipmap.gift_rank_zhizun05, R.mipmap.gift_rank_zhizun03,
            R.mipmap.gift_rank_zhizun02, R.mipmap.gift_rank_zhizun02};

    public TotleAdapter(List<WeekModel> data, Context context) {
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    private ImageOptions options = new ImageOptions.Builder()
            .setFadeIn(true)
            .setCircular(true)
            .build();

    public void updataRes(List<WeekModel> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = inflater.inflate(R.layout.totle_fragment_item, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.mLeftIv.setImageResource(number[0]);
                break;
            case 1:
                holder.mLeftIv.setImageResource(number[1]);
                break;
            case 2:
                holder.mLeftIv.setImageResource(number[2]);
                break;
            case 3:
                holder.mLeftIv.setImageResource(number[3]);
                break;
            case 4:
                holder.mLeftIv.setImageResource(number[4]);
                break;
            case 5:
                holder.mLeftIv.setImageResource(number[5]);
                break;
            case 6:
                holder.mLeftIv.setImageResource(number[6]);
                break;
            case 7:
                holder.mLeftIv.setImageResource(number[7]);
                break;
            case 8:
                holder.mLeftIv.setImageResource(number[8]);
                break;
            case 9:
                holder.mLeftIv.setImageResource(number[9]);
                break;
        }

        int level = data.get(position).getLevel();
        switch (level) {
            case 1:
                holder.mDuanweiIv.setImageResource(duanwei[0]);
                break;
            case 2:
                holder.mDuanweiIv.setImageResource(duanwei[1]);
                break;
            case 3:
                holder.mDuanweiIv.setImageResource(duanwei[2]);
                break;
            case 4:
                holder.mDuanweiIv.setImageResource(duanwei[3]);
                break;
            case 5:
                holder.mDuanweiIv.setImageResource(duanwei[4]);
                break;
            case 6:
                holder.mDuanweiIv.setImageResource(duanwei[5]);
                break;
            case 7:
                holder.mDuanweiIv.setImageResource(duanwei[6]);
                break;
            case 8:
                holder.mDuanweiIv.setImageResource(duanwei[7]);
                break;
            case 9:
                holder.mDuanweiIv.setImageResource(duanwei[8]);
                break;
            case 10:
                holder.mDuanweiIv.setImageResource(duanwei[9]);
                break;
            case 11:
                holder.mDuanweiIv.setImageResource(duanwei[10]);
                break;
            case 12:
                holder.mDuanweiIv.setImageResource(duanwei[11]);
                break;
            case 13:
                holder.mDuanweiIv.setImageResource(duanwei[12]);
                break;
            case 14:
                holder.mDuanweiIv.setImageResource(duanwei[13]);
                break;
            case 15:
                holder.mDuanweiIv.setImageResource(duanwei[14]);
                break;
            case 16:
                holder.mDuanweiIv.setImageResource(duanwei[15]);
                break;
            case 17:
                holder.mDuanweiIv.setImageResource(duanwei[16]);
                break;
            case 18:
                holder.mDuanweiIv.setImageResource(duanwei[17]);
                break;
            case 19:
                holder.mDuanweiIv.setImageResource(duanwei[18]);
                break;
            case 20:
                holder.mDuanweiIv.setImageResource(duanwei[19]);
                break;
            case 21:
                holder.mDuanweiIv.setImageResource(duanwei[20]);
                break;
            case 22:
                holder.mDuanweiIv.setImageResource(duanwei[21]);
                break;
            case 23:
                holder.mDuanweiIv.setImageResource(duanwei[22]);
                break;
            case 24:
                holder.mDuanweiIv.setImageResource(duanwei[23]);
                break;
            case 25:
                holder.mDuanweiIv.setImageResource(duanwei[24]);
                break;
            case 26:
                holder.mDuanweiIv.setImageResource(duanwei[25]);
                break;
            case 27:
                holder.mDuanweiIv.setImageResource(duanwei[26]);
                break;
            case 28:
                holder.mDuanweiIv.setImageResource(duanwei[27]);
                break;
            case 29:
                holder.mDuanweiIv.setImageResource(duanwei[28]);
                break;
            case 30:
                holder.mDuanweiIv.setImageResource(duanwei[29]);
                break;
            case 31:
                holder.mDuanweiIv.setImageResource(duanwei[30]);
                break;
            case 32:
                holder.mDuanweiIv.setImageResource(duanwei[31]);
                break;
            case 33:
                holder.mDuanweiIv.setImageResource(duanwei[32]);
                break;
            case 34:
                holder.mDuanweiIv.setImageResource(duanwei[33]);
                break;
            case 35:
                holder.mDuanweiIv.setImageResource(duanwei[34]);
                break;
            case 36:
                holder.mDuanweiIv.setImageResource(duanwei[35]);
                break;
            case 37:
                holder.mDuanweiIv.setImageResource(duanwei[36]);
                break;
            case 38:
                holder.mDuanweiIv.setImageResource(duanwei[37]);
                break;
            case 39:
                holder.mDuanweiIv.setImageResource(duanwei[38]);
                break;
            case 40:
                holder.mDuanweiIv.setImageResource(duanwei[39]);
                break;
        }
        holder.mNameTv.setText(data.get(position).getNickname());
        x.image().bind(holder.mTouxiangIv,data.get(position).getAvatar(),options);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.stu_toplist_totle_item_left_iv)
        ImageView mLeftIv;
        @InjectView(R.id.stu_toplist_totle_item_touxiang_iv)
        ImageView mTouxiangIv;
        @InjectView(R.id.stu_toplist_totle_item_duanwei_iv)
        ImageView mDuanweiIv;
        @InjectView(R.id.stu_toplist_totle_item_name_tv)
        TextView mNameTv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }

}
