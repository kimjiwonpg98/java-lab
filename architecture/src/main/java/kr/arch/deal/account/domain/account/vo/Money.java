package kr.arch.deal.account.domain.account.vo;

import java.math.BigInteger;

import lombok.Value;

@Value
public class Money {
    public static Money ZERO = Money.of(BigInteger.ZERO);

    BigInteger amount;

    public boolean isPositiveOrZero() {
        return this.amount.compareTo(BigInteger.ZERO) >= 0;
    }

    public boolean isNegative() {
        return this.amount.compareTo(BigInteger.ZERO) < 0;
    }

    public boolean isPositive() {
        return this.amount.compareTo(BigInteger.ZERO) > 0;
    }

    public boolean isGreaterThanOrEqualTo(Money money) {
        return this.amount.compareTo(money.amount) >= 0;
    }

    public boolean isGreaterThan(Money money) {
        return this.amount.compareTo(money.amount) >= 1;
    }

    public static Money of(BigInteger value) {
        return new Money(value);
    }

    public static Money add(Money a, Money b) {
        return a.plus(b);
    }

    public Money minus(Money money) {
        return new Money(this.amount.subtract(money.amount));
    }

    public Money plus(Money money) {
        return Money.of(this.amount.add(money.amount));
    }

    public static Money subtract(Money a, Money b) {
        return new Money(a.amount.subtract(b.amount));
    }

    public Money negate() {
        return new Money(this.amount.negate());
    }

}