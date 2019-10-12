package com.example.tuduzhao.tudufullscreendialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3;
    private FullScreenDialog mDialog;
    private FullScreenDialogFragment mDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                if (mDialog == null) {
                    mDialog = new FullScreenDialog(this);
                }
                mDialog.show();
                mDialog.setOnDialogClickListener(new FullScreenDialog.OnDialogClickListener() {
                    @Override
                    public void onBtn1Click() {

                    }

                    @Override
                    public void onBtn2Click() {

                    }
                });

                break;
            case R.id.btn2:
                if (mDialogFragment == null) {
                    mDialogFragment = new FullScreenDialogFragment();
                }
                if(!mDialogFragment.isAdded()){
                    getSupportFragmentManager().beginTransaction().add(mDialogFragment,"mDialogFragment").commitAllowingStateLoss();
                }
                mDialogFragment.setOnDialogClickListener(new FullScreenDialog.OnDialogClickListener() {
                    @Override
                    public void onBtn1Click() {

                    }

                    @Override
                    public void onBtn2Click() {

                    }
                });

                break;
            case R.id.btn3:
                FullScreenDialogActivity.startActivity(this);
                break;
        }
    }
}
