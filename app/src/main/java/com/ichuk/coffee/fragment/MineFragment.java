package com.ichuk.coffee.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ichuk.coffee.R;
import com.ichuk.coffee.activity.home.LoginActivity;
import com.ichuk.coffee.activity.mine.MessageActivity;
import com.ichuk.coffee.activity.mine.MyAllowanceActivity;
import com.ichuk.coffee.activity.mine.MyCouponActivity;
import com.ichuk.coffee.activity.mine.MyExpensesRecordActivity;
import com.ichuk.coffee.activity.mine.MyGiftCardActivity;
import com.ichuk.coffee.activity.mine.MyLeaveMessageActivity;
import com.ichuk.coffee.activity.mine.MyPointActivity;
import com.ichuk.coffee.activity.mine.MyRedEnvelopeActivity;
import com.ichuk.coffee.activity.mine.MyScoreActivity;
import com.ichuk.coffee.activity.mine.OrderActivity;
import com.ichuk.coffee.activity.mine.SettingActivity;
import com.ichuk.coffee.adapter.MineGridAdapter;
import com.ichuk.coffee.base.BaseFragment;
import com.ichuk.coffee.bean.MineGridBean;
import com.ichuk.coffee.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by xzh on 2017/12/4.
 *
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private ImageView ivMineSetting;
    private ImageView ivMineMessage;
    private TextView tvFindAll;
    private ImageView ivPendingPayment;
    private TextView tvPendingPayment;
    private ImageView ivUsable;
    private TextView tvUsable;
    private ImageView ivRefund;
    private TextView tvRefund;
    private GridView gvMine;
    private List<MineGridBean> mList = new ArrayList<>();
    private CircleImageView civAccountPic;
    private TextView tvAccountName;
    private Dialog dialog;

    /**
     * Find the Views in the layout
     */
    private void findViews() {
        if (getView() != null) {
            civAccountPic = getView().findViewById(R.id.civ_account_pic);
            tvAccountName = getView().findViewById(R.id.tv_account_name);
            ivMineSetting = getView().findViewById(R.id.iv_mine_setting);
            ivMineMessage = getView().findViewById(R.id.iv_mine_message);
            tvFindAll = getView().findViewById(R.id.tv_find_all);
            ivPendingPayment = getView().findViewById(R.id.iv_pending_payment);
            tvPendingPayment = getView().findViewById(R.id.tv_pending_payment);
            ivUsable = getView().findViewById(R.id.iv_usable);
            tvUsable = getView().findViewById(R.id.tv_usable);
            ivRefund = getView().findViewById(R.id.iv_refund);
            tvRefund = getView().findViewById(R.id.tv_refund);
            gvMine = getView().findViewById(R.id.gv_mine);
        }
    }

    /**
     * initial view
     */
    @Override
    protected void initView() {
        findViews();
        getData();
        setGridView();
        setEvent();
    }

    /**
     * set listener
     */
    private void setEvent() {
        gvMine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        toActivity(MyScoreActivity.class);
                        break;
                    case 1:
                        toActivity(MyPointActivity.class);
                        break;
                    case 2:
                        toActivity(MyCouponActivity.class);
                        break;
                    case 3:
                        toActivity(MyAllowanceActivity.class);
                        break;
                    case 4:
                        toActivity(MyRedEnvelopeActivity.class);
                        break;
                    case 5:
                        toActivity(MyGiftCardActivity.class);
                        break;
                    case 6:
                        toActivity(MyExpensesRecordActivity.class);
                        break;
                    case 7:
                        toActivity(MyLeaveMessageActivity.class);
                        break;
                    case 8:
                        showDialog();
                        break;
                }
            }
        });
        tvAccountName.setOnClickListener(this);
        ivMineSetting.setOnClickListener(this);
        ivMineMessage.setOnClickListener(this);
        tvFindAll.setOnClickListener(this);
        ivPendingPayment.setOnClickListener(this);
        ivUsable.setOnClickListener(this);
        ivRefund.setOnClickListener(this);
    }

    /**
     * show dialog for customer service
     */
    private void showDialog() {
        dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        View view = LayoutInflater.from(context).inflate(R.layout.item_dialog_mine_customer_service, null);

        TextView tvPlayPhone = view.findViewById(R.id.tv_play_phone);
        TextView tvLeaveMessage = view.findViewById(R.id.tv_leave_message);
        TextView tvCancel = view.findViewById(R.id.tv_cancel);
        tvPlayPhone.setOnClickListener(this);
        tvLeaveMessage.setOnClickListener(this);
        tvCancel.setOnClickListener(this);

        //将布局设置给Dialog
        dialog.setContentView(view);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
    }

    /**
     * set gridView
     */
    private void setGridView() {
        MineGridAdapter mAdapter = new MineGridAdapter(context, mList);
        gvMine.setAdapter(mAdapter);
    }

    /**
     * get data
     */
    private void getData() {
        MineGridBean mineGridBean = new MineGridBean();
        mineGridBean.setName("我的积分");
        MineGridBean mineGridBean1 = new MineGridBean();
        mineGridBean1.setName("我的积点");
        MineGridBean mineGridBean2 = new MineGridBean();
        mineGridBean2.setName("我的优惠券");
        MineGridBean mineGridBean3 = new MineGridBean();
        mineGridBean3.setName("我的补贴");
        MineGridBean mineGridBean4 = new MineGridBean();
        mineGridBean4.setName("我的红包");
        MineGridBean mineGridBean5 = new MineGridBean();
        mineGridBean5.setName("我的储值卡");
        MineGridBean mineGridBean6 = new MineGridBean();
        mineGridBean6.setName("我的消费记录");
        MineGridBean mineGridBean7 = new MineGridBean();
        mineGridBean7.setName("我的留言");
        MineGridBean mineGridBean8 = new MineGridBean();
        mineGridBean8.setName("客服电话");
        mList.add(mineGridBean);
        mList.add(mineGridBean1);
        mList.add(mineGridBean2);
        mList.add(mineGridBean3);
        mList.add(mineGridBean4);
        mList.add(mineGridBean5);
        mList.add(mineGridBean6);
        mList.add(mineGridBean7);
        mList.add(mineGridBean8);

    }

    /**
     * load layout
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_account_name: {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.iv_mine_setting: {
                Intent intent = new Intent(context, SettingActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.iv_mine_message: {
                Intent intent = new Intent(context, MessageActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_find_all: {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("flag", 0);
                startActivity(intent);
                break;
            }
            case R.id.iv_pending_payment: {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("flag", 1);
                startActivity(intent);
                break;
            }
            case R.id.iv_usable: {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("flag", 2);
                startActivity(intent);
                break;
            }
            case R.id.iv_refund: {
                Intent intent = new Intent(context, OrderActivity.class);
                intent.putExtra("flag", 3);
                startActivity(intent);
                break;
            }
            case R.id.tv_play_phone:
                ToastUtil.toast(context, "打电话");
                break;
            case R.id.tv_leave_message:
                ToastUtil.toast(context, "留言");
                break;
            case R.id.tv_cancel:
                if (dialog != null) {
                    dialog.dismiss();
                }
                break;
        }
    }
}
