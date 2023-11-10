package christmas.dto;

import christmas.VisitedDate;
import christmas.exception.VisitedDateException;
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
            throw VisitedDateException.from("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private boolean isNotNumber(String requestDate) {
        return !NUMBER.matcher(requestDate).matches();
    }

    public VisitedDate toVisitedDate() {
        return VisitedDate.of(toInt(requestDate));
    }

    private int toInt(String requestDate) {
        return Integer.parseInt(requestDate);
    }
}
