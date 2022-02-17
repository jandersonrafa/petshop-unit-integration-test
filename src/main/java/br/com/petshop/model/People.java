/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.model;

import lombok.*;
import org.springframework.data.annotation.Id;


/**
 *
 * @author janderson
 */
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class People {

    @Id
    private Long peopleId;
    private String txName;
    private Integer irAge;

}
