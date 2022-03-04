package com.example.bkd0708k11.activities.noteapp.helpers;

import java.text.NumberFormat;
import java.util.Currency;

public class Helpers {
    public static String formatCurrency(double amount) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setCurrency(Currency.getInstance("VND"));
        return format.format(amount);
    }
}
