package com.darwin.wasterecycling.net;


import java.util.concurrent.Future;

public interface Client<A> {
    <T> T request(Object data,Class<T> responseType,A targetAddress);

    <T> void AsyncRequest(Object data, Class<T> responseType,A targetAddress);

}
