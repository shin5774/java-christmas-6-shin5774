package christmas.dto;

import christmas.Validator;
import christmas.VisitedDate;
import christmas.exception.VisitedDateException;

public class VisitedDateDTO {
    private final String requestDate;

    public VisitedDateDTO(String requestDate) {
        validate(requestDate);
        this.requestDate = requestDate;
    }

    private void validate(String requestDate) {
        if (Validator.isNotNumber(requestDate)) {
            throw VisitedDateException.from("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public VisitedDate toVisitedDate() {
        return VisitedDate.of(toInt(requestDate));
    }

    private int toInt(String requestDate) {
        return Integer.parseInt(requestDate);
    }
}
