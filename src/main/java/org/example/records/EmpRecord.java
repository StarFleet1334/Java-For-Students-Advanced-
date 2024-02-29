package org.example.records;

import java.util.Map;

// In this code we extend Records constructor
public record EmpRecord(int id, String name, long salary, Map<String,String> addresses) {
    public EmpRecord {
        if (id < 0) {
            throw new IllegalArgumentException("employee id can't be negative");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("employee salary can't be negative");
        }
    }

    // We can also create methods in records
    public int getAddressCount() {
        if (this.addresses != null)
            return this.addresses().size();
        else
            return 0;
    }
    //But, records are meant to be data carriers. We should avoid having utility methods in a record class.
}
