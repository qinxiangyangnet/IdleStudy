package com.yueyang.tt.current;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-14 16:51
 **/
public class CountDownLatchRe {


    private static final class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 4982264981922014374L;

        Sync(int count) {
            setState(count);
        }

        int getCount() {
            return getState();
        }


        @Override
        protected int tryAcquireShared(int acquires) {
            return (getState() == 0) ? 1 : -1;
        }

        /**
         * *
         *
         * @param releases
         * @return
         */
        @Override
        protected boolean tryReleaseShared(int releases) {
            for (; ; ) {
                int c = getState();
                if (c == 0)
                    return false;
                int nextc = c - 1;
                if (compareAndSetState(c, nextc))
                    return nextc == 0;
            }
        }
    }


    private final Sync sync;

    public CountDownLatchRe(int count) {
        if (count < 0) throw new IllegalArgumentException("count<0");
        this.sync = new Sync(count);
    }


    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    public void countDown() {
        sync.releaseShared(1);
    }

}