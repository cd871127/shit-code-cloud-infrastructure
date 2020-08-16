package com.shit.code.cloud.infrastructure.gateway.thread;

import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class ThreadWrapper {
    public static Runnable wrap(final Runnable runnable, final Map<String, String> mdcContext) {
        return () -> {
            if (mdcContext == null) {
//                MDC.clear();
            } else {
                MDC.setContextMap(mdcContext);
            }
            try {
                runnable.run();
            } finally {
//                MDC.clear();
            }
        };
    }

    public static <T> Callable<T> wrap(final Callable<T> callable, final Map<String, String> mdcContext) {
        return () -> {
//            if (mdcContext == null) {
////                MDC.clear();
//            } else {
//                MDC.setContextMap(mdcContext);
//            }
            try {
                return callable.call();
            } finally {
//                MDC.clear();
            }
        };
    }

    public static <T> Stream<T> wrap(Stream<T> stream, final Map<String, String> mdcContext) {
        return stream.peek(t -> {
            if (mdcContext != null) {
                MDC.setContextMap(mdcContext);
            }
        });
    }
}
