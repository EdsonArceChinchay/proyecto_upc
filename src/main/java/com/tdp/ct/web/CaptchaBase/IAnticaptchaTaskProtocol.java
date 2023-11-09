package com.tdp.ct.web.CaptchaBase;


import com.tdp.ct.web.ApiResponse.TaskResultResponse;
import org.json.JSONObject;

public interface IAnticaptchaTaskProtocol {
    JSONObject getPostData();

    TaskResultResponse.SolutionData getTaskSolution();
}
