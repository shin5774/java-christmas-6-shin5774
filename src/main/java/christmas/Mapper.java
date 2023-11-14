package christmas;

import christmas.dto.VisitedDateDTO;
import christmas.exception.VisitedDateException;

public class Mapper {
    public static VisitedDateDTO toVisitedDateDTO(String requestDate) {
        if (Validator.isNotNumber(requestDate)) {
            throw VisitedDateException.from("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }

        return new VisitedDateDTO(requestDate);
    }

    public static VisitedDate toVisitedDate(VisitedDateDTO visitedDateDTO) {
        return VisitedDate.of(toInt(visitedDateDTO.requestDate()));
    }

    private static int toInt(String requestDate) {
        return Integer.parseInt(requestDate);
    }
}
