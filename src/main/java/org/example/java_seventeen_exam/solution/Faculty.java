package org.example.java_seventeen_exam.solution;

public abstract sealed class Faculty implements Educational permits
    EngineeringFaculty,
    HumanitiesFaculty,
    BusinessFaculty {
}
