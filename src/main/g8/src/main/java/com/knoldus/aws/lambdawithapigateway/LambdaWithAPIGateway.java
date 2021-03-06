package com.knoldus.aws.lambdawithapigateway;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.Optional;

public class LambdaWithAPIGateway implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	/**
	 * Handler function for handling API Gateway requests. Request body is set as the body of the response.
	 * Status code is important to set here. If not, then by default API Gateway sets the status code as
	 * 500 and shows an Internal Server error.
	 *
	 * @param requestEvent Request that triggered this lambda function.
	 * @param context Used to access lambda environment information.
	 * @return APIGatewayProxyResponseEvent object
	 */
	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent requestEvent, Context context) {
		Optional<String> maybePayload = Optional.ofNullable(requestEvent.getBody());
		String payload = maybePayload.orElse("No body was provided");

		APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
		responseEvent.setStatusCode(200);
		requestEvent.setBody(payload);
		return responseEvent;
	}
}
