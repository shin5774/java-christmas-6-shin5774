package christmas.controller.request;

import christmas.domain.VisitedDate;
import christmas.dto.VisitedDateDTO;
import christmas.util.Mapper;
import christmas.view.request.RequestVisitedDateView;

public class RequestVisitedDateController extends RequestController<VisitedDate> {
    private RequestVisitedDateView requestView = new RequestVisitedDateView();

    @Override
    VisitedDate request() {
        VisitedDateDTO visitedDateDTO = requestView.process();
        return Mapper.toVisitedDate(visitedDateDTO);
    }
}
