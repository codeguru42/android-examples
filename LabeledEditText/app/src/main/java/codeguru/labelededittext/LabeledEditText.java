package codeguru.labelededittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LabeledEditText extends LinearLayout {

    public LabeledEditText(Context context) {
        this(context, null);
    }

    public LabeledEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabeledEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TextView label = new TextView(context);
        EditText edit = new EditText(context);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LabeledEditText,
                0, 0);
        int[] set = {android.R.attr.inputType};
        TypedArray b = context.getTheme().obtainStyledAttributes(attrs, set, 0, 0);

        try {
            int labelWeight = a.getInt(R.styleable.LabeledEditText_labelWeight, 0);
            ViewGroup.LayoutParams labelParams = new LinearLayout.LayoutParams(
                    0, LayoutParams.WRAP_CONTENT, labelWeight);
            label.setLayoutParams(labelParams);

            int editWeight = a.getInt(R.styleable.LabeledEditText_editWeight, 0);
            ViewGroup.LayoutParams editParams = new LinearLayout.LayoutParams(
                    0, LayoutParams.WRAP_CONTENT, editWeight);
            edit.setLayoutParams(editParams);

            label.setText(a.getString(R.styleable.LabeledEditText_label));
            edit.setHint(a.getString(R.styleable.LabeledEditText_hint));
            edit.setInputType(b.getInt(0, 0));
        } finally {
            a.recycle();
        }

        this.addView(label);
        this.addView(edit);
    }

}
