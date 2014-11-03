package codeguru.labelededittext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class LabeledEditText extends LinearLayout {

    public LabeledEditText(Context context) {
        this(context, null);
    }

    public LabeledEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabeledEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        View.inflate(context, R.layout.labeled_edit_text, this);
    }

}
