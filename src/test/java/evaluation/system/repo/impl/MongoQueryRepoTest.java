/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluation.system.repo.impl;

import ir.ac.iust.dml.kg.evaluation.repo.impl.MongoQueryRepo;
import com.mongodb.MongoClient;
import ir.ac.iust.dml.kg.evaluation.model.Query;
import ir.ac.iust.dml.kg.evaluation.util.MongoConnection;
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
public class MongoQueryRepoTest {
    
    private MongoQueryRepo queryRepo;
    private MongoConnection connection;
    
    public MongoQueryRepoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        this.queryRepo = new MongoQueryRepo("parsijoo", "evaluation", "localhost", 27017);
                
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addQuery method, of class MongoQueryRepo.
     */
    @org.junit.Test
    public void testAddQuery() {
        System.out.println("addQuery");
        MongoQueryRepo instance = queryRepo;
        Query qu = new Query();
        qu.setId(1);
        qu.setQuery("new random");
        instance.addQuery(qu);
        
       
        
    }
    
    

    
}
