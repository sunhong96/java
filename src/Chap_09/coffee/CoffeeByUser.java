package Chap_09.coffee;

import Chap_09.User.User;

public class CoffeeByUser <T extends User>//어떤타입이든 상관없는데 User를 상속하는 클래스만 사용가능
{
    public T user;

    public CoffeeByUser(T user) {
        this.user = user;
    }
    public void ready(){
        System.out.println("커피 준비 완료 : " + user.name);
        user.addPoint();
    }
}
