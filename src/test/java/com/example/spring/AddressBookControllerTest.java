package com.example.spring;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@SpringBootTest
@AutoConfigureMockMvc
class AddressBookControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAddressBook() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(content().string(containsString("Address Book")));
    }

    @Test
    void getAddressBooks() throws Exception {
        this.mockMvc.perform(get("/AddressBook").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));
    }

    @Test
    void getBuddies() throws Exception {
        this.mockMvc.perform(get("/BuddyInfo").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));
    }

    @Test
    void addAddressBook() throws Exception {
        this.mockMvc.perform(post("/AddressBook").contentType("application/json").content("{\"name\":\"test\"}"))
                .andExpect(status().isCreated());
    }

//    @Test
//    void addAddressBook() throws Exception {
//        this.mockMvc.perform(post("/AddressBook/new")
//                .requestAttr("name", "test"))
//                .andExpect(status().isOk());
//    }

}

