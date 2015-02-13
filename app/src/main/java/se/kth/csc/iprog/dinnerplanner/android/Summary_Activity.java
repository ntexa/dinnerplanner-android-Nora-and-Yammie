package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;

import se.kth.csc.iprog.dinnerplanner.android.view.Summary_Controller;
import se.kth.csc.iprog.dinnerplanner.android.view.Summary_View;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class Summary_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.summary_view);

        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        // Creating the view class instance
        Summary_View view = new Summary_View(findViewById(R.id.make_dinner), model);
        Summary_Controller controller = new Summary_Controller(model, view);
    }
}
