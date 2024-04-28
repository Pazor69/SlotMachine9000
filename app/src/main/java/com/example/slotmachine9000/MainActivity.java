package com.example.slotmachine9000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView slot1, slot2, slot3;
    private TextView resultText;
    private Button playButton;
    private int[] slotImages = {R.drawable.cherry, R.drawable.lemon, R.drawable.orange, R.drawable.grape, R.drawable.watermelon};
    private Random random = new Random();
    private int siano=10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slot1 = findViewById(R.id.imageView1);
        slot2 = findViewById(R.id.imageView2);
        slot3 = findViewById(R.id.imageView3);
        resultText = findViewById(R.id.textView);
        playButton = findViewById(R.id.button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinSlot();
            }
        });
    }

    private void spinSlot() {
        if (siano > 99) {
            siano -= 100;
            int image1 = slotImages[random.nextInt(slotImages.length)];
            int image2 = slotImages[random.nextInt(slotImages.length)];
            int image3 = slotImages[random.nextInt(slotImages.length)];

            slot1.setImageResource(image1);
            slot2.setImageResource(image2);
            slot3.setImageResource(image3);
            resultText.setText("Pieniądze: " + siano + "$");
            if (image1 == image2 && image2 == image3) {

                siano += (100*26);

                CharSequence text = "WYGRANA!!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(this /* MyActivity */, text, duration);
                toast.show();
                resultText.setText("Pieniądze: " + siano + "$");


            } else {
                CharSequence text = "Nie poszło!!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(this /* MyActivity */, text, duration);
                toast.show();
            }
        }
        else{
            CharSequence text = "KONIEC PIENIEDZY KONIEC GRY, RESTART!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this /* MyActivity */, text, duration);
            toast.show();
        }
    }
}
