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
    private final int green = Color.rgb(65, 220, 160);

    private LinearLayout root;
    private TextView selectedMarket;

    private TextView label(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setPadding(0, 7, 0, 7);
        return t;
    }

    private LinearLayout createCard(String heading) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(18, 13, 18, 13);
        card.setBackgroundColor(panel);

        TextView title = label(heading, 16, Color.WHITE);
        title.setTypeface(null, Typeface.BOLD);
        card.addView(title);

        LinearLayout.LayoutParams lp =
            new LinearLayout.LayoutParams(-1, -2);
        lp.setMargins(0, 8, 0, 8);
        root.addView(card, lp);

        return card;
    }

    private void addLine(LinearLayout card, String text) {
        card.addView(label(text, 14, muted));
    }

    private Button makeButton(String text) {
        Button button = new Button(this);
        button.setText(text);
        return button;
    }

    private void showInfo(String title, String message) {
        new android.app.AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", (d, w) -> d.dismiss())
            .show();
    }

    private void selectMarket(String market) {
        selectedMarket.setText("SELECTED MARKET: " + market);
    }

    @Override
    public void onCreate(Bundle state) {
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

        root.addView(label(
            "DUAL MARKET AI ASSISTANT  •  v0.3.0",
            12, green
        ));

        selectedMarket = label(
            "SELECTED MARKET: STANDARD FOREX",
            15, Color.WHITE
        );
        selectedMarket.setTypeface(null, Typeface.BOLD);
        root.addView(selectedMarket);

        LinearLayout forex = createCard("01 • STANDARD FOREX");
        addLine(forex, "Market: EUR/USD");
        addLine(forex, "Data system: Forex provider");
        addLine(forex, "Connection: NOT CONNECTED");
        addLine(forex, "AI Signal: WAIT");
        addLine(forex, "Paper trade: IDLE");

        Button forexButton = makeButton("SELECT STANDARD FOREX");
        forexButton.setOnClickListener(v -> {
            selectMarket("STANDARD FOREX • EUR/USD");
            showInfo(
                "Standard Forex",
                "Forex data connection is not configured yet. " +
                "A verified Forex provider is required before signals can be calculated."
            );
        });
        forex.addView(forexButton);

        LinearLayout otc = createCard("02 • QUOTEX OTC");
        addLine(otc, "Market: EUR/USD (OTC)");
        addLine(otc, "Data system: Separate OTC provider");
        addLine(otc, "Connection: NOT VERIFIED");
        addLine(otc, "AI Signal: WAIT");
        addLine(otc, "Paper trade: IDLE");

        Button otcButton = makeButton("SELECT QUOTEX OTC");
        otcButton.setOnClickListener(v -> {
            selectMarket("QUOTEX OTC • EUR/USD");
            showInfo(
                "Quotex OTC",
                "OTC data source has not been verified. " +
                "This system is separate from Standard Forex. " +
                "No Quotex account automation is enabled."
            );
        });
        otc.addView(otcButton);

        LinearLayout settings = createCard("03 • TRADING SETTINGS");
        addLine(settings, "Account mode: DEMO / PAPER ONLY");
        addLine(settings, "Trade duration: 30 seconds");
        addLine(settings, "Real-money trading: DISABLED");
        addLine(settings, "Automatic Quotex orders: DISABLED");

        Button check = makeButton("CHECK DATA SETUP");
        check.setOnClickListener(v -> showInfo(
            "Next development step",
            "Connect and verify a supported Standard Forex data provider. " +
            "Then develop and test the separate Quotex OTC data source. " +
            "Signals will remain WAIT until valid market data is available."
        ));
        root.addView(check);

        TextView note = label(
            "SAFETY: No guessed BUY/SELL signals. Forex and OTC data " +
            "must never be mixed. This build does not connect to Quotex " +
            "or place real orders.",
            12, muted
        );
        note.setPadding(2, 16, 2, 10);
        root.addView(note);

        TextView footer = label(
            "AI LALA TRADER  •  DUAL MARKET DEMO",
            11, muted
        );
        footer.setGravity(Gravity.CENTER);
        root.addView(footer);
    }
}
