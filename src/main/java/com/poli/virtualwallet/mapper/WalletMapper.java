package com.poli.virtualwallet.mapper;

import com.poli.virtualwallet.collection.Admin;
import com.poli.virtualwallet.collection.Collaborator;
import com.poli.virtualwallet.collection.Transactions;
import com.poli.virtualwallet.dto.AdminDTO;
import com.poli.virtualwallet.dto.TransactionsDTO;
import com.poli.virtualwallet.dto.CollaboratorDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
@RequiredArgsConstructor
public class WalletMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public AdminDTO toAdminDTO(Admin admin) {
        return modelMapper.map(admin, AdminDTO.class);
    }

    public Admin toAdminEntity(AdminDTO dto) {
        return modelMapper.map(dto, Admin.class);
    }

    public CollaboratorDTO toCollaboratorDTO(Collaborator colab) {
        return modelMapper.map(colab, CollaboratorDTO.class);
    }

    public Collaborator toCollaboratorEntity(CollaboratorDTO dto) {
        return modelMapper.map(dto, Collaborator.class);
    }

    public TransactionsDTO toTransactionsDTO(Transactions transac) {
        return modelMapper.map(transac, TransactionsDTO.class);
    }

    public Transactions toTransactionsEntity(TransactionsDTO dto) {
        return modelMapper.map(dto, Transactions.class);
    }
}
