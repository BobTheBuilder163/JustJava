package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();

        CheckBox whippedCream = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCream.isChecked();

        CheckBox chocolate = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolate.isChecked();
        displayMessage(createOrderSummary("Arlee Villarivera", price, hasWhippedCream, hasChocolate));
    }

    /**
     * Calculates the price of the order.
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     *
     * @param name name of the person
     * @param total total price
     * @return Order summary
     */
    private String createOrderSummary(String name, int total, boolean hasToppings, boolean hasChocolate) {
        String message = "Name: " + name;
                message += "\nAdd whipped cream? " + hasToppings;
                message += "\nAdd Chocolate? " + hasChocolate;
                message += "\nQuantity: " + quantity;
                message += "\nTotal: $" + total;
                message += "\nThank you!";
        return message;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int displayQuantity) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + displayQuantity);
    }

    /**
     * This method increment the quantity on the screen.
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method decrement the quantity on the screen.
     */
    public void decrement(View view) {
        quantity--;
        if (quantity < 0) {
            quantity = 0;
        }
        displayQuantity(quantity);
    }

    /**
     * This method displays the given message.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}