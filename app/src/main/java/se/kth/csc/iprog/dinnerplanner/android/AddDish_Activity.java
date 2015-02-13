package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;

import se.kth.csc.iprog.dinnerplanner.android.view.AddDish_Controller;
import se.kth.csc.iprog.dinnerplanner.android.view.AddDish_View;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class AddDish_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddish_view);

        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        // Creating the view class instance
        AddDish_View view = new AddDish_View(findViewById(R.id.dialog_container), model, this);
        AddDish_Controller controller = new AddDish_Controller(model, view, this);
    }
}
