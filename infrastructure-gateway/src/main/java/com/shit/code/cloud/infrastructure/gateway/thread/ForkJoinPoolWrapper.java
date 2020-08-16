package com.shit.code.cloud.infrastructure.gateway.thread;

import org.slf4j.MDC;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ForkJoinPoolWrapper extends ForkJoinPool {
    public ForkJoinPoolWrapper() {
        super();
    }

    public ForkJoinPoolWrapper(int parallelism) {
        super(parallelism);
    }

    public ForkJoinPoolWrapper(int parallelism, ForkJoinWorkerThreadFactory factory, Thread.UncaughtExceptionHandler handler, boolean asyncMode) {
        super(parallelism, factory, handler, asyncMode);
    }

    @Override
    public <T> T invoke(ForkJoinTask<T> task) {
        return super.invoke(task);
    }

    @Override
    public void execute(ForkJoinTask<?> task) {
        super.execute(task);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(ThreadWrapper.wrap(task, MDC.getCopyOfContextMap()));
    }

    @Override
    public <T> ForkJoinTask<T> submit(ForkJoinTask<T> task) {
        return super.submit(task);
    }

    @Override
    public <T> ForkJoinTask<T> submit(Callable<T> task) {
        return super.submit(ThreadWrapper.wrap(task, MDC.getCopyOfContextMap()));
    }

    @Override
    public <T> ForkJoinTask<T> submit(Runnable task, T result) {
        return super.submit(ThreadWrapper.wrap(task, MDC.getCopyOfContextMap()), result);
    }

    @Override
    public ForkJoinTask<?> submit(Runnable task) {
        return super.submit(ThreadWrapper.wrap(task, MDC.getCopyOfContextMap()));
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
        return super.invokeAll(tasks.stream().map(task -> ThreadWrapper.wrap(task, MDC.getCopyOfContextMap())).collect(Collectors.toList()));
    }
}
