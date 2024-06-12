public class EsAggregationSearchTest {
	private static java.lang.String elasticIp = "192.169.0.23";

	private static int elasticPort = 9200;

	private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(com.pancm.elasticsearch.EsHighLevelRestSearchTest.class);

	private static org.elasticsearch.client.RestHighLevelClient client = null;

	public static void main(java.lang.String[] args) {
		try {
			com.pancm.elasticsearch.EsAggregationSearchTest.init();
			com.pancm.elasticsearch.EsAggregationSearchTest.createIndex();
			com.pancm.elasticsearch.EsAggregationSearchTest.bulk();
			com.pancm.elasticsearch.EsAggregationSearchTest.groupbySearch();
			com.pancm.elasticsearch.EsAggregationSearchTest.avgSearch();
			com.pancm.elasticsearch.EsAggregationSearchTest.maxSearch();
			com.pancm.elasticsearch.EsAggregationSearchTest.sumSearch();
			com.pancm.elasticsearch.EsAggregationSearchTest.avgGroupSearch();
			com.pancm.elasticsearch.EsAggregationSearchTest.maxGroupSearch();
			com.pancm.elasticsearch.EsAggregationSearchTest.sumGroupSearch();
			com.pancm.elasticsearch.EsAggregationSearchTest.topSearch();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		} finally {
			com.pancm.elasticsearch.EsAggregationSearchTest.close();
		}
	}

	private static void init() {
		org.elasticsearch.client.RestClientBuilder restClientBuilder = org.elasticsearch.client.RestClient.builder(new org.apache.http.HttpHost(com.pancm.elasticsearch.EsAggregationSearchTest.elasticIp, com.pancm.elasticsearch.EsAggregationSearchTest.elasticPort));
		com.pancm.elasticsearch.EsAggregationSearchTest.client = new org.elasticsearch.client.RestHighLevelClient(restClientBuilder);
	}

	private static void close() {
		if (com.pancm.elasticsearch.EsAggregationSearchTest.client != null) {
			try {
				com.pancm.elasticsearch.EsAggregationSearchTest.client.close();
			} catch (java.io.IOException e) {
				e.printStackTrace();
			} finally {
				com.pancm.elasticsearch.EsAggregationSearchTest.client = null;
			}
		}
	}

	private static void createIndex() throws java.io.IOException {
		java.lang.String type = "_doc";
		java.lang.String index = "student";
		java.util.Map<java.lang.String, java.lang.Object> setmapping = new java.util.HashMap<>();
		setmapping.put("number_of_shards", 10);
		setmapping.put("number_of_replicas", 1);
		setmapping.put("refresh_interval", "5s");
		java.util.Map<java.lang.String, java.lang.Object> keyword = new java.util.HashMap<>();
		keyword.put("type", "keyword");
		java.util.Map<java.lang.String, java.lang.Object> lon = new java.util.HashMap<>();
		lon.put("type", "long");
		java.util.Map<java.lang.String, java.lang.Object> date = new java.util.HashMap<>();
		date.put("type", "date");
		date.put("format", "yyyy-MM-dd");
		java.util.Map<java.lang.String, java.lang.Object> date2 = new java.util.HashMap<>();
		date2.put("type", "date");
		date2.put("format", "yyyy-MM-dd HH:mm:ss.SSS");
		java.util.Map<java.lang.String, java.lang.Object> jsonMap2 = new java.util.HashMap<>();
		java.util.Map<java.lang.String, java.lang.Object> properties = new java.util.HashMap<>();
		properties.put("uid", lon);
		properties.put("grade", lon);
		properties.put("class", lon);
		properties.put("age", lon);
		properties.put("name", keyword);
		properties.put("createtm", date);
		properties.put("updatetm", date2);
		java.util.Map<java.lang.String, java.lang.Object> mapping = new java.util.HashMap<>();
		mapping.put("properties", properties);
		jsonMap2.put(type, mapping);
		org.elasticsearch.action.admin.indices.get.GetIndexRequest getRequest = new org.elasticsearch.action.admin.indices.get.GetIndexRequest();
		getRequest.indices(index);
		getRequest.types(type);
		getRequest.local(false);
		getRequest.humanReadable(true);
		boolean exists2 = com.pancm.elasticsearch.EsAggregationSearchTest.client.indices().exists(getRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		if (exists2) {
			java.lang.System.out.println(index + "索引库已经存在!");
			return;
		}
		org.elasticsearch.action.admin.indices.create.CreateIndexRequest request = new org.elasticsearch.action.admin.indices.create.CreateIndexRequest(index);
		try {
			request.settings(setmapping);
			request.mapping(type, jsonMap2);
			request.alias(new org.elasticsearch.action.admin.indices.alias.Alias("pancm_alias"));
			org.elasticsearch.action.admin.indices.create.CreateIndexResponse createIndexResponse = com.pancm.elasticsearch.EsAggregationSearchTest.client.indices().create(request, org.elasticsearch.client.RequestOptions.DEFAULT);
			boolean falg = createIndexResponse.isAcknowledged();
			if (falg) {
				java.lang.System.out.println(("创建索引库:" + index) + "成功！");
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	private static void bulk() throws java.io.IOException {
		java.lang.String type = "_doc";
		java.lang.String index = "student";
		org.elasticsearch.action.bulk.BulkRequest request = new org.elasticsearch.action.bulk.BulkRequest();
		int k = 10;
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> mapList = new java.util.ArrayList<>();
		java.time.LocalDateTime ldt = java.time.LocalDateTime.now();
		for (int i = 1; i <= k; i++) {
			java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
			map.put("uid", i);
			map.put("age", i);
			map.put("name", "虚无境" + (i % 3));
			map.put("class", i % 10);
			map.put("grade", 400 + i);
			map.put("createtm", ldt.plusDays(i).format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			map.put("updatetm", ldt.plusDays(i).format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
			if (i == 5) {
				map.put("updatetm", "2019-11-31 21:04:55.268");
			}
			mapList.add(map);
		}
		for (int i = 0; i < mapList.size(); i++) {
			java.util.Map<java.lang.String, java.lang.Object> map = mapList.get(i);
			java.lang.String id = map.get("uid").toString();
			request.add(new org.elasticsearch.action.update.UpdateRequest(index, type, id).doc(map, org.elasticsearch.common.xcontent.XContentType.JSON).docAsUpsert(true).retryOnConflict(5));
		}
		com.pancm.elasticsearch.EsAggregationSearchTest.client.bulk(request, org.elasticsearch.client.RequestOptions.DEFAULT);
		java.lang.System.out.println("批量执行成功！");
	}

	private static void groupbySearch() throws java.io.IOException {
		java.lang.String buk = "group";
		org.elasticsearch.search.aggregations.AggregationBuilder aggregation = org.elasticsearch.search.aggregations.AggregationBuilders.terms("age").field("age");
		org.elasticsearch.search.aggregations.AggregationBuilder aggregation2 = org.elasticsearch.search.aggregations.AggregationBuilders.terms("name").field("name");
		org.elasticsearch.search.aggregations.AggregationBuilder aggregation3 = org.elasticsearch.search.aggregations.AggregationBuilders.dateHistogram("createtm").field("createtm").format("yyyy-MM-dd").dateHistogramInterval(org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval.DAY);
		aggregation2.subAggregation(aggregation3);
		aggregation.subAggregation(aggregation2);
		com.pancm.elasticsearch.EsAggregationSearchTest.agg(aggregation, buk);
	}

	private static void avgSearch() throws java.io.IOException {
		java.lang.String buk = "t_grade_avg";
		org.elasticsearch.search.aggregations.AggregationBuilder aggregation = org.elasticsearch.search.aggregations.AggregationBuilders.avg(buk).field("grade");
		com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("求班级的平均分数:");
		com.pancm.elasticsearch.EsAggregationSearchTest.agg(aggregation, buk);
	}

	private static void maxSearch() throws java.io.IOException {
		java.lang.String buk = "t_grade";
		org.elasticsearch.search.aggregations.AggregationBuilder aggregation = org.elasticsearch.search.aggregations.AggregationBuilders.max(buk).field("grade");
		com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("求班级的最高分数:");
		com.pancm.elasticsearch.EsAggregationSearchTest.agg(aggregation, buk);
	}

	private static void sumSearch() throws java.io.IOException {
		java.lang.String buk = "t_grade";
		org.elasticsearch.search.aggregations.AggregationBuilder aggregation = org.elasticsearch.search.aggregations.AggregationBuilders.sum(buk).field("grade");
		com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("求班级的总分数:");
		com.pancm.elasticsearch.EsAggregationSearchTest.agg(aggregation, buk);
	}

	private static void avgGroupSearch() throws java.io.IOException {
		java.lang.String agg = "t_class_avg";
		java.lang.String buk = "t_grade";
		org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder aggregation = org.elasticsearch.search.aggregations.AggregationBuilders.terms(agg).field("class");
		aggregation.subAggregation(org.elasticsearch.search.aggregations.AggregationBuilders.avg(buk).field("grade"));
		com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("根据班级求平均分数:");
		com.pancm.elasticsearch.EsAggregationSearchTest.agg(aggregation, agg, buk);
	}

	private static void maxGroupSearch() throws java.io.IOException {
		java.lang.String agg = "t_class_max";
		java.lang.String buk = "t_grade";
		org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder aggregation = org.elasticsearch.search.aggregations.AggregationBuilders.terms(agg).field("class");
		aggregation.subAggregation(org.elasticsearch.search.aggregations.AggregationBuilders.max(buk).field("grade"));
		com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("根据班级求最大分数:");
		com.pancm.elasticsearch.EsAggregationSearchTest.agg(aggregation, agg, buk);
	}

	private static void sumGroupSearch() throws java.io.IOException {
		java.lang.String agg = "t_class_sum";
		java.lang.String buk = "t_grade";
		org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder aggregation = org.elasticsearch.search.aggregations.AggregationBuilders.terms(agg).field("class");
		aggregation.subAggregation(org.elasticsearch.search.aggregations.AggregationBuilders.sum(buk).field("grade"));
		com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("根据班级求总分:");
		com.pancm.elasticsearch.EsAggregationSearchTest.agg(aggregation, agg, buk);
	}

	protected static void agg(org.elasticsearch.search.aggregations.AggregationBuilder aggregation, java.lang.String buk) throws java.io.IOException {
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsAggregationSearchTest.search(aggregation);
		if (org.elasticsearch.rest.RestStatus.OK.equals(searchResponse.status())) {
			org.elasticsearch.search.aggregations.Aggregations aggregations = searchResponse.getAggregations();
			if (buk.contains("avg")) {
				org.elasticsearch.search.aggregations.metrics.avg.Avg ba = aggregations.get(buk);
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info((buk + ":") + ba.getValue());
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
			} else if (buk.contains("max")) {
				org.elasticsearch.search.aggregations.metrics.max.Max ba = aggregations.get(buk);
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info((buk + ":") + ba.getValue());
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
			} else if (buk.contains("min")) {
				org.elasticsearch.search.aggregations.metrics.min.Min ba = aggregations.get(buk);
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info((buk + ":") + ba.getValue());
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
			} else if (buk.contains("sum")) {
				org.elasticsearch.search.aggregations.metrics.sum.Sum ba = aggregations.get(buk);
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info((buk + ":") + ba.getValue());
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
			} else if (buk.contains("top")) {
				org.elasticsearch.search.aggregations.metrics.tophits.TopHits ba = aggregations.get(buk);
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info((buk + ":") + ba.getHits().totalHits);
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
			} else if (buk.contains("group")) {
				java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
				java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list = new java.util.ArrayList<>();
				com.pancm.elasticsearch.EsAggregationSearchTest.agg(map, list, aggregations);
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("聚合查询结果:" + list);
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
			}
		}
	}

	private static void agg(java.util.Map<java.lang.String, java.lang.Object> map, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, org.elasticsearch.search.aggregations.Aggregations aggregations) {
		aggregations.forEach(( aggregation) -> {
			java.lang.String name = aggregation.getName();
			org.elasticsearch.search.aggregations.bucket.terms.Terms genders = aggregations.get(name);
			for (org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket entry : genders.getBuckets()) {
				java.lang.String key = entry.getKey().toString();
				long t = entry.getDocCount();
				map.put(name, key);
				map.put((name + "_") + "count", t);
				java.util.List<org.elasticsearch.search.aggregations.Aggregation> list2 = entry.getAggregations().asList();
				if (list2.isEmpty()) {
					java.util.Map<java.lang.String, java.lang.Object> map2 = new java.util.HashMap<>();
					org.springframework.beans.BeanUtils.copyProperties(map, map2);
					list.add(map2);
				} else {
					com.pancm.elasticsearch.EsAggregationSearchTest.agg(map, list, entry.getAggregations());
				}
			}
		});
	}

	private static void agg(java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, org.elasticsearch.search.aggregations.Aggregations aggregations) {
		aggregations.forEach(( aggregation) -> {
			java.lang.String name = aggregation.getName();
			org.elasticsearch.search.aggregations.bucket.terms.Terms genders = aggregations.get(name);
			for (org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket entry : genders.getBuckets()) {
				java.lang.String key = entry.getKey().toString();
				long t = entry.getDocCount();
				java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
				map.put(name, key);
				map.put((name + "_") + "count", t);
				java.util.List<org.elasticsearch.search.aggregations.Aggregation> list2 = entry.getAggregations().asList();
				if (list2.isEmpty()) {
					list.add(map);
				} else {
					com.pancm.elasticsearch.EsAggregationSearchTest.agg(list, entry.getAggregations());
				}
			}
		});
		java.lang.System.out.println(list);
	}

	private static org.elasticsearch.action.search.SearchResponse search(org.elasticsearch.search.aggregations.AggregationBuilder aggregation) throws java.io.IOException {
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest();
		searchRequest.indices("student");
		searchRequest.types("_doc");
		org.elasticsearch.search.builder.SearchSourceBuilder searchSourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		searchSourceBuilder.explain(false);
		searchSourceBuilder.fetchSource(false);
		searchSourceBuilder.version(false);
		searchSourceBuilder.aggregation(aggregation);
		com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("查询的语句:" + searchSourceBuilder.toString());
		searchRequest.source(searchSourceBuilder);
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsAggregationSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		return searchResponse;
	}

	protected static void agg(org.elasticsearch.search.aggregations.AggregationBuilder aggregation, java.lang.String agg, java.lang.String buk) throws java.io.IOException {
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsAggregationSearchTest.search(aggregation);
		if (org.elasticsearch.rest.RestStatus.OK.equals(searchResponse.status())) {
			org.elasticsearch.search.aggregations.Aggregations aggregations = searchResponse.getAggregations();
			org.elasticsearch.search.aggregations.bucket.terms.Terms byAgeAggregation = aggregations.get(agg);
			com.pancm.elasticsearch.EsAggregationSearchTest.logger.info(agg + " 结果");
			com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("name: " + byAgeAggregation.getName());
			com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("type: " + byAgeAggregation.getType());
			com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("sumOfOtherDocCounts: " + byAgeAggregation.getSumOfOtherDocCounts());
			com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
			for (org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket buck : byAgeAggregation.getBuckets()) {
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("key: " + buck.getKeyAsNumber());
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("docCount: " + buck.getDocCount());
				com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("docCountError: " + buck.getDocCountError());
				if (agg.contains("avg")) {
					org.elasticsearch.search.aggregations.metrics.avg.Avg ba = buck.getAggregations().get(buk);
					com.pancm.elasticsearch.EsAggregationSearchTest.logger.info((buk + ":") + ba.getValue());
					com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
				} else if (agg.contains("max")) {
					org.elasticsearch.search.aggregations.metrics.max.Max ba = buck.getAggregations().get(buk);
					com.pancm.elasticsearch.EsAggregationSearchTest.logger.info((buk + ":") + ba.getValue());
					com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
				} else if (agg.contains("min")) {
					org.elasticsearch.search.aggregations.metrics.min.Min ba = buck.getAggregations().get(buk);
					com.pancm.elasticsearch.EsAggregationSearchTest.logger.info((buk + ":") + ba.getValue());
					com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
				} else if (agg.contains("sum")) {
					org.elasticsearch.search.aggregations.metrics.sum.Sum ba = buck.getAggregations().get(buk);
					com.pancm.elasticsearch.EsAggregationSearchTest.logger.info((buk + ":") + ba.getValue());
					com.pancm.elasticsearch.EsAggregationSearchTest.logger.info("------------------------------------");
				}
			}
		}
	}

	private static void havingSearch() throws java.io.IOException {
		java.lang.String index = "";
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest(index);
		searchRequest.indices(index);
		org.elasticsearch.search.builder.SearchSourceBuilder sourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		org.elasticsearch.index.query.BoolQueryBuilder boolQueryBuilder = new org.elasticsearch.index.query.BoolQueryBuilder();
		searchRequest.indicesOptions(org.elasticsearch.action.support.IndicesOptions.lenientExpandOpen());
		java.lang.String alias_name = "nas_ip_address_group";
		java.lang.String group_name = "nas_ip_address";
		java.lang.String query_name = "acct_start_time";
		java.lang.String query_type = "gte,lte";
		java.lang.String query_name_value = "2020-08-05 13:25:55,2020-08-20 13:26:55";
		java.lang.String[] query_types = query_type.split(",");
		java.lang.String[] query_name_values = query_name_value.split(",");
		for (int i = 0; i < query_types.length; i++) {
			if ("gte".equals(query_types[i])) {
				boolQueryBuilder.must(org.elasticsearch.index.query.QueryBuilders.rangeQuery(query_name).gte(query_name_values[i]));
			}
			if ("lte".equals(query_types[i])) {
				boolQueryBuilder.must(org.elasticsearch.index.query.QueryBuilders.rangeQuery(query_name).lte(query_name_values[i]));
			}
		}
		org.elasticsearch.search.aggregations.AggregationBuilder aggregationBuilder = org.elasticsearch.search.aggregations.AggregationBuilders.terms(alias_name).field(group_name).size(java.lang.Integer.MAX_VALUE);
		java.util.Map<java.lang.String, java.lang.String> bucketsPathsMap = new java.util.HashMap<>(8);
		bucketsPathsMap.put("groupCount", "_count");
		org.elasticsearch.script.Script script = new org.elasticsearch.script.Script("params.groupCount >= 1000");
		org.elasticsearch.search.aggregations.pipeline.bucketselector.BucketSelectorPipelineAggregationBuilder bs = org.elasticsearch.search.aggregations.pipeline.PipelineAggregatorBuilders.bucketSelector("having", bucketsPathsMap, script);
		aggregationBuilder.subAggregation(bs);
		sourceBuilder.aggregation(aggregationBuilder);
		sourceBuilder.explain(false);
		sourceBuilder.fetchSource(false);
		sourceBuilder.version(false);
		sourceBuilder.query(boolQueryBuilder);
		searchRequest.source(sourceBuilder);
		java.lang.System.out.println(sourceBuilder);
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsAggregationSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		long count = searchResponse.getHits().getHits().length;
		org.elasticsearch.search.aggregations.Aggregations aggregations = searchResponse.getAggregations();
		java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list = new java.util.ArrayList<>();
		com.pancm.elasticsearch.EsAggregationSearchTest.agg(list, aggregations);
		java.lang.System.out.println(list);
	}

	private static void distinctSearch() throws java.io.IOException {
		java.lang.String buk = "group";
		java.lang.String distinctName = "name";
		org.elasticsearch.search.aggregations.AggregationBuilder aggregation = org.elasticsearch.search.aggregations.AggregationBuilders.terms("age").field("age");
		org.elasticsearch.search.aggregations.metrics.cardinality.CardinalityAggregationBuilder cardinalityBuilder = org.elasticsearch.search.aggregations.AggregationBuilders.cardinality(distinctName).field(distinctName);
		aggregation.subAggregation(cardinalityBuilder);
		com.pancm.elasticsearch.EsAggregationSearchTest.agg(aggregation, buk);
	}

	private static void topSearch() throws java.io.IOException {
	}
}