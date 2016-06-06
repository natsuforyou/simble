package org.simble.member.api;

public interface HelloApi {

    String sayHello();

    void testException() throws Exception;

    void testCustomException() throws Exception;
}
