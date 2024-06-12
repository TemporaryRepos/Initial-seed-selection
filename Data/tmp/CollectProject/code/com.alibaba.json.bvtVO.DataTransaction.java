@java.lang.SuppressWarnings("rawtypes")
public class DataTransaction implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private com.alibaba.json.bvtVO.DataTransaction.Head head = new com.alibaba.json.bvtVO.DataTransaction.Head();

	private com.alibaba.json.bvtVO.DataTransaction.Body body = new com.alibaba.json.bvtVO.DataTransaction.Body();

	public DataTransaction() {
	}

	public static class Head {
		private java.lang.String appid;

		private java.lang.String transcode;

		private java.lang.String seqno;

		private com.alibaba.json.bvtVO.DataTransaction.Head.User user = new com.alibaba.json.bvtVO.DataTransaction.Head.User();

		private com.alibaba.json.bvtVO.DataTransaction.Head.Ret ret = new com.alibaba.json.bvtVO.DataTransaction.Head.Ret();

		public static class User {
			private java.lang.String id;

			public java.lang.String getId() {
				return id;
			}

			public void setId(java.lang.String id) {
				this.id = id;
			}
		}

		public static class Ret {
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

		public com.alibaba.json.bvtVO.DataTransaction.Head.User getUser() {
			return user;
		}

		public void setUser(com.alibaba.json.bvtVO.DataTransaction.Head.User user) {
			this.user = user;
		}

		public com.alibaba.json.bvtVO.DataTransaction.Head.Ret getRet() {
			return ret;
		}

		public void setRet(com.alibaba.json.bvtVO.DataTransaction.Head.Ret ret) {
			this.ret = ret;
		}

		public void setRetCode(java.lang.String code) {
			this.ret.code = code;
		}

		public void setRetMsg(java.lang.String msg) {
			this.ret.msg = msg;
		}
	}

	public static class Body {
		private com.alibaba.json.bvtVO.DataTransaction.Body.Param param = new com.alibaba.json.bvtVO.DataTransaction.Body.Param();

		private com.alibaba.json.bvtVO.DataTransaction.Body.DataSet dataset;

		public Body() {
		}

		public static class Param {
			private com.alibaba.json.bvtVO.DataTransaction.Body.Param.Limit limit = new com.alibaba.json.bvtVO.DataTransaction.Body.Param.Limit();

			private java.util.Map<java.lang.String, java.lang.String> form = new java.util.HashMap<java.lang.String, java.lang.String>();

			public static class Limit {
				private java.lang.String start;

				private java.lang.String size;

				private java.lang.String total;

				private java.lang.String orderBy;

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

				public java.lang.String getOrderBy() {
					return orderBy;
				}

				public void setOrderBy(java.lang.String orderBy) {
					this.orderBy = orderBy;
				}
			}

			public com.alibaba.json.bvtVO.DataTransaction.Body.Param.Limit getLimit() {
				return limit;
			}

			public void setLimit(com.alibaba.json.bvtVO.DataTransaction.Body.Param.Limit limit) {
				this.limit = limit;
			}

			public java.util.Map<java.lang.String, java.lang.String> getForm() {
				return form;
			}

			public void setForm(java.util.Map<java.lang.String, java.lang.String> form) {
				this.form = form;
			}
		}

		public static class DataSet {
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

		public com.alibaba.json.bvtVO.DataTransaction.Body.Param getParam() {
			return param;
		}

		public void setParam(com.alibaba.json.bvtVO.DataTransaction.Body.Param param) {
			this.param = param;
		}

		public com.alibaba.json.bvtVO.DataTransaction.Body.DataSet getDataset() {
			return dataset;
		}

		public void setDataset(com.alibaba.json.bvtVO.DataTransaction.Body.DataSet dataset) {
			this.dataset = dataset;
		}

		public void setDataset(java.lang.String total, java.util.List rows) {
			com.alibaba.json.bvtVO.DataTransaction.Body.DataSet ds = new com.alibaba.json.bvtVO.DataTransaction.Body.DataSet();
			ds.setTotal(total);
			ds.setRows(rows);
			this.setDataset(ds);
		}
	}

	public com.alibaba.json.bvtVO.DataTransaction.Head getHead() {
		return head;
	}

	public com.alibaba.json.bvtVO.DataTransaction.Body getBody() {
		return body;
	}

	public void setRetMsgCode(java.lang.String code, java.lang.String msg) {
		this.head.setRetCode(code);
		this.head.setRetMsg(msg);
	}

	public void setRetMsgCode(java.lang.String code) {
		this.setRetMsgCode(code, null);
	}

	public void setDataSet(java.lang.String total, java.util.List rows) {
		this.body.setDataset(total, rows);
	}

	public static com.alibaba.json.bvtVO.DataTransaction fromJSON(java.lang.String jsonString) {
		return com.alibaba.fastjson.JSON.parseObject(jsonString, com.alibaba.json.bvtVO.DataTransaction.class);
	}

	public java.lang.String toJSON() {
		return com.alibaba.fastjson.JSON.toJSONString(this);
	}

	public static void main(java.lang.String[] args) {
		com.alibaba.json.bvtVO.DataTransaction dt = new com.alibaba.json.bvtVO.DataTransaction();
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list = new java.util.ArrayList<java.util.Map<java.lang.String, java.lang.Object>>();
		java.util.Map<java.lang.String, java.lang.Object> m = new java.util.HashMap<java.lang.String, java.lang.Object>();
		m.put("name", "tom");
		m.put("sex", "m");
		list.add(m);
		dt.setDataSet("1000", list);
		dt.setRetMsgCode("1", "ok");
		dt.getHead().setAppid("back");
		dt.getHead().setSeqno("201010");
		dt.getHead().getUser().setId("root");
		java.util.Map<java.lang.String, java.lang.String> m2 = new java.util.HashMap<java.lang.String, java.lang.String>();
		m2.put("name1", "tom");
		m2.put("name2", "tom");
		m2.put("name3", "tom");
		dt.getBody().getParam().setForm(m2);
		java.lang.System.out.println(dt.toJSON());
		com.alibaba.json.bvtVO.DataTransaction dt2 = com.alibaba.json.bvtVO.DataTransaction.fromJSON(dt.toJSON());
		java.lang.System.out.println(dt2.toJSON());
	}
}