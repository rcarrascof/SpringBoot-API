package RcxDev.example.superPos.Controllers;

import RcxDev.example.superPos.Dto.BaseDTO;
import RcxDev.example.superPos.Dto.LoginDto;
import RcxDev.example.superPos.Dto.LoginInfoDTO;
import RcxDev.example.superPos.Entities.shop;
import RcxDev.example.superPos.Entities.users;
import RcxDev.example.superPos.Repository.loginRepository;
import RcxDev.example.superPos.Service.loginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/login" )
@AllArgsConstructor
public class LoginController {

    private final loginService service;
    @PostMapping()
    private LoginInfoDTO Login(@RequestBody LoginDto params ){
        return service.getAllUsers(params);
    }


    @GetMapping("shopInfo")
    private ResponseEntity<List<shop>> shopInformation(@RequestParam Long shop_id){
        try {
            var result = service.shopInformation(shop_id);
            if(result!=null)
            return new ResponseEntity<>(result, HttpStatus.OK);

        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);

    } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
}
