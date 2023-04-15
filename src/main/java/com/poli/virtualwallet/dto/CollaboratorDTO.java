package com.poli.virtualwallet.dto;

import com.poli.virtualwallet.collection.Contacts;
import lombok.Data;

import java.util.List;

@Data
public class CollaboratorDTO {
    private String email;
    private String name;
    private Double balance;
    private List<Contacts> contactsList;
    private Boolean logged;
}
