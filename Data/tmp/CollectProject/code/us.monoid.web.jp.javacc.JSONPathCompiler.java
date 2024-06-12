public class JSONPathCompiler implements us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants , us.monoid.web.jp.javacc.JSONPathCompilerConstants {
	protected us.monoid.web.jp.javacc.JJTJSONPathCompilerState jjtree = new us.monoid.web.jp.javacc.JJTJSONPathCompilerState();

	public static class JSONPathExpr extends us.monoid.web.jp.javacc.AbstractJSONExpr {
		JSONPathExpr(int i) {
			super(i);
		}

		public void dump(java.lang.String prefix) {
			java.lang.System.out.println(prefix + toString());
			if ((children != null) && (children.length > 0)) {
				java.lang.System.out.println(prefix + " [");
				for (int i = 0; (children != null) && (i < children.length); ++i) {
					java.lang.System.out.print(((prefix + " (") + (i + 1)) + ")");
					us.monoid.web.jp.javacc.SimpleNode c = ((us.monoid.web.jp.javacc.SimpleNode) (children[i]));
					if (c == null) {
						java.lang.System.out.println("null");
					} else {
						c.dump(prefix + " ");
					}
				}
				java.lang.System.out.println(prefix + " ]");
			}
		}

		public java.lang.Object eval(java.lang.Object o) throws us.monoid.json.JSONException {
			if (o == null) {
				return null;
			}
			switch (this.id) {
				case us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTIMAGE :
					{
						return this.value;
					}
				case us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTEXPRESSION :
					{
						if (getChildrenCount() == 0) {
							return null;
						}
						for (int i = 0; (o != null) && (i < getChildrenCount()); ++i) {
							o = at(i).eval(o);
						}
						return o;
					}
				case us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTARRAY :
					{
						if (this.value instanceof java.lang.Integer) {
							int index = java.lang.Integer.class.cast(this.value);
							if (o instanceof us.monoid.json.JSONArray) {
								us.monoid.json.JSONArray array = us.monoid.json.JSONArray.class.cast(o);
								return array.get(index);
							} else {
								return null;
							}
						} else if (o instanceof us.monoid.json.JSONArray) {
							us.monoid.json.JSONArray array = us.monoid.json.JSONArray.class.cast(o);
							java.lang.Object result = null;
							match : for (int i = 0, len = array.length(); i < len; i++) {
								java.lang.Object item = array.get(i);
								boolean test = at(0).test(item);
								if (test) {
									result = item;
									break;
								}
							}
							return result;
						}
					}
				case us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTOBJECT :
					{
						if (o instanceof us.monoid.json.JSONObject) {
							us.monoid.json.JSONObject json = us.monoid.json.JSONObject.class.cast(o);
							return json.get(this.value.toString());
						} else if (o instanceof us.monoid.json.JSONArray) {
							us.monoid.json.JSONArray array = us.monoid.json.JSONArray.class.cast(o);
							java.util.List<java.lang.Object> matches = new java.util.ArrayList<java.lang.Object>();
							java.lang.Object result = null;
							for (int i = 0, len = array.length(); i < len; i++) {
								java.lang.Object item = array.get(i);
								if (item instanceof us.monoid.json.JSONObject) {
									us.monoid.json.JSONObject obj = ((us.monoid.json.JSONObject) (item));
									if (obj.has(this.value.toString())) {
										matches.add(obj.get(this.value.toString()));
									}
								}
							}
							return matches;
						}
						return null;
					}
				default :
					java.lang.System.err.println("Doesn't handle " + this.id);
					break;
			}
			return null;
		}
	}

	static us.monoid.web.jp.javacc.SimpleNode jjtCreate(int id) {
		return new us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr(id);
	}

	public static void main(java.lang.String[] args) throws java.lang.Exception {
		try {
			java.io.StringReader r = new java.io.StringReader(args[0]);
			us.monoid.web.jp.javacc.JSONPathCompiler app = new us.monoid.web.jp.javacc.JSONPathCompiler(r);
			us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr x = us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr.class.cast(app.expr());
			x.dump(" ");
			us.monoid.json.JSONObject json = new us.monoid.json.JSONObject("{ \"a\": [" + ("{\"Hello\": \"World\"},{\"Hello\": \"JB\"}]" + ", \"b\": null, \"c\": { \"d\": 1234 }}"));
			java.lang.Object o = x.eval(json);
			java.lang.System.err.println(("Compiling <code>" + args[0]) + "</code>");
			java.lang.System.err.println(("Eval <code>" + json) + "</code>");
			java.lang.System.err.println(("Result is:<code>" + o) + "</code>");
		} catch (java.lang.Exception err) {
			err.printStackTrace();
		}
	}

	public final us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr json() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTEXPRESSION)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		try {
			expr();
			jj_consume_token(0);
			jjtree.closeNodeScope(jjtn000, true);
			jjtc000 = false;
			{
				if (true) {
					return jjtn000;
				}
			}
		} catch (java.lang.Throwable jjte000) {
			if (jjtc000) {
				jjtree.clearNodeScope(jjtn000);
				jjtc000 = false;
			} else {
				jjtree.popNode();
			}
			if (jjte000 instanceof java.lang.RuntimeException) {
				{
					if (true) {
						throw ((java.lang.RuntimeException) (jjte000));
					}
				}
			}
			if (jjte000 instanceof us.monoid.web.jp.javacc.ParseException) {
				{
					if (true) {
						throw ((us.monoid.web.jp.javacc.ParseException) (jjte000));
					}
				}
			}
			{
				if (true) {
					throw ((java.lang.Error) (jjte000));
				}
			}
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
		throw new java.lang.Error("Missing return statement in function");
	}

	public final us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr expr() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTEXPRESSION)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		try {
			switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.OPEN_ARRAY :
					array();
					break;
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.IDENTIFIER :
					object();
					break;
				default :
					jj_la1[0] = jj_gen;
					jj_consume_token(-1);
					throw new us.monoid.web.jp.javacc.ParseException();
			}
			label_1 : while (true) {
				switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
					case us.monoid.web.jp.javacc.JSONPathCompilerConstants.OPEN_ARRAY :
					case us.monoid.web.jp.javacc.JSONPathCompilerConstants.DOT :
						break;
					default :
						jj_la1[1] = jj_gen;
						break label_1;
				}
				switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
					case us.monoid.web.jp.javacc.JSONPathCompilerConstants.OPEN_ARRAY :
						array();
						break;
					case us.monoid.web.jp.javacc.JSONPathCompilerConstants.DOT :
						jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.DOT);
						object();
						break;
					default :
						jj_la1[2] = jj_gen;
						jj_consume_token(-1);
						throw new us.monoid.web.jp.javacc.ParseException();
				}
			} 
			jjtree.closeNodeScope(jjtn000, true);
			jjtc000 = false;
			{
				if (true) {
					return jjtn000;
				}
			}
		} catch (java.lang.Throwable jjte000) {
			if (jjtc000) {
				jjtree.clearNodeScope(jjtn000);
				jjtc000 = false;
			} else {
				jjtree.popNode();
			}
			if (jjte000 instanceof java.lang.RuntimeException) {
				{
					if (true) {
						throw ((java.lang.RuntimeException) (jjte000));
					}
				}
			}
			if (jjte000 instanceof us.monoid.web.jp.javacc.ParseException) {
				{
					if (true) {
						throw ((us.monoid.web.jp.javacc.ParseException) (jjte000));
					}
				}
			}
			{
				if (true) {
					throw ((java.lang.Error) (jjte000));
				}
			}
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
		throw new java.lang.Error("Missing return statement in function");
	}

	public final void array() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTARRAY)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		us.monoid.web.jp.javacc.Token i;
		try {
			jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.OPEN_ARRAY);
			switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.INTEGER :
					i = jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.INTEGER);
					jjtn000.value = new java.lang.Integer(i.image);
					break;
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.OPEN_ARRAY :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.CNAME :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.NOT :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.NUMBER :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.IDENTIFIER :
				case 23 :
					selector();
					break;
				default :
					jj_la1[3] = jj_gen;
					jj_consume_token(-1);
					throw new us.monoid.web.jp.javacc.ParseException();
			}
			jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.CLOSE_ARRAY);
		} catch (java.lang.Throwable jjte000) {
			if (jjtc000) {
				jjtree.clearNodeScope(jjtn000);
				jjtc000 = false;
			} else {
				jjtree.popNode();
			}
			if (jjte000 instanceof java.lang.RuntimeException) {
				{
					if (true) {
						throw ((java.lang.RuntimeException) (jjte000));
					}
				}
			}
			if (jjte000 instanceof us.monoid.web.jp.javacc.ParseException) {
				{
					if (true) {
						throw ((us.monoid.web.jp.javacc.ParseException) (jjte000));
					}
				}
			}
			{
				if (true) {
					throw ((java.lang.Error) (jjte000));
				}
			}
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
	}

	public final void selector() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTSELECTOR)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		try {
			term();
			label_2 : while (true) {
				switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
					case us.monoid.web.jp.javacc.JSONPathCompilerConstants.OR :
						break;
					default :
						jj_la1[4] = jj_gen;
						break label_2;
				}
				jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.OR);
				term();
			} 
		} catch (java.lang.Throwable jjte000) {
			if (jjtc000) {
				jjtree.clearNodeScope(jjtn000);
				jjtc000 = false;
			} else {
				jjtree.popNode();
			}
			if (jjte000 instanceof java.lang.RuntimeException) {
				{
					if (true) {
						throw ((java.lang.RuntimeException) (jjte000));
					}
				}
			}
			if (jjte000 instanceof us.monoid.web.jp.javacc.ParseException) {
				{
					if (true) {
						throw ((us.monoid.web.jp.javacc.ParseException) (jjte000));
					}
				}
			}
			{
				if (true) {
					throw ((java.lang.Error) (jjte000));
				}
			}
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
	}

	public final void term() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTTERM)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		try {
			neg();
			label_3 : while (true) {
				switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
					case us.monoid.web.jp.javacc.JSONPathCompilerConstants.AND :
						break;
					default :
						jj_la1[5] = jj_gen;
						break label_3;
				}
				jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.AND);
				neg();
			} 
		} catch (java.lang.Throwable jjte000) {
			if (jjtc000) {
				jjtree.clearNodeScope(jjtn000);
				jjtc000 = false;
			} else {
				jjtree.popNode();
			}
			if (jjte000 instanceof java.lang.RuntimeException) {
				{
					if (true) {
						throw ((java.lang.RuntimeException) (jjte000));
					}
				}
			}
			if (jjte000 instanceof us.monoid.web.jp.javacc.ParseException) {
				{
					if (true) {
						throw ((us.monoid.web.jp.javacc.ParseException) (jjte000));
					}
				}
			}
			{
				if (true) {
					throw ((java.lang.Error) (jjte000));
				}
			}
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
	}

	public final void neg() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTNEG)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		us.monoid.web.jp.javacc.Token n = null;
		try {
			switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.NOT :
					n = jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.NOT);
					break;
				default :
					jj_la1[6] = jj_gen;
			}
			part();
			jjtree.closeNodeScope(jjtn000, true);
			jjtc000 = false;
			if (n != null) {
				jjtn000.value = java.lang.Boolean.FALSE;
			}
		} catch (java.lang.Throwable jjte000) {
			if (jjtc000) {
				jjtree.clearNodeScope(jjtn000);
				jjtc000 = false;
			} else {
				jjtree.popNode();
			}
			if (jjte000 instanceof java.lang.RuntimeException) {
				{
					if (true) {
						throw ((java.lang.RuntimeException) (jjte000));
					}
				}
			}
			if (jjte000 instanceof us.monoid.web.jp.javacc.ParseException) {
				{
					if (true) {
						throw ((us.monoid.web.jp.javacc.ParseException) (jjte000));
					}
				}
			}
			{
				if (true) {
					throw ((java.lang.Error) (jjte000));
				}
			}
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
	}

	public final void part() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTPART)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		try {
			switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.OPEN_ARRAY :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.CNAME :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.INTEGER :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.NUMBER :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.IDENTIFIER :
					predicate();
					break;
				case 23 :
					jj_consume_token(23);
					selector();
					jj_consume_token(24);
					break;
				default :
					jj_la1[7] = jj_gen;
					jj_consume_token(-1);
					throw new us.monoid.web.jp.javacc.ParseException();
			}
		} catch (java.lang.Throwable jjte000) {
			if (jjtc000) {
				jjtree.clearNodeScope(jjtn000);
				jjtc000 = false;
			} else {
				jjtree.popNode();
			}
			if (jjte000 instanceof java.lang.RuntimeException) {
				{
					if (true) {
						throw ((java.lang.RuntimeException) (jjte000));
					}
				}
			}
			if (jjte000 instanceof us.monoid.web.jp.javacc.ParseException) {
				{
					if (true) {
						throw ((us.monoid.web.jp.javacc.ParseException) (jjte000));
					}
				}
			}
			{
				if (true) {
					throw ((java.lang.Error) (jjte000));
				}
			}
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
	}

	public final void predicate() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTPREDICATE)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr leftExpr;
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr rightExpr = null;
		us.monoid.web.jp.javacc.Token test = null;
		try {
			leftExpr = primaryExpr();
			switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.OP :
					test = jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.OP);
					rightExpr = primaryExpr();
					break;
				default :
					jj_la1[8] = jj_gen;
			}
			jjtree.closeNodeScope(jjtn000, true);
			jjtc000 = false;
			jjtn000.value = new us.monoid.web.jp.javacc.Predicates.Operator(leftExpr, test.image, rightExpr);
		} catch (java.lang.Throwable jjte000) {
			if (jjtc000) {
				jjtree.clearNodeScope(jjtn000);
				jjtc000 = false;
			} else {
				jjtree.popNode();
			}
			if (jjte000 instanceof java.lang.RuntimeException) {
				{
					if (true) {
						throw ((java.lang.RuntimeException) (jjte000));
					}
				}
			}
			if (jjte000 instanceof us.monoid.web.jp.javacc.ParseException) {
				{
					if (true) {
						throw ((us.monoid.web.jp.javacc.ParseException) (jjte000));
					}
				}
			}
			{
				if (true) {
					throw ((java.lang.Error) (jjte000));
				}
			}
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
	}

	public final us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr primaryExpr() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTEXPRESSION)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		try {
			switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.OPEN_ARRAY :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.IDENTIFIER :
					expr();
					break;
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.CNAME :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.INTEGER :
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.NUMBER :
					literalOrNumber();
					break;
				default :
					jj_la1[9] = jj_gen;
					jj_consume_token(-1);
					throw new us.monoid.web.jp.javacc.ParseException();
			}
			jjtree.closeNodeScope(jjtn000, true);
			jjtc000 = false;
			{
				if (true) {
					return jjtn000;
				}
			}
		} catch (java.lang.Throwable jjte000) {
			if (jjtc000) {
				jjtree.clearNodeScope(jjtn000);
				jjtc000 = false;
			} else {
				jjtree.popNode();
			}
			if (jjte000 instanceof java.lang.RuntimeException) {
				{
					if (true) {
						throw ((java.lang.RuntimeException) (jjte000));
					}
				}
			}
			if (jjte000 instanceof us.monoid.web.jp.javacc.ParseException) {
				{
					if (true) {
						throw ((us.monoid.web.jp.javacc.ParseException) (jjte000));
					}
				}
			}
			{
				if (true) {
					throw ((java.lang.Error) (jjte000));
				}
			}
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
		throw new java.lang.Error("Missing return statement in function");
	}

	public final us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr literalOrNumber() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTIMAGE)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		us.monoid.web.jp.javacc.Token string = null;
		us.monoid.web.jp.javacc.Token number = null;
		try {
			switch (jj_ntk == (-1) ? jj_ntk() : jj_ntk) {
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.CNAME :
					string = jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.CNAME);
					break;
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.NUMBER :
					number = jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.NUMBER);
					break;
				case us.monoid.web.jp.javacc.JSONPathCompilerConstants.INTEGER :
					number = jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.INTEGER);
					break;
				default :
					jj_la1[10] = jj_gen;
					jj_consume_token(-1);
					throw new us.monoid.web.jp.javacc.ParseException();
			}
			jjtree.closeNodeScope(jjtn000, true);
			jjtc000 = false;
			if (number != null) {
				jjtn000.value = new java.lang.Double(number.image);
			} else if (string != null) {
				jjtn000.value = string.image.substring(1, string.image.length() - 1);
			}
			{
				if (true) {
					return jjtn000;
				}
			}
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
		throw new java.lang.Error("Missing return statement in function");
	}

	public final void object() throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr jjtn000 = ((us.monoid.web.jp.javacc.JSONPathCompiler.JSONPathExpr) (us.monoid.web.jp.javacc.JSONPathCompiler.jjtCreate(us.monoid.web.jp.javacc.JSONPathCompilerTreeConstants.JJTOBJECT)));
		boolean jjtc000 = true;
		jjtree.openNodeScope(jjtn000);
		us.monoid.web.jp.javacc.Token name;
		try {
			name = jj_consume_token(us.monoid.web.jp.javacc.JSONPathCompilerConstants.IDENTIFIER);
			jjtree.closeNodeScope(jjtn000, true);
			jjtc000 = false;
			jjtn000.value = name.image;
		} finally {
			if (jjtc000) {
				jjtree.closeNodeScope(jjtn000, true);
			}
		}
	}

	public us.monoid.web.jp.javacc.JSONPathCompilerTokenManager token_source;

	us.monoid.web.jp.javacc.SimpleCharStream jj_input_stream;

	public us.monoid.web.jp.javacc.Token token;

	public us.monoid.web.jp.javacc.Token jj_nt;

	private int jj_ntk;

	private int jj_gen;

	private final int[] jj_la1 = new int[11];

	private static int[] jj_la1_0;

	static {
		jj_la1_init_0();
	}

	private static void jj_la1_init_0() {
		us.monoid.web.jp.javacc.JSONPathCompiler.jj_la1_0 = new int[]{ 0x400020, 0x1020, 0x1020, 0xc68120, 0x2000, 0x4000, 0x8000, 0xc60120, 0x10000, 0x460120, 0x60100 };
	}

	public JSONPathCompiler(java.io.InputStream stream) {
		this(stream, null);
	}

	public JSONPathCompiler(java.io.InputStream stream, java.lang.String encoding) {
		try {
			jj_input_stream = new us.monoid.web.jp.javacc.SimpleCharStream(stream, encoding, 1, 1);
		} catch (java.io.UnsupportedEncodingException e) {
			throw new java.lang.RuntimeException(e);
		}
		token_source = new us.monoid.web.jp.javacc.JSONPathCompilerTokenManager(jj_input_stream);
		token = new us.monoid.web.jp.javacc.Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 11; i++) {
			jj_la1[i] = -1;
		}
	}

	public void ReInit(java.io.InputStream stream) {
		ReInit(stream, null);
	}

	public void ReInit(java.io.InputStream stream, java.lang.String encoding) {
		try {
			jj_input_stream.ReInit(stream, encoding, 1, 1);
		} catch (java.io.UnsupportedEncodingException e) {
			throw new java.lang.RuntimeException(e);
		}
		token_source.ReInit(jj_input_stream);
		token = new us.monoid.web.jp.javacc.Token();
		jj_ntk = -1;
		jjtree.reset();
		jj_gen = 0;
		for (int i = 0; i < 11; i++) {
			jj_la1[i] = -1;
		}
	}

	public JSONPathCompiler(java.io.Reader stream) {
		jj_input_stream = new us.monoid.web.jp.javacc.SimpleCharStream(stream, 1, 1);
		token_source = new us.monoid.web.jp.javacc.JSONPathCompilerTokenManager(jj_input_stream);
		token = new us.monoid.web.jp.javacc.Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 11; i++) {
			jj_la1[i] = -1;
		}
	}

	public void ReInit(java.io.Reader stream) {
		jj_input_stream.ReInit(stream, 1, 1);
		token_source.ReInit(jj_input_stream);
		token = new us.monoid.web.jp.javacc.Token();
		jj_ntk = -1;
		jjtree.reset();
		jj_gen = 0;
		for (int i = 0; i < 11; i++) {
			jj_la1[i] = -1;
		}
	}

	public JSONPathCompiler(us.monoid.web.jp.javacc.JSONPathCompilerTokenManager tm) {
		token_source = tm;
		token = new us.monoid.web.jp.javacc.Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 11; i++) {
			jj_la1[i] = -1;
		}
	}

	public void ReInit(us.monoid.web.jp.javacc.JSONPathCompilerTokenManager tm) {
		token_source = tm;
		token = new us.monoid.web.jp.javacc.Token();
		jj_ntk = -1;
		jjtree.reset();
		jj_gen = 0;
		for (int i = 0; i < 11; i++) {
			jj_la1[i] = -1;
		}
	}

	private us.monoid.web.jp.javacc.Token jj_consume_token(int kind) throws us.monoid.web.jp.javacc.ParseException {
		us.monoid.web.jp.javacc.Token oldToken;
		if ((oldToken = token).next != null) {
			token = token.next;
		} else {
			token = token.next = token_source.getNextToken();
		}
		jj_ntk = -1;
		if (token.kind == kind) {
			jj_gen++;
			return token;
		}
		token = oldToken;
		jj_kind = kind;
		throw generateParseException();
	}

	public final us.monoid.web.jp.javacc.Token getNextToken() {
		if (token.next != null) {
			token = token.next;
		} else {
			token = token.next = token_source.getNextToken();
		}
		jj_ntk = -1;
		jj_gen++;
		return token;
	}

	public final us.monoid.web.jp.javacc.Token getToken(int index) {
		us.monoid.web.jp.javacc.Token t = token;
		for (int i = 0; i < index; i++) {
			if (t.next != null) {
				t = t.next;
			} else {
				t = t.next = token_source.getNextToken();
			}
		}
		return t;
	}

	private int jj_ntk() {
		if ((jj_nt = token.next) == null) {
			return jj_ntk = (token.next = token_source.getNextToken()).kind;
		} else {
			return jj_ntk = jj_nt.kind;
		}
	}

	private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();

	private int[] jj_expentry;

	private int jj_kind = -1;

	public us.monoid.web.jp.javacc.ParseException generateParseException() {
		jj_expentries.clear();
		boolean[] la1tokens = new boolean[25];
		if (jj_kind >= 0) {
			la1tokens[jj_kind] = true;
			jj_kind = -1;
		}
		for (int i = 0; i < 11; i++) {
			if (jj_la1[i] == jj_gen) {
				for (int j = 0; j < 32; j++) {
					if ((us.monoid.web.jp.javacc.JSONPathCompiler.jj_la1_0[i] & (1 << j)) != 0) {
						la1tokens[j] = true;
					}
				}
			}
		}
		for (int i = 0; i < 25; i++) {
			if (la1tokens[i]) {
				jj_expentry = new int[1];
				jj_expentry[0] = i;
				jj_expentries.add(jj_expentry);
			}
		}
		int[][] exptokseq = new int[jj_expentries.size()][];
		for (int i = 0; i < jj_expentries.size(); i++) {
			exptokseq[i] = jj_expentries.get(i);
		}
		return new us.monoid.web.jp.javacc.ParseException(token, exptokseq, us.monoid.web.jp.javacc.JSONPathCompilerConstants.tokenImage);
	}

	public final void enable_tracing() {
	}

	public final void disable_tracing() {
	}
}