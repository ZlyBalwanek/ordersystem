package pl.dieselsystem.ordersystem.model;

public enum Category {

    pump("Pompa"),
    injector("Wtryskiwacz"),
    unitInjector("Pompowtryskiwacz"),
    pumpCr("Pompa CR"),
    injectorCr("Wtryskiwacz CR");

    private final String category;

    Category(String category) {

        this.category = category;

    }

    public String getCategory() {

        return this.category;

    }

}
