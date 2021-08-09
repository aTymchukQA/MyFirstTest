public class User {

    private String name;
    private Integer age;
    private Boolean isRegistered;

    public Boolean getRegistered() {
        return isRegistered;
    }

    public User(String name, Integer age, Boolean isRegistered) {
        this.name = name;
        this.age = age;
        this.isRegistered = isRegistered;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
