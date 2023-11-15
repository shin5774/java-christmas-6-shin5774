package christmas.controller;

import christmas.domain.Benefits;
import christmas.domain.UserInformation;

public class CalculateBenefitsController {
    private final UserInformation userInformation;

    public CalculateBenefitsController(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public Benefits proceed() {
        return userInformation.getBenefits();
    }
}
