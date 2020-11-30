package sunny.com.sunSpringTest01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@SpringBootTest
@Slf4j
@Ignore
class SunSpringTest01ApplicationTests
{
	@Autowired
	sunny.com.sunSpringTest01.ApiClients.IRAWGAPIs IRAWGAPIs;

	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String BEARER_TOKEN_TYPE = "Bearer";
/*
	@Autowired
	private ResourceOwnerPasswordAccessTokenProvider resourceOwnerPasswordAccessTokenProvider;

	@Autowired
	private ResourceOwnerPasswordResourceDetails oAuth2ProtectedResourceDetails;

 */

	@Test
	void getTop50GamesWithYear()
	{
		return;
		/*
		ResponseEntity<String> reStr = IRAWGAPIs.getListGames("levelheroes", 1,
				200,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				"2016-01-01,2016-12-30",
				null,
				null,
				null,
				null,
				null,
				"rating");

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(reStr.getBody().toString());
		String prettyJsonString = gson.toJson(je);
		System.out.println(prettyJsonString);

		 */
	}
	//126097
	@Test
	void testGetGameDetails()
	{//58777, 171, Animal Crossing 421698, blood stone 28964, band hero 24503
	/*
		ResponseEntity<String> reStr = IRAWGAPIs.getGameDetails("levelheroes",28964);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(reStr.getBody().toString());
		String prettyJsonString = gson.toJson(je);
		System.out.println(String.format(prettyJsonString));

	 */
	}

	@Test
	void searchItem()
	{
		/*ResponseEntity<String> reStr = IRAWGAPIs.getListGames("levelheroes", 1,
				20,
				"Band Hero",
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(reStr.getBody().toString());
		String prettyJsonString = gson.toJson(je);
		System.out.println(prettyJsonString);*/
	}
	void t01()
	{
		//Tuple tuple = TupleBuilder.tuple().of("weightedPriceLong", weightedPriceLong, "weightedPriceShort", weightedPriceShort, "bdPriceSum", bdPriceSum);
		//tuple.getBigDecimal(0);
	}
	/*
	@Test
	void getToken()
	{
		OAuth2AccessToken accessToken = resourceOwnerPasswordAccessTokenProvider
				.obtainAccessToken(oAuth2ProtectedResourceDetails, new DefaultAccessTokenRequest());
		System.out.println(accessToken.toString());
	}

	 */


}
