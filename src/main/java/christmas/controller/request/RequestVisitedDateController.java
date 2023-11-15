package christmas.controller.request;

import christmas.domain.VisitedDate;
import christmas.dto.VisitedDateDTO;
import christmas.util.Mapper;
import christmas.view.request.RequestView;

public class RequestVisitedDateController extends RequestController<VisitedDate> {
    private final RequestView<VisitedDateDTO> requestView;

    public RequestVisitedDateController(RequestView<VisitedDateDTO> requestView) {
        this.requestView = requestView;
    }

    @Override
    VisitedDate request() {
        VisitedDateDTO visitedDateDTO = requestView.process();
        return Mapper.toVisitedDate(visitedDateDTO);
    }
}
