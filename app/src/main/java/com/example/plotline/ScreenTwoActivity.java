package com.example.plotline;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
    public class ScreenTwoActivity extends AppCompatActivity {

        private LinearLayout buttonsLayout;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_screen_two);

            buttonsLayout = findViewById(R.id.buttons_layout);

            String targetButton = getIntent().getStringExtra("targetButton");
            String font = getIntent().getStringExtra("font");
            String color = getIntent().getStringExtra("color");
            String position = getIntent().getStringExtra("position");
            int arrowWidth = getIntent().getIntExtra("arrowWidth", 0);
            int arrowHeight = getIntent().getIntExtra("arrowHeight", 0);

            Button button1 = findViewById(R.id.button1);
            Button button2 = findViewById(R.id.button2);
            Button button3 = findViewById(R.id.button3);
            Button button4 = findViewById(R.id.button4);
            Button button5 = findViewById(R.id.button5);

            Button target = null;
            String b = "";
            switch (targetButton) {
                case "button1":
                    target = button1;
                    b = "one";
                    break;
                case "button2":
                    target = button2;
                    b = "two";
                    break;
                case "button3":
                    target = button3;
                    b = "three";
                    break;
                case "button4":
                    target = button4;
                    break;
                case "button5":
                    target = button5;
                    break;
            }
            TextView tooltipView = new TextView(this);
            tooltipView.setText(targetButton);
            tooltipView.setTypeface(Typeface.DEFAULT_BOLD);
            tooltipView.setTextColor(Color.parseColor(color));
            tooltipView.setBackgroundColor(Color.parseColor("#DADADA"));
            tooltipView.setPadding(16, 8, 16, 8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            if (position.equals("left")) {
                layoutParams.gravity = Gravity.START;
            } else if (position.equals("right")) {
                layoutParams.gravity = Gravity.END;
            } else if (position.equals("top")) {
                layoutParams.gravity = Gravity.TOP;
            } else if (position.equals("bottom")) {
                layoutParams.gravity = Gravity.BOTTOM;
            }


            buttonsLayout.addView(tooltipView, layoutParams);

            target.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonsLayout.removeView(tooltipView);
                }
            });
        }
    }