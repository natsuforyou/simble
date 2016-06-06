package org.simble.member.service;

public interface HelloService {

    String sayHello();

    void testException() throws Exception;

    void testCustomException() throws Exception;
}
