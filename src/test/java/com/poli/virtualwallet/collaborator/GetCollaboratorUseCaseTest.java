package com.poli.virtualwallet.collaborator;

import com.poli.virtualwallet.collection.Collaborator;
import com.poli.virtualwallet.dto.CollaboratorDTO;
import com.poli.virtualwallet.mapper.WalletMapper;
import com.poli.virtualwallet.repository.ICollaboratorRepository;
import com.poli.virtualwallet.usecase.collaborator.GetCollaboratorUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;



@SpringBootTest
class GetCollaboratorUseCaseTest {

    private GetCollaboratorUseCase useCase;

    @Autowired
    private WalletMapper mapper;

    @Mock
    ICollaboratorRepository repository;

    @BeforeEach
    public void setUp() {
        useCase = new GetCollaboratorUseCase(repository, mapper);
    }

    @Test
    public void getCollaboratorTest(){

        Collaborator collaborator1 = new Collaborator();
        Collaborator collaborator2 = new Collaborator();
        Collaborator collaborator3 = new Collaborator();

        collaborator1.setName("Sher Maestre");
        collaborator1.setBalance(1000000.0);
        collaborator1.setEmail("sherilyn.99@gmail.com");
        collaborator1.setContactsList(new ArrayList<>());
        collaborator1.setLogged(true);

        collaborator2.setName("Santi Gomez");
        collaborator2.setBalance(2000000.0);
        collaborator2.setEmail("santi@gmail.com");
        collaborator2.setContactsList(new ArrayList<>());
        collaborator2.setLogged(false);

        collaborator3.setName("Luis Lopez");
        collaborator3.setBalance(3000000.0);
        collaborator3.setEmail("luislopez@gmail.com");
        collaborator3.setContactsList(new ArrayList<>());
        collaborator3.setLogged(true);

        Mockito.when(repository.findAll()).thenReturn(Flux.just(collaborator1, collaborator2, collaborator3));
        Flux<CollaboratorDTO> flux = useCase.apply();

        StepVerifier.create(flux).expectNextCount(3).verifyComplete();

        Mockito.verify(repository).findAll();

    }
}