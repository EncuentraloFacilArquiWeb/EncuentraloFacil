package com.com.jwtdemo.repository;

import com.com.jwtdemo.model.Seller;
import com.com.jwtdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    // Puedes definir consultas personalizadas si es necesario
    // Por ejemplo, para buscar un vendedor por su ID de vendedor
    //Seller findByIdSeller(Long idSeller);

    // Otras operaciones de consulta si son necesarias
}
