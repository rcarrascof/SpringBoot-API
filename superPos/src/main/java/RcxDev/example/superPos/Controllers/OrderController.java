package RcxDev.example.superPos.Controllers;

import RcxDev.example.superPos.Dto.BaseDTO;
import RcxDev.example.superPos.Dto.OrderListDTO;
import RcxDev.example.superPos.Entities.order_details;
import RcxDev.example.superPos.Entities.order_list;
import RcxDev.example.superPos.Service.orderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/orders" )
@AllArgsConstructor
public class OrderController {
    private final orderService service;

    @GetMapping
    private List<order_list> getOrderList(@RequestParam String search_text, Long shop_id, Long owner_id){

        return service.orderLists(search_text,shop_id,owner_id);
    }

    @GetMapping("Detail")
    private List<order_details> getOrderDetail(@RequestParam String invoice_id){

        return service.OrderDetail(invoice_id);
    }

    @PostMapping("submit")
    private  ResponseEntity<String> orderSubmit(@RequestBody OrderListDTO ordersData){
        try {

            service.orderSubmit(ordersData);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error"+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/delete")
    public ResponseEntity<BaseDTO> deleteOrder(@RequestParam String invoice_id) {
        BaseDTO result = new BaseDTO();
        result.setValue("failure");
        result.setMessage("Error deleting order:"+invoice_id);
        try {
            if (service.deleteByInvoiceId(invoice_id)){
                result.setMessage("Order deleted successfully");
                result.setValue("success");
                return new ResponseEntity<>(result, HttpStatus.OK);
            }

            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            result.setMessage("Error deleting order: " + e.getMessage());
            return new  ResponseEntity<BaseDTO>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
