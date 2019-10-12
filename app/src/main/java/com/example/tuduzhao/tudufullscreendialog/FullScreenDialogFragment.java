package com.example.tuduzhao.tudufullscreendialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tudu.Zhao
 * on 2019/9/29
 **/
public class FullScreenDialogFragment extends DialogFragment {

    private TextView mBtn1;
    private TextView mBtn2;
    private ImageView mClose;
    private FullScreenDialog.OnDialogClickListener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.requestFeature(Window.FEATURE_NO_TITLE);
            window.setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }
        setCancelable(false);
        View view = inflater.inflate(R.layout.dialog_layout, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        final Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.height = WindowManager.LayoutParams.MATCH_PARENT;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.gravity = Gravity.TOP;
            window.setAttributes(params);
        }
    }

    private void initView(View view) {
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

    public void setOnDialogClickListener(FullScreenDialog.OnDialogClickListener listener) {
        mListener = listener;
    }

    public interface OnDialogClickListener {

        void onBtn1Click();

        void onBtn2Click();
    }
}
