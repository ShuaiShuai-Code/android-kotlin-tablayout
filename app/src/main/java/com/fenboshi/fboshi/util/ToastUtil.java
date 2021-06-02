package com.fenboshi.fboshi.util;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fenboshi.fboshi.MyApplication;
import com.fenboshi.fboshi.R;

public class ToastUtil {

    private static Toast toast;
    private static TextView tv;
    private static View view;

    public static void showToast(String text) {
        if (null == text || text.isEmpty())
            return;
        if (toast == null) {
            view = View.inflate(MyApplication.Companion.getApplication(), R.layout.toast_layout, null);
            toast = Toast.makeText(MyApplication.Companion.getApplication(), text, Toast.LENGTH_SHORT);
            toast.setView(view);
            tv = view.findViewById(R.id.tv_toast);
        }
        tv.setText(text);
        toast.show();
    }

    private static Toast centerToast;
    private static TextView centerText;
    private static View centerView;

    public static void showCenterToast(String str) {
        if (centerToast == null) {
            centerView = View.inflate(MyApplication.Companion.getApplication(), R.layout.toast_layout, null);
            centerText = centerView.findViewById(R.id.tv_toast);
            centerToast = Toast.makeText(MyApplication.Companion.getApplication(), str, Toast.LENGTH_SHORT);
            centerToast.setView(centerView);
            centerToast.setGravity(Gravity.CENTER, 0, 0);
        }
        centerText.setText(str);
        centerToast.show();
    }


}
