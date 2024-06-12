public final class EsUtil {
	private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(com.pancm.elasticsearch.EsHighLevelRestSearchTest.class);

	private EsUtil() {
	}

	public static void main(java.lang.String[] args) {
		try {
			com.pancm.elasticsearch.EsUtil.build("192.169.0.23:9200");
			java.lang.System.out.println("ES连接初始化成功!");
			java.lang.String index = "student";
			java.lang.String type = "_doc";
			java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list = new java.util.ArrayList<>();
			for (int i = 0; i < 10; i++) {
				java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
				map.put("id", i);
				map.put("name", "张三" + i);
				map.put("age", 10 + i);
				list.add(map);
			}
			com.pancm.elasticsearch.EsUtil.setIsAutoClose(false);
			com.pancm.elasticsearch.EsUtil.saveBulk(list, index, type, "id");
			java.lang.System.out.println("批量写入成功!");
			java.lang.System.out.println("查询的结果1:" + com.pancm.elasticsearch.EsUtil.queryById(index, type, "1"));
			org.elasticsearch.index.query.QueryBuilder queryBuilder = new org.elasticsearch.index.query.TermQueryBuilder("name", "xuwujing");
			java.lang.System.out.println("更新的结果:" + com.pancm.elasticsearch.EsUtil.updateByQuery(index, type, queryBuilder));
			java.lang.System.out.println("查询的结果2:" + com.pancm.elasticsearch.EsUtil.queryById(index, type, "1"));
			org.elasticsearch.index.query.QueryBuilder queryBuilder3 = org.elasticsearch.index.query.QueryBuilders.matchAllQuery();
			java.lang.System.out.println("查询的结果3:" + com.pancm.elasticsearch.EsUtil.query(index, type, queryBuilder3));
			org.elasticsearch.index.query.QueryBuilder queryBuilder4 = org.elasticsearch.index.query.QueryBuilders.rangeQuery("age").from(15);
			org.elasticsearch.index.query.QueryBuilder queryBuilder5 = org.elasticsearch.index.query.QueryBuilders.rangeQuery("id").from(5);
			java.lang.System.out.println("查询的结果4:" + com.pancm.elasticsearch.EsUtil.query(index, type, queryBuilder4, queryBuilder5));
			com.pancm.elasticsearch.EsQueryCondition esQueryCondition = new com.pancm.elasticsearch.EsQueryCondition();
			esQueryCondition.setCloseSource(true);
			esQueryCondition.setIndex(1);
			esQueryCondition.setPagesize(3);
			esQueryCondition.setOrder("desc");
			esQueryCondition.setOrderField(new java.lang.String[]{ "age" });
			java.lang.String[] incStrings = new java.lang.String[]{ "age", "name" };
			esQueryCondition.setIncludeFields(incStrings);
			esQueryCondition.setExcludeFields(new java.lang.String[]{ "id" });
			java.lang.System.out.println("查询的结果5:" + com.pancm.elasticsearch.EsUtil.query(index, type, esQueryCondition, queryBuilder4));
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				com.pancm.elasticsearch.EsUtil.close();
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void createIndexTest() throws java.io.IOException {
		java.util.Map<java.lang.String, java.lang.Object> setmapping = new java.util.HashMap<>();
		setmapping.put("number_of_shards", 12);
		setmapping.put("number_of_routing_shards", 24);
		setmapping.put("number_of_replicas", 1);
		setmapping.put("refresh_interval", "5s");
		java.lang.String index = "test5";
		java.lang.String type = "test5";
		java.lang.String alias = "test";
		java.util.Map<java.lang.String, java.lang.Object> jsonMap2 = new java.util.HashMap<>();
		java.util.Map<java.lang.String, java.lang.Object> message = new java.util.HashMap<>();
		message.put("type", "text");
		java.util.Map<java.lang.String, java.lang.Object> properties = new java.util.HashMap<>();
		properties.put("msg", message);
		java.util.Map<java.lang.String, java.lang.Object> mapping = new java.util.HashMap<>();
		mapping.put("properties", properties);
		jsonMap2.put(type, mapping);
		java.lang.String mappings = jsonMap2.toString();
		com.pancm.elasticsearch.EsBasicModelConfig esBasicModelConfig = new com.pancm.elasticsearch.EsBasicModelConfig();
		esBasicModelConfig.setIndex(index);
		esBasicModelConfig.setType(type);
		esBasicModelConfig.setMappings(mappings);
		esBasicModelConfig.setSettings(setmapping);
		esBasicModelConfig.setAlias(alias);
		com.pancm.elasticsearch.EsUtil.creatIndex(esBasicModelConfig);
	}

	public static void build(java.lang.String... nodes) {
		java.util.Objects.requireNonNull(nodes, "hosts can not null");
		java.util.ArrayList<org.apache.http.HttpHost> ahosts = new java.util.ArrayList<org.apache.http.HttpHost>();
		for (java.lang.String host : nodes) {
			com.pancm.elasticsearch.IpHandler addr = new com.pancm.elasticsearch.IpHandler();
			addr.IpPortFromUrl(host);
			ahosts.add(new org.apache.http.HttpHost(addr.getIp(), addr.getPort()));
		}
		com.pancm.elasticsearch.EsUtil.httpHosts = ahosts.toArray(new org.apache.http.HttpHost[0]);
		com.pancm.elasticsearch.EsUtil.init();
	}

	public static boolean creatIndex(com.pancm.elasticsearch.EsBasicModelConfig esBasicModelConfig) throws java.io.IOException {
		boolean falg = true;
		java.util.Objects.requireNonNull(esBasicModelConfig, "esBasicModelConfig is not null");
		java.lang.String type = java.util.Objects.requireNonNull(esBasicModelConfig.getType(), "type is not null");
		java.lang.String index = java.util.Objects.requireNonNull(esBasicModelConfig.getIndex(), "index is not null");
		if (com.pancm.elasticsearch.EsUtil.exitsIndex(index)) {
			com.pancm.elasticsearch.EsUtil.logger.warn("索引库{}已经存在!无需在进行创建!", index);
			return true;
		}
		java.lang.String mapping = esBasicModelConfig.getMappings();
		java.util.Map<java.lang.String, java.lang.Object> setting = esBasicModelConfig.getSettings();
		java.lang.String alias = esBasicModelConfig.getAlias();
		org.elasticsearch.action.admin.indices.create.CreateIndexRequest request = new org.elasticsearch.action.admin.indices.create.CreateIndexRequest(index);
		try {
			if (java.util.Objects.nonNull(mapping)) {
				request.mapping(type, mapping);
			}
			if (java.util.Objects.nonNull(setting)) {
				request.settings(setting);
			}
			if (java.util.Objects.nonNull(alias)) {
				request.alias(new org.elasticsearch.action.admin.indices.alias.Alias(alias));
			}
			org.elasticsearch.action.admin.indices.create.CreateIndexResponse createIndexResponse = com.pancm.elasticsearch.EsUtil.client.indices().create(request, org.elasticsearch.client.RequestOptions.DEFAULT);
			falg = createIndexResponse.isAcknowledged();
		} catch (java.io.IOException e) {
			throw e;
		} finally {
			if (com.pancm.elasticsearch.EsUtil.isAutoClose) {
				com.pancm.elasticsearch.EsUtil.close();
			}
		}
		return falg;
	}

	public static boolean exitsIndex(java.lang.String index) throws java.io.IOException {
		try {
			org.elasticsearch.action.admin.indices.get.GetIndexRequest getRequest = new org.elasticsearch.action.admin.indices.get.GetIndexRequest();
			getRequest.indices(index);
			getRequest.local(false);
			getRequest.humanReadable(true);
			return com.pancm.elasticsearch.EsUtil.client.indices().exists(getRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		} finally {
			if (com.pancm.elasticsearch.EsUtil.isAutoClose) {
				com.pancm.elasticsearch.EsUtil.close();
			}
		}
	}

	public static boolean save(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String index, java.lang.String type) throws java.io.IOException {
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> mapList = new java.util.ArrayList<>();
		mapList.add(map);
		return com.pancm.elasticsearch.EsUtil.saveBulk(mapList, index, type, null);
	}

	public static boolean saveBulk(java.util.List<java.util.Map<java.lang.String, java.lang.Object>> mapList, java.lang.String index, java.lang.String type) throws java.io.IOException {
		return com.pancm.elasticsearch.EsUtil.saveBulk(mapList, index, type, null);
	}

	public static boolean saveBulk(java.util.List<java.util.Map<java.lang.String, java.lang.Object>> mapList, java.lang.String index, java.lang.String type, java.lang.String key) throws java.io.IOException {
		if ((mapList == null) || (mapList.size() == 0)) {
			return true;
		}
		if ((((index == null) || (index.trim().length() == 0)) || (type == null)) || (type.trim().length() == 0)) {
			return false;
		}
		try {
			org.elasticsearch.action.bulk.BulkRequest request = new org.elasticsearch.action.bulk.BulkRequest();
			mapList.forEach(( map) -> {
				if (key != null) {
					java.lang.String id = map.get(key) + "";
					if ((id == null) || (id.trim().length() == 0)) {
						request.add(new org.elasticsearch.action.index.IndexRequest(index, type).source(map, org.elasticsearch.common.xcontent.XContentType.JSON));
					} else {
						request.add(new org.elasticsearch.action.index.IndexRequest(index, type, id).source(map, org.elasticsearch.common.xcontent.XContentType.JSON));
					}
				} else {
					request.add(new org.elasticsearch.action.index.IndexRequest(index, type).source(map, org.elasticsearch.common.xcontent.XContentType.JSON));
				}
			});
			org.elasticsearch.action.bulk.BulkResponse bulkResponse = com.pancm.elasticsearch.EsUtil.client.bulk(request, org.elasticsearch.client.RequestOptions.DEFAULT);
			if (bulkResponse.hasFailures()) {
				return false;
			}
			return true;
		} finally {
			if (com.pancm.elasticsearch.EsUtil.isAutoClose) {
				com.pancm.elasticsearch.EsUtil.close();
			}
		}
	}

	public static boolean deleteById(java.lang.String index, java.lang.String type, java.lang.String id) throws java.io.IOException {
		if (((index == null) || (type == null)) || (id == null)) {
			return true;
		}
		try {
			org.elasticsearch.action.delete.DeleteRequest deleteRequest = new org.elasticsearch.action.delete.DeleteRequest();
			deleteRequest.id(id);
			deleteRequest.index(index);
			deleteRequest.type(type);
			com.pancm.elasticsearch.EsUtil.client.delete(deleteRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		} finally {
			if (com.pancm.elasticsearch.EsUtil.isAutoClose) {
				com.pancm.elasticsearch.EsUtil.close();
			}
		}
		return true;
	}

	public static boolean deleteByIds(java.lang.String index, java.lang.String type, java.util.Set<java.lang.String> ids) throws java.io.IOException {
		if (((index == null) || (type == null)) || (ids == null)) {
			return true;
		}
		try {
			org.elasticsearch.action.bulk.BulkRequest requestBulk = new org.elasticsearch.action.bulk.BulkRequest();
			ids.forEach(( id) -> {
				org.elasticsearch.action.delete.DeleteRequest deleteRequest = new org.elasticsearch.action.delete.DeleteRequest(index, type, id);
				requestBulk.add(deleteRequest);
			});
			com.pancm.elasticsearch.EsUtil.client.bulk(requestBulk, org.elasticsearch.client.RequestOptions.DEFAULT);
		} finally {
			if (com.pancm.elasticsearch.EsUtil.isAutoClose) {
				com.pancm.elasticsearch.EsUtil.close();
			}
		}
		return false;
	}

	public static java.util.Map<java.lang.String, java.lang.Object> queryById(java.lang.String index, java.lang.String type, java.lang.String id) throws java.io.IOException {
		if ((index == null) || (type == null)) {
			return null;
		}
		java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
		try {
			org.elasticsearch.action.get.GetRequest request = new org.elasticsearch.action.get.GetRequest();
			request.index(index);
			request.type(type);
			request.id(id);
			org.elasticsearch.action.get.GetResponse getResponse = com.pancm.elasticsearch.EsUtil.client.get(request, org.elasticsearch.client.RequestOptions.DEFAULT);
			if (getResponse.isExists()) {
				map = getResponse.getSourceAsMap();
			}
		} finally {
			if (com.pancm.elasticsearch.EsUtil.isAutoClose) {
				com.pancm.elasticsearch.EsUtil.close();
			}
		}
		return map;
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> query(java.lang.String index, java.lang.String type, org.elasticsearch.index.query.QueryBuilder... queryBuilders) throws java.io.IOException {
		return com.pancm.elasticsearch.EsUtil.query(index, type, null, queryBuilders);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> query(java.lang.String index, java.lang.String type, com.pancm.elasticsearch.EsQueryCondition esQueryCondition, org.elasticsearch.index.query.QueryBuilder... queryBuilders) throws java.io.IOException {
		if ((index == null) || (type == null)) {
			return null;
		}
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list = new java.util.ArrayList<>();
		try {
			org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest(index);
			searchRequest.types(type);
			org.elasticsearch.search.builder.SearchSourceBuilder sourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
			if (esQueryCondition != null) {
				java.lang.Integer form = esQueryCondition.getIndex();
				java.lang.Integer pagesize = esQueryCondition.getPagesize();
				if ((((form != null) && (form > 0)) && (pagesize != null)) && (pagesize > 0)) {
					form = (form - 1) * pagesize;
					pagesize = form + pagesize;
					sourceBuilder.from(form);
					sourceBuilder.size(pagesize);
				}
				java.lang.String routing = esQueryCondition.getRouting();
				if ((routing != null) && (routing.length() > 0)) {
					searchRequest.routing(routing);
				}
				searchRequest.indicesOptions(org.elasticsearch.action.support.IndicesOptions.lenientExpandOpen());
				java.lang.String order = esQueryCondition.getOrder();
				if (order != null) {
					java.lang.String[] orderField = esQueryCondition.getOrderField();
					org.elasticsearch.search.sort.SortOrder order2 = (order.equals(org.elasticsearch.search.sort.SortOrder.DESC)) ? org.elasticsearch.search.sort.SortOrder.DESC : org.elasticsearch.search.sort.SortOrder.ASC;
					if (orderField != null) {
						for (java.lang.String field : orderField) {
							sourceBuilder.sort(new org.elasticsearch.search.sort.FieldSortBuilder(field).order(order2));
						}
					} else {
						sourceBuilder.sort(new org.elasticsearch.search.sort.ScoreSortBuilder().order(order2));
					}
				}
				java.lang.String[] includeFields = esQueryCondition.getIncludeFields();
				java.lang.String[] excludeFields = esQueryCondition.getExcludeFields();
				if ((((includeFields != null) && (includeFields.length > 0)) && (excludeFields != null)) && (excludeFields.length > 0)) {
					sourceBuilder.fetchSource(includeFields, excludeFields);
				}
				sourceBuilder.fetchSource(esQueryCondition.isCloseSource());
			}
			if (queryBuilders != null) {
				for (org.elasticsearch.index.query.QueryBuilder queryBuilder : queryBuilders) {
					sourceBuilder.query(queryBuilder);
				}
			}
			searchRequest.source(sourceBuilder);
			org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsUtil.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
			if ((queryBuilders != null) || ((esQueryCondition != null) && esQueryCondition.isQueryData())) {
				searchResponse.getHits().forEach(( hit) -> {
					java.util.Map<java.lang.String, java.lang.Object> map = hit.getSourceAsMap();
					list.add(map);
				});
			}
			if ((esQueryCondition != null) && esQueryCondition.isNeedTotal()) {
				java.util.Map<java.lang.String, java.lang.Object> mapTotal = new java.util.HashMap<>();
				mapTotal.put("total", searchResponse.getHits().getTotalHits());
				list.add(mapTotal);
			}
		} finally {
			if (com.pancm.elasticsearch.EsUtil.isAutoClose) {
				com.pancm.elasticsearch.EsUtil.close();
			}
		}
		return list;
	}

	public static java.util.Map<java.lang.String, java.lang.Object> updateByQuery(java.lang.String index, java.lang.String type, org.elasticsearch.index.query.QueryBuilder... queryBuilders) throws java.io.IOException {
		if ((index == null) || (type == null)) {
			return null;
		}
		java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
		try {
			org.elasticsearch.index.reindex.UpdateByQueryRequest request = new org.elasticsearch.index.reindex.UpdateByQueryRequest();
			request.indices(index);
			request.setDocTypes(type);
			if (queryBuilders != null) {
				for (org.elasticsearch.index.query.QueryBuilder queryBuilder : queryBuilders) {
					request.setQuery(queryBuilder);
				}
			}
			org.elasticsearch.index.reindex.BulkByScrollResponse bulkResponse = com.pancm.elasticsearch.EsUtil.client.updateByQuery(request, org.elasticsearch.client.RequestOptions.DEFAULT);
			map.put("time", bulkResponse.getTook().getMillis());
			map.put("total", bulkResponse.getTotal());
		} finally {
			if (com.pancm.elasticsearch.EsUtil.isAutoClose) {
				com.pancm.elasticsearch.EsUtil.close();
			}
		}
		return map;
	}

	public static java.util.Map<java.lang.String, java.lang.Object> deleteByQuery(java.lang.String index, java.lang.String type, org.elasticsearch.index.query.QueryBuilder[] queryBuilders) throws java.io.IOException {
		if (((index == null) || (type == null)) || (queryBuilders == null)) {
			return null;
		}
		java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
		try {
			org.elasticsearch.index.reindex.DeleteByQueryRequest request = new org.elasticsearch.index.reindex.DeleteByQueryRequest(index, type);
			if (queryBuilders != null) {
				for (org.elasticsearch.index.query.QueryBuilder queryBuilder : queryBuilders) {
					request.setQuery(queryBuilder);
				}
			}
			org.elasticsearch.index.reindex.BulkByScrollResponse bulkResponse = com.pancm.elasticsearch.EsUtil.client.deleteByQuery(request, org.elasticsearch.client.RequestOptions.DEFAULT);
			map.put("time", bulkResponse.getTook().getMillis());
			map.put("total", bulkResponse.getTotal());
		} finally {
			if (com.pancm.elasticsearch.EsUtil.isAutoClose) {
				com.pancm.elasticsearch.EsUtil.close();
			}
		}
		return map;
	}

	public static java.util.Map<java.lang.String, java.lang.Object> reindexByQuery(java.lang.String index, java.lang.String destIndex, org.elasticsearch.index.query.QueryBuilder[] queryBuilders) throws java.io.IOException {
		if ((index == null) || (destIndex == null)) {
			return null;
		}
		java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
		try {
			org.elasticsearch.index.reindex.ReindexRequest request = new org.elasticsearch.index.reindex.ReindexRequest();
			request.setSourceIndices(index);
			request.setDestIndex(destIndex);
			if (queryBuilders != null) {
				for (org.elasticsearch.index.query.QueryBuilder queryBuilder : queryBuilders) {
					request.setSourceQuery(queryBuilder);
				}
			}
			request.setDestOpType("create");
			request.setConflicts("proceed");
			request.setTimeout(org.elasticsearch.common.unit.TimeValue.timeValueMinutes(2));
			org.elasticsearch.index.reindex.BulkByScrollResponse bulkResponse = com.pancm.elasticsearch.EsUtil.client.reindex(request, org.elasticsearch.client.RequestOptions.DEFAULT);
			map.put("time", bulkResponse.getTook().getMillis());
			map.put("total", bulkResponse.getTotal());
			map.put("createdDocs", bulkResponse.getCreated());
			map.put("updatedDocs", bulkResponse.getUpdated());
		} finally {
			if (com.pancm.elasticsearch.EsUtil.isAutoClose) {
				com.pancm.elasticsearch.EsUtil.close();
			}
		}
		return map;
	}

	private static void init() {
		if (com.pancm.elasticsearch.EsUtil.client == null) {
			synchronized(com.pancm.elasticsearch.EsUtil.class) {
				if (com.pancm.elasticsearch.EsUtil.client == null) {
					org.elasticsearch.client.RestClientBuilder restClientBuilder = org.elasticsearch.client.RestClient.builder(com.pancm.elasticsearch.EsUtil.httpHosts);
					com.pancm.elasticsearch.EsUtil.client = new org.elasticsearch.client.RestHighLevelClient(restClientBuilder);
				}
			}
		}
	}

	private static void close() throws java.io.IOException {
		if (com.pancm.elasticsearch.EsUtil.client != null) {
			try {
				com.pancm.elasticsearch.EsUtil.client.close();
				com.pancm.elasticsearch.EsUtil.setIsAutoClose(true);
			} catch (java.io.IOException e) {
				throw e;
			}
		}
	}

	public static boolean isIsAutoClose() {
		return com.pancm.elasticsearch.EsUtil.isAutoClose;
	}

	public static void setIsAutoClose(boolean isAutoClose) {
		com.pancm.elasticsearch.EsUtil.isAutoClose = isAutoClose;
	}

	private static java.lang.String[] elasticIps;

	private static int elasticPort;

	private static org.apache.http.HttpHost[] httpHosts;

	private static volatile org.elasticsearch.client.RestHighLevelClient client = null;

	private static boolean isAutoClose = true;

	private static final java.lang.String COMMA_SIGN = ",";
}