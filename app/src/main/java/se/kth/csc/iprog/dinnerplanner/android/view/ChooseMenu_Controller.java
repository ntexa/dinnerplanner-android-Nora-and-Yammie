package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.AddDish_Activity;
import se.kth.csc.iprog.dinnerplanner.android.Summary_Activity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class ChooseMenu_Controller implements View.OnClickListener, TextView.OnEditorActionListener, AdapterView.OnItemClickListener {

    DinnerModel model;
    ChooseMenu_View view;

    public ChooseMenu_Controller(DinnerModel model, ChooseMenu_View view) {
        this.model = model;
        this.view = view;

        view.create.setOnClickListener(this);
        view.numberGuests.setOnEditorActionListener(this);
        view.starterGrid.setOnItemClickListener(this);
        view.mainCourseGrid.setOnItemClickListener(this);
        view.dessertGrid.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), Summary_Activity.class);
        view.getContext().startActivity(intent);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean handled = false;
        if(i == EditorInfo.IME_ACTION_DONE) {
            model.setNumberOfGuests((int) Integer.parseInt(textView.getText().toString()));
            handled = true;
        }
        return handled;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(view.getContext(), AddDish_Activity.class);
        TextView name = (TextView) view.findViewById(R.id.course_name);
        intent.putExtra("name", name.getText());
        view.getContext().startActivity(intent);
    }
}
