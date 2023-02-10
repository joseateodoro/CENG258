//Jose Antonio Castro Teodoro n01384776 Section B

package jose.teodoro.n01384776.Animation;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import jose.teodoro.n01384776.R;


public class N01384776Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_n01384776, container, false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_n01384776);

        // Handle Grow Button
        final Button growButton = (Button) findViewById(R.id.ButtonScale);
        growButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.grow);
            }
        });

        // Handle Move Button
        final Button moveButton = (Button) findViewById(R.id.ButtonTranslate);
        moveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.translate_position);
            }
        });

        // Handle Spin Button
        final Button spinButton = (Button) findViewById(R.id.ButtonRotate);
        spinButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.spin);
            }
        });
    }

    private void performAnimation(int animationResourceID)
    {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView)findViewById(R.id.ImageViewForTweening);
        reusableImageView.setImageResource(R.drawable.green_rect);
        reusableImageView.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        reusableImageView.startAnimation(an);
    }

    private void performAnimation(int animationResourceID)
    {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView)findViewById(R.id.ImageViewForTweening);
        reusableImageView.setImageResource(R.drawable.green_rect);
        reusableImageView.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());
        // Start the animation
        reusableImageView.startAnimation(an);
    }

    private void toggleButtons(boolean clickableState)
    {

        // Handle Grow Button
        final Button growButton = (Button) findViewById(R.id.ButtonScale);
        growButton.setClickable(clickableState);

        // Handle Move Button
        final Button moveButton = (Button) findViewById(R.id.ButtonTranslate);
        moveButton.setClickable(clickableState);

        // Handle Spin Button
        final Button spinButton = (Button) findViewById(R.id.ButtonRotate);
        spinButton.setClickable(clickableState);

    }

    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            // Hide our ImageView
            ImageView reusableImageView = (ImageView)findViewById(R.id.ImageViewForTweening);
            reusableImageView.setVisibility(View.INVISIBLE);

            // Enable all buttons once animation is over
            toggleButtons(true);

        }

        public void onAnimationStart(Animation animation) {
            // Disable all buttons while animation is running
            toggleButtons(false);

        }

    }
}