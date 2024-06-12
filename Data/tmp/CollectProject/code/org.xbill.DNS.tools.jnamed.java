public class jnamed {
	static final int FLAG_DNSSECOK = 1;

	static final int FLAG_SIGONLY = 2;

	java.util.Map<java.lang.Integer, org.xbill.DNS.Cache> caches;

	java.util.Map<org.xbill.DNS.Name, org.xbill.DNS.Zone> znames;

	java.util.Map<org.xbill.DNS.Name, org.xbill.DNS.TSIG> TSIGs;

	private static java.lang.String addrport(java.net.InetAddress addr, int port) {
		return (addr.getHostAddress() + "#") + port;
	}

	public jnamed(java.lang.String conffile) throws java.io.IOException, org.xbill.DNS.ZoneTransferException {
		java.io.FileInputStream fs;
		java.io.InputStreamReader isr;
		java.io.BufferedReader br;
		java.util.List<java.lang.Integer> ports = new java.util.ArrayList<>();
		java.util.List<java.net.InetAddress> addresses = new java.util.ArrayList<>();
		try {
			fs = new java.io.FileInputStream(conffile);
			isr = new java.io.InputStreamReader(fs);
			br = new java.io.BufferedReader(isr);
		} catch (java.lang.Exception e) {
			java.lang.System.out.println("Cannot open " + conffile);
			return;
		}
		try {
			caches = new java.util.HashMap<>();
			znames = new java.util.HashMap<>();
			TSIGs = new java.util.HashMap<>();
			java.lang.String line;
			while ((line = br.readLine()) != null) {
				java.util.StringTokenizer st = new java.util.StringTokenizer(line);
				if (!st.hasMoreTokens()) {
					continue;
				}
				java.lang.String keyword = st.nextToken();
				if (!st.hasMoreTokens()) {
					java.lang.System.out.println("Invalid line: " + line);
					continue;
				}
				if (keyword.charAt(0) == '#') {
					continue;
				}
				switch (keyword) {
					case "primary" :
						addPrimaryZone(st.nextToken(), st.nextToken());
						break;
					case "secondary" :
						addSecondaryZone(st.nextToken(), st.nextToken());
						break;
					case "cache" :
						org.xbill.DNS.Cache cache = new org.xbill.DNS.Cache(st.nextToken());
						caches.put(org.xbill.DNS.DClass.IN, cache);
						break;
					case "key" :
						java.lang.String s1 = st.nextToken();
						java.lang.String s2 = st.nextToken();
						if (st.hasMoreTokens()) {
							addTSIG(s1, s2, st.nextToken());
						} else {
							addTSIG("hmac-md5", s1, s2);
						}
						break;
					case "port" :
						ports.add(java.lang.Integer.valueOf(st.nextToken()));
						break;
					case "address" :
						java.lang.String addr = st.nextToken();
						addresses.add(org.xbill.DNS.Address.getByAddress(addr));
						break;
					default :
						java.lang.System.out.println("unknown keyword: " + keyword);
						break;
				}
			} 
			if (ports.isEmpty()) {
				ports.add(53);
			}
			if (addresses.isEmpty()) {
				addresses.add(org.xbill.DNS.Address.getByAddress("0.0.0.0"));
			}
			for (java.net.InetAddress address : addresses) {
				for (java.lang.Integer o : ports) {
					int port = o;
					addUDP(address, port);
					addTCP(address, port);
					java.lang.System.out.println("jnamed: listening on " + org.xbill.DNS.tools.jnamed.addrport(address, port));
				}
			}
			java.lang.System.out.println("jnamed: running");
		} finally {
			br.close();
		}
	}

	public void addPrimaryZone(java.lang.String zname, java.lang.String zonefile) throws java.io.IOException {
		org.xbill.DNS.Name origin = null;
		if (zname != null) {
			origin = org.xbill.DNS.Name.fromString(zname, org.xbill.DNS.Name.root);
		}
		org.xbill.DNS.Zone newzone = new org.xbill.DNS.Zone(origin, zonefile);
		znames.put(newzone.getOrigin(), newzone);
	}

	public void addSecondaryZone(java.lang.String zone, java.lang.String remote) throws java.io.IOException, org.xbill.DNS.ZoneTransferException {
		org.xbill.DNS.Name zname = org.xbill.DNS.Name.fromString(zone, org.xbill.DNS.Name.root);
		org.xbill.DNS.Zone newzone = new org.xbill.DNS.Zone(zname, org.xbill.DNS.DClass.IN, remote);
		znames.put(zname, newzone);
	}

	public void addTSIG(java.lang.String algstr, java.lang.String namestr, java.lang.String key) throws java.io.IOException {
		org.xbill.DNS.Name name = org.xbill.DNS.Name.fromString(namestr, org.xbill.DNS.Name.root);
		TSIGs.put(name, new org.xbill.DNS.TSIG(algstr, namestr, key));
	}

	public org.xbill.DNS.Cache getCache(int dclass) {
		return caches.computeIfAbsent(dclass, org.xbill.DNS.Cache::new);
	}

	public org.xbill.DNS.Zone findBestZone(org.xbill.DNS.Name name) {
		org.xbill.DNS.Zone foundzone;
		foundzone = znames.get(name);
		if (foundzone != null) {
			return foundzone;
		}
		int labels = name.labels();
		for (int i = 1; i < labels; i++) {
			org.xbill.DNS.Name tname = new org.xbill.DNS.Name(name, i);
			foundzone = znames.get(tname);
			if (foundzone != null) {
				return foundzone;
			}
		}
		return null;
	}

	public org.xbill.DNS.RRset findExactMatch(org.xbill.DNS.Name name, int type, int dclass, boolean glue) {
		org.xbill.DNS.Zone zone = findBestZone(name);
		if (zone != null) {
			return zone.findExactMatch(name, type);
		} else {
			java.util.List<org.xbill.DNS.RRset> rrsets;
			org.xbill.DNS.Cache cache = getCache(dclass);
			if (glue) {
				rrsets = cache.findAnyRecords(name, type);
			} else {
				rrsets = cache.findRecords(name, type);
			}
			if (rrsets == null) {
				return null;
			} else {
				return rrsets.get(0);
			}
		}
	}

	void addRRset(org.xbill.DNS.Name name, org.xbill.DNS.Message response, org.xbill.DNS.RRset rrset, int section, int flags) {
		for (int s = 1; s <= section; s++) {
			if (response.findRRset(name, rrset.getType(), s)) {
				return;
			}
		}
		if ((flags & org.xbill.DNS.tools.jnamed.FLAG_SIGONLY) == 0) {
			for (org.xbill.DNS.Record r : rrset.rrs()) {
				if (r.getName().isWild() && (!name.isWild())) {
					r = r.withName(name);
				}
				response.addRecord(r, section);
			}
		}
		if ((flags & (org.xbill.DNS.tools.jnamed.FLAG_SIGONLY | org.xbill.DNS.tools.jnamed.FLAG_DNSSECOK)) != 0) {
			for (org.xbill.DNS.Record r : rrset.sigs()) {
				if (r.getName().isWild() && (!name.isWild())) {
					r = r.withName(name);
				}
				response.addRecord(r, section);
			}
		}
	}

	private void addSOA(org.xbill.DNS.Message response, org.xbill.DNS.Zone zone) {
		response.addRecord(zone.getSOA(), org.xbill.DNS.Section.AUTHORITY);
	}

	private void addNS(org.xbill.DNS.Message response, org.xbill.DNS.Zone zone, int flags) {
		org.xbill.DNS.RRset nsRecords = zone.getNS();
		addRRset(nsRecords.getName(), response, nsRecords, org.xbill.DNS.Section.AUTHORITY, flags);
	}

	private void addCacheNS(org.xbill.DNS.Message response, org.xbill.DNS.Cache cache, org.xbill.DNS.Name name) {
		org.xbill.DNS.SetResponse sr = cache.lookupRecords(name, org.xbill.DNS.Type.NS, org.xbill.DNS.Credibility.HINT);
		if (!sr.isDelegation()) {
			return;
		}
		org.xbill.DNS.RRset nsRecords = sr.getNS();
		for (org.xbill.DNS.Record r : nsRecords.rrs()) {
			response.addRecord(r, org.xbill.DNS.Section.AUTHORITY);
		}
	}

	private void addGlue(org.xbill.DNS.Message response, org.xbill.DNS.Name name, int flags) {
		org.xbill.DNS.RRset a = findExactMatch(name, org.xbill.DNS.Type.A, org.xbill.DNS.DClass.IN, true);
		if (a == null) {
			return;
		}
		addRRset(name, response, a, org.xbill.DNS.Section.ADDITIONAL, flags);
	}

	private void addAdditional2(org.xbill.DNS.Message response, int section, int flags) {
		for (org.xbill.DNS.Record r : response.getSection(section)) {
			org.xbill.DNS.Name glueName = r.getAdditionalName();
			if (glueName != null) {
				addGlue(response, glueName, flags);
			}
		}
	}

	private void addAdditional(org.xbill.DNS.Message response, int flags) {
		addAdditional2(response, org.xbill.DNS.Section.ANSWER, flags);
		addAdditional2(response, org.xbill.DNS.Section.AUTHORITY, flags);
	}

	byte addAnswer(org.xbill.DNS.Message response, org.xbill.DNS.Name name, int type, int dclass, int iterations, int flags) {
		org.xbill.DNS.SetResponse sr;
		byte rcode = org.xbill.DNS.Rcode.NOERROR;
		if (iterations > 6) {
			return org.xbill.DNS.Rcode.NOERROR;
		}
		if ((type == org.xbill.DNS.Type.SIG) || (type == org.xbill.DNS.Type.RRSIG)) {
			type = org.xbill.DNS.Type.ANY;
			flags |= org.xbill.DNS.tools.jnamed.FLAG_SIGONLY;
		}
		org.xbill.DNS.Zone zone = findBestZone(name);
		if (zone != null) {
			sr = zone.findRecords(name, type);
		} else {
			org.xbill.DNS.Cache cache = getCache(dclass);
			sr = cache.lookupRecords(name, type, org.xbill.DNS.Credibility.NORMAL);
		}
		if (sr.isUnknown()) {
			addCacheNS(response, getCache(dclass), name);
		}
		if (sr.isNXDOMAIN()) {
			response.getHeader().setRcode(org.xbill.DNS.Rcode.NXDOMAIN);
			if (zone != null) {
				addSOA(response, zone);
				if (iterations == 0) {
					response.getHeader().setFlag(org.xbill.DNS.Flags.AA);
				}
			}
			rcode = org.xbill.DNS.Rcode.NXDOMAIN;
		} else if (sr.isNXRRSET()) {
			if (zone != null) {
				addSOA(response, zone);
				if (iterations == 0) {
					response.getHeader().setFlag(org.xbill.DNS.Flags.AA);
				}
			}
		} else if (sr.isDelegation()) {
			org.xbill.DNS.RRset nsRecords = sr.getNS();
			addRRset(nsRecords.getName(), response, nsRecords, org.xbill.DNS.Section.AUTHORITY, flags);
		} else if (sr.isCNAME()) {
			org.xbill.DNS.CNAMERecord cname = sr.getCNAME();
			org.xbill.DNS.RRset rrset = new org.xbill.DNS.RRset(cname);
			addRRset(name, response, rrset, org.xbill.DNS.Section.ANSWER, flags);
			if ((zone != null) && (iterations == 0)) {
				response.getHeader().setFlag(org.xbill.DNS.Flags.AA);
			}
			rcode = addAnswer(response, cname.getTarget(), type, dclass, iterations + 1, flags);
		} else if (sr.isDNAME()) {
			org.xbill.DNS.DNAMERecord dname = sr.getDNAME();
			org.xbill.DNS.RRset rrset = new org.xbill.DNS.RRset(dname);
			addRRset(name, response, rrset, org.xbill.DNS.Section.ANSWER, flags);
			org.xbill.DNS.Name newname;
			try {
				newname = name.fromDNAME(dname);
			} catch (org.xbill.DNS.NameTooLongException e) {
				return org.xbill.DNS.Rcode.YXDOMAIN;
			}
			org.xbill.DNS.CNAMERecord cname = new org.xbill.DNS.CNAMERecord(name, dclass, 0, newname);
			org.xbill.DNS.RRset cnamerrset = new org.xbill.DNS.RRset(cname);
			addRRset(name, response, cnamerrset, org.xbill.DNS.Section.ANSWER, flags);
			if ((zone != null) && (iterations == 0)) {
				response.getHeader().setFlag(org.xbill.DNS.Flags.AA);
			}
			rcode = addAnswer(response, newname, type, dclass, iterations + 1, flags);
		} else if (sr.isSuccessful()) {
			java.util.List<org.xbill.DNS.RRset> rrsets = sr.answers();
			for (org.xbill.DNS.RRset rrset : rrsets) {
				addRRset(name, response, rrset, org.xbill.DNS.Section.ANSWER, flags);
			}
			if (zone != null) {
				addNS(response, zone, flags);
				if (iterations == 0) {
					response.getHeader().setFlag(org.xbill.DNS.Flags.AA);
				}
			} else {
				addCacheNS(response, getCache(dclass), name);
			}
		}
		return rcode;
	}

	byte[] doAXFR(org.xbill.DNS.Name name, org.xbill.DNS.Message query, org.xbill.DNS.TSIG tsig, org.xbill.DNS.TSIGRecord qtsig, java.net.Socket s) {
		org.xbill.DNS.Zone zone = znames.get(name);
		boolean first = true;
		if (zone == null) {
			return errorMessage(query, org.xbill.DNS.Rcode.REFUSED);
		}
		try {
			java.io.DataOutputStream dataOut;
			dataOut = new java.io.DataOutputStream(s.getOutputStream());
			int id = query.getHeader().getID();
			java.util.Iterator<org.xbill.DNS.RRset> it = zone.AXFR();
			while (it.hasNext()) {
				org.xbill.DNS.RRset rrset = it.next();
				org.xbill.DNS.Message response = new org.xbill.DNS.Message(id);
				org.xbill.DNS.Header header = response.getHeader();
				header.setFlag(org.xbill.DNS.Flags.QR);
				header.setFlag(org.xbill.DNS.Flags.AA);
				addRRset(rrset.getName(), response, rrset, org.xbill.DNS.Section.ANSWER, org.xbill.DNS.tools.jnamed.FLAG_DNSSECOK);
				if (tsig != null) {
					tsig.apply(response, qtsig, first);
					qtsig = response.getTSIG();
				}
				first = false;
				byte[] out = response.toWire();
				dataOut.writeShort(out.length);
				dataOut.write(out);
			} 
		} catch (java.io.IOException ex) {
			java.lang.System.out.println("AXFR failed");
		}
		try {
			s.close();
		} catch (java.io.IOException ex) {
		}
		return null;
	}

	byte[] generateReply(org.xbill.DNS.Message query, byte[] in, java.net.Socket s) {
		org.xbill.DNS.Header header;
		int maxLength;
		int flags = 0;
		header = query.getHeader();
		if (header.getFlag(org.xbill.DNS.Flags.QR)) {
			return null;
		}
		if (header.getRcode() != org.xbill.DNS.Rcode.NOERROR) {
			return errorMessage(query, org.xbill.DNS.Rcode.FORMERR);
		}
		if (header.getOpcode() != org.xbill.DNS.Opcode.QUERY) {
			return errorMessage(query, org.xbill.DNS.Rcode.NOTIMP);
		}
		org.xbill.DNS.Record queryRecord = query.getQuestion();
		org.xbill.DNS.TSIGRecord queryTSIG = query.getTSIG();
		org.xbill.DNS.TSIG tsig = null;
		if (queryTSIG != null) {
			tsig = TSIGs.get(queryTSIG.getName());
			if ((tsig == null) || (tsig.verify(query, in, null) != org.xbill.DNS.Rcode.NOERROR)) {
				return formerrMessage(in);
			}
		}
		org.xbill.DNS.OPTRecord queryOPT = query.getOPT();
		if (s != null) {
			maxLength = 65535;
		} else if (queryOPT != null) {
			maxLength = java.lang.Math.max(queryOPT.getPayloadSize(), 512);
		} else {
			maxLength = 512;
		}
		if ((queryOPT != null) && ((queryOPT.getFlags() & org.xbill.DNS.ExtendedFlags.DO) != 0)) {
			flags = org.xbill.DNS.tools.jnamed.FLAG_DNSSECOK;
		}
		org.xbill.DNS.Message response = new org.xbill.DNS.Message(query.getHeader().getID());
		response.getHeader().setFlag(org.xbill.DNS.Flags.QR);
		if (query.getHeader().getFlag(org.xbill.DNS.Flags.RD)) {
			response.getHeader().setFlag(org.xbill.DNS.Flags.RD);
		}
		response.addRecord(queryRecord, org.xbill.DNS.Section.QUESTION);
		org.xbill.DNS.Name name = queryRecord.getName();
		int type = queryRecord.getType();
		int dclass = queryRecord.getDClass();
		if ((type == org.xbill.DNS.Type.AXFR) && (s != null)) {
			return doAXFR(name, query, tsig, queryTSIG, s);
		}
		if ((!org.xbill.DNS.Type.isRR(type)) && (type != org.xbill.DNS.Type.ANY)) {
			return errorMessage(query, org.xbill.DNS.Rcode.NOTIMP);
		}
		byte rcode = addAnswer(response, name, type, dclass, 0, flags);
		if ((rcode != org.xbill.DNS.Rcode.NOERROR) && (rcode != org.xbill.DNS.Rcode.NXDOMAIN)) {
			return errorMessage(query, rcode);
		}
		addAdditional(response, flags);
		if (queryOPT != null) {
			int optflags = (flags == org.xbill.DNS.tools.jnamed.FLAG_DNSSECOK) ? org.xbill.DNS.ExtendedFlags.DO : 0;
			org.xbill.DNS.OPTRecord opt = new org.xbill.DNS.OPTRecord(((short) (4096)), rcode, ((byte) (0)), optflags);
			response.addRecord(opt, org.xbill.DNS.Section.ADDITIONAL);
		}
		response.setTSIG(tsig, org.xbill.DNS.Rcode.NOERROR, queryTSIG);
		return response.toWire(maxLength);
	}

	byte[] buildErrorMessage(org.xbill.DNS.Header header, int rcode, org.xbill.DNS.Record question) {
		org.xbill.DNS.Message response = new org.xbill.DNS.Message();
		response.setHeader(header);
		for (int i = 0; i < 4; i++) {
			response.removeAllRecords(i);
		}
		if (rcode == org.xbill.DNS.Rcode.SERVFAIL) {
			response.addRecord(question, org.xbill.DNS.Section.QUESTION);
		}
		header.setRcode(rcode);
		return response.toWire();
	}

	public byte[] formerrMessage(byte[] in) {
		org.xbill.DNS.Header header;
		try {
			header = new org.xbill.DNS.Header(in);
		} catch (java.io.IOException e) {
			return null;
		}
		return buildErrorMessage(header, org.xbill.DNS.Rcode.FORMERR, null);
	}

	public byte[] errorMessage(org.xbill.DNS.Message query, int rcode) {
		return buildErrorMessage(query.getHeader(), rcode, query.getQuestion());
	}

	public void TCPclient(java.net.Socket s) {
		try (final java.io.InputStream is = s.getInputStream()) {
			int inLength;
			java.io.DataInputStream dataIn;
			java.io.DataOutputStream dataOut;
			byte[] in;
			dataIn = new java.io.DataInputStream(is);
			inLength = dataIn.readUnsignedShort();
			in = new byte[inLength];
			dataIn.readFully(in);
			org.xbill.DNS.Message query;
			byte[] response;
			try {
				query = new org.xbill.DNS.Message(in);
				response = generateReply(query, in, s);
				if (response == null) {
					return;
				}
			} catch (java.io.IOException e) {
				response = formerrMessage(in);
			}
			dataOut = new java.io.DataOutputStream(s.getOutputStream());
			dataOut.writeShort(response.length);
			dataOut.write(response);
		} catch (java.io.IOException e) {
			java.lang.System.out.println((("TCPclient(" + org.xbill.DNS.tools.jnamed.addrport(s.getLocalAddress(), s.getLocalPort())) + "): ") + e);
		}
	}

	public void serveTCP(java.net.InetAddress addr, int port) {
		try (final java.net.ServerSocket sock = new java.net.ServerSocket(port, 128, addr)) {
			while (true) {
				final java.net.Socket s = sock.accept();
				java.lang.Thread t;
				t = new java.lang.Thread(() -> TCPclient(s));
				t.start();
			} 
		} catch (java.io.IOException e) {
			java.lang.System.out.println((("serveTCP(" + org.xbill.DNS.tools.jnamed.addrport(addr, port)) + "): ") + e);
		}
	}

	public void serveUDP(java.net.InetAddress addr, int port) {
		try (final java.net.DatagramSocket sock = new java.net.DatagramSocket(port, addr)) {
			final short udpLength = 512;
			byte[] in = new byte[udpLength];
			java.net.DatagramPacket indp = new java.net.DatagramPacket(in, in.length);
			java.net.DatagramPacket outdp = null;
			while (true) {
				indp.setLength(in.length);
				try {
					sock.receive(indp);
				} catch (java.io.InterruptedIOException e) {
					continue;
				}
				org.xbill.DNS.Message query;
				byte[] response;
				try {
					query = new org.xbill.DNS.Message(in);
					response = generateReply(query, in, null);
					if (response == null) {
						continue;
					}
				} catch (java.io.IOException e) {
					response = formerrMessage(in);
				}
				if (outdp == null) {
					outdp = new java.net.DatagramPacket(response, response.length, indp.getAddress(), indp.getPort());
				} else {
					outdp.setData(response);
					outdp.setLength(response.length);
					outdp.setAddress(indp.getAddress());
					outdp.setPort(indp.getPort());
				}
				sock.send(outdp);
			} 
		} catch (java.io.IOException e) {
			java.lang.System.out.println((("serveUDP(" + org.xbill.DNS.tools.jnamed.addrport(addr, port)) + "): ") + e);
		}
	}

	public void addTCP(final java.net.InetAddress addr, final int port) {
		java.lang.Thread t = new java.lang.Thread(() -> serveTCP(addr, port));
		t.start();
	}

	public void addUDP(final java.net.InetAddress addr, final int port) {
		java.lang.Thread t = new java.lang.Thread(() -> serveUDP(addr, port));
		t.start();
	}

	public static void main(java.lang.String[] args) {
		if (args.length > 1) {
			java.lang.System.out.println("usage: jnamed [conf]");
			java.lang.System.exit(0);
		}
		try {
			java.lang.String conf;
			if (args.length == 1) {
				conf = args[0];
			} else {
				conf = "jnamed.conf";
			}
			new org.xbill.DNS.tools.jnamed(conf);
		} catch (java.io.IOException | org.xbill.DNS.ZoneTransferException e) {
			java.lang.System.out.println(e);
		}
	}
}