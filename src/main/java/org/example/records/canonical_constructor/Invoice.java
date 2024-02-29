package org.example.records.canonical_constructor;

import java.util.Calendar;


public record Invoice(String id, float amount) {
    static String prefix = String.valueOf(Calendar.getInstance().get(Calendar.YEAR))
            +String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);

    public Invoice(String id, float amount){
        this.id=prefix+id.trim();
        this.amount=amount;
    }
}
