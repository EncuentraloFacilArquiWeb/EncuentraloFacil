package com.com.jwtdemo.service;

import com.com.jwtdemo.DTO.SellerDTO;
import com.com.jwtdemo.DTO.UserDTO;
import com.com.jwtdemo.model.Seller;
import com.com.jwtdemo.model.User;
import com.com.jwtdemo.repository.SellerRepository;
import org.hibernate.cache.spi.SecondLevelCacheLogger;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
    //public List<Seller> lista() {
      //  return sellerRepository.findAll();
    //}
    public List<Seller> lista() {
        return sellerRepository.listAllSeller();
    }

    public Seller delete (Long id) throws Exception {
        // Pregunta si existe
        Seller sel = sellerRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id de seller no existe: "+ id));

        sellerRepository.delete(sel);
        return sel;
    }

    public List<SellerDTO> getAllSellers() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private UserDTO convertUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        //userDTO.setId(user.getId());
        //userDTO.setUsername(user.getUsername());
        //userDTO.setPassword(user.getPassword());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setCountry(user.getCountry());
        //userDTO.setRole(user.getRole());

        // Otros campos que puedas tener en UserDTO

        return userDTO;
    }

    private SellerDTO convertToDTO(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setId(seller.getId());
        sellerDTO.setName(seller.getName());
        sellerDTO.setStore(seller.getStore());
        sellerDTO.setStoreDescription(seller.getStoreDescription());
        sellerDTO.setStoreLocation(seller.getStoreLocation());

        //Mapeo del usuario (User) si es necesario
        if (seller.getUser() != null) {
          sellerDTO.setUser(convertUserToDTO(seller.getUser()));
        }

        // Otros campos que puedas tener en SellerDTO

        return sellerDTO;
    }

}
