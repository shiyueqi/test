package reflect;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * Created by shiyueqi on 2016/8/9.
 */

/**
 * ��������ʵ����
 *
 * @author zhengt
 * @time Jun 3, 2095 3:14:48 PM
 */
public class ProxyTest implements XiangQinInterface {
    public void xiangQin() {
        System.out.println("zhangsan go to xiangqin.");
    }

    public static void main(String args[]) {
        //�Ƚ���������������׵�ʵ����ʵ������Ҳ���ǵõ�XiangQinInterface�ӿڵ�һ��ʵ������
        XiangQinInterface zhangSan = new ProxyTest();
        /**
         * �õ�ZhangSanXiangQinInterfaceImpl������һ�������࣬ͬʱΪ���������һ��������ReadyInvocationHandler��
         * ���ź��ƿڣ���ʵ����ÿ�ε���ZhangSanXiangQinInterfaceImpl��������xiangQin����ʱ��
         * ����zhangSan���ZhangSanXiangQinInterfaceImpl���ʵ��ȥ���ã�
         * �������ZhangSanXiangQinInterfaceImpl�Ĵ�����ReadyInvocationHandlerȥ�������Լ���invoke����,
         * ���invoke�������ؿ��Ե���zhangSan���ʵ����xiangQin����
         */
        /**
         * ��java������ʵ�ֶ�̬������
         * ��һ��������Ҫ��һ���ӿڣ���Ҫ��һ���ӿڵ�ʵ���࣬�����ʵ�����ؾ�������Ҫ����Ķ���
         * ��ν������Ҳ�����ڵ���ʵ����ķ���ʱ�������ڷ���ִ��ǰ��������Ĺ�����������Ǵ���
         * �ڶ���������Ҫ�Լ�дһ����Ҫ������ķ���ִ��ʱ���ܹ������⹤�����࣬����������̳�InvocationHandler�ӿڣ�
         * ΪʲôҪ�̳����أ���Ϊ�������ʵ���ڵ���ʵ����ķ�����ʱ�򣬲����������ʵ��������������
         * ����ת������������invoke�������̳�ʱ����ʵ�ֵķ����������������������Ե���������ʵ��������������
         * ����������Ҫ�ô������ʵ��ȥ����ʵ����ķ�����ʱ��д���������δ��롣
         */
        XiangQinInterface proxy = (XiangQinInterface) Proxy.newProxyInstance(
                zhangSan.getClass().getClassLoader(),
                zhangSan.getClass().getInterfaces(),
                new ReadyInvocationHandler(zhangSan));
        proxy.xiangQin();
        /**
         * ����Ҫ�������в��Ƕγ����Ĵ������˼���Լ�����������Щ������
         * ��һ������zhangSan.getClass().getClassLoader()���Ҫ����������������
         * zhangSan.getClass().getInterfaces()Ҫ��������ʵ�ֵ����еĽӿ�
         * ��Ϊ��������Proxy.getProxyClass(ClassLoader loader, Class<?>... interfaces)
         * �ķ������ش������java.lang.Class����Ҳ���ǵõ���java��̬���ɵĴ�����$Proxy0��Class����
         * ͬʱ��java���������̬���ɵ�$Proxy0��ʵ����Ҫ�������ʵ�ֵ����нӿڣ����̳���Proxy�ӿڡ�
         * �ڶ���ʵ���������̬���ɵ�$Proxy0���һ��ʵ����ʵ����������Ĺ��캯��ΪProxy(InvocationHandler h)��
         * Ҳ����˵Ҫʵ���������̬���ɵ�$Proxy0�࣬�������һ��InvocationHandler������Ҳ���������Լ�ʵ�ֵ������ڴ�����
         * ����ִ��ǰ�������⹤������ReadyInvocationHandler��
         * ��δ���Proxy.newProxyInstance(zhangSan.getClass().getClassLoader(),zhangSan.getClass().getInterfaces(),new ReadyInvocationHandler(zhangSan))
         * �õ�����ʵ��һ��������$Proxy0 extends Proxy implements XiangQinInterface���ࡣ
         * �����������$Proxy0��ǿ��ת�ͳ�XiangQinInterface���ͣ�����xiangQin������
         */
    }
}



