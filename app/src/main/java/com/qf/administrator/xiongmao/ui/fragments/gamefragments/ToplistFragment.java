package com.qf.administrator.xiongmao.ui.fragments.gamefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.qf.administrator.xiongmao.R;
import com.qf.administrator.xiongmao.ui.fragments.BaseFragment;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by a on 2016/9/21.
 */
public class ToplistFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {


    private RadioGroup mRadioGroup;
    private FrameLayout mContainers;
    private Fragment mShowFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstceState) {
        layout = inflater.inflate(R.layout.fragment_toplist, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mRadioGroup = ((RadioGroup) layout.findViewById(R.id.stu_toplist_fragment_rg));
        mRadioGroup.setOnCheckedChangeListener(this);
        mContainers = ((FrameLayout) layout.findViewById(R.id.stu_toplist_fragment_container));

        /**
         * 动态添加碎片
         * ①获取碎片管理器
         * ②开启碎片事物
         * ③在事务中添加动作
         * ④提交事物
         */

        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mShowFragment = new ToplistWeekFragment();
        /**
         * 将碎片添加到容器中,并且为碎片添加一个TAG,对应findFragmentByTag
         * 三个参数
         * ①Fragment添加目标容器的id
         * ②被添加的Fragment
         * ③添加Fragment时,对Fragment添加的标记TAG
         */
        transaction.add(R.id.stu_toplist_fragment_container,mShowFragment,ToplistWeekFragment.TAG);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.stu_toplist_fragment_week:
                switchPages(ToplistWeekFragment.TAG,ToplistWeekFragment.class);
                break;
            case R.id.stu_toplist_fragment_totle:
                switchPages(ToplistTotleFragment.TAG,ToplistTotleFragment.class);
                break;
        }
    }

    /**
     * 切换页面的封装
     * @param tag 添加碎片的标记
     * @param cls 添加碎片的class
     */

    private void switchPages(String tag, Class<?extends Fragment>cls){
        /**
         * 将当前显示的碎片进行隐藏 之后将要显示的页面显示出来
         */
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //隐藏显示的页面
        transaction.hide(mShowFragment);
        //根据TAG去FragmentManager中进行查找碎片
        mShowFragment=fm.findFragmentByTag(tag);
        //如果找到了,直接进行显示
        if (mShowFragment!=null) {
            transaction.show(mShowFragment);
        }else {
            //如果没找到,添加到容器中并且设置一个标记
            try {
                //使用反射进行一个对象的实例化
                mShowFragment=cls.getConstructor().newInstance();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            transaction.add(R.id.stu_toplist_fragment_container,mShowFragment,tag);
        }
        transaction.commit();
    }

}
