package com.hillel.test.service;

import com.hillel.test.dao.ServerDao;
import com.hillel.test.model.Server;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;

/**
 * Created by eugen on 12/8/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServersServiceTest {

    @Autowired
    ServersService serversService;

    @MockBean
    ServerDao serverDao;

    @Test
    public void shouldFindAllServers() {
        when(serverDao.findAll()).thenReturn(Arrays.asList(new Server()));
        System.out.println(serversService.findAllServers());
    }
}
