package com.poli.virtualwallet.usecase.collaborator;

import com.poli.virtualwallet.repository.ICollaboratorRepository;
import com.poli.virtualwallet.dto.CollaboratorDTO;
import com.poli.virtualwallet.mapper.WalletMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetCollaboratorUseCase {
    private ICollaboratorRepository iCollaboratorRepository;
    private WalletMapper walletMapper;

    public GetCollaboratorUseCase(ICollaboratorRepository iCollaboratorRepository, WalletMapper walletMapper) {
        this.iCollaboratorRepository = iCollaboratorRepository;
        this.walletMapper = walletMapper;
    }

    public Flux<CollaboratorDTO> apply(){return iCollaboratorRepository.findAll().map(walletMapper::toCollaboratorDTO);}
}
