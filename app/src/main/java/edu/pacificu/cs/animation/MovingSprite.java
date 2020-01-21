package edu.pacificu.cs.animation;

import android.content.Context;
import android.view.Display;

import java.util.Random;

/**
 * Defines the MovingSprite class which maintains the specifics of a sprite
 * including its location, size, and bitmap.
 *
 * @author Computer Science, Pacific University.
 *
 * @version 1.0
 */
public class MovingSprite extends FixedSprite
{
    protected int speed;
    private double mAngle;
    protected int dx;
    protected int dy;
    private final static double ANGLE = 360;
    private Random cRandom = new Random();
    /**
     * Constructor that initializes the values associated with the sprite.
     *
     * @param context
     *          reference to application-specific resources
     *
     * @param display
     *          the display
     *
     * @param drawable
     *          reference to a bitmap
     *
     * @param topCoord
     *          the top coordinate of the sprite
     *
     * @param leftCoord
     *          the left coordinate of the sprite
     *
     *
     * @since 1.0
     */
    public MovingSprite (Context context, Display display, int drawable,
                         int topCoord, int leftCoord)
    {
        super (context, display, drawable, topCoord, leftCoord);
        speed = cRandom.nextInt(20) + 1;
        randomDirection();
    }

    /**
     * Sets the value of the top y coordinate.
     *
     * @return the top y coordinate value
     *
     * @since 1.0
     */
    public void setTopCoordinate (int topCoordinate)
    {
        mTopCoordinate = topCoordinate;
    }

    /**
     * Sets the value of the left x coordinate.
     *
     * @return the left x coordinate value
     *
     * @since 1.0
     */
    public void setLeftCoordinate (int leftCoordinate)
    {
        mLeftCoordinate = leftCoordinate;
    }

    public void move ()
    {
        setTopCoordinate(getTopCoordinate() + dy);
        setLeftCoordinate(getLeftCoordinate() + dx);
    }

    public void randomDirection() {
        mAngle = cRandom.nextDouble() * ANGLE;

        dx = (int) (speed * Math.sin(mAngle));
        dy = (int) (speed * Math.cos(mAngle));
    }
}
