import java.math.BigDecimal;
import java.util.Properties;
import java.util.Random;

/**
 * Created by shiyueqi on 2016/7/25.
 */
public class Test {
    public static void main(String[] args){

        String str = "Hello, world";
        int len = 1;
//        User user = new User();
//        user.setAge(11);
//        user.setName("sss");
//
//        User user2 = user;
//        user2.setAge(12);
//        user2.setName("abc");
//
//        System.out.println(user.toString());
//        System.out.println(user2.toString());
//
//        System.out.println(user.getRealName());

//        Properties properties = System.getProperties();
//        System.out.println(properties);
//
//        properties.setProperty("magpie_registry","172.18.63.74:2181,172.18.63.75:2181,172.18.63.110:2181");
//
//        System.out.println(properties.getProperty("magpie_registry"));
//
//        /**
//         * Double���ͳ˷�����׼��
//         */
//        Double amount = 323.40;
//        amount = amount * 100;
//        System.out.println(amount);
//        int payAmount = amount.intValue();
//        System.out.println(payAmount);
//
//
//
//        BigDecimal b1 = new BigDecimal(Double.toString(342.40));
//        BigDecimal b2 = new BigDecimal(Double.toString(100.00));
//        System.out.println(b1.multiply(b2).intValue());
//
//        Integer intA = 128;
//        Integer intB = 128;
//        System.out.println(intA == intB);
//
//        intA = 100;
//        intB = 100;
//        System.out.println(intA == intB);
//        assert (intA != intB);
//
//        User user = new User();
//        user.setAge(11);
//        user.setName("sss");
//
//        User user2 = new User();
//        user2 = user;
//
//        System.out.println(user.getAge()+ "||"+user.getName());
//
//        doFilter(user2);
//
//        System.out.println(user.getAge()+ "||"+user.getName());
//        System.out.println(user2.getAge()+ "||"+user2.getName());
//
//        Random random = new Random(100);
//        for(int i=0;i<10;i++){
//            System.out.println(random.nextInt(1000));
//        }
    }

    public int getRandomNum() {
        Random random = new Random(100);
        return random.nextInt(100);
    }

    public static User doFilter(User user){
        user.setAge(111);
        user.setName("afdasfda");

        return user;
    }

    static class User extends AbstarctUser implements Cloneable{
        private int age;

        private String name;

        private UserAdapter userAdapter = new UserAdapter();

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getRealName() {
            return userAdapter.getUserName();
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class UserAdapter {
        private User user = new User();

        public String getUserName() {
            String a = user.getC();
            return "adapter: " + user.getName();
        }
    }

    static abstract class AbstarctUser {
        protected String getC(){
            return "c";
        }
    }
}
