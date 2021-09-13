package pl.carwebapp.model;

public enum Price {
    SMALL(50), MEDIUM(188), LARGE(200), PRESTIGE(350);

    private int prices;

    Price(int prices) {
        this.prices = prices;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }
}
