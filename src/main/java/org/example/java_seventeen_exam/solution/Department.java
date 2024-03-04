package org.example.java_seventeen_exam.solution;

public abstract sealed class Department permits
    ComputerEngineeringDept,
        SoftwareEngineeringDept,
    AccountingDept,
    SocialCareDept{
}
