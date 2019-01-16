package com.hillel.test;

import com.hillel.test.dao.ServerDao;
import com.hillel.test.model.Server;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TestApplicationTests {

	@Autowired
	ServerDao serverDao;

	/*@Autowired
	ServersService serversService;*/

	@After
	public void clean() {
		serverDao.deleteAll();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testDeleteAll() {
		Server server = new Server();
		server.setName("test1");
		server.setDescription("test1");
		serverDao.save(server);
		serverDao.deleteAll();
		List<Server> all = (List<Server>) serverDao.findAll();
		assertTrue(all.size()==0);
	}


	@Test
	public void testInsertServer() {
		Server server = new Server();
		server.setName("test");
		server.setDescription("test");

		serverDao.save(server);
		Server found = serverDao.findByName(server.getName());

		assertEquals(found,server);
	}

	@Test
	public void testXFindAll() {
		List<Server> list = (List<Server>) serverDao.findAll();
		assertTrue(list.size() == 0);
	}

}
