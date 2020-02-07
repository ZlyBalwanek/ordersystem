package pl.dieselsystem.ordersystem.model;

public enum Status {

    accept("Przyjęte do weryfikacji"),
    verification("Weryfikacja"),
    await("Oczekiwanie na decyzję"),
    repair("W naprawie"),
    ready("Gotowe do odbioru"),
    pickUp("Odebrane");

    private final String status;

    Status(String status) {

        this.status = status;

    }

    public String getStatus() {
        return this.status;
    }

}
