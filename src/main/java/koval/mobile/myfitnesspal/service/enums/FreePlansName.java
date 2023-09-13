package koval.mobile.myfitnesspal.service.enums;

public enum FreePlansName {
    EAT_GREEN("Eat Green"),

    MYFITNESSPAL_101("MyFitnessPal 101");


    public final String name;

    FreePlansName(String name) {
        this.name = name;
    }


    public String getFreePlanName() {
        return name;
    }

}
