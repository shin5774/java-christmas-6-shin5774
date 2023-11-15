package christmas.controller;

import christmas.Benefits;
import christmas.UserInformation;

public class CalculateBenefitsController {
    private final UserInformation userInformation;

    public CalculateBenefitsController(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public Benefits proceed() {
        return userInformation.getBenefits();
    }
}
