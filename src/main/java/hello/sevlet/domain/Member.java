package hello.sevlet.domain;

public class Member {
    // 시스템에 저장될 때 등록되는 시스템이 지정해주는 id
    private Long id;
    // 회원가입할 때 적는 이름
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
