package codeguru.labelededittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class LabeledEditText extends LinearLayout {

    @InjectView(R.id.label) TextView label;
    @InjectView(R.id.edit) EditText edit;

    public LabeledEditText(Context context) {
        this(context, null);
    }

    public LabeledEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabeledEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        View root = View.inflate(context, R.layout.labeled_edit_text, this);
        ButterKnife.inject(this, root);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LabeledEditText,
                0, 0);

        try {
            label.setText(a.getString(R.styleable.LabeledEditText_label));
            edit.setHint(a.getString(R.styleable.LabeledEditText_hint));
        } finally {
            a.recycle();
        }
    }

}
