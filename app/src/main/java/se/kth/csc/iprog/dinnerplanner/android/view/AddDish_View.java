package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;


public class AddDish_View {

        View view;
        DinnerModel model;
        Context context;
        Activity activity;

        Button choose;
        TextView courseName;
        TextView courseCost;
        ImageView courseImage;

        public AddDish_View(View view, DinnerModel model, Activity activity) {
            // store in the class the reference to the Android View
            this.view = view;
            this.model = model;
            this.context = view.getContext();
            // Fix for intent
            this.activity = activity;

            // Set View variables
            choose = (Button) view.findViewById(R.id.addcourse_Bttn);
            courseName = (TextView) view.findViewById(R.id.dialog_course_name);
            courseCost = (TextView) view.findViewById(R.id.dialog_course_cost);
            courseImage = (ImageView) view.findViewById(R.id.dialog_course_image);

            Intent intent = activity.getIntent();
            if(intent != null) {
                String name = intent.getExtras().getString("name");
                Dish dish = model.getDishByName(name);
                if(model.inMenu(dish)) {
                    choose.setText("Remove");
                }
                courseName.setText(name);
                courseCost.setText("Price: " + model.getNumberOfGuests()*dish.getPrice() + " kr (" + dish.getPrice() + " kr/pers)");
                courseImage.setImageResource(dish.getImage());
            }
        }
}
