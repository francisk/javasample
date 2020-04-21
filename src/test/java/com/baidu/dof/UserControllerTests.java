package com.baidu.dof.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.baidu.dof.controller.UserController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests extends AbstractTestClass {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webContext;

    @Before
    public void setUp() throws Exception{
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webContext).build();
        Class.forName(this.dbDriver);
        try (Connection conn = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPassword);
             Statement statement = conn.createStatement()) {
            statement.execute(this.insertUser);
        } catch (Exception e) {
            // throw exception
        }
    }
    @After
    public void tearDown() throws Exception{
        Class.forName(this.dbDriver);
        try (Connection conn = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPassword);
             Statement statement = conn.createStatement()) {
            statement.execute("Delete from users");
        } catch (Exception e) {
            // throw exception
        }
    }

    @Test
    public void TestGetAllUsers() throws Exception{
        MvcResult result = mockMvc.perform(get("/user/all"))
        .andExpect(status().isOk())
        .andReturn();
    }

    @Test
    public void TestGetSpecificUser() throws Exception{
    }
}