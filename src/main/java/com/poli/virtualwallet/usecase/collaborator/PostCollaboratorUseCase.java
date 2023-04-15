package com.poli.virtualwallet.usecase.collaborator;

import com.poli.virtualwallet.repository.ICollaboratorRepository;
import com.poli.virtualwallet.dto.CollaboratorDTO;
import com.poli.virtualwallet.mapper.WalletMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class PostCollaboratorUseCase {
    private ICollaboratorRepository iCollaboratorRepository;
    private WalletMapper walletMapper;

    public PostCollaboratorUseCase(ICollaboratorRepository iCollaboratorRepository, WalletMapper walletMapper) {
        this.iCollaboratorRepository = iCollaboratorRepository;
        this.walletMapper = walletMapper;
    }

    public Mono<CollaboratorDTO> apply(CollaboratorDTO dto){
        return iCollaboratorRepository
                .save(walletMapper.toCollaboratorEntity(dto))
                .map(walletMapper::toCollaboratorDTO);}
}
