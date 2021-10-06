package pl.carwebapp.dto;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class PaymentDto {

    @Positive
    BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
