package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentSuccess extends AppCompatActivity {

    private ImageView iconImageView;
    private TextView redirectText;
    private static final long TOTAL_DURATION = 3000;
    private static final long TICK_INTERVAL = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);

        iconImageView = findViewById(R.id.iconImageView);
        redirectText = findViewById(R.id.redirectText);

        animateIcon();

    }

    private void animateIcon() {
        animateIcon(500, 0.5f, 1.0f, 2000);
    }

    private void animateIcon(long duration, float shrinkScale, float expandScale, long repeatDuration) {
        // Set up the shrink and expand animations
        ObjectAnimator shrinkX = ObjectAnimator.ofFloat(iconImageView, "scaleX", shrinkScale);
        ObjectAnimator shrinkY = ObjectAnimator.ofFloat(iconImageView, "scaleY", shrinkScale);

        ObjectAnimator expandX = ObjectAnimator.ofFloat(iconImageView, "scaleX", expandScale);
        ObjectAnimator expandY = ObjectAnimator.ofFloat(iconImageView, "scaleY", expandScale);

        // Create an AnimatorSet to play the animations in sequence
        AnimatorSet iconAnimator = new AnimatorSet();
        iconAnimator.play(shrinkX).with(shrinkY).before(expandX).before(expandY);
        iconAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        iconAnimator.setDuration(duration);

        shrinkX.setRepeatCount((int) (repeatDuration / duration) - 1);  // Repeat for 3 seconds
        shrinkY.setRepeatCount((int) (repeatDuration / duration) - 1);  // Repeat for 3 seconds
        expandX.setRepeatCount((int) (repeatDuration / duration) - 1);
        expandY.setRepeatCount((int) (repeatDuration / duration) - 1);
        shrinkX.setRepeatMode(ObjectAnimator.REVERSE);  // Reverse the animation on each repeat
        shrinkY.setRepeatMode(ObjectAnimator.REVERSE);  // Reverse the animation on each repeat
        expandX.setRepeatMode(ObjectAnimator.REVERSE); // Reverse the animation on each repeat
        expandY.setRepeatMode(ObjectAnimator.REVERSE);

        iconAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // Redirect to another activity after the animation completes
                startActivity(new Intent(PaymentSuccess.this, HomePage.class));
                finish();
            }
        });

        startTimer(TOTAL_DURATION);
        // Start the icon animation
        iconAnimator.start();
    }

    private void startTimer(long totalDuration) {
        new CountDownTimer(totalDuration, TICK_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update the timer text with remaining seconds
                long remainingSeconds = millisUntilFinished / 1000;
                redirectText.setText("Redirecting to home in " + remainingSeconds + "s");
            }

            @Override
            public void onFinish() {
                // Ensure the timer text displays 0s at the end
            }
        }.start();
    }
}