package christmas.view.request;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.view.InformationMessage.REQUEST_VISITED_DATE_MESSAGE;

import christmas.dto.VisitedDateDTO;
import christmas.util.Mapper;

public class RequestVisitedDateView extends RequestView<VisitedDateDTO> {
    @Override
    void displayInformationMessage() {
        System.out.println(REQUEST_VISITED_DATE_MESSAGE);
    }

    @Override
    VisitedDateDTO request() {
        return Mapper.toVisitedDateDTO(readLine());
    }
}
