package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class AddDish_Controller implements View.OnClickListener {

    DinnerModel model;
    AddDish_View view;
    Activity activity;

    public AddDish_Controller(DinnerModel model, AddDish_View view, Activity activity) {
        this.model = model;
        this.view = view;
        this.activity = activity;
        view.choose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Dish dish = model.getDishByName(view.courseName.getText().toString());
        Button btn = (Button) v;
        if(model.inMenu(dish)) {
            model.removeDishFromMenu(dish);
        } else {
            model.addDishToMenu(dish);
        }
        activity.finish();
    }
}
