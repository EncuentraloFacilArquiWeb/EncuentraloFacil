package com.com.EncuentraloFacil.repository;

import com.com.EncuentraloFacil.DTO.SellerDTO;
import com.com.EncuentraloFacil.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    // Puedes definir consultas personalizadas si es necesario
    // Por ejemplo, para buscar un vendedor por su ID de vendedor
    //Seller findByIdSeller(Long idSeller);

    // Otras operaciones de consulta si son necesarias

    @Query(value = "SELECT * FROM public.seller ORDER BY id ASC", nativeQuery = true)
    List<Seller> listAllSeller();

    @Query(value = "select a.id from seller a ORDER BY id ASC", nativeQuery = true)
    SellerDTO nombreEidSeller();


}
