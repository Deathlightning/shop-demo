package xyz.kingsword.shopdemo.model.service;

import java.util.function.Supplier;

/**
 * @author: wzh date: 2019-04-24 19:48
 * @version: 1.0
 **/
public final class ConditionalStrategy {
    private Boolean flag;

    private ConditionalStrategy(boolean flag) {
        this.flag = flag;
    }


    public static ConditionalStrategy ofTrue() {
        return new ConditionalStrategy(true);
    }

    public static ConditionalStrategy ofFalse() {
        return new ConditionalStrategy(false);
    }

    public static ConditionalStrategy ofCondition(boolean value) {
        return value ? ofTrue() : ofFalse();
    }

    public boolean get() {
        return flag;
    }

    public <T> T orElse(T one, T another) {
        return flag ? one : another;
    }

    public <T> T orElseGet(T one, Supplier<? extends T> another) {
        return orElse(one, another.get());
    }

    public <X extends Throwable> void orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (!flag)
            throw exceptionSupplier.get();
    }
}