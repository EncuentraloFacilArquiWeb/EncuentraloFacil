package com.com.jwtdemo.service;

import com.com.jwtdemo.DTO.ProductDTO;
import com.com.jwtdemo.DTO.SellerDTO;
import com.com.jwtdemo.DTO.UserDTO;
import com.com.jwtdemo.model.Seller;
import com.com.jwtdemo.model.User;
import com.com.jwtdemo.service.SellerService;
import com.com.jwtdemo.model.Product;
import com.com.jwtdemo.repository.ProductRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final SellerService sellerService;
    @Autowired
    public ProductService(ProductRepository productRepository, SellerService sellerService) {
        this.productRepository = productRepository;
        this.sellerService = sellerService;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
   /* public List<Product> lista() {
        return productRepository.findAll();
    }*/

    public Product elimina (Long id) throws Exception {
        // Pregunta si existe
        Product pro = productRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id de producto no existe: "+ id));

        productRepository.delete(pro);
        return pro;
    }

    public List<ProductDTO> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory(product.getCategory());
        productDTO.setBrand(product.getBrand());
        productDTO.setExpiration_date(product.getExpiration_date());

        // Mapeo del usuario (User) si es necesario
        if (product.getSeller() != null) {
            productDTO.setSeller(convertSellerToDTO(product.getSeller()));
        }

        // Otros campos que puedas tener en SellerDTO

        return productDTO;
    }
    private SellerDTO convertSellerToDTO(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setId(seller.getId());
        sellerDTO.setName(seller.getName());
        sellerDTO.setStore(seller.getStore());
        sellerDTO.setStoreDescription(seller.getStoreDescription());
        sellerDTO.setStoreLocation(seller.getStoreLocation());

        //Mapeo del usuario (User) si es necesario
       // if (seller.getUser() != null) {
         //   sellerDTO.setUser(convertUserToDTO(seller.getUser()));
        //}

        // Otros campos que puedas tener en SellerDTO

        return sellerDTO;
    }
    /*private UserDTO convertUserToDTO(User user) {
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
    }*/






}