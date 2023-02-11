package RcxDev.example.superPos.Service;

import RcxDev.example.superPos.Dto.LoginDto;
import RcxDev.example.superPos.Dto.LoginInfoDTO;
import RcxDev.example.superPos.Entities.shop;
import RcxDev.example.superPos.Entities.users;
import RcxDev.example.superPos.Repository.loginRepository;
import RcxDev.example.superPos.Repository.shopRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class loginService {
    private final loginRepository repository;
    private final shopRepository shopRepository;
    public LoginInfoDTO getAllUsers(LoginDto params){

        LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
        users users =repository.findUser(params.getEmail(),params.getPassword());
        if(users!=null){
            loginInfoDTO.setId(users.getId());
            loginInfoDTO.setName(users.getName());
            loginInfoDTO.setUser_type(users.getUser_type());
            loginInfoDTO.setShop_id(users.getShop_id());
            loginInfoDTO.setOwner_id(users.getOwner_id()    );

           var shop=  shopRepository.getShopById(users.getShop_id());
            loginInfoDTO.setShop_name(shop.getShop_name());
            loginInfoDTO.setShop_contact(shop.getShop_contact());
            loginInfoDTO.setShop_email(shop.getShop_email());
            loginInfoDTO.setTax(18.0);
            loginInfoDTO.setCurrency_symbol(shop.getCurrency_symbol());
            loginInfoDTO.setShop_status(shop.getShop_status());

            loginInfoDTO.setMessage("Login Successfull!");
            loginInfoDTO.setValue("success");

        }else{

            loginInfoDTO.setValue("failure");
            loginInfoDTO.setMessage("Invalid cell or password! Try again!");
        }

        return loginInfoDTO;
    }


    public List<shop> shopInformation(Long shopId){

        return shopRepository.getShopsById(shopId);
    }
}
