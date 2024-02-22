package org.example.concurrency;


/**
 *                              LiveLock
 * -> A livelock is similar to a deadlock in that the threads
 * involved are stuck, making no progress. However, with deadlock, the
 * threads are doing nothing. With livelock, the threads are busy but their actions are
 * repeatedly triggering the same conditions.
 *
 * -> A real-world example of livelock occurs when two people meet in a narrow
 * corridor, and each tries to be polite by moving aside to let the other pass, but they
 * end up swaying from side to side without making any progress because they both repeatedly
 * move the same way at the same time.
 *
 *
 * -> Livelock is a risk with some algorithms that detect and recover from deadlock.
 * If more than one process takes action, the deadlock detection algorithm can be repeatedly
 * triggered.
 *
 * -> Livelock can be difficult to detect as the threads are active
 * (they are stuck in an endless cycle).
 *
 *
 *                              Starvation
 *
 * -> Starvation occurs when a thread is unable to gain access to a required resource.
 *
 * -> This can happen to low-priority threads if the resource in question is in high
 * demand by higher-priority threads.
 *
 * -> This can affect the liveness of you application as,even if it is a low-priority thread,
 * it must get it's work done.
 */

public class Livelock { }
