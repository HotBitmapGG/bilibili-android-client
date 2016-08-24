package com.hotbitmapgg.ohmybilibili.widget;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class BezierEvaluator implements TypeEvaluator<PointF>
{


    private PointF pointF1;

    private PointF pointF2;

    public BezierEvaluator(PointF pointF1, PointF pointF2)
    {

        this.pointF1 = pointF1;
        this.pointF2 = pointF2;
    }

    @Override
    public PointF evaluate(float time, PointF startValue, PointF endValue)
    {

        float timeLeft = 1.0f - time;
        PointF point = new PointF();//结果

        point.x = timeLeft * timeLeft * timeLeft * (startValue.x)
                + 3 * timeLeft * timeLeft * time * (pointF1.x)
                + 3 * timeLeft * time * time * (pointF2.x)
                + time * time * time * (endValue.x);

        point.y = timeLeft * timeLeft * timeLeft * (startValue.y)
                + 3 * timeLeft * timeLeft * time * (pointF1.y)
                + 3 * timeLeft * time * time * (pointF2.y)
                + time * time * time * (endValue.y);
        return point;
    }
}
