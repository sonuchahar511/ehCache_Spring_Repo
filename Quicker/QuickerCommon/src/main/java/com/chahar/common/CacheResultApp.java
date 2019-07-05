package com.chahar.common;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CacheResultApp {
    public static void main(String[] args) {
        final CacheResult cacheResult = new CacheResult();
        for (int i = 1; i <= 20; i++) {
            try {
                System.out.println("Iteration: " + i + " , result: " + cacheResult.getResult());

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class CacheResult {

    private final Supplier<Boolean> result = Suppliers.memoizeWithExpiration(new Supplier<Boolean>() {
        @Override
        public Boolean get() {
            return computeResult();
        }
    }, 5, TimeUnit.SECONDS);

    public boolean getResult() {
        return result.get();
    }

    private boolean computeResult() {
        System.out.println("calculating result " + new Date());

        return System.currentTimeMillis() % 2 == 1;
    }

}
