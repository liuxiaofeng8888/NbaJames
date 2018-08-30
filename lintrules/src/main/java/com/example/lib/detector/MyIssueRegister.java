package com.example.lib.detector;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;

import java.util.Arrays;
import java.util.List;

public class MyIssueRegister extends IssueRegistry {

    @Override
    public List<Issue> getIssues() {
        System.out.println("***************************************************");
        System.out.println("**************** lint 开始静态分析代码 *****************");
        System.out.println("***************************************************");

//        return null;
        return Arrays.asList(LogDetector.ISSUE);
    }
}
