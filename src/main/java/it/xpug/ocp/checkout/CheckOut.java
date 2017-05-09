package it.xpug.ocp.checkout;

public class CheckOut {

    private PriceCalculator calculator;

    public CheckOut(PriceCalculator calculator) {

        this.calculator = calculator;
    }

    public int total() {
		return calculator.total();
	}

	public void scan(String code) {
        calculator.add(code);
	}

}
