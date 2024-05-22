package com.aurosks.kpac;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-applicationContext.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
public class KpacDaoTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private KpacDao kpacDao;

    @Before
    public void setUp() {
        kpacDao = new KpacDao();
        kpacDao.setJdbcTemplate(jdbcTemplate);
    }

    @Test
    public void testGetAllKpacs() {
        List<Kpac> kpacs = kpacDao.getAllKpacs();
        assertNotNull(kpacs);
        assertEquals(3, kpacs.size());
    }

    @Test
    public void testAddKpac() {
        Kpac kpac = new Kpac();
        kpac.setTitle("K-PAC 3");
        kpac.setDescription("Description for K-PAC 3");
        kpac.setCreationDate("2023-03-01");

        kpacDao.addKpac(kpac);

        List<Kpac> kpacs = kpacDao.getAllKpacs();
        assertEquals(3, kpacs.size());
    }

    @Test
    public void testDeleteKpac() {
        kpacDao.deleteKpac(1L);

        List<Kpac> kpacs = kpacDao.getAllKpacs();
        assertEquals(2, kpacs.size());
    }
}
