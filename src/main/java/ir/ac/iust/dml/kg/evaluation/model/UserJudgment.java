/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.iust.dml.kg.evaluation.model;

/**
 *
 * @author r.farjamfard
 */
public class UserJudgment {
    
    private String answerUri;
    private Boolean relevant;

    public String getAnswerUri() {
        return answerUri;
    }

    public void setAnswerUri(String answerUri) {
        this.answerUri = answerUri;
    }

    public Boolean isRelevant() {
        return relevant;
    }

    public void setRelevant(Boolean relevant) {
        this.relevant = relevant;
    }
    
    
    
}
