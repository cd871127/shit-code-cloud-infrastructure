package com.shit.code.cloud.infrastructure.shiro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * @author Anthony Chen
 * @date 2020/7/9
 **/
@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping("olala")
    public String test() {
        return "123123";
    }

//    {
//
//        public static class ForkJoinWorkerThreadWrap extends ForkJoinWorkerThread {
//            public Map<String, String> getContext() {
//                return context;
//            }
//
//            public void setContext(Map<String, String> context) {
//                this.context = context;
//            }
//
//            public Object getRpcContext() {
//                return rpcContext;
//            }
//
//            public void setRpcContext(Object rpcContext) {
//                this.rpcContext = rpcContext;
//            }
//
//            private Map<String, String> context;
//            private Object rpcContext;
//
//            protected ForkJoinWorkerThreadWrap(ForkJoinPool pool) {
//                super(pool);
//            }
//
//            private ForkJoinWorkerThread forkJoinWorkerThread;
//
//            public ForkJoinWorkerThreadWrap(ForkJoinWorkerThread forkJoinWorkerThread) {
//                this(forkJoinWorkerThread.getPool());
//                this.forkJoinWorkerThread = forkJoinWorkerThread;
//            }
//
//            @Override
//            public void run() {
//                if (this.context != null) {
//                    FenqileMDC.setContextMap(this.context);
//                }
//
//                if (this.rpcContext != null) {
//                    try {
//                        Method method = TraceProxy.class.getMethod("setRpcContext", Object.class);
//                        method.invoke(TraceProxy.class, rpcContext);
//                        log.info("====================================");
//                    } catch (Exception e1) {
//                    }
//                }
//                forkJoinWorkerThread.run();
//            }
//
//            public static class TraceForkJoinWorkerThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {
//                @Override
//                public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
//                    ForkJoinWorkerThread forkJoinWorkerThread = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
//                    ForkJoinWorkerThreadWrap forkJoinWorkerThreadWrap = new ForkJoinWorkerThreadWrap(forkJoinWorkerThread);
//                    forkJoinWorkerThreadWrap.setContext(FenqileMDC.getCopyOfContextMap());
//                    forkJoinWorkerThreadWrap.setRpcContext(ThreadUtil.getRpcContext());
//                    return forkJoinWorkerThreadWrap;
//                }
//            }
//        }
//    }
}
