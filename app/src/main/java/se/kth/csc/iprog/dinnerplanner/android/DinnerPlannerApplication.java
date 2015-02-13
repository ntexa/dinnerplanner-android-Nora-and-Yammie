package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Application;
import android.content.Context;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

public class DinnerPlannerApplication extends Application {
	
	private DinnerModel model = new DinnerModel();

	public DinnerModel getModel() {
		return model;
	}

	public void setModel(DinnerModel model) {
		this.model = model;
	}

    public static int getDrawable(Context context, String name)
    {
        return context.getResources().getIdentifier(name,"drawable", context.getPackageName());
    }

}
