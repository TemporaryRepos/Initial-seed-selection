public class dig {
	static org.xbill.DNS.Name name = null;

	static int type = org.xbill.DNS.Type.A;

	static int dclass = org.xbill.DNS.DClass.IN;

	static void usage() {
		java.lang.System.out.println("; dnsjava dig");
		java.lang.System.out.println("Usage: dig [@server] name [<type>] [<class>] [options]");
		java.lang.System.exit(0);
	}

	static void doQuery(org.xbill.DNS.Message response, long ms) {
		java.lang.System.out.println("; dnsjava dig");
		java.lang.System.out.println(response);
		java.lang.System.out.println((";; Query time: " + ms) + " ms");
	}

	public static void main(java.lang.String[] argv) throws java.io.IOException {
		java.lang.String server = null;
		int arg;
		org.xbill.DNS.Message query;
		org.xbill.DNS.Message response;
		org.xbill.DNS.Record rec;
		org.xbill.DNS.SimpleResolver res = null;
		boolean printQuery = false;
		long startTime;
		long endTime;
		if (argv.length < 1) {
			org.xbill.DNS.tools.dig.usage();
		}
		try {
			arg = 0;
			if (argv[arg].startsWith("@")) {
				server = argv[arg++].substring(1);
			}
			if (server != null) {
				res = new org.xbill.DNS.SimpleResolver(server);
			} else {
				res = new org.xbill.DNS.SimpleResolver();
			}
			java.lang.String nameString = argv[arg++];
			if (nameString.equals("-x")) {
				org.xbill.DNS.tools.dig.name = org.xbill.DNS.ReverseMap.fromAddress(argv[arg++]);
				org.xbill.DNS.tools.dig.type = org.xbill.DNS.Type.PTR;
				org.xbill.DNS.tools.dig.dclass = org.xbill.DNS.DClass.IN;
			} else {
				org.xbill.DNS.tools.dig.name = org.xbill.DNS.Name.fromString(nameString, org.xbill.DNS.Name.root);
				org.xbill.DNS.tools.dig.type = org.xbill.DNS.Type.value(argv[arg]);
				if (org.xbill.DNS.tools.dig.type < 0) {
					org.xbill.DNS.tools.dig.type = org.xbill.DNS.Type.A;
				} else {
					arg++;
				}
				org.xbill.DNS.tools.dig.dclass = org.xbill.DNS.DClass.value(argv[arg]);
				if (org.xbill.DNS.tools.dig.dclass < 0) {
					org.xbill.DNS.tools.dig.dclass = org.xbill.DNS.DClass.IN;
				} else {
					arg++;
				}
			}
			while (argv[arg].startsWith("-") && (argv[arg].length() > 1)) {
				switch (argv[arg].charAt(1)) {
					case 'p' :
						java.lang.String portStr;
						int port;
						if (argv[arg].length() > 2) {
							portStr = argv[arg].substring(2);
						} else {
							portStr = argv[++arg];
						}
						port = java.lang.Integer.parseInt(portStr);
						if ((port < 0) || (port > 65535)) {
							java.lang.System.out.println("Invalid port");
							return;
						}
						res.setPort(port);
						break;
					case 'b' :
						java.lang.String addrStr;
						if (argv[arg].length() > 2) {
							addrStr = argv[arg].substring(2);
						} else {
							addrStr = argv[++arg];
						}
						java.net.InetAddress addr;
						try {
							addr = java.net.InetAddress.getByName(addrStr);
						} catch (java.lang.Exception e) {
							java.lang.System.out.println("Invalid address");
							return;
						}
						res.setLocalAddress(addr);
						break;
					case 'k' :
						java.lang.String key;
						if (argv[arg].length() > 2) {
							key = argv[arg].substring(2);
						} else {
							key = argv[++arg];
						}
						java.lang.String[] parts = key.split("[:/]", 3);
						switch (parts.length) {
							case 2 :
								res.setTSIGKey(new org.xbill.DNS.TSIG(org.xbill.DNS.TSIG.HMAC_MD5, parts[0], parts[1]));
								break;
							case 3 :
								res.setTSIGKey(new org.xbill.DNS.TSIG(parts[0], parts[1], parts[2]));
								break;
							default :
								throw new java.lang.IllegalArgumentException("Invalid TSIG key specification");
						}
						break;
					case 't' :
						res.setTCP(true);
						break;
					case 'i' :
						res.setIgnoreTruncation(true);
						break;
					case 'e' :
						java.lang.String ednsStr;
						int edns;
						if (argv[arg].length() > 2) {
							ednsStr = argv[arg].substring(2);
						} else {
							ednsStr = argv[++arg];
						}
						edns = java.lang.Integer.parseInt(ednsStr);
						if ((edns < 0) || (edns > 1)) {
							java.lang.System.out.println("Unsupported EDNS level: " + edns);
							return;
						}
						res.setEDNS(edns);
						break;
					case 'd' :
						res.setEDNS(0, 0, org.xbill.DNS.ExtendedFlags.DO);
						break;
					case 'q' :
						printQuery = true;
						break;
					default :
						java.lang.System.out.print("Invalid option: ");
						java.lang.System.out.println(argv[arg]);
				}
				arg++;
			} 
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			if (org.xbill.DNS.tools.dig.name == null) {
				org.xbill.DNS.tools.dig.usage();
			}
		}
		if (res == null) {
			res = new org.xbill.DNS.SimpleResolver();
		}
		rec = org.xbill.DNS.Record.newRecord(org.xbill.DNS.tools.dig.name, org.xbill.DNS.tools.dig.type, org.xbill.DNS.tools.dig.dclass);
		query = org.xbill.DNS.Message.newQuery(rec);
		if (printQuery) {
			java.lang.System.out.println(query);
		}
		if (org.xbill.DNS.tools.dig.type == org.xbill.DNS.Type.AXFR) {
			java.lang.System.out.println(("; dnsjava dig <> " + org.xbill.DNS.tools.dig.name) + " axfr");
			org.xbill.DNS.ZoneTransferIn xfrin = org.xbill.DNS.ZoneTransferIn.newAXFR(org.xbill.DNS.tools.dig.name, res.getAddress(), res.getTSIGKey());
			xfrin.setTimeout(res.getTimeout());
			try {
				xfrin.run(new org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler() {
					@java.lang.Override
					public void startAXFR() {
					}

					@java.lang.Override
					public void startIXFR() {
					}

					@java.lang.Override
					public void startIXFRDeletes(org.xbill.DNS.Record soa) {
					}

					@java.lang.Override
					public void startIXFRAdds(org.xbill.DNS.Record soa) {
					}

					@java.lang.Override
					public void handleRecord(org.xbill.DNS.Record r) {
						java.lang.System.out.println(r);
					}
				});
			} catch (org.xbill.DNS.ZoneTransferException e) {
				throw new org.xbill.DNS.WireParseException(e.getMessage());
			}
		} else {
			startTime = java.lang.System.currentTimeMillis();
			response = res.send(query);
			endTime = java.lang.System.currentTimeMillis();
			org.xbill.DNS.tools.dig.doQuery(response, endTime - startTime);
		}
	}
}