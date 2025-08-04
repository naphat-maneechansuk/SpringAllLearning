package com.fullSpring.LearningBoot;

import com.fullSpring.LearningBoot.service.PaymentService;

public class ExampleUse {

    public static void main(String[] args) {


        FortuneTeller fortuneTeller = new FortuneTeller( new PaymentService("NORMAL"));
        String paymentId = fortuneTeller.createPayment();

        // GOTO pay this paymentId

        int luck = fortuneTeller.mobileNoFortune(paymentId, "0811234567");
        System.out.println("Luck is : " + luck);


        FortuneTeller fortuneTeller1 = new FortuneTeller(new PaymentService("VIP"));
        FortuneTeller fortuneTeller2 = new FortuneTeller(new PaymentService("NORMAL"));

    }

}