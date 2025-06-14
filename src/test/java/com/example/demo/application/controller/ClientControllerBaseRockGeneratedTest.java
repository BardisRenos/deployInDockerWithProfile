package com.example.demo.application.controller;

import com.example.demo.application.dto.ClientDTO;
import com.example.demo.application.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;

@Timeout(10)
public class ClientControllerBaseRockGeneratedTest {

    @Mock
    private ClientService clientService;

    private ClientController clientController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clientController = spy(new ClientController(clientService));
    }

    @Test
    public void testGetAllClientsReturnsListOfClients() {
        ClientDTO client1 = new ClientDTO();
        ClientDTO client2 = new ClientDTO();

        List<ClientDTO> expectedClients = Arrays.asList(client1, client2);
        doReturn(expectedClients).when(clientService).getAllClients();

        List<ClientDTO> result = clientController.getAllClients();

        assertThat(result, notNullValue());
        assertThat(result, hasSize(2));
        assertThat(result, equalTo(expectedClients));
        verify(clientService, atLeast(1)).getAllClients();
    }

    @Test
    public void testGetAllClientsReturnsEmptyList() {
        List<ClientDTO> expectedClients = Collections.emptyList();
        doReturn(expectedClients).when(clientService).getAllClients();

        List<ClientDTO> result = clientController.getAllClients();

        assertThat(result, notNullValue());
        assertThat(result, hasSize(0));
        assertThat(result, equalTo(expectedClients));
        verify(clientService, atLeast(1)).getAllClients();
    }

    @Test
    public void testGetClientByIdReturnsClient() {
        Long clientId = 1L;
        ClientDTO expectedClient = new ClientDTO();

        doReturn(expectedClient).when(clientService).getClientById(clientId);

        ClientDTO result = clientController.getClientById(clientId);

        assertThat(result, notNullValue());
        assertThat(result, equalTo(expectedClient));
        verify(clientService, atLeast(1)).getClientById(clientId);
    }

    @Test
    public void testGetClientByIdWithDifferentId() {
        Long clientId = 999L;
        ClientDTO expectedClient = new ClientDTO();

        doReturn(expectedClient).when(clientService).getClientById(clientId);

        ClientDTO result = clientController.getClientById(clientId);

        assertThat(result, notNullValue());
        assertThat(result, equalTo(expectedClient));
        verify(clientService, atLeast(1)).getClientById(clientId);
    }

    @Test
    public void testGetClientsByNameReturnsMatchingClients() {
        String clientName = "John";
        ClientDTO client1 = new ClientDTO();
        ClientDTO client2 = new ClientDTO();

        List<ClientDTO> expectedClients = Arrays.asList(client1, client2);
        doReturn(expectedClients).when(clientService).getClientsByName(clientName);

        List<ClientDTO> result = clientController.getClientsByName(clientName);

        assertThat(result, notNullValue());
        assertThat(result, hasSize(2));
        assertThat(result, equalTo(expectedClients));
        verify(clientService, atLeast(1)).getClientsByName(clientName);
    }

    @Test
    public void testGetClientsByNameReturnsEmptyListWhenNoMatches() {
        String clientName = "NonExistent";
        List<ClientDTO> expectedClients = Collections.emptyList();

        doReturn(expectedClients).when(clientService).getClientsByName(clientName);
        List<ClientDTO> result = clientController.getClientsByName(clientName);

        assertThat(result, notNullValue());
        assertThat(result, hasSize(0));
        assertThat(result, equalTo(expectedClients));
        verify(clientService, atLeast(1)).getClientsByName(clientName);
    }

    @Test
    public void testGetClientsByNameWithDifferentName() {
        String clientName = "Alice";
        ClientDTO client = new ClientDTO();
        List<ClientDTO> expectedClients = Arrays.asList(client);

        doReturn(expectedClients).when(clientService).getClientsByName(clientName);
        List<ClientDTO> result = clientController.getClientsByName(clientName);

        assertThat(result, notNullValue());
        assertThat(result, hasSize(1));
        assertThat(result, equalTo(expectedClients));
        verify(clientService, atLeast(1)).getClientsByName(clientName);
    }

    @Test
    public void testControllerInstantiation() {
        ClientController controller = new ClientController(clientService);
        assertThat(controller, notNullValue());
    }
}
