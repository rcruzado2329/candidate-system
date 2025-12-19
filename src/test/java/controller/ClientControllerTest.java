package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.rcruzado.candidatesystem.CandidateSystemApplication;
import org.rcruzado.candidatesystem.controller.ClientController;
import org.rcruzado.candidatesystem.dto.ClientResponse;
import org.rcruzado.candidatesystem.dto.CreateClientRequest;
import org.rcruzado.candidatesystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ClientController.class)
@AutoConfigureMockMvc(addFilters = false)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateClient_Success_200() throws Exception {

        CreateClientRequest request = new CreateClientRequest(
                "Juan",
                "Perez",
                30,
                LocalDate.of(1994, 1, 10)
        );

        ClientResponse response = ClientResponse.builder()
                .id(1L)
                .name("Juan")
                .lastName("Perez")
                .age(30)
                .birthDate(LocalDate.of(1994, 1, 10))
                .estimatedLifeEventDate(LocalDate.of(2074, 1, 10))
                .build();

        when(clientService.create(any())).thenReturn(response);

        mockMvc.perform(post("/api/v1/clients")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Juan Perez"));
    }

    @Test
    void testCreateClient_ValidationError_422() throws Exception {

        CreateClientRequest request = new CreateClientRequest(
                "",
                "",
                -1,
                null
        );

        mockMvc.perform(post("/api/v1/clients")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testCreateClient_InternalError_500() throws Exception {

        CreateClientRequest request = new CreateClientRequest(
                "Error",
                "Test",
                40,
                LocalDate.of(1984, 5, 20)
        );

        when(clientService.create(any()))
                .thenThrow(new RuntimeException("DB error"));

        mockMvc.perform(post("/api/v1/clients")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isInternalServerError());
    }

}