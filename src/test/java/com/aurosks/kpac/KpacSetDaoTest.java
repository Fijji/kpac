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
public class KpacSetDaoTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private KpacSetDao kpacSetDao;

    @Before
    public void setUp() {
        kpacSetDao = new KpacSetDao();
        kpacSetDao.setJdbcTemplate(jdbcTemplate);
    }

    @Test
    public void testGetAllKpacSets() {
        List<KpacSet> kpacSets = kpacSetDao.getAllKpacSets();
        assertNotNull(kpacSets);
        assertEquals(2, kpacSets.size());
    }

    @Test
    public void testAddKpacSet() {
        KpacSet kpacSet = new KpacSet();
        kpacSet.setTitle("Set 3");

        kpacSetDao.addKpacSet(kpacSet);

        List<KpacSet> kpacSets = kpacSetDao.getAllKpacSets();
        assertEquals(3, kpacSets.size());
    }

    @Test
    public void testDeleteKpacSet() {
        kpacSetDao.deleteKpacSet(1L);

        List<KpacSet> kpacSets = kpacSetDao.getAllKpacSets();
        assertEquals(2, kpacSets.size());
    }
}

