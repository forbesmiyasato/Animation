package edu.pacificu.cs.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;

public class BoundedMovingSprite extends MovingSprite {
    private int mTopBound;
    private int mBottomBound;
    private int mLeftBound;
    private int mRightBound;

    BoundedMovingSprite(Context context, Display display, int drawable,
                        int topCoord, int leftCoord, int topBound, int bottomBound, int leftBound, int rightBound)
    {
        super(context, display, drawable, topCoord, leftCoord);
        mTopBound = topBound;
        mBottomBound = bottomBound;
        mLeftBound = leftBound;
        mRightBound = rightBound;
    }

    public void hitBound () {
        BitmapFactory.Options dimensions = new BitmapFactory.Options();
        dimensions.inJustDecodeBounds = true;
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.ball_blue, dimensions);
        int height = dimensions.outHeight;
        int width =  dimensions.outWidth;
        if (getTopCoordinate() <= mTopBound) {
            dy = dy * -1;
        }
        if (getLeftCoordinate() <= mLeftBound)
        {
            dx = dx * -1;
        }
        if (height + getTopCoordinate() + height >= mBottomBound)
        {
            dy = dy * -1;
        }
        if (width + getLeftCoordinate() + width >= mRightBound)
        {
            dx = dx * -1;
        }
    }
}
