package com.ichuk.coffee.fragment.community;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.adapter.community.ArticleAdapter;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.bean.ArticleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzh on 2018/1/16.
 */

public class ArticleFragment extends BaseFragment {
    private RecyclerView rvArticle;
    private List<ArticleBean> mList = new ArrayList<>();

    /**
     * load layout
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_community_item_article;
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        setRecyclerView();
    }

    /**
     *  get data from http
     */
    private void getData() {
        ArticleBean articleBean = new ArticleBean();
        articleBean.setTime("1月16日");
        articleBean.setTitle("文章内容");
        articleBean.setName("xzh");
        mList.add(articleBean);
        mList.add(articleBean);
        mList.add(articleBean);
    }

    /**
     * set recyclerView
     */
    private void setRecyclerView() {
        rvArticle.setLayoutManager(new LinearLayoutManager(context));
        rvArticle.setAdapter(new ArticleAdapter(context, mList));
    }

    /**
     *  initial widget
     */
    private void findViews() {
        rvArticle = getView().findViewById(R.id.rv_article);
    }
}
