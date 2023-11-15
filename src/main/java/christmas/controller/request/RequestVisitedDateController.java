package christmas.controller.request;

import christmas.domain.VisitedDate;
import christmas.dto.VisitedDateDTO;
import christmas.util.Mapper;
import christmas.view.InputView;

public class RequestVisitedDateController extends RequestController<VisitedDate> {
    private InputView inputView = new InputView();

    @Override
    VisitedDate active() {
        VisitedDateDTO visitedDateDTO = inputView.requestVisitedDate();
        return Mapper.toVisitedDate(visitedDateDTO);
    }
}
