package org.example.java_seventeen_exam.solution;

final class BusinessFaculty extends Faculty{

    public void business() {
        System.out.println("We teach accountancy, law, economics etc...");
    }

    @Override
    public String toString() {
        return "Business";
    }
}
