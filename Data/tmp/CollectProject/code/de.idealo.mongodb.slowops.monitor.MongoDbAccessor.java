public class MongoDbAccessor {
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(de.idealo.mongodb.slowops.monitor.MongoDbAccessor.class);

	public static final int DEFAULT_CONNECT_TIMEOUT_MS = 2000;

	public static final int DEFAULT_SLOW_MS = 100;

	private static final int DEFAULT_SOCKET_TIMEOUT_MS = 10000;

	private static final java.util.concurrent.ConcurrentHashMap<java.lang.Integer, de.idealo.mongodb.slowops.monitor.MongoDbAccessor> INSTANCES = new java.util.concurrent.ConcurrentHashMap<java.lang.Integer, de.idealo.mongodb.slowops.monitor.MongoDbAccessor>();

	private final com.mongodb.ServerAddress[] serverAddresses;

	private final int socketTimeout;

	private final int connectTimeout;

	private final java.lang.String user;

	private final java.lang.String pw;

	private final boolean ssl;

	private final boolean isSecondaryReadPreferred;

	private com.mongodb.MongoClient mongo;

	private final java.util.concurrent.locks.ReadWriteLock globalLock = new java.util.concurrent.locks.ReentrantReadWriteLock();

	private final java.util.concurrent.locks.Lock writeLock;

	public static void terminate() {
		if (!de.idealo.mongodb.slowops.monitor.MongoDbAccessor.INSTANCES.isEmpty()) {
			for (de.idealo.mongodb.slowops.monitor.MongoDbAccessor i : de.idealo.mongodb.slowops.monitor.MongoDbAccessor.INSTANCES.values()) {
				if (i.mongo != null) {
					i.mongo.close();
					i.mongo = null;
				}
			}
			de.idealo.mongodb.slowops.monitor.MongoDbAccessor.INSTANCES.clear();
		}
	}

	private MongoDbAccessor() {
		this(-1, -1, false, null, null, false, null);
	}

	public MongoDbAccessor(java.lang.String user, java.lang.String pw, boolean ssl, com.mongodb.ServerAddress... serverAddresses) {
		this(-1, -1, false, user, pw, ssl, serverAddresses);
	}

	public MongoDbAccessor(int socketTimeout, int connectTimeout, java.lang.String user, java.lang.String pw, boolean ssl, com.mongodb.ServerAddress... serverAddresses) {
		this(socketTimeout, connectTimeout, false, user, pw, ssl, serverAddresses);
	}

	public MongoDbAccessor(int socketTimeout, int connectTimeout, boolean isSecondaryReadPreferred, java.lang.String user, java.lang.String pw, boolean ssl, com.mongodb.ServerAddress... serverAddresses) {
		this.serverAddresses = serverAddresses;
		this.socketTimeout = (socketTimeout < 0) ? de.idealo.mongodb.slowops.monitor.MongoDbAccessor.DEFAULT_SOCKET_TIMEOUT_MS : socketTimeout;
		this.connectTimeout = (connectTimeout < 0) ? de.idealo.mongodb.slowops.monitor.MongoDbAccessor.DEFAULT_CONNECT_TIMEOUT_MS : connectTimeout;
		this.user = user;
		this.pw = pw;
		this.ssl = ssl;
		this.isSecondaryReadPreferred = isSecondaryReadPreferred;
		writeLock = globalLock.writeLock();
		init();
	}

	private void init() {
		de.idealo.mongodb.slowops.monitor.MongoDbAccessor.LOG.debug(">>> init connection to servers {} ", serverAddresses);
		try {
			writeLock.lock();
			final de.idealo.mongodb.slowops.monitor.MongoDbAccessor instance = de.idealo.mongodb.slowops.monitor.MongoDbAccessor.INSTANCES.get(this.hashCode());
			if ((instance != null) && (instance.mongo != null)) {
				this.mongo = instance.mongo;
				de.idealo.mongodb.slowops.monitor.MongoDbAccessor.LOG.debug("reuse connection to servers {} ", serverAddresses);
			} else {
				de.idealo.mongodb.slowops.monitor.MongoDbAccessor.LOG.debug("create new connection to servers {} ", serverAddresses);
				de.idealo.mongodb.slowops.monitor.MongoDbAccessor.INSTANCES.put(this.hashCode(), this);
				try {
					com.mongodb.MongoClientOptions options = com.mongodb.MongoClientOptions.builder().socketTimeout(socketTimeout).connectTimeout(connectTimeout).readPreference(isSecondaryReadPreferred ? com.mongodb.ReadPreference.secondaryPreferred() : com.mongodb.ReadPreference.primaryPreferred()).writeConcern(com.mongodb.WriteConcern.ACKNOWLEDGED).sslEnabled(ssl).sslInvalidHostNameAllowed(true).build();
					if ((((user != null) && (!user.isEmpty())) && (pw != null)) && (!pw.isEmpty())) {
						com.mongodb.MongoCredential mc = com.mongodb.MongoCredential.createCredential(user, "admin", pw.toCharArray());
						if (serverAddresses.length == 1) {
							mongo = new com.mongodb.MongoClient(serverAddresses[0], mc, options);
						} else {
							mongo = new com.mongodb.MongoClient(com.google.common.collect.Lists.newArrayList(serverAddresses), mc, options);
						}
					} else if (serverAddresses.length == 1) {
						mongo = new com.mongodb.MongoClient(serverAddresses[0], options);
					} else {
						mongo = new com.mongodb.MongoClient(com.google.common.collect.Lists.newArrayList(serverAddresses), options);
					}
				} catch (com.mongodb.MongoException e) {
					de.idealo.mongodb.slowops.monitor.MongoDbAccessor.LOG.error("Error while initializing mongo at address {}", serverAddresses, e);
				}
			}
		} finally {
			writeLock.unlock();
		}
		de.idealo.mongodb.slowops.monitor.MongoDbAccessor.LOG.debug("<<< init");
	}

	public org.bson.codecs.configuration.CodecRegistry getDefaultCodecRegistry() {
		return mongo.getDefaultCodecRegistry();
	}

	public com.mongodb.client.MongoDatabase getMongoDatabase(java.lang.String dbName) {
		return mongo.getDatabase(dbName);
	}

	public com.mongodb.DB getMongoDB(java.lang.String dbName) {
		return mongo.getDB(dbName);
	}

	public org.bson.Document runCommand(java.lang.String dbName, com.mongodb.DBObject cmd) throws java.lang.IllegalStateException {
		if ((dbName != null) && (!dbName.isEmpty())) {
			long start = java.lang.System.currentTimeMillis();
			org.bson.Document result = new org.bson.Document();
			try {
				result = getMongoDatabase(dbName).runCommand(((org.bson.conversions.Bson) (cmd)), isSecondaryReadPreferred ? com.mongodb.ReadPreference.secondaryPreferred() : com.mongodb.ReadPreference.primaryPreferred());
			} catch (java.lang.Throwable e) {
				de.idealo.mongodb.slowops.monitor.MongoDbAccessor.LOG.debug("runCommand failed {} on {}/{}", new java.lang.Object[]{ cmd.toString(), serverAddresses, dbName });
				throw e;
			}
			long end = java.lang.System.currentTimeMillis();
			de.idealo.mongodb.slowops.monitor.MongoDbAccessor.LOG.debug("runCommand {} execTime in ms: {} on {}/{}", new java.lang.Object[]{ cmd.toString(), end - start, serverAddresses, dbName });
			return result;
		}
		throw new java.lang.IllegalStateException("Database not initialized");
	}

	private java.util.List<com.mongodb.ServerAddress> getAllAddresses() {
		return mongo.getAllAddress();
	}

	private void find(java.lang.String dbName, java.lang.String collName, int limit) {
		final com.mongodb.client.MongoIterable<org.bson.Document> res = getMongoDatabase(dbName).getCollection(collName).find().limit(limit);
		if (res != null) {
			for (org.bson.Document doc : res) {
				de.idealo.mongodb.slowops.monitor.MongoDbAccessor.LOG.info("doc: {}", com.mongodb.util.JSON.serialize(doc));
			}
		}
	}

	@java.lang.Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		de.idealo.mongodb.slowops.monitor.MongoDbAccessor that = ((de.idealo.mongodb.slowops.monitor.MongoDbAccessor) (o));
		if (socketTimeout != that.socketTimeout) {
			return false;
		}
		if (connectTimeout != that.connectTimeout) {
			return false;
		}
		if (ssl != that.ssl) {
			return false;
		}
		if (isSecondaryReadPreferred != that.isSecondaryReadPreferred) {
			return false;
		}
		if (user != null ? !user.equals(that.user) : that.user != null) {
			return false;
		}
		if (pw != null ? !pw.equals(that.pw) : that.pw != null) {
			return false;
		}
		int serverAddressesHashCode = 0;
		for (com.mongodb.ServerAddress sa : serverAddresses) {
			serverAddressesHashCode += sa.hashCode();
		}
		int thatServerAddressesHashCode = 0;
		for (com.mongodb.ServerAddress sa : that.serverAddresses) {
			thatServerAddressesHashCode += sa.hashCode();
		}
		return serverAddressesHashCode == thatServerAddressesHashCode;
	}

	@java.lang.Override
	public int hashCode() {
		int result = 31 * socketTimeout;
		result = (31 * result) + connectTimeout;
		result = (31 * result) + (user != null ? user.hashCode() : 0);
		result = (31 * result) + (pw != null ? pw.hashCode() : 0);
		result = (31 * result) + (ssl ? 1 : 0);
		result = (31 * result) + (isSecondaryReadPreferred ? 1 : 0);
		for (com.mongodb.ServerAddress sa : serverAddresses) {
			result = result + sa.hashCode();
		}
		return result;
	}

	public static void main(java.lang.String[] args) throws java.net.UnknownHostException {
	}
}