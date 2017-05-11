/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.iust.dml.kg.evaluation.repo.impl;

import ir.ac.iust.dml.kg.evaluation.model.Person;
import ir.ac.iust.dml.kg.evaluation.model.Query;
import ir.ac.iust.dml.kg.evaluation.model.UserAnswerStatus;
import ir.ac.iust.dml.kg.evaluation.model.UserJudgment;
import ir.ac.iust.dml.kg.evaluation.model.UserResponse;
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
public class MongoUserResponseRepoTest {
    
    private MongoUserResponseRepo userResponseRepo;
    private MongoPersonRepo personRepo;
    
    public MongoUserResponseRepoTest() {
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
        this.userResponseRepo = new MongoUserResponseRepo("parsijoo", "evaluation", personRepo, "localhost", 27017);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUserResponse method, of class MongoUserResponseRepo.
     */
    @Test
    public void testAddUserResponse() {
        System.out.println("addUserResponse");
        UserResponse userResponse = new UserResponse();
        Person person = new Person();
        person.setId(4);
        person.setName("raziyeh");
        userResponse.setPerson(person);;
        List<UserJudgment> judgment = new ArrayList<>();
        UserJudgment userJ = new UserJudgment();
        userJ.setAnswerUri("wiki://lili");
        userJ.setRelevant(Boolean.TRUE);
        UserJudgment userJu = new UserJudgment();
        userJu.setAnswerUri("uri-1");
        userJu.setRelevant(Boolean.FALSE);
        Query q = new  Query();
        q.setId(1);
        q.setQuery("whitehouse");
        judgment.add(userJ);
        judgment.add(userJu);
        userResponse.setJudgmentList(judgment);
        userResponse.setQuery(q);
        UserAnswerStatus status = new UserAnswerStatus();
        status.setAbleToAnswer(Boolean.TRUE);
        status.setReson(null);
        userResponse.setStatus(status);
        MongoUserResponseRepo instance = userResponseRepo;
       // instance.addUserResponse(userResponse);
        //UserResponse list = instance.getUserResponseByPersonQuery("new random",4);
        instance.addUserResponse(userResponse);
        userResponse.getStatus().setAbleToAnswer(Boolean.FALSE);;
        instance.updateUserResponse(userResponse);
        System.out.println("jey");
        // TODO review the generated test code and remove the default call to fail.
  
    }

   
    
}
