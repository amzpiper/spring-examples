package com.kuang.demo01;

public class Client {
    public static void main(String[] args) {
        //房东要出租房屋
        Host host = new Host();

        //代理，中介帮助房东出租房屋
        Proxy proxy = new Proxy(host);
        //找中介租房
        proxy.rent();
    }
}
