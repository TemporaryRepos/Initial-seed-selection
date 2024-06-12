public class EsHighLevelRestSearchTest {
	private static java.lang.String elasticIp = "192.169.0.23";

	private static int elasticPort = 9200;

	private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(com.pancm.elasticsearch.EsHighLevelRestSearchTest.class);

	private static org.elasticsearch.client.RestHighLevelClient client = null;

	public static void main(java.lang.String[] args) {
		try {
			com.pancm.elasticsearch.EsHighLevelRestSearchTest.init();
			com.pancm.elasticsearch.EsHighLevelRestSearchTest.allSearch();
			com.pancm.elasticsearch.EsHighLevelRestSearchTest.genSearch();
			com.pancm.elasticsearch.EsHighLevelRestSearchTest.orSearch();
			com.pancm.elasticsearch.EsHighLevelRestSearchTest.likeSearch();
			com.pancm.elasticsearch.EsHighLevelRestSearchTest.existSearch();
			com.pancm.elasticsearch.EsHighLevelRestSearchTest.rangeSearch();
			com.pancm.elasticsearch.EsHighLevelRestSearchTest.regexpSearch();
			com.pancm.elasticsearch.EsHighLevelRestSearchTest.boolSearch();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		} finally {
			com.pancm.elasticsearch.EsHighLevelRestSearchTest.close();
		}
	}

	private static void boolSearch() throws java.io.IOException {
		java.lang.String type = "_doc";
		java.lang.String index = "test1";
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest(index);
		searchRequest.types(type);
		org.elasticsearch.search.builder.SearchSourceBuilder sourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		org.elasticsearch.index.query.BoolQueryBuilder boolQueryBuilder = new org.elasticsearch.index.query.BoolQueryBuilder();
		boolQueryBuilder.must(org.elasticsearch.index.query.QueryBuilders.termQuery("uid", 12345));
		boolQueryBuilder.must(org.elasticsearch.index.query.QueryBuilders.termQuery("msgcode", 1));
		sourceBuilder.query(boolQueryBuilder);
		searchRequest.source(sourceBuilder);
		java.lang.System.out.println("组合查询的DSL语句:" + sourceBuilder.toString());
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		searchResponse.getHits().forEach(( hit) -> {
			java.lang.String string = hit.getSourceAsString();
			java.lang.System.out.println("组合查询的String结果:" + string);
		});
		java.lang.System.out.println("\n=================\n");
	}

	private static void regexpSearch() throws java.io.IOException {
		java.lang.String type = "_doc";
		java.lang.String index = "test1";
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest(index);
		searchRequest.types(type);
		org.elasticsearch.search.builder.SearchSourceBuilder sourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		sourceBuilder.query(org.elasticsearch.index.query.QueryBuilders.regexpQuery("message", "xu[0-9]"));
		searchRequest.source(sourceBuilder);
		java.lang.System.out.println("正则查询的DSL语句:" + sourceBuilder.toString());
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		searchResponse.getHits().forEach(( hit) -> {
			java.util.Map<java.lang.String, java.lang.Object> map = hit.getSourceAsMap();
			java.lang.String string = hit.getSourceAsString();
			java.lang.System.out.println("正则查询的Map结果:" + map);
			java.lang.System.out.println("正则查询的String结果:" + string);
		});
		java.lang.System.out.println("\n=================\n");
	}

	private static void rangeSearch() throws java.io.IOException {
		java.lang.String type = "_doc";
		java.lang.String index = "test1";
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest(index);
		searchRequest.types(type);
		org.elasticsearch.search.builder.SearchSourceBuilder sourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		sourceBuilder.query(org.elasticsearch.index.query.QueryBuilders.rangeQuery("sendtime").gte("2019-01-01 00:00:00").lte("2019-12-31 23:59:59"));
		searchRequest.source(sourceBuilder);
		java.lang.System.out.println("范围查询的DSL语句:" + sourceBuilder.toString());
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		searchResponse.getHits().forEach(( hit) -> {
			java.lang.String string = hit.getSourceAsString();
			java.lang.System.out.println("范围查询的String结果:" + string);
		});
		java.lang.System.out.println("\n=================\n");
	}

	private static void existSearch() throws java.io.IOException {
		java.lang.String type = "_doc";
		java.lang.String index = "test1";
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest(index);
		searchRequest.types(type);
		org.elasticsearch.search.builder.SearchSourceBuilder sourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		sourceBuilder.query(org.elasticsearch.index.query.QueryBuilders.existsQuery("msgcode"));
		searchRequest.source(sourceBuilder);
		java.lang.System.out.println("存在查询的DSL语句:" + sourceBuilder.toString());
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		searchResponse.getHits().forEach(( hit) -> {
			java.util.Map<java.lang.String, java.lang.Object> map = hit.getSourceAsMap();
			java.lang.String string = hit.getSourceAsString();
			java.lang.System.out.println("存在查询的Map结果:" + map);
			java.lang.System.out.println("存在查询的String结果:" + string);
		});
		java.lang.System.out.println("\n=================\n");
	}

	private static void inSearch() throws java.io.IOException {
		java.lang.String type = "_doc";
		java.lang.String index = "test1";
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest(index, type);
		org.elasticsearch.search.builder.SearchSourceBuilder sourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		searchRequest.source(sourceBuilder);
		java.lang.System.out.println("in查询的DSL语句:" + sourceBuilder.toString());
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		searchResponse.getHits().forEach(( hit) -> {
			java.util.Map<java.lang.String, java.lang.Object> map = hit.getSourceAsMap();
			java.lang.String string = hit.getSourceAsString();
			java.lang.System.out.println("in查询的Map结果:" + map);
			java.lang.System.out.println("in查询的String结果:" + string);
		});
		java.lang.System.out.println("\n=================\n");
	}

	private static void likeSearch() throws java.io.IOException {
		java.lang.String type = "_doc";
		java.lang.String index = "test1";
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest();
		searchRequest.indices(index);
		searchRequest.types(type);
		org.elasticsearch.search.builder.SearchSourceBuilder searchSourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		org.elasticsearch.index.query.BoolQueryBuilder boolQueryBuilder = new org.elasticsearch.index.query.BoolQueryBuilder();
		boolQueryBuilder.must(org.elasticsearch.index.query.QueryBuilders.wildcardQuery("message", "*xu*"));
		searchSourceBuilder.query(boolQueryBuilder);
		java.lang.System.out.println("模糊查询语句:" + searchSourceBuilder.toString());
		searchRequest.source(searchSourceBuilder);
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		searchResponse.getHits().forEach(( documentFields) -> {
			java.lang.System.out.println("模糊查询结果:" + documentFields.getSourceAsMap());
		});
		java.lang.System.out.println("\n=================\n");
	}

	private static void genSearch() throws java.io.IOException {
		java.lang.String type = "_doc";
		java.lang.String index = "test1";
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest(index);
		searchRequest.types(type);
		org.elasticsearch.search.builder.SearchSourceBuilder sourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		sourceBuilder.query(org.elasticsearch.index.query.QueryBuilders.termQuery("uid", "1234"));
		sourceBuilder.from(0);
		sourceBuilder.size(5);
		sourceBuilder.timeout(new org.elasticsearch.common.unit.TimeValue(60, java.util.concurrent.TimeUnit.SECONDS));
		searchRequest.indicesOptions(org.elasticsearch.action.support.IndicesOptions.lenientExpandOpen());
		searchRequest.preference("_local");
		java.lang.String[] includeFields = new java.lang.String[]{ "title", "user", "innerObject.*" };
		java.lang.String[] excludeFields = new java.lang.String[]{ "_type" };
		searchRequest.source(sourceBuilder);
		java.lang.System.out.println("普通查询的DSL语句:" + sourceBuilder.toString());
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		org.elasticsearch.rest.RestStatus status = searchResponse.status();
		org.elasticsearch.common.unit.TimeValue took = searchResponse.getTook();
		java.lang.Boolean terminatedEarly = searchResponse.isTerminatedEarly();
		boolean timedOut = searchResponse.isTimedOut();
		int totalShards = searchResponse.getTotalShards();
		int successfulShards = searchResponse.getSuccessfulShards();
		int failedShards = searchResponse.getFailedShards();
		for (org.elasticsearch.action.search.ShardSearchFailure failure : searchResponse.getShardFailures()) {
		}
		searchResponse.getHits().forEach(( hit) -> {
			java.util.Map<java.lang.String, java.lang.Object> map = hit.getSourceAsMap();
			java.lang.System.out.println("普通查询的结果:" + map);
		});
		java.lang.System.out.println("\n=================\n");
	}

	private static void allSearch() throws java.io.IOException {
		org.elasticsearch.action.search.SearchRequest searchRequestAll = new org.elasticsearch.action.search.SearchRequest();
		org.elasticsearch.search.builder.SearchSourceBuilder searchSourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		searchSourceBuilder.query(org.elasticsearch.index.query.QueryBuilders.matchAllQuery());
		searchRequestAll.source(searchSourceBuilder);
		org.elasticsearch.action.search.SearchResponse searchResponseAll = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequestAll, org.elasticsearch.client.RequestOptions.DEFAULT);
		java.lang.System.out.println("所有查询总数:" + searchResponseAll.getHits().getTotalHits());
	}

	private static void orSearch() throws java.io.IOException {
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest();
		searchRequest.indices("test1");
		searchRequest.types("_doc");
		org.elasticsearch.search.builder.SearchSourceBuilder searchSourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		org.elasticsearch.index.query.BoolQueryBuilder boolQueryBuilder = new org.elasticsearch.index.query.BoolQueryBuilder();
		org.elasticsearch.index.query.BoolQueryBuilder boolQueryBuilder2 = new org.elasticsearch.index.query.BoolQueryBuilder();
		boolQueryBuilder2.should(org.elasticsearch.index.query.QueryBuilders.termQuery("uid", 1234));
		boolQueryBuilder2.should(org.elasticsearch.index.query.QueryBuilders.termQuery("uid", 12345));
		boolQueryBuilder.must(boolQueryBuilder2);
		boolQueryBuilder.must(org.elasticsearch.index.query.QueryBuilders.termQuery("phone", "12345678909"));
		searchSourceBuilder.query(boolQueryBuilder);
		java.lang.System.out.println("或查询语句:" + searchSourceBuilder.toString());
		searchRequest.source(searchSourceBuilder);
		org.elasticsearch.action.search.SearchResponse searchResponse = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		searchResponse.getHits().forEach(( documentFields) -> {
			java.lang.System.out.println("或查询结果:" + documentFields.getSourceAsMap());
		});
		java.lang.System.out.println("\n=================\n");
	}

	private static void init() {
		org.elasticsearch.client.RestClientBuilder restClientBuilder = org.elasticsearch.client.RestClient.builder(new org.apache.http.HttpHost(com.pancm.elasticsearch.EsHighLevelRestSearchTest.elasticIp, com.pancm.elasticsearch.EsHighLevelRestSearchTest.elasticPort));
		com.pancm.elasticsearch.EsHighLevelRestSearchTest.client = new org.elasticsearch.client.RestHighLevelClient(restClientBuilder);
	}

	private static void close() {
		if (com.pancm.elasticsearch.EsHighLevelRestSearchTest.client != null) {
			try {
				com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.close();
			} catch (java.io.IOException e) {
				e.printStackTrace();
			} finally {
				com.pancm.elasticsearch.EsHighLevelRestSearchTest.client = null;
			}
		}
	}

	private static void search() throws java.io.IOException {
		org.elasticsearch.action.search.SearchRequest searchRequest = new org.elasticsearch.action.search.SearchRequest("user");
		org.elasticsearch.search.builder.SearchSourceBuilder sourceBuilder = new org.elasticsearch.search.builder.SearchSourceBuilder();
		org.elasticsearch.index.query.MatchQueryBuilder matchQueryBuilder = new org.elasticsearch.index.query.MatchQueryBuilder("user", "pancm");
		matchQueryBuilder.fuzziness(org.elasticsearch.common.unit.Fuzziness.AUTO);
		matchQueryBuilder.prefixLength(3);
		matchQueryBuilder.maxExpansions(10);
		org.elasticsearch.search.builder.SearchSourceBuilder searchSourceBuilder2 = new org.elasticsearch.search.builder.SearchSourceBuilder();
		searchSourceBuilder2.query(matchQueryBuilder);
		org.elasticsearch.action.search.SearchRequest searchRequest2 = new org.elasticsearch.action.search.SearchRequest();
		searchRequest2.source(searchSourceBuilder2);
		org.elasticsearch.action.search.SearchResponse searchResponse2 = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest, org.elasticsearch.client.RequestOptions.DEFAULT);
		org.elasticsearch.search.SearchHits hits = searchResponse2.getHits();
		long totalHits = hits.getTotalHits();
		float maxScore = hits.getMaxScore();
		hits.forEach(( hit) -> {
			java.lang.String index = hit.getIndex();
			java.lang.String type = hit.getType();
			java.lang.String id = hit.getId();
			float score = hit.getScore();
			java.util.Map<java.lang.String, java.lang.Object> sourceAsMap = hit.getSourceAsMap();
			java.lang.String string = hit.getSourceAsString();
			java.lang.System.out.println("Match查询的Map结果:" + sourceAsMap);
			java.lang.System.out.println("Match查询的String结果:" + string);
			java.lang.String documentTitle = ((java.lang.String) (sourceAsMap.get("title")));
			java.util.Map<java.lang.String, java.lang.Object> innerObject = ((java.util.Map<java.lang.String, java.lang.Object>) (sourceAsMap.get("innerObject")));
		});
		java.lang.System.out.println("\n=================\n");
		org.elasticsearch.search.builder.SearchSourceBuilder searchSourceBuilder3 = new org.elasticsearch.search.builder.SearchSourceBuilder();
		org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder highlightBuilder = new org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder();
		org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder.Field highlightTitle = new org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder.Field("title");
		highlightTitle.highlighterType("user");
		highlightBuilder.field(highlightTitle);
		org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder.Field highlightUser = new org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder.Field("user");
		highlightBuilder.field(highlightUser);
		searchSourceBuilder3.highlighter(highlightBuilder);
		org.elasticsearch.action.search.SearchRequest searchRequest3 = new org.elasticsearch.action.search.SearchRequest();
		searchRequest3.source(searchSourceBuilder3);
		org.elasticsearch.action.search.SearchResponse searchResponse3 = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest3, org.elasticsearch.client.RequestOptions.DEFAULT);
		searchResponse3.getHits().forEach(( hit) -> {
			java.util.Map<java.lang.String, java.lang.Object> map = hit.getSourceAsMap();
			java.lang.String string = hit.getSourceAsString();
			java.lang.System.out.println("Highlight查询的Map结果:" + map);
			java.lang.System.out.println("Highlight查询的String结果:" + string);
		});
		java.lang.System.out.println("\n=================\n");
		org.elasticsearch.search.builder.SearchSourceBuilder searchSourceBuilder4 = new org.elasticsearch.search.builder.SearchSourceBuilder();
		org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder aggregation = org.elasticsearch.search.aggregations.AggregationBuilders.terms("user_").field("user");
		aggregation.subAggregation(org.elasticsearch.search.aggregations.AggregationBuilders.avg("average_age").field("age"));
		searchSourceBuilder4.aggregation(aggregation);
		org.elasticsearch.action.search.SearchRequest searchRequest4 = new org.elasticsearch.action.search.SearchRequest();
		searchRequest4.source(searchSourceBuilder4);
		org.elasticsearch.action.search.SearchResponse searchResponse4 = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest4, org.elasticsearch.client.RequestOptions.DEFAULT);
		org.elasticsearch.search.aggregations.Aggregations aggregations = searchResponse4.getAggregations();
		java.lang.System.out.println("聚合查询");
		for (org.elasticsearch.search.aggregations.Aggregation agg : aggregations) {
			java.lang.String type = agg.getType();
			java.lang.String name = agg.getName();
			org.elasticsearch.search.aggregations.bucket.terms.Terms terms = ((org.elasticsearch.search.aggregations.bucket.terms.Terms) (aggregations.get(name)));
			for (org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket bucket : terms.getBuckets()) {
				java.lang.System.out.println("条数:" + bucket.getDocCount());
				java.lang.System.out.println("key:" + bucket.getKey());
				java.lang.System.out.println("num:" + bucket.getKeyAsNumber());
				org.elasticsearch.search.aggregations.metrics.avg.Avg avg = bucket.getAggregations().get("average_age");
				java.lang.System.out.println("value:" + avg.getValue());
			}
			if (type.equals(org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder.NAME)) {
				org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket elasticBucket = ((org.elasticsearch.search.aggregations.bucket.terms.Terms) (agg)).getBucketByKey("average_age");
				long numberOfDocs = elasticBucket.getDocCount();
				java.lang.System.out.println("条数:" + numberOfDocs);
			}
		}
		org.elasticsearch.search.builder.SearchSourceBuilder searchSourceBuilder5 = new org.elasticsearch.search.builder.SearchSourceBuilder();
		org.elasticsearch.search.suggest.SuggestionBuilder termSuggestionBuilder = org.elasticsearch.search.suggest.SuggestBuilders.termSuggestion("user").text("pancm");
		org.elasticsearch.search.suggest.SuggestBuilder suggestBuilder = new org.elasticsearch.search.suggest.SuggestBuilder();
		suggestBuilder.addSuggestion("suggest_user", termSuggestionBuilder);
		searchSourceBuilder5.suggest(suggestBuilder);
		org.elasticsearch.action.search.SearchRequest searchRequest5 = new org.elasticsearch.action.search.SearchRequest();
		searchRequest5.source(searchSourceBuilder5);
		org.elasticsearch.action.search.SearchResponse searchResponse5 = com.pancm.elasticsearch.EsHighLevelRestSearchTest.client.search(searchRequest5, org.elasticsearch.client.RequestOptions.DEFAULT);
		org.elasticsearch.search.suggest.Suggest suggest = searchResponse5.getSuggest();
		org.elasticsearch.search.suggest.term.TermSuggestion termSuggestion = suggest.getSuggestion("suggest_user");
		for (org.elasticsearch.search.suggest.term.TermSuggestion.Entry entry : termSuggestion.getEntries()) {
			for (org.elasticsearch.search.suggest.term.TermSuggestion.Entry.Option option : entry) {
				java.lang.String suggestText = option.getText().string();
				java.lang.System.out.println("返回结果:" + suggestText);
			}
		}
	}
}