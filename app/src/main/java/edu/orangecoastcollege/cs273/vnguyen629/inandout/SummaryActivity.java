package edu.orangecoastcollege.cs273.vnguyen629.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Controller that receives data (via Intent) from OrderActivity.java
 * and displays the total, subtotal, number of items ordered, and tax
 * amount to the screen.
 * @author Vincent Nguyen
 */
public class SummaryActivity extends AppCompatActivity {

    private TextView orderTotalTextView;
    private TextView itemsOrderedTextView;
    private TextView subtotalTextView;
    private TextView taxAmountTextView;
    private Button startNewOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intentFromOrderActivity = getIntent();

        orderTotalTextView = (TextView) findViewById(R.id.orderTotalTextView);
        itemsOrderedTextView = (TextView) findViewById(R.id.itemsOrderedTextView);
        subtotalTextView = (TextView) findViewById(R.id.subtotalTextView);
        taxAmountTextView = (TextView) findViewById(R.id.taxTextView);

        itemsOrderedTextView.setText(intentFromOrderActivity.getStringExtra("Items"));
        subtotalTextView.setText(intentFromOrderActivity.getStringExtra("Subtotal"));
        taxAmountTextView.setText(intentFromOrderActivity.getStringExtra("Tax"));
        orderTotalTextView.setText(intentFromOrderActivity.getStringExtra("Total"));

        startNewOrderButton = (Button) findViewById(R.id.newOrderButton);
        startNewOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToDataEntry(v);
            }
        });
    }

    public void returnToDataEntry(View view) {
        this.finish();
    }
}
