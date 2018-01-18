package allebdi.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class PlaceDetailsActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imageView;
    TextView name, description;
    RatingBar ratingBar;
    Button navgiationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details2);

        // tooblar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final Place selectedPlace = (Place) getIntent().getExtras().get("selectedPlace");


        imageView = (ImageView) findViewById(R.id.image);
        ratingBar = (RatingBar) findViewById(R.id.rating);
        name = (TextView) findViewById(R.id.name);
        description = (TextView) findViewById(R.id.descrption);
        navgiationBtn = (Button) findViewById(R.id.navigation);


        imageView.setImageResource(selectedPlace.getPicturePath());
        ratingBar.setRating(selectedPlace.getRating());
        name.setText(selectedPlace.getName());
        description.setText(selectedPlace.getDescription());

        navgiationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), selectedPlace.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
