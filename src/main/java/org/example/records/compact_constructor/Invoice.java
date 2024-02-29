package org.example.records.compact_constructor;

import java.util.Calendar;

/**
 *
 *  Here, we simply provide the record name as the constructor without any parameters
 *
 *  This type of constructor has implicit declaration of all the parameters – the same
 *  as the record component – and is automatically assigned to the values passed to the component
 *  of the record. Also, note that, in compact constructors, we do not use this keyword.
 *
 * @param id
 * @param amount
 */

public record Invoice(String id, float amount) {
    static String prefix = String.valueOf(Calendar.getInstance().get(Calendar.YEAR))
            +String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
    public Invoice{
        id=prefix+id.trim();
        amount=amount;
    }
}
