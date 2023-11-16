package christmas.view.request;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.dto.VisitedDateDTO;
import christmas.util.Mapper;

public class RequestVisitedDateView extends RequestView<VisitedDateDTO> {
    private static final String INFORMATION_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    @Override
    void displayInformationMessage() {
        System.out.println(INFORMATION_MESSAGE);
    }

    @Override
    VisitedDateDTO request() {
        return Mapper.toVisitedDateDTO(readLine());
    }
}
