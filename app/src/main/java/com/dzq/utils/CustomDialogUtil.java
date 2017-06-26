package com.dzq.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.dzq.widget.CustomDialog;


/**
 * Created by dingzuoqiang on 2017/6/20.
 * Email: 530858106@qq.com
 */

public class CustomDialogUtil {

    /**
     * final Context context,
     * String content,
     * String okText,
     * String cancelText,
     * final DialogInterface.OnClickListener okListener
     * final DialogInterface.OnClickListener cancelListener
     * boolean isAutoDissmiss
     */
    public static View normalDialog(final Context context, String title, String content, String okText, String cancelText, final DialogInterface.OnClickListener okListener, final DialogInterface.OnClickListener cancelListener, boolean isAutoDissmiss) {

        CustomDialog.CustomDialogBuilder customBuilder = new CustomDialog.CustomDialogBuilder(context);
        customBuilder.setTitle(title)
                .setMessage(content)
                .setNegativeButton(cancelText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (cancelListener != null)
                            cancelListener.onClick(dialog, which);
                    }
                })
                .setPositiveButton(okText,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                if (okListener != null)
                                    okListener.onClick(dialog, which);
                            }
                        });
        CustomDialog dialog = customBuilder.create();
        dialog.setCancelable(isAutoDissmiss);
        dialog.show();

        return dialog.getWindow().getDecorView();
    }

}
