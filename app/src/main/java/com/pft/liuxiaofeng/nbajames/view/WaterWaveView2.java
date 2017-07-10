package com.pft.liuxiaofeng.nbajames.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.pft.liuxiaofeng.nbajames.bean.Wave;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author :Little Pidding
 * @since 17-7-7.
 */

public class WaterWaveView2 extends View {

    private CopyOnWriteArrayList<Wave> mList = new CopyOnWriteArrayList();

    //界面刷新
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            invalidate();//刷新界面,会执行onDraw方法
        }
    };

    public WaterWaveView2(Context context) {
        super(context);
    }

    public WaterWaveView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WaterWaveView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //获取圆心,并且删除集合透明度为0的圆环,通知handler调用onDraw()方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                deleteItem();
                Wave wave = new Wave(x, y);
                mList.add(wave);

                //刷新界面
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                float x1 = event.getX();
                float y1 = event.getY();
                deleteItem();
                Wave wave1 = new Wave(x1, y1);
                mList.add(wave1);

                //刷新界面
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("onMeasure","调用了");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e("onLayout","调用了");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("onDraw","调用了");
        //避免程序一运行就进行绘制
        if (mList.size() > 0) {

            //对集合中的圆环对象循环绘制
            for (Wave wave : mList) {
                canvas.drawCircle(wave.x, wave.y, wave.radius, wave.paint);
                wave.radius += 3;
                //对画笔透明度进行操作
                int alpha = wave.paint.getAlpha();
                if (alpha < 80) {
                    alpha = 0;
                } else {
                    alpha -= 2;
                }
                Log.e("alpha",alpha+"");
                deleteItem();
                //设置画笔宽度和透明度
                wave.paint.setStrokeWidth(wave.radius / 8);
                wave.paint.setAlpha(alpha);

                //延迟刷新界面
                mHandler.sendEmptyMessageDelayed(1, 100);
            }
        }
    }

    //删除透明度为0的圆环
    private void deleteItem(){
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).paint.getAlpha() ==0){
                mList.remove(i);
            }
        }
    }
}
