package com.poli.virtualwallet.collaborator;

import com.poli.virtualwallet.collection.Collaborator;
import com.poli.virtualwallet.dto.CollaboratorDTO;
import com.poli.virtualwallet.mapper.WalletMapper;
import com.poli.virtualwallet.repository.ICollaboratorRepository;
import com.poli.virtualwallet.usecase.collaborator.PutCollaboratorUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;

@SpringBootTest
class PutCollaboratorUseCaseTest {

private PutCollaboratorUseCase useCase;

    @Autowired
    private WalletMapper mapper;

    @Mock
    ICollaboratorRepository repository;

    @BeforeEach
    public void setUp() {
        useCase = new PutCollaboratorUseCase(repository, mapper);
    }
    @Test
    public void putCollaboratorTest(){
        Collaborator collaborator1 = new Collaborator();
        collaborator1.setName("Sher Maestre");
        collaborator1.setBalance(1000000.0);
        collaborator1.setEmail("sherilyn.99@gmail.com");
        collaborator1.setContactsList(new ArrayList<>());
        collaborator1.setLogged(true);

        CollaboratorDTO collaborator1DTO = new CollaboratorDTO();
        collaborator1DTO.setName("Sher Maestre");
        collaborator1DTO.setBalance(1000000.0);
        collaborator1DTO.setEmail("sherilyn.99@gmail.com");
        collaborator1DTO.setContactsList(new ArrayList<>());
        collaborator1DTO.setLogged(true);

        Mockito.when(repository.save(collaborator1)).thenReturn(Mono.just(collaborator1));

        Mono<CollaboratorDTO> mono = useCase.apply(collaborator1DTO);

        StepVerifier.create(mono)
                .expectNext(collaborator1DTO)
                .verifyComplete();

        Mockito.verify(repository).save(collaborator1);
    }
}