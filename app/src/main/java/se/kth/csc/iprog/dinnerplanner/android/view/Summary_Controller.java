package se.kth.csc.iprog.dinnerplanner.android.view;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;


public class Summary_Controller implements View.OnClickListener {

    DinnerModel model;
    Summary_View view;

    public Summary_Controller(DinnerModel model, Summary_View view) {
        this.model = model;
        this.view = view;

        view.ingredientsImage.setOnClickListener(this);
        view.starterImage.setOnClickListener(this);
        view.mainCourseImage.setOnClickListener(this);
        view.dessertImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ImageView clicked = (ImageView) v;
        Dish dish = null;
        if(v == view.ingredientsImage) {
            cleanTabs();
            view.title.setText("Ingredients");
            view.content.setText(model.getAllIngredientsAsString());
            view.italic.setText(model.getNumberOfGuests() +  " pers");
            clicked.setBackgroundColor(Color.rgb(173,17,43));
            return;
        }
        if (v == view.starterImage) {
            dish = model.getSelectedDish(1);
        } else if (v == view.mainCourseImage) {
            dish = model.getSelectedDish(2);
        } else if (v == view.dessertImage) {
            dish = model.getSelectedDish(3);
        }
        if(dish != null) {
            cleanTabs();
            view.title.setText("Description");
            view.content.setText(dish.getDescription());
            view.italic.setText(dish.getName());
            clicked.setBackgroundColor(Color.rgb(173,17,43));
        }
    }

    public void cleanTabs() {
        view.ingredientsImage.setBackgroundColor(Color.GRAY);
        view.starterImage.setBackgroundColor(Color.GRAY);
        view.mainCourseImage.setBackgroundColor(Color.GRAY);
        view.dessertImage.setBackgroundColor(Color.GRAY);
    }
}
