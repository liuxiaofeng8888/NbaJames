package com.example.lib.detector;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import java.util.List;

import lombok.ast.AstVisitor;
import lombok.ast.Node;

public class LogDetector extends Detector implements Detector.JavaScanner {

    public static final Issue ISSUE = Issue.create("LogUse", "避免使用Log/System.out.println"
            , "使用工具类LogUtils", Category.SECURITY, 5, Severity.ERROR,
            new Implementation(LogDetector.class, Scope.JAVA_FILE_SCOPE));

    @Override
    public List<Class<? extends Node>> getApplicableNodeTypes() {
        return super.getApplicableNodeTypes();
    }

    @Override
    public AstVisitor createJavaVisitor(JavaContext context) {
        return super.createJavaVisitor(context);
    }
}
