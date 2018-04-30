package com.example.liuyu.tree.Fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.android.camera2basic.R;
import com.example.liuyu.tree.view.PaintView;
import com.example.liuyu.tree.view.WriteDialogListener;

public class MarkPadFragment extends Fragment {
    private Context mContext;
    private WriteDialogListener mWriteDialogListener;
    private PaintView mPaintView;
    private FrameLayout mFrameLayout;
    private ImageView iv;
    private Button mBtnOK, mBtnClear, mBtnCancel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mark, null);

        mFrameLayout = view.findViewById(R.id.markpad);
        mContext = getContext();
        // 获取屏幕尺寸
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        getActivity().getWindow().getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        final int screenWidth = mDisplayMetrics.widthPixels;
        final int screenHeight = mDisplayMetrics.heightPixels;
        mPaintView = new PaintView(mContext, screenWidth, screenHeight);
        mFrameLayout.addView(mPaintView);
        mPaintView.requestFocus();

        mBtnOK = (Button) view.findViewById(R.id.write_pad_ok);
        mBtnClear = (Button) view.findViewById(R.id.write_pad_clear);
        mBtnCancel = (Button) view.findViewById(R.id.write_pad_cancel);
        iv = view.findViewById(R.id.iv);
        byte[] bytes = (byte[])getArguments().get("bytes");
        if(bytes!=null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
            iv.setImageBitmap(bitmap);
        }
        return view;
    }

}