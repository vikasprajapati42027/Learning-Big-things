package com.example.toggle;

import org.springframework.stereotype.Service;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

@Service
public class DiscountService {

    private final FeatureManager featureManager;
    public static final Feature HOLIDAY_SALE = new NamedFeature("HOLIDAY_SALE");

    public DiscountService(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    public double getDiscount() {
        // Check if feature is enabled in a Dashboard (like Unleash)
        if (featureManager.isActive(HOLIDAY_SALE)) {
            return 0.20; // 20% off
        }
        return 0.05; // 5% base off
    }
}
