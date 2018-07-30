

package com.educacionit.java.rest.occupations.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.educacionit.java.rest.occupations.entity.Occupation;
import com.educacionit.java.rest.occupations.repository.IOccupationRepository;


@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE , classes = MongodbConfiguration.class)
public class MovieRepositoryTest {


    @Autowired
    private IOccupationRepository repository = null;

    private final Logger logger = LoggerFactory.getLogger (MovieRepositoryTest.class);


    public MovieRepositoryTest() {

        super ();
    }


    @Test
    public void testCreate () {

        Occupation o = new Occupation ();
        o.setName ("Programming");
        o.setDescription ("Software Programming");
        o.setEnabled (Boolean.TRUE);

        this.repository.save (o);
        logger.debug (o.toString ());
        assertNotNull ("Occupation is null !!!", o.getId ());
    }
}