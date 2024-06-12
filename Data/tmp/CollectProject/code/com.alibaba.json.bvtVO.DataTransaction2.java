public class DataTransaction2 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private com.alibaba.json.bvtVO.DataTransaction2.Head head = new com.alibaba.json.bvtVO.DataTransaction2.Head();

	private com.alibaba.json.bvtVO.DataTransaction2.Body body = new com.alibaba.json.bvtVO.DataTransaction2.Body();

	public DataTransaction2() {
	}

	class Head {
		private java.lang.String appid;

		private java.lang.String transcode;

		private java.lang.String seqno;

		private com.alibaba.json.bvtVO.DataTransaction2.Head.User user = new com.alibaba.json.bvtVO.DataTransaction2.Head.User();

		private com.alibaba.json.bvtVO.DataTransaction2.Head.Ret ret = new com.alibaba.json.bvtVO.DataTransaction2.Head.Ret();

		public Head() {
		}

		class User {
			private java.lang.String id;

			public java.lang.String getId() {
				return id;
			}

			public void setId(java.lang.String id) {
				this.id = id;
			}
		}

		class Ret {
			private java.lang.String code;

			private java.lang.String msg;

			public java.lang.String getCode() {
				return code;
			}

			public void setCode(java.lang.String code) {
				this.code = code;
			}

			public java.lang.String getMsg() {
				return msg;
			}

			public void setMsg(java.lang.String msg) {
				this.msg = msg;
			}
		}

		public java.lang.String getAppid() {
			return appid;
		}

		public void setAppid(java.lang.String appid) {
			this.appid = appid;
		}

		public java.lang.String getTranscode() {
			return transcode;
		}

		public void setTranscode(java.lang.String transcode) {
			this.transcode = transcode;
		}

		public java.lang.String getSeqno() {
			return seqno;
		}

		public void setSeqno(java.lang.String seqno) {
			this.seqno = seqno;
		}

		public com.alibaba.json.bvtVO.DataTransaction2.Head.User getUser() {
			return user;
		}

		public void setUser(com.alibaba.json.bvtVO.DataTransaction2.Head.User user) {
			this.user = user;
		}

		public com.alibaba.json.bvtVO.DataTransaction2.Head.Ret getRet() {
			return ret;
		}

		public void setRet(com.alibaba.json.bvtVO.DataTransaction2.Head.Ret ret) {
			this.ret = ret;
		}

		public void setRetCode(java.lang.String code) {
			this.ret.code = code;
		}

		public void setRetMsg(java.lang.String msg) {
			this.ret.msg = msg;
		}
	}

	@java.lang.SuppressWarnings("rawtypes")
	class Body {
		private com.alibaba.json.bvtVO.DataTransaction2.Body.Param param = new com.alibaba.json.bvtVO.DataTransaction2.Body.Param();

		private com.alibaba.json.bvtVO.DataTransaction2.Body.DataSet dataset = new com.alibaba.json.bvtVO.DataTransaction2.Body.DataSet();

		public Body() {
		}

		class Param {
			private com.alibaba.json.bvtVO.DataTransaction2.Body.Param.Limit limit = new com.alibaba.json.bvtVO.DataTransaction2.Body.Param.Limit();

			private java.util.Map<java.lang.String, java.lang.String> form = new java.util.HashMap<java.lang.String, java.lang.String>();

			class Limit {
				private java.lang.String start;

				private java.lang.String size;

				private java.lang.String total;

				public java.lang.String getStart() {
					return start;
				}

				public void setStart(java.lang.String start) {
					this.start = start;
				}

				public java.lang.String getSize() {
					return size;
				}

				public void setSize(java.lang.String size) {
					this.size = size;
				}

				public java.lang.String getTotal() {
					return total;
				}

				public void setTotal(java.lang.String total) {
					this.total = total;
				}
			}

			public com.alibaba.json.bvtVO.DataTransaction2.Body.Param.Limit getLimit() {
				return limit;
			}

			public void setLimit(com.alibaba.json.bvtVO.DataTransaction2.Body.Param.Limit limit) {
				this.limit = limit;
			}

			public java.util.Map<java.lang.String, java.lang.String> getForm() {
				return form;
			}

			public void setForm(java.util.Map<java.lang.String, java.lang.String> form) {
				this.form = form;
			}
		}

		class DataSet {
			private java.lang.String total;

			private java.util.List rows = new java.util.ArrayList();

			public java.lang.String getTotal() {
				return total;
			}

			public void setTotal(java.lang.String total) {
				this.total = total;
			}

			public java.util.List getRows() {
				return rows;
			}

			public void setRows(java.util.List rows) {
				this.rows = rows;
			}
		}

		public com.alibaba.json.bvtVO.DataTransaction2.Body.Param getParam() {
			return param;
		}

		public void setParam(com.alibaba.json.bvtVO.DataTransaction2.Body.Param param) {
			this.param = param;
		}

		public com.alibaba.json.bvtVO.DataTransaction2.Body.DataSet getDataset() {
			return dataset;
		}

		public void setDataset(com.alibaba.json.bvtVO.DataTransaction2.Body.DataSet dataset) {
			this.dataset = dataset;
		}

		public void setDataset(java.lang.String total, java.util.List rows) {
			com.alibaba.json.bvtVO.DataTransaction2.Body.DataSet ds = new com.alibaba.json.bvtVO.DataTransaction2.Body.DataSet();
			ds.setTotal(total);
			ds.setRows(rows);
			this.dataset = ds;
		}
	}

	public com.alibaba.json.bvtVO.DataTransaction2.Head getHead() {
		return head;
	}

	public com.alibaba.json.bvtVO.DataTransaction2.Body getBody() {
		return body;
	}

	public void setHead(com.alibaba.json.bvtVO.DataTransaction2.Head head) {
		this.head = head;
	}

	public void setBody(com.alibaba.json.bvtVO.DataTransaction2.Body body) {
		this.body = body;
	}

	public void setRetMsgCode(java.lang.String code, java.lang.String msg) {
		this.head.setRetCode(code);
		this.head.setRetMsg(msg);
	}

	public void setRetMsgCode(java.lang.String code) {
		this.setRetMsgCode(code, null);
	}

	@java.lang.SuppressWarnings("rawtypes")
	public void setDataSet(java.lang.String total, java.util.List rows) {
		this.body.setDataset(total, rows);
	}

	public static com.alibaba.json.bvtVO.DataTransaction2 fromJSON(java.lang.String jsonString) {
		return com.alibaba.fastjson.JSON.parseObject(jsonString, com.alibaba.json.bvtVO.DataTransaction2.class);
	}

	public java.lang.String toJSON() {
		return com.alibaba.fastjson.JSON.toJSONString(this);
	}

	public static void main(java.lang.String[] args) {
		java.lang.String jsonString = "{'head' : {'appid':'epas','transcode' : '000000','seqno' : '111111111',        'user' : {          'id' : '00000'},        'ret' : {           'code' : '1',           'msg' : 'txt'}  },  'body' : {      param : {           form:{              name : '111',               sex : '1',              address : 'street1',                array : [ {                 id : '1',                   name : 'tom1'               }, {                    id : '2',                   name : 'tom2'               } ]},           limit : {               start : 1,              size : 25,              total : 100}        },      dataset : {         total : 1000,           rows : [ {              id : 'id',              name : 'name'           }, {                id : 'id',              name : 'name'           } ]     }   }}";
		com.alibaba.json.bvtVO.DataTransaction2 dt = com.alibaba.json.bvtVO.DataTransaction2.fromJSON(jsonString);
		java.lang.System.out.println(dt.toJSON());
		com.alibaba.json.bvtVO.DataTransaction2 dt1 = com.alibaba.fastjson.JSON.parseObject(dt.toJSON(), com.alibaba.json.bvtVO.DataTransaction2.class);
		java.lang.System.out.println(dt1.toJSON());
		org.junit.Assert.assertEquals(dt.toJSON(), dt1.toJSON());
		java.lang.System.out.println("=================");
		java.lang.System.out.println(dt.toJSON());
		dt.setRetMsgCode("-1", "错误");
		dt.setDataSet("1000", new java.util.ArrayList<java.util.Map<java.lang.String, java.lang.Object>>());
		java.lang.System.out.println(dt.toJSON());
		java.lang.String text = dt.toJSON();
		java.lang.System.out.println(text);
		com.alibaba.json.bvtVO.DataTransaction2 dt2 = com.alibaba.fastjson.JSON.parseObject(text, com.alibaba.json.bvtVO.DataTransaction2.class);
		java.lang.System.out.println(com.alibaba.fastjson.JSON.toJSONString(dt2));
		org.junit.Assert.assertEquals(dt.toJSON(), dt2.toJSON());
	}
}