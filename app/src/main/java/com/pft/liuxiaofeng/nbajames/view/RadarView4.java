package com.pft.liuxiaofeng.nbajames.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.pft.liuxiaofeng.nbajames.R;

/**
 * @author :Little Pidding
 * @since 17-7-7.
 */

public class RadarView4 extends View {
    private Paint mCirclePaint; //圆环画笔

    private Paint mShaderPaint; //扫描画笔

    private Shader mShader;

    private Matrix mMatrix;

    private int start;

    private int width;

    private int height;

    //通过Handler循环绘制实现移动
    private Handler mHandler = new Handler();

    Runnable run = new Runnable() {
        @Override
        public void run() {
            start++;
            mMatrix = new Matrix();
            //为矩阵设置旋转坐标
            mMatrix.setRotate(start, width / 2, height / 2);
            //刷新ui
            postInvalidate();
            //如果到了360度,重新开始
            start = start == 360 ? 0 : start;
            //延迟执行
            postDelayed(this, 10);
        }
    };

    public RadarView4(Context context) {
        super(context);
        init();
    }

    public RadarView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadarView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        //提交计划任务马上执行
        mHandler.post(run);
    }

    //初始化数据
    private void init() {
        //创建圆环画笔
        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.GRAY);
        //设置画笔的宽度
        mCirclePaint.setStrokeWidth(3);
        //设置抗锯齿模式
        mCirclePaint.setAntiAlias(true);
        //设置画笔风格
        mCirclePaint.setStyle(Paint.Style.STROKE);

        //创建扫描画笔
        mShaderPaint = new Paint();
        mShaderPaint.setAntiAlias(true);
        //设置画笔风格为填充模式
        mShaderPaint.setStyle(Paint.Style.FILL);
    }

    //开始绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        //以中心为圆点
        canvas.drawCircle(width / 2, height / 2, width / 12, mCirclePaint);
        canvas.drawCircle(width / 2, height / 2, width / 6, mCirclePaint);
        canvas.drawCircle(width / 2, height / 2, width / 4, mCirclePaint);
        canvas.drawCircle(width / 2, height / 2, width / 3, mCirclePaint);
        //画两条直线
        canvas.drawLine(width / 2 - width / 3, height / 2, width / 2 + width / 3, height / 2, mCirclePaint);
        canvas.drawLine(width / 2, height / 2 - width / 3, width / 2, height / 2 + width / 3, mCirclePaint);
        //避免重新创建对象
        if (mShader == null) {
            //新建扫描渲染,扫描边由透明到红色渐变
            mShader = new SweepGradient(width / 2, height / 2, Color.TRANSPARENT, getResources().getColor(R.color.colorAccent));
            //设置渲染对象
            mShaderPaint.setShader(mShader);
            //设置画布当前的矩阵
            canvas.concat(mMatrix);
            //画一个扫描图像
            canvas.drawCircle(width / 2, height / 2, width / 3, mShaderPaint);
        }
    }
}
