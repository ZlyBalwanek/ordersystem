package pl.dieselsystem.ordersystem.model;

public enum Category {

    PUMP("Pompa"),
    INJECTOR("Wtryskiwacz"),
    UNIT_INJECTOR("Pompowtryskiwacz"),
    PUMP_COMMONRAIL("Pompa CR"),
    INJECTOR_COMMONRAIL("Wtryskiwacz CR");

    private final String category;

    Category(String category) {

        this.category = category;

    }

    public String getCategory() {

        return this.category;

    }

}