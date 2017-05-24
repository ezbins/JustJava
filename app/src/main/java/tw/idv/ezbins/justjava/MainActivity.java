package tw.idv.ezbins.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private final int PRICE = 5;
    private int total_quanity = 0;
    private Button add_btn;
    private Button subTract_btn;
    private Button btn_order;
    private TextView quanity_text;
    private TextView show_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_btn = (Button) findViewById(R.id.add_btn);
        subTract_btn = (Button) findViewById(R.id.subtract_btn);
        btn_order = (Button) findViewById(R.id.btn_order);
        quanity_text = (TextView) findViewById(R.id.quanity_text_view);
        show_price = (TextView) findViewById(R.id.price_text_show);
    }

    @Override
    protected void onStart() {
        super.onStart();
        display(0);
        showPrice(0);
        increment();
        decrement();
        submitOrder();
    }

    /**
     * increase quanity
     */
    private void increment() {
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_quanity = total_quanity + 1;
                quanity_text.setText(Integer.toString(total_quanity));
            }
        });
    }

    /**
     * decrement quanity
     */
    private void decrement() {
        subTract_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_quanity = total_quanity - 1;
                if (total_quanity < 0) {
                    total_quanity = 0;
                    display(total_quanity);
                } else {
                    display(total_quanity);
                }
            }
        });
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder() {
        /*String priceMsg = "Free";
        displayMessage(priceMsg);*/
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total_price = 0;
                total_price = total_quanity * PRICE;
                showPrice(total_price);
            }
        });
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        quanity_text.setText(Integer.toString(number));
    }
    /*private void displayMessage(String msg) {
        TextView showMsg = (TextView) findViewById(R.id.price_text_show);
        showMsg.setText(msg);
    }*/

    /**
     * This method display account from coffee quanities.
     *
     * @param price
     */
    private void showPrice(int price) {
        show_price.setText("$" + Integer.toString(price));
    }

}
