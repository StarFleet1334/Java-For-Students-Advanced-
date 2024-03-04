package org.example.java_seventeen_exam.solution;

public record LecturerRecord (String name, Integer age, Faculty faculty, Department department) {



    public LecturerRecord {
        String errorMsg = """
            Illegal argument passed:
            "name": %s,
            "age:": %s
        """.formatted(name,age);
        if (name.isBlank() || age < 0) {
            throw new IllegalArgumentException(errorMsg);
        }
    }


    public boolean hasPhd() {
        String prefix = name.substring(0,3);
        String suffix = name.substring(name.length()-3);
        return (
                switch (prefix) {
                    case "Dr." -> true;
                    default -> false;
                } ||
                        switch (suffix) {
                            case "PhD" -> true;
                            default -> false;
                        }
                );
    }

    public void whichFaculty() {
        switch (faculty) {
            case EngineeringFaculty e -> {
                System.out.println("Faculty of: %s".formatted(e.toString()));;
                e.engineering();
            }
            case HumanitiesFaculty h -> {
                System.out.println("Faculty of: %s".formatted(h.toString()));;
                h.humanities();
            }
            case BusinessFaculty b -> {
                System.out.println("Faculty of: %s".formatted(b.toString()));;
                b.business();
            }
            default -> throw new IllegalArgumentException("Faculty: %s is causing error".formatted(department.toString()));
        }
    }

    public void whichDept() {
        switch (department) {
            case ComputerEngineeringDept s  -> {
                System.out.println("Dept of: %s".formatted(s.toString()));;
                s.compEng();
            }
            case SoftwareEngineeringDept s -> {
                System.out.println("Dept of: %s".formatted(s.toString()));;
                s.swEng();
            }
            case SocialCareDept s -> {
                System.out.println("Dept of: %s".formatted(s.toString()));;
                s.socialCare();
            }
            case AccountingDept a -> {
                System.out.println("Dept of: %s".formatted(a.toString()));;
                a.accounting();
            }
            default -> throw new IllegalArgumentException("Department: %s is causing error".formatted(department.toString()));
        }
    }


}
