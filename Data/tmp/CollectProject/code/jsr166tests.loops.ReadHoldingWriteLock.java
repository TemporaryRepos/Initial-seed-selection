class ReadHoldingWriteLock {
	public static void main(java.lang.String[] args) throws java.lang.Exception {
		jsr166tests.loops.ReadHoldingWriteLock t = new jsr166tests.loops.ReadHoldingWriteLock();
		t.testReadAfterWriteLock();
		t.testReadHoldingWriteLock();
		t.testReadHoldingWriteLock2();
		t.testReadHoldingWriteLockFair();
		t.testReadHoldingWriteLockFair2();
	}

	static final long SHORT_DELAY_MS = 50;

	static final long MEDIUM_DELAY_MS = 200;

	void assertTrue(boolean b) {
		if (!b) {
			throw new java.lang.Error();
		}
	}

	public void testReadAfterWriteLock() throws java.lang.Exception {
		final java.util.concurrent.locks.ReentrantReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
		lock.writeLock().lock();
		java.lang.Thread t1 = new java.lang.Thread(new java.lang.Runnable() {
			public void run() {
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});
		java.lang.Thread t2 = new java.lang.Thread(new java.lang.Runnable() {
			public void run() {
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});
		t1.start();
		t2.start();
		java.lang.Thread.sleep(jsr166tests.loops.ReadHoldingWriteLock.SHORT_DELAY_MS);
		lock.writeLock().unlock();
		t1.join(jsr166tests.loops.ReadHoldingWriteLock.MEDIUM_DELAY_MS);
		t2.join(jsr166tests.loops.ReadHoldingWriteLock.MEDIUM_DELAY_MS);
		assertTrue(!t1.isAlive());
		assertTrue(!t2.isAlive());
	}

	public void testReadHoldingWriteLock() throws java.lang.Exception {
		final java.util.concurrent.locks.ReentrantReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
		lock.writeLock().lock();
		assertTrue(lock.readLock().tryLock());
		lock.readLock().unlock();
		lock.writeLock().unlock();
	}

	public void testReadHoldingWriteLock2() throws java.lang.Exception {
		final java.util.concurrent.locks.ReentrantReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
		lock.writeLock().lock();
		java.lang.Thread t1 = new java.lang.Thread(new java.lang.Runnable() {
			public void run() {
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});
		java.lang.Thread t2 = new java.lang.Thread(new java.lang.Runnable() {
			public void run() {
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});
		t1.start();
		t2.start();
		lock.readLock().lock();
		lock.readLock().unlock();
		java.lang.Thread.sleep(jsr166tests.loops.ReadHoldingWriteLock.SHORT_DELAY_MS);
		lock.readLock().lock();
		lock.readLock().unlock();
		lock.writeLock().unlock();
		t1.join(jsr166tests.loops.ReadHoldingWriteLock.MEDIUM_DELAY_MS);
		t2.join(jsr166tests.loops.ReadHoldingWriteLock.MEDIUM_DELAY_MS);
		assertTrue(!t1.isAlive());
		assertTrue(!t2.isAlive());
	}

	public void testReadHoldingWriteLockFair() throws java.lang.Exception {
		final java.util.concurrent.locks.ReentrantReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock(true);
		lock.writeLock().lock();
		assertTrue(lock.readLock().tryLock());
		lock.readLock().unlock();
		lock.writeLock().unlock();
	}

	public void testReadHoldingWriteLockFair2() throws java.lang.Exception {
		final java.util.concurrent.locks.ReentrantReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock(true);
		lock.writeLock().lock();
		java.lang.Thread t1 = new java.lang.Thread(new java.lang.Runnable() {
			public void run() {
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});
		java.lang.Thread t2 = new java.lang.Thread(new java.lang.Runnable() {
			public void run() {
				lock.readLock().lock();
				lock.readLock().unlock();
			}
		});
		t1.start();
		t2.start();
		lock.readLock().lock();
		lock.readLock().unlock();
		java.lang.Thread.sleep(jsr166tests.loops.ReadHoldingWriteLock.SHORT_DELAY_MS);
		lock.readLock().lock();
		lock.readLock().unlock();
		lock.writeLock().unlock();
		t1.join(jsr166tests.loops.ReadHoldingWriteLock.MEDIUM_DELAY_MS);
		t2.join(jsr166tests.loops.ReadHoldingWriteLock.MEDIUM_DELAY_MS);
		assertTrue(!t1.isAlive());
		assertTrue(!t2.isAlive());
	}
}