package com.kuang.demo01;

//中介
public class Proxy implements Rent{

    Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHost();
        sign();
        fee();
        host.rent();
    }

    //看房
    public void seeHost() {
        System.out.println("看房");
    }

    //收费
    public void fee() {
        System.out.println("收费");
    }

    //签合同
    public void sign() {
        System.out.println("签合同");
    }
}
