package org.example.records.non_canonical_constructor;

import java.util.Calendar;

/**
 *
 * he key requirement of a non-canonical constructor
 * is that the constructor must call another constructor in the record through the this keyword.
 *
 * Declaring a record with both a canonical constructor and non-canonical
 * constructor is perfectly valid and there are no restrictions on the number
 * of constructors a record can have, as long as it is designed according to the norms of the record
 *
 *
 * @param id
 * @param amount
 */

public record Invoice(String id, float amount) {
    static String prefix = String.valueOf(Calendar.getInstance().get(Calendar.YEAR))
            +String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);

    // Here this is canonical-constructor ( compact constructor)
    public Invoice{
        id=prefix+id.trim();
        amount=amount;
    }


    // Here non-canonical
    public Invoice(String id){
        this(id,0.0f);
    }
}
