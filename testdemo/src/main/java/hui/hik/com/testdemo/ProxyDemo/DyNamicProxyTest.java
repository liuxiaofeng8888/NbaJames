package hui.hik.com.testdemo.ProxyDemo;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author littlepudding
 * @date 2019-4-29
 * @description 动态代理
 */
public class DyNamicProxyTest {
    interface IHello{
        void sayHello();
    }

    static class Hello implements IHello{

        @Override
        public void sayHello() {
            Log.e("tag", "Hello Word");
        }
    }

    static class DynamicProxy implements InvocationHandler{
        Object originalObj;
        Object bind(Object originalObj){
            this.originalObj = originalObj;
            Log.e("classloader1", "bind: "+originalObj.getClass().getClassLoader().getParent() );
            Log.e("classloader2", "bind: "+originalObj.getClass().getInterfaces().getClass().getClassLoader() );
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),originalObj.getClass().getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Log.e("tag", "welcome" );
            return method.invoke(originalObj,args);
        }
    }

    public static void main(){
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
    }
}
