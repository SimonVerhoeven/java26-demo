package dev.simonverhoeven.java26demo.preview.language;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Supplier;

/// JEP-526: Lazy constants (Second preview)

public class LazyConstantsDemo {

//    // We defer the initialization, it'll be initialized at-most once and is immutable.
//    // This enables constant-folding.
//    private final Supplier<Integer> meaningOfLife = LazyConstant.supplier(() -> 42);
//    private final List<BigDecimal> numbers = LazyConstant.list(42, BigDecimal::valueOf);
//
//    Integer getMeaningOfLife() {
//        // The constant is computed on the first get invocation
//        return meaningOfLife.get();
//    }
//
//    List<BigDecimal> getNumbers() {
//        // the constant computation is deferred to the first .get(index) or similar.
//        return numbers;
//    }
}