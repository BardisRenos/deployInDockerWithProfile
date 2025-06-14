package com.example.demo.application.service;

import com.example.demo.application.dao.ClientRepository;
import com.example.demo.application.dto.ClientDTO;
import com.example.demo.application.mapper.ClientMapper;
import com.example.demo.application.resource.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Timeout(10)
public class ClientServiceBaseRockGeneratedTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clientService = new ClientService(clientRepository, clientMapper);
    }

    @Test
    public void testGetAllClientsReturnsListOfClientDTOs() {
        // Arrange
        Client client1 = mock(Client.class);
        Client client2 = mock(Client.class);
        List<Client> clients = Arrays.asList(client1, client2);
        ClientDTO clientDTO1 = mock(ClientDTO.class);
        ClientDTO clientDTO2 = mock(ClientDTO.class);
        List<ClientDTO> expectedClientDTOs = Arrays.asList(clientDTO1, clientDTO2);
        doReturn(clients).when(clientRepository).findAll();
        doReturn(expectedClientDTOs).when(clientMapper).toDtoList(anyList());
        // Act
        List<ClientDTO> result = clientService.getAllClients();
        // Assert
        assertThat(result, is(notNullValue()));
        assertThat(result, hasSize(2));
        assertThat(result, is(equalTo(expectedClientDTOs)));
        verify(clientRepository, atLeast(1)).findAll();
        verify(clientMapper, atLeast(1)).toDtoList(clients);
    }

    @Test
    public void testGetAllClientsWithEmptyList() {
        // Arrange
        List<Client> emptyClients = new ArrayList<>();
        List<ClientDTO> emptyClientDTOs = new ArrayList<>();
        doReturn(emptyClients).when(clientRepository).findAll();
        doReturn(emptyClientDTOs).when(clientMapper).toDtoList(anyList());
        // Act
        List<ClientDTO> result = clientService.getAllClients();
        // Assert
        assertThat(result, is(notNullValue()));
        assertThat(result, hasSize(0));
        verify(clientRepository, atLeast(1)).findAll();
        verify(clientMapper, atLeast(1)).toDtoList(emptyClients);
    }

    @Test
    public void testGetClientByIdReturnsClientDTO() {
        // Arrange
        Long clientId = 1L;
        Client client = mock(Client.class);
        ClientDTO expectedClientDTO = mock(ClientDTO.class);
        doReturn(Optional.of(client)).when(clientRepository).findById(anyLong());
        doReturn(expectedClientDTO).when(clientMapper).toDto(any(Client.class));
        // Act
        ClientDTO result = clientService.getClientById(clientId);
        // Assert
        assertThat(result, is(notNullValue()));
        assertThat(result, is(equalTo(expectedClientDTO)));
        verify(clientRepository, atLeast(1)).findById(clientId);
        verify(clientMapper, atLeast(1)).toDto(client);
    }

    @Test
    public void testGetClientByIdThrowsRuntimeExceptionWhenClientNotFound() {
        // Arrange
        Long clientId = 999L;
        doReturn(Optional.empty()).when(clientRepository).findById(anyLong());
        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clientService.getClientById(clientId);
        });
        assertThat(exception.getMessage(), is(equalTo("Client not found with id " + clientId)));
        verify(clientRepository, atLeast(1)).findById(clientId);
    }

    @Test
    public void testGetClientsByNameReturnsListOfClientDTOs() {
        // Arrange
        String clientName = "John Doe";
        Client client1 = mock(Client.class);
        Client client2 = mock(Client.class);
        List<Client> clients = Arrays.asList(client1, client2);
        ClientDTO clientDTO1 = mock(ClientDTO.class);
        ClientDTO clientDTO2 = mock(ClientDTO.class);
        List<ClientDTO> expectedClientDTOs = Arrays.asList(clientDTO1, clientDTO2);
        doReturn(clients).when(clientRepository).findByName(anyString());
        doReturn(expectedClientDTOs).when(clientMapper).toDtoList(anyList());
        // Act
        List<ClientDTO> result = clientService.getClientsByName(clientName);
        // Assert
        assertThat(result, is(notNullValue()));
        assertThat(result, hasSize(2));
        assertThat(result, is(equalTo(expectedClientDTOs)));
        verify(clientRepository, atLeast(1)).findByName(clientName);
        verify(clientMapper, atLeast(1)).toDtoList(clients);
    }

    @Test
    public void testGetClientsByNameWithEmptyResult() {
        // Arrange
        String clientName = "NonExistent";
        List<Client> emptyClients = new ArrayList<>();
        List<ClientDTO> emptyClientDTOs = new ArrayList<>();
        doReturn(emptyClients).when(clientRepository).findByName(anyString());
        doReturn(emptyClientDTOs).when(clientMapper).toDtoList(anyList());
        // Act
        List<ClientDTO> result = clientService.getClientsByName(clientName);
        // Assert
        assertThat(result, is(notNullValue()));
        assertThat(result, hasSize(0));
        verify(clientRepository, atLeast(1)).findByName(clientName);
        verify(clientMapper, atLeast(1)).toDtoList(emptyClients);
    }

    @Test
    public void testGetClientsByNameWithNullName() {
        // Arrange
        String nullName = null;
        List<Client> clients = new ArrayList<>();
        List<ClientDTO> clientDTOs = new ArrayList<>();
        doReturn(clients).when(clientRepository).findByName(any());
        doReturn(clientDTOs).when(clientMapper).toDtoList(anyList());
        // Act
        List<ClientDTO> result = clientService.getClientsByName(nullName);
        // Assert
        assertThat(result, is(notNullValue()));
        assertThat(result, hasSize(0));
        verify(clientRepository, atLeast(1)).findByName(nullName);
        verify(clientMapper, atLeast(1)).toDtoList(clients);
    }

    @Test
    public void testClientServiceInstantiation() {
        // Act
        ClientService service = new ClientService(clientRepository, clientMapper);
        // Assert
        assertThat(service, is(notNullValue()));
    }
}
