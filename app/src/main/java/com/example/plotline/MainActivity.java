package com.example.plotline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button submitButton;
    private EditText target,target_font,target_color, target_position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        target=findViewById(R.id.target_button_edittext);
        target_font=findViewById(R.id.font_edittext);
        target_color=findViewById(R.id.color_edittext);
        target_position=findViewById(R.id.position_edittext);
        submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScreenTwo();
            }
        });
    }

    private void openScreenTwo() {
        Intent intent = new Intent(MainActivity.this, ScreenTwoActivity.class);
        String targetButton = target.getText().toString();
        String font=target_font.getText().toString();
        String color = target_color.getText().toString();
        String position = target_position.getText().toString();
        intent.putExtra("targetButton", targetButton);
        intent.putExtra("font", font);
        intent.putExtra("color", color);
        intent.putExtra("position", position);
        intent.putExtra("arrowHeight",10);
        intent.putExtra("arrowWidth",20);
        startActivity(intent);
    }
}
