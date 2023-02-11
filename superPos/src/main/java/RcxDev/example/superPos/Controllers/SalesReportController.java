package RcxDev.example.superPos.Controllers;

import RcxDev.example.superPos.Dto.OrderDetailDTO;
import RcxDev.example.superPos.Dto.ReportDTO;
import RcxDev.example.superPos.Entities.order_details;
import RcxDev.example.superPos.Service.orderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path ="api/v1/SalesReport" )
@AllArgsConstructor
public class SalesReportController {
    private final orderService service;


    @GetMapping("/List")
    private List<order_details> getReportList(@RequestParam String type, Long shop_id, Long owner_id, String yearly){
        var list =service.salesReportList(type,shop_id,owner_id,yearly);
        return service.salesReportList(type,shop_id,owner_id,yearly);


    }

    @GetMapping()
    private List<ReportDTO> getSalesReport(@RequestParam String type, Long shop_id, Long owner_id, String yearly){
        List<ReportDTO> reportDTOS= new ArrayList<>();
        reportDTOS.add(service.salesReportList(type,shop_id,owner_id,yearly,true));
        return reportDTOS;


    }
}
