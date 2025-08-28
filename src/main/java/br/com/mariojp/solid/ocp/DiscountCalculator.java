package br.com.mariojp.solid.ocp;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {

    private Map<CustomerType, DiscountPolicy> discountPolicies;

    public DiscountCalculator() {
        this.discountPolicies = new HashMap<>();
        this.discountPolicies.put(CustomerType.REGULAR, new RegularPolicy());
        this.discountPolicies.put(CustomerType.PREMIUM, new PremiumPolicy());
        this.discountPolicies.put(CustomerType.PARTNER, new PartnerPolicy());
    }


    public DiscountCalculator(Map<CustomerType, DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }


    public double apply(double amount, CustomerType customerType) {
        DiscountPolicy selectedPolicy = discountPolicies.get(customerType);

        return selectedPolicy.apply(amount);
    }
}
