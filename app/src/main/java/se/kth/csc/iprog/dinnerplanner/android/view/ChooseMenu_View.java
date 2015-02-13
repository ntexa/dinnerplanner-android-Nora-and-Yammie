package se.kth.csc.iprog.dinnerplanner.android.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class ChooseMenu_View implements Observer {

	View view;
    DinnerModel model;
    Context context;

    // View elements
    Button create;
    TextView numberGuests;
    TextView totalCost;
    GridView starterGrid;
    GridView mainCourseGrid;
    GridView dessertGrid;

	public ChooseMenu_View(View view, DinnerModel model) {

		// store in the class the reference to the Android View
        this.view = view;
        this.model = model;
        this.context = view.getContext();

        // Set View variables
        create = (Button) view.findViewById(R.id.create_button);
        numberGuests = (TextView) view.findViewById(R.id.numberGuests);
        totalCost = (TextView) view.findViewById(R.id.totalCost);

        starterGrid = (GridView) view.findViewById(R.id.starters_grid);
        starterGrid.setAdapter(new CourseAdapter(model.getDishesOfType(1), context));

        mainCourseGrid = (GridView) view.findViewById(R.id.main_course_grid);
        mainCourseGrid.setAdapter(new CourseAdapter(model.getDishesOfType(2), context));

        dessertGrid = (GridView) view.findViewById(R.id.dessert_grid);
        dessertGrid.setAdapter(new CourseAdapter(model.getDishesOfType(3), context));

        // Register observer
        model.addObserver(this);

        // Set the number of guests and total cost
        textUpdate();
    }

    @Override
    public void update(Observable observable, Object o) {
        textUpdate();
        starterGrid.invalidateViews();
        mainCourseGrid.invalidateViews();
        dessertGrid.invalidateViews();
    }

    public void textUpdate() {
        numberGuests.setText("" + model.getNumberOfGuests());
        totalCost.setText("Total cost: " + model.getTotalMenuPrice() + " kr");
    }

    public class CourseAdapter extends BaseAdapter {

        ArrayList<Dish> dishes;
        Context context;

        public CourseAdapter(Set<Dish> dishSet, Context context) {
            this.context = context;
            this.dishes = new ArrayList<Dish>();
            for(Dish d : dishSet) {
                dishes.add(d);
            }
        }

        @Override
        public int getCount() {
            return dishes.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Dish dish = dishes.get(i);
            View item = view;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.viewitem_view, viewGroup, false);
            ImageView image = (ImageView) item.findViewById(R.id.course_image);
            TextView text = (TextView) item.findViewById(R.id.course_name);
            image.setImageResource(dish.getImage());
            text.setText(dish.getName());
            if(model.inMenu(dish)) {
                // Chosen State
                image.setBackgroundColor(Color.rgb(173,17,43));
            }
            return item;
        }
    }
}