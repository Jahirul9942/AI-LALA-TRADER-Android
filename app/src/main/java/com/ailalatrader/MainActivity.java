package com.ailalatrader;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {
    private final int bg = Color.rgb(10, 16, 28);
    private final int panel = Color.rgb(22, 32, 49);
    private final int muted = Color.rgb(166, 181, 201);
    private LinearLayout root;

    private TextView label(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value); t.setTextSize(size); t.setTextColor(color);
        t.setPadding(0, 7, 0, 7);
        return t;
    }

    private void card(String heading, String body) {
        LinearLayout c = new LinearLayout(this);
        c.setOrientation(LinearLayout.VERTICAL);
        c.setPadding(18, 13, 18, 13);
        c.setBackgroundColor(panel);
        TextView h = label(heading, 13, muted);
        h.setTypeface(null, Typeface.BOLD);
        c.addView(h);
        c.addView(label(body, 17, Color.WHITE));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
        lp.setMargins(0, 7, 0, 7);
        root.addView(c, lp);
    }

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        ScrollView scroll = new ScrollView(this);
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(20, 25, 20, 20);
        root.setBackgroundColor(bg);
        scroll.addView(root);
        setContentView(scroll);

        TextView title = label("AI LALA TRADER", 26, Color.WHITE);
        title.setTypeface(null, Typeface.BOLD);
        root.addView(title);
        TextView sub = label("30-SECOND DEMO ASSISTANT  •  v0.2.0", 12, Color.rgb(65, 220, 160));
        root.addView(sub);

        card("SELECTED MARKET", "EUR/USD (OTC)");
        card("TRADE DURATION", "30 seconds");
        card("ACCOUNT MODE", "DEMO / PAPER TRADING ONLY");
        card("DATA CONNECTION", "Not connected. Quotex OTC live data access has not been verified.");
        card("AI SIGNAL", "WAIT — waiting for a verified market-data feed. No BUY or SELL signal will be guessed.");
        card("PAPER TRADE STATUS", "No virtual trade running");

        Button check = new Button(this);
        check.setText("CHECK DATA SETUP");
        check.setOnClickListener(v -> new android.app.AlertDialog.Builder(this)
            .setTitle("Next development step")
            .setMessage("A supported market-data source is needed before reliable signals can be calculated. Quotex account automation is not enabled.")
            .setPositiveButton("OK", (d, w) -> d.dismiss())
            .show());
        root.addView(check);

        TextView note = label("Safety: OTC 30-second prices are highly volatile. This app does not connect to Quotex, place orders, or use real money.", 12, muted);
        note.setPadding(2, 16, 2, 10);
        root.addView(note);
        TextView footer = label("AI LALA TRADER  •  Demo build", 11, muted);
        footer.setGravity(Gravity.CENTER);
        root.addView(footer);
    }
}
