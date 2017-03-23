package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ���׿���һ���ӵĴ��£�����ǰҪ׼��һ�£�����˧��Щ��
 *
 * @author zhengt
 * @time Jun 3, 2095 3:15:48 PM
 */
public class ReadyInvocationHandler implements InvocationHandler {
    //���׽ӿڵ�ʵ���࣬Ҳ��������������
    private Object zhangSan = null;

    public ReadyInvocationHandler(Object realSubject) {
        this.zhangSan = realSubject;
    }

    public Object invoke(Object proxy, Method m, Object[] args) {
        Object result = null;
        try {
            /**
             * ��̬������$Proxy0����xiangQin����ʱ��������Լ���xiangQin������
             * �����Լ���xiangQin����������õ���super.h.invoke(this, , )��Ҳ���Ǹ���Proxy��h��invoke������
             * Ҳ����ReadyInvocationHandler���invoke������
             * ���ԣ�invoke(Object proxy, Method m, Object[] args)�ֵ�proxyʵ���Ͼ��Ƕ�̬������$Proxy0��
             * ����㽫��ǿת��XiangQinInterfaceȻ���������xiangQin������Ȼ�����ͻ����super.h.invoke(this, , )�������ͻ���ѭ����
             */
            /**
             * ���Ϲ�����������������Object proxy��������������ʲô�أ������Ҳ��֪����
             * ������������֪���������Ǹ�ʲô������������ʲô����Ͳ��ö�֪��
             */
            System.out.println(proxy.getClass().getSimpleName());
            System.out.println("zhangsan dressed.");
            result = m.invoke(zhangSan, args);
        } catch (Exception ex) {
            System.exit(1);
        }
        return result;
    }
}
