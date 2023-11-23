package com.com.jwtdemo.repository;

import com.com.jwtdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    //@Query(value = "select ALL FROM Product WHERE expiration_date =2023-12-31",nativeQuery = true)
    //Product productoPorFecha(Date date);


    @Query(value = "select a FROM Product a WHERE a.expiration_date =:edate")
    List<Product> findbyExpiration_date(@Param("edate")Date edate);

    List<Product> findByCategory(String category);



}
