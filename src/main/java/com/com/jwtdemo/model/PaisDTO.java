package com.com.jwtdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaisDTO {//ES DTO SI NO ES DEFINIDO COMO @ENTITY
    String name;
}