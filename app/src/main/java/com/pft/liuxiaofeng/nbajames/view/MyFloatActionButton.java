package com.pft.liuxiaofeng.nbajames.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;

/**
 * @author :Little Pidding
 * @since 17-9-27.
 */

public class MyFloatActionButton extends FloatingActionButton {
    int dx, dy;
    private int lastx, lasty;//记录手指按下去的位置
    private int startX, startY, endX, endY;
    private long startTime = 0;
    private long endTime = 0;
    private boolean isclick;
    private String TAG ="MyFloatActionButton";
    private WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
    private int width = windowManager.getDefaultDisplay().getWidth();
    private int height = windowManager.getDefaultDisplay().getHeight();

    public MyFloatActionButton(Context context) {

        super(context, null);
    }

    public MyFloatActionButton(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyFloatActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        setSaveEnabled(true);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Log.d(TAG,"onSaveInstanceState satrtX=" + startX);
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.state = startX;
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        Log.d(TAG,"onRestoreInstanceState satrtX" + ((SavedState) state).state);
        super.onRestoreInstanceState(state);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:// 获取手指第一次接触屏幕
                dx = 0;
                dy = 0;
                isclick = false;//当按下的时候设置isclick为false，具体原因看后边的讲解
                startTime = System.currentTimeMillis();
                break;
            case MotionEvent.ACTION_MOVE:// 手指在屏幕上移动对应的事件
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();
                // 获取手指移动的距离
                dx = x - lastx;
                dy = y - lasty;
                setAlpha(0.5f);
                int l = getLeft();
                int r = getRight();
                int t = getTop();
                int b = getBottom();
                Log.d(TAG,"上面的位置是" + (l + dx) + "右边的坐标是" + (t + dy));
                // 更改在窗体的位置//确保位置显示在屏幕内
                if ((l + dx) >= 0 && (t + dy) > 0 && (r + dx) <= width && (b + dy) <= height)
                    layout(l + dx, t + dy, r + dx, b + dy);
                // 获取移动后的位置
                lastx = (int) event.getRawX();
                lasty = (int) event.getRawY();
                if (Math.abs(dx) > 20 || Math.abs(dy) > 20) {
                    Log.d(TAG,"Math.abs(dx)>20");
                    event.setAction(MotionEvent.ACTION_CANCEL);
                    return true;
                }
            case MotionEvent.ACTION_UP:// 手指离开屏幕对应事件
                // 记录最后图片在窗体的位置
                endTime = System.currentTimeMillis();
                //当从点击到弹起小于半秒的时候,则判断为点击,如果超过则不响应点击事件
                if ((endTime - startTime) > 0.1 * 1000L) {
                    isclick = true;
                } else {
                    isclick = false;
                }
                lastx = (int) event.getRawX();
                lasty = (int) event.getRawY();
                System.out.println("执行顺序up");
                setAlpha(1.0f);

        }
        if (isclick)
            return true;
        return super.dispatchTouchEvent(event);
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR
                = new Creator<SavedState>() {

            @Override
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int state;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            state = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(state);
        }
    }
}
