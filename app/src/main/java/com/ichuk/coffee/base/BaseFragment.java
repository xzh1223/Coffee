package com.ichuk.coffee.base;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xzh on 2017/12/4.
 *  base fragment
 */

public abstract class BaseFragment extends Fragment {

    public Context context;
    public SharedPreferences pref;
    public int mWidth;
    public int mHeight;

    /**
     * Called when the fragment's activity has been created and this
     * fragment's view hierarchy instantiated.  It can be used to do final
     * initialization once these pieces are in place
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getWidth();
        pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        context = getActivity();
        initView();

    }

    /**
     * load layout
     */
    protected abstract int getLayout();

    /**
     *  initial view
     */
    protected abstract void initView();

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(),container,false);
    }

    public void getWidth(){
        DisplayMetrics dm =getResources().getDisplayMetrics();
        mWidth = dm.widthPixels;
        mHeight = dm.heightPixels;

    }

    public void toActivity(Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }

}
