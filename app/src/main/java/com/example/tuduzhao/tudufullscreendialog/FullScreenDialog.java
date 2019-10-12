package com.example.tuduzhao.tudufullscreendialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tudu.Zhao
 * on 2019/9/29
 **/
public class FullScreenDialog extends Dialog {
    private TextView mBtn1;
    private TextView mBtn2;
    private ImageView mClose;
    private OnDialogClickListener mListener;


    public FullScreenDialog(@NonNull Context context) {
        super(context, R.style.FullScreenDialog);
        initView(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.height = d.getHeight();
        p.width = d.getWidth();
        getWindow().setAttributes(p);
    }

    public void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null);
        setContentView(view);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        mBtn1 = view.findViewById(R.id.tv_1);
        mBtn2 = view.findViewById(R.id.tv_2);
        mClose = view.findViewById(R.id.close);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onBtn1Click();
                }
                dismiss();
            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onBtn2Click();
                }
                dismiss();
            }
        });
        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });
    }

    public void setOnDialogClickListener(OnDialogClickListener listener) {
        mListener = listener;
    }

    public interface OnDialogClickListener {

        void onBtn1Click();

        void onBtn2Click();
    }
}
