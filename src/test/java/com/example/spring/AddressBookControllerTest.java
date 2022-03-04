package com.example.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressBookControllerTest{

    @Autowired
    private MockMvc mockMvc;

    /**
     * Check that getAddressBooks returns
     */
    @Test
    void getAddressBook() throws Exception{
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(content().string(containsString("Address Book")));
    }

    /**
     * Check that AddressBook returns a json object
     */
    @Test
    void getAddressBooks() throws Exception{
        this.mockMvc.perform(get("/AddressBook").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));
    }

    /**
     * Check that BuddyInfo returns a json object
     */
    @Test
    void getBuddies() throws Exception{
        this.mockMvc.perform(get("/BuddyInfo").contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));
    }

    /**
     * Check that AddressBook Post works
     */
    @Test
    void addAddressBook() throws Exception{
        this.mockMvc.perform(post("/AddressBook").contentType("application/json").content("{\"name\":\"test\"}"))
                .andExpect(status().isCreated());
    }

    /**
     * Check that BuddyInfo Post works
     */
    @Test
    void addBuddy() throws Exception{
        this.mockMvc.perform(post("/BuddyInfo").contentType("application/json").content("{\"addressBookId\":\"1\",\"name\":\"t\",\"phone\":\"2\"}"))
                .andExpect(status().isCreated());
    }
}

