package christmas.controller;

import christmas.InputView;
import christmas.Mapper;
import christmas.VisitedDate;
import christmas.dto.VisitedDateDTO;

public class RequestVisitedDateController extends RequestController<VisitedDate> {
    private InputView inputView = new InputView();

    @Override
    VisitedDate active() {
        VisitedDateDTO visitedDateDTO = inputView.requestVisitedDate();
        return Mapper.toVisitedDate(visitedDateDTO);
    }
}
