package se.kth.csc.iprog.dinnerplanner.android.view;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

public class Summary_View {

	View view;
    DinnerModel model;

    TextView totalCost;
    TextView content;
    TextView italic;
    TextView name;
    TextView title;
    ImageView ingredientsImage;
    ImageView starterImage;
    ImageView mainCourseImage;
    ImageView dessertImage;

	public Summary_View(View view, DinnerModel model) {

		// store in the class the reference to the Android View
        this.view = view;
        this.model = model;

        totalCost = (TextView) view.findViewById(R.id.totalCost);
        content = (TextView) view.findViewById(R.id.content);
        italic = (TextView) view.findViewById(R.id.make_dinner_italic);
        title = (TextView) view.findViewById(R.id.make_dinner_title);
        ingredientsImage = (ImageView) view.findViewById(R.id.ingredients_image);
        starterImage = (ImageView) view.findViewById(R.id.chosen_starter_image);
        mainCourseImage = (ImageView) view.findViewById(R.id.chosen_main_course_image);
        dessertImage = (ImageView) view.findViewById(R.id.chosen_dessert_image);

        totalCost.setText("Total cost: " + model.getTotalMenuPrice() + " kr");
        content.setText(model.getAllIngredientsAsString());

        italic.setText(model.getNumberOfGuests() + " pers");

        Set<Dish> menu = model.getFullMenu();
        ImageView image;
        for (Dish d : menu) {
            switch (d.getType()) {
                case 1:
                    image = starterImage;
                    name = (TextView) view.findViewById(R.id.chosen_starter_name);
                break;
                case 2:
                    image = mainCourseImage;
                    name = (TextView) view.findViewById(R.id.chosen_main_course_name);
                    break;
                default:
                    image = dessertImage;
                    name = (TextView) view.findViewById(R.id.chosen_dessert_name);
            }
            image.setImageResource(d.getImage());
            name.setText(d.getName());
        }
    }
}
