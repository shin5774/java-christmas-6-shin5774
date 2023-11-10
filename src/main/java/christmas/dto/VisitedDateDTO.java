package christmas.dto;

import java.util.regex.Pattern;

public class VisitedDateDTO {
    private static final Pattern NUMBER = Pattern.compile("[0-9]+");
    private final String requestDate;

    public VisitedDateDTO(String requestDate) {
        validate(requestDate);
        this.requestDate = requestDate;
    }

    private void validate(String requestDate) {
        if (isNotNumber(requestDate)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotNumber(String requestDate) {
        return !NUMBER.matcher(requestDate).matches();
    }
}
