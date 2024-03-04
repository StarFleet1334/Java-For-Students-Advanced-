package org.example.java_seventeen_exam.solution;

final class AccountingDept extends Department {

   public void accounting() {
       System.out.println("Custom accounting");
   }

    @Override
    public String toString() {
        return "Accounting";
    }
}
