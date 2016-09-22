package edu.orangecoastcollege.cs273.vnguyen629.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;

/**
 * Takes in the customer's order/input and initializes
 * order object accordingly.
 * @author Vincent Nguyen
 */
public class OrderActivity extends AppCompatActivity {

    private EditText doubleDoubleEditText;
    private EditText cheeseburgerEditText;
    private EditText frenchFriesEditText;
    private EditText shakesEditText;
    private EditText smallDrinkEditText;
    private EditText mediumDrinkEditText;
    private EditText largeDrinkEditText;
    private Button orderButton;

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    Order newOrder = new Order();

    private String itemsOrdered;
    private String amountSubtotal;
    private String amountTax;
    private String amountTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        doubleDoubleEditText = (EditText) findViewById(R.id.doubleDoubleAmountEditText);
        cheeseburgerEditText = (EditText) findViewById(R.id.cheeseburgerAmountEditText);
        frenchFriesEditText = (EditText) findViewById(R.id.frenchFriesAmountEditText);
        shakesEditText = (EditText) findViewById(R.id.shakesAmountEditText);
        smallDrinkEditText = (EditText) findViewById(R.id.smallDrinkAmountEditText);
        mediumDrinkEditText = (EditText) findViewById(R.id.mediumDrinkAmountEditText);
        largeDrinkEditText = (EditText) findViewById(R.id.largeDrinkAmountEditText);

        orderButton = (Button) findViewById(R.id.placeOrderButton);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int amount = Integer.parseInt(doubleDoubleEditText.getText().toString());
                    newOrder.setDoubleDoubles(amount);
                }
                catch (NumberFormatException err) {
                    newOrder.setDoubleDoubles(0);
                }
                try {
                    int amount = Integer.parseInt(cheeseburgerEditText.getText().toString());
                    newOrder.setCheeseburgers(amount);
                }
                catch (NumberFormatException err) {
                    newOrder.setCheeseburgers(0);
                }
                try {
                    int amount = Integer.parseInt(frenchFriesEditText.getText().toString());
                    newOrder.setFrenchFries(amount);
                }
                catch (NumberFormatException err) {
                    newOrder.setFrenchFries(0);
                }
                try {
                    int amount = Integer.parseInt(shakesEditText.getText().toString());
                    newOrder.setShakes(amount);
                }
                catch (NumberFormatException err) {
                    newOrder.setShakes(0);
                }
                try {
                    int amount = Integer.parseInt(smallDrinkEditText.getText().toString());
                    newOrder.setSmallDrinks(amount);
                }
                catch (NumberFormatException err) {
                    newOrder.setSmallDrinks(0);
                }
                try {
                    int amount = Integer.parseInt(mediumDrinkEditText.getText().toString());
                    newOrder.setMediumDrinks(amount);
                }
                catch (NumberFormatException err) {
                    newOrder.setMediumDrinks(0);
                }
                try {
                    int amount = Integer.parseInt(largeDrinkEditText.getText().toString());
                    newOrder.setLargeDrinks(amount);
                }
                catch (NumberFormatException err) {
                    newOrder.setLargeDrinks(0);
                }
            }
        });

        Intent summaryIntent = new Intent(this, SummaryActivity.class);

        itemsOrdered = getString(R.string.items_ordered_text) + newOrder.getNumberItemsOrdered();
        amountSubtotal = getString(R.string.subtotal_text) + currency.format(newOrder.calculateSubtotal());
        amountTax = getString(R.string.tax_text) + currency.format(newOrder.calculateTax());
        amountTotal = getString(R.string.order_total_text )+ currency.format(newOrder.calculateTotal());

        summaryIntent.putExtra("Items", itemsOrdered);
        summaryIntent.putExtra("Subtotal", amountSubtotal);
        summaryIntent.putExtra("Tax", amountTax);
        summaryIntent.putExtra("Total", amountTotal);

        startActivity(summaryIntent);
        }
    }
