package com.example.lib.detector;

import com.android.tools.lint.client.api.JavaParser;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import java.util.Collections;
import java.util.List;

import lombok.ast.AstVisitor;
import lombok.ast.ForwardingAstVisitor;
import lombok.ast.MethodInvocation;
import lombok.ast.Node;

public class LogDetector extends Detector implements Detector.JavaScanner {

    public static final Issue ISSUE = Issue.create("LogUse", "LittlePudding大爷说不要用Log/System.out.println"
            , "应该使用工具类LogUtils", MyCategory.MY_CATEGORY, 5, Severity.ERROR,
            new Implementation(LogDetector.class, Scope.JAVA_FILE_SCOPE));

    @Override
    public List<Class<? extends Node>> getApplicableNodeTypes() {
//        return super.getApplicableNodeTypes();
        return Collections.<Class<? extends Node>>singletonList(MethodInvocation.class);
    }

    @Override
    public AstVisitor createJavaVisitor(JavaContext context) {
//        return super.createJavaVisitor(context);
        return new ForwardingAstVisitor() {
            @Override
            public boolean visitMethodInvocation(MethodInvocation node) {
                if (node.toString().startsWith("System.out.println")){
                    context.report(ISSUE,node,context.getLocation(node),"请使用logUtils，避免使用System.out.println");
                    return true;
                }

                JavaParser.ResolvedNode resolvedNode = context.resolve(node);
                if (resolvedNode instanceof JavaParser.ResolvedNode){
                    JavaParser.ResolvedMethod method = (JavaParser.ResolvedMethod) resolvedNode;
                    //方法所在的类校验
                    JavaParser.ResolvedClass resolvedClass = method.getContainingClass();
                    if (resolvedClass.matches("android.util.Log")){
                        context.report(ISSUE,node,context.getLocation(node),"请使用logUtils，避免使用Log");
                        return true;
                    }
                }
                return super.visitMethodInvocation(node);
            }
        };
    }
}
