package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;

import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenu_Controller;
import se.kth.csc.iprog.dinnerplanner.android.view.ChooseMenu_View;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class AddMenu_activity extends Activity {

    @Override
         protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.addmenu_view);

        DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        // Creating the view class instance
        ChooseMenu_View view = new ChooseMenu_View(findViewById(R.id.choosemenu_view), model);
        ChooseMenu_Controller controller = new ChooseMenu_Controller(model, view);
    }
}