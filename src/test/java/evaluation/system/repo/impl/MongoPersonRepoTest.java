/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluation.system.repo.impl;

import ir.ac.iust.dml.kg.evaluation.repo.impl.MongoPersonRepo;
import ir.ac.iust.dml.kg.evaluation.model.Person;
import ir.ac.iust.dml.kg.evaluation.repo.PersonRepo;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raziyeh
 */
public class MongoPersonRepoTest {
    
    private MongoPersonRepo personRepo;
    
    
    public MongoPersonRepoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.personRepo = new MongoPersonRepo("parsijoo", "evaluation", "localhost", 27017);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addPeson method, of class MongoPersonRepo.
     */
    @Test
    public void testAddPeson() {
        System.out.println("addPeson");
        MongoPersonRepo instance = personRepo;
        ArrayList<Person> personList = (ArrayList<Person>) instance.getAllPerson();
        System.out.println("hellp");
        
       
    }

  
}
