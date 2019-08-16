package com.lau;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Lau on 2019/7/9.
 */
public class LineItemDecoration extends RecyclerView.ItemDecoration {
    private Context context;

    public LineItemDecoration(Context context) {
        this.context = context;
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        Drawable divider = ContextCompat.getDrawable(context, R.drawable.sep_line);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + 1;
            if (divider != null) {
                divider.setBounds(left, top, right, bottom);
                divider.draw(c);
            }
        }
    }
}
