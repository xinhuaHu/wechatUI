package com.example.wechat;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * �����������Ͻ̳�
 * */
public class AddPopWindow extends PopupWindow {
    private View conentView;

    private Context context;
    
	@SuppressLint("InflateParams")
	public AddPopWindow(final Activity context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.popwindow, null);
 
        // ����SelectPicPopupWindow��View
        this.setContentView(conentView);
        // ����SelectPicPopupWindow��������Ŀ�
        this.setWidth(LayoutParams.WRAP_CONTENT);
        // ����SelectPicPopupWindow��������ĸ�
        this.setHeight(LayoutParams.WRAP_CONTENT);
        // ����SelectPicPopupWindow��������ɵ��
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // ˢ��״̬
        this.update();
        // ʵ����һ��ColorDrawable��ɫΪ��͸��
        ColorDrawable dw = new ColorDrawable(0000000000);
        // ��back���������ط�ʹ����ʧ,������������ܴ���OnDismisslistener �����������ؼ��仯�Ȳ���
        this.setBackgroundDrawable(dw);
        
        // ����SelectPicPopupWindow�������嶯��Ч��
        this.setAnimationStyle(R.style.AnimationPreview);
        
        RelativeLayout re_chatroom = (RelativeLayout) conentView.findViewById(R.id.re_chatroom);
        RelativeLayout re_addfriends = (RelativeLayout) conentView.findViewById(R.id.re_addfriends);
        RelativeLayout re_saoyisao = (RelativeLayout) conentView.findViewById(R.id.re_saoyisao);
        RelativeLayout re_help = (RelativeLayout) conentView.findViewById(R.id.re_help);
    
        re_chatroom.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "����Ⱥ��", Toast.LENGTH_SHORT).show();
			}
		});
        re_addfriends.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "�������", Toast.LENGTH_SHORT).show();
			}
		});
        re_saoyisao.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "ɨһɨ", Toast.LENGTH_SHORT).show();
			}
		});
        re_help.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "�����뷴��", Toast.LENGTH_SHORT).show();
			}
		});
	}

    /**
     * ��ʾpopupWindow
     * 
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // ��������ʽ��ʾpopupwindow
            this.showAsDropDown(parent, 0, 0);
        } else {
            this.dismiss();
        }
    }
}
