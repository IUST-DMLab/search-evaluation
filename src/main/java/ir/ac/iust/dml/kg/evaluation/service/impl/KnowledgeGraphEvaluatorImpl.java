/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.iust.dml.kg.evaluation.service.impl;

import ir.ac.iust.dml.kg.evaluation.model.KnowledgeGraphResponse;
import ir.ac.iust.dml.kg.evaluation.model.UserJudgment;
import ir.ac.iust.dml.kg.evaluation.model.UserResponse;
import ir.ac.iust.dml.kg.evaluation.service.KnowledgeGraphEvaluator;
import ir.ac.iust.dml.kg.evaluation.service.UserResponseService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author r.farjamfard
 */
public class KnowledgeGraphEvaluatorImpl implements KnowledgeGraphEvaluator {

    private final UserResponseService userResponseService;

    public KnowledgeGraphEvaluatorImpl(UserResponseService userResponseService) {
        this.userResponseService = userResponseService;
    }

    @Override
    public float calculatePrecision(List<KnowledgeGraphResponse> knowledgeGraphResponses) {
        List<Float> allPrecisions = new ArrayList<>();
        for (KnowledgeGraphResponse kgResponse : knowledgeGraphResponses) {
            List<UserResponse> userResponses = this.userResponseService.getUserResponseByQuery(kgResponse.getQuery());
            int totalCount = kgResponse.getUriList().size();
            int truePositiveCounts = caculateTruePositiveCounts(userResponses, kgResponse.getUriList());
            float precision = (float) truePositiveCounts / (float) totalCount;
            allPrecisions.add(precision);
        }
        float totalPrecision = calculateAverage(allPrecisions);
        return totalPrecision;
    }

    private int caculateTruePositiveCounts(List<UserResponse> userResponses, List<String> kgUriList) {

        int truePositiveAnswers = 0;
        for (UserResponse userResponse : userResponses) {
            List<UserJudgment> judgmentList = userResponse.getJudgmentList();
            if (!kgUriList.isEmpty()) {
                for(String uri : kgUriList){  
                    Boolean flag = false;
                    for(UserJudgment judgment : judgmentList) {
                        if (uri.equalsIgnoreCase(judgment.getAnswer()) && judgment.isRelevant()) {
                            boolean isRemoved = kgUriList.remove(uri);
                            truePositiveAnswers++;
                            flag = true;
                        }
                    }

                }//
            }
        }

        return truePositiveAnswers;
    }

    private float calculateAverage(List<Float> items) {
        Float sum = 0f;
        for (Float item : items) {
            sum = sum + item;
        }
        return sum / items.size();
    }

    /*private int caculateTotalPositiveCount(List<UserResponse> userResponses) {

        return 0;
    }*/
    @Override
    public float calculatePrecisionAtK(List<KnowledgeGraphResponse> knowledgeGraphResponses, int k) {
        if (k <= 1) {
            k = 1;
        }
        for (KnowledgeGraphResponse kgResponse : knowledgeGraphResponses) {
            if (kgResponse.getUriList() != null) {
                kgResponse.setUriList(kgResponse.getUriList().subList(0, k - 1));
            }
        }

        return this.calculatePrecision(knowledgeGraphResponses);
    }

}
