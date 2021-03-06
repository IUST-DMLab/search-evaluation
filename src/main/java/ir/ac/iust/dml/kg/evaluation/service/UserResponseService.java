/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.iust.dml.kg.evaluation.service;

import ir.ac.iust.dml.kg.evaluation.model.UserResponse;
import java.util.List;

/**
 *
 * @author r.farjamfard
 */
public interface UserResponseService {

    void saveUserResponse(UserResponse userResponse);

    List<UserResponse> getUserResponseByPersonId(String personId);

    List<UserResponse> getUserResponseByQuery(String query);

    List<UserResponse> getJudgedUserResponseByQuery(String query);

    void deleteUserResponseByQuery(String query);

}
