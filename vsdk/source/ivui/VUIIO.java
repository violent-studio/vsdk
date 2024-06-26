package vsdk.source.ivui;

import com.raylib.Raylib;

/**
 * VUI Shared data & utilities.
 */
public class VUIIO {
    protected static VUIStyle style;

    protected static boolean disabled = false;

    /**
     * Create new IO context.
     *
     * @param style_ Style.
     */
    public static void newCtx(VUIStyle style_) {
        style = style_ == null ? new VUIStyle() : style_;
    }

    /**
     * Is mouse collides with next Rectangle.
     *
     * @param x X.
     * @param y Y.
     * @param w Width.
     * @param h Height.
     */
    public static boolean mouseHovers(float x, float y, float w, float h) {
        return Raylib.CheckCollisionPointRec(Raylib.GetMousePosition(), new Raylib.Rectangle().x(x).y(y).width(w).height(h));
    }

    /**
     * Is mouse collides with text.
     *
     * @param content Text.
     * @param x Text X Position.
     * @param y Text Y Position.
     */
    public static boolean mouseHoversText(String content, float x, float y) {
        Raylib.Vector2 textVec2 = Raylib.MeasureTextEx(style.getTextFont().getFont(), content, style.getTextSize(), style.getTextSpacing());

        return mouseHovers(x, y, textVec2.x(), textVec2.y());
    }

    /**
     * Disable next widgets.
     */
    public static void beginDisabled() {
        disabled = true;
    }

    /**
     * Do not disable next widgets.
     */
    public static void endDisabled() {
        disabled = false;
    }

    /**
     * Get style.
     */
    public static VUIStyle getStyle() {
        return style;
    }
}
