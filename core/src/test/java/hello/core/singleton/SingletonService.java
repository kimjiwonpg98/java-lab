package hello.core.singleton;

public class SingletonService {
    /* static 영역에 객체 딱 1개만 생성 */
    private static final SingletonService instance = new SingletonService();

    /* public으로 열어서 객체 인스턴스가 필요할 때 static 메서드를 통해서 조회 */
    public static SingletonService getInstance() {
        return instance;
    }

    /* 다른 곳에서 new 생성자로 만드는 것 방지 */
    private SingletonService() {}
}
