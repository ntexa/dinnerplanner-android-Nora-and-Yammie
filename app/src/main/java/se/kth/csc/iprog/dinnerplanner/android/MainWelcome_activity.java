package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainWelcome_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.mainwelcome_view);

        // Creating the view class instance
        //ExampleView mainView = new ExampleView(findViewById(R.id.this_is_example_view_id));
    }

    public void chooseCourses(View view) {
        Intent intent = new Intent(this, AddMenu_activity.class);
        startActivity(intent);
    }

}
