package com.unionpay.test.stone.designpattern;

public class BuilderPattern {

	public BuilderPattern() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		User.Builder builder = new User.Builder();
		User user = builder.setName("stone").setAge(26).setAddress("address").build();
		
		User.Builder builder2 = new User.Builder();
		User user2 = builder2.setName("stone2").setAge(25).setAddress("address2").build();
		
		System.out.println(user.toString());
		System.out.println(user2.toString());
	}

}

class User {

    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
    
    @Override
    public String toString() {
		return "user: [name: " + name + ", age: " + age + ", address: " + address + "]";    	
    }

    public static class Builder {
        private User user = new User();

        public Builder setName(String name) {
            user.name = name;
            return this;
        }

        public Builder setAge(int age) {
            user.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            user.address = address;
            return this;
        }

        public User build() {
            return user;
        }
    }
}
