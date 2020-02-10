package pl.dieselsystem.ordersystem.model;

public enum Status {

    ACCEPT("Przyjęte do weryfikacji"),
    VERIFICATION("Weryfikacja"),
    AWAIT("Oczekiwanie na decyzję"),
    REPAIR("W naprawie"),
    READY("Gotowe do odbioru"),
    PICK_UP("Odebrane");

    private final String status;

    Status(String status) {

        this.status = status;

    }

    public String getStatus() {
        return this.status;
    }

}
