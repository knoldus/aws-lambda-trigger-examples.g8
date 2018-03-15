A [Giter8][g8] template for AWS Lambda trigger examples in Java 8.

# How to use
---
You can import the template using
`<Write command to import template>`

You need to create jar of the project. You can create a jar using the following command -
`mvn clean package`

### Creating a Lambda function
Once the jar is created, login to your AWS account, go to AWS Lambda service and create a new function. Steps to create a new function -

1. Choose 'Author from Scratch' template.
2. Choose runtime as Java 8.
3. For choosing a role, you can choose to create a new role and assign some permissions or you can choose an existing role with some already assigned permissions.
4. Create function by clicking on the 'Create function' button.

That's it! Your lambda function is created.

### Uploading jar to Lambda
Now upload the jar received by running the `mvn clean package` command. This jar will be residing in the target folder of your root directory. After selecting your jar, click on *Save* button to upload the jar.
**NOTE** - There will be two jars, one's name will be starting with the name `original-` and it's size will also be very small. This jar is the build of the project **without** dependencies. The other jar is the jar that has to be uploaded to our AWS lambda function.

Once the jar has finished uploading, we will be ready to add a trigger to our lambda function.

### Assigning handler functions to Lambda
From the list of triggers, the following triggers are supported by the template -

- API Gateway
- S3
- Code Commit
- SNS
- Kinesis
- DynamoDB 

For using any trigger, you will have to define a handler function for the lambda to trigger. Where you uploaded the jar, you also have a textbox to define the handler function for the lambda. For using a trigger, you have to define it's handler function there.

- API Gateway - `com.knoldus.aws.lambdawithapigateway.LambdaWithAPIGateway::handleRequest`
- S3 - `com.knoldus.aws.lambdawiths3.LambdaWithS3::handleRequest`
- Code Commit - `com.knoldus.aws.lambdawithcodecommit.LambdaWithCodeCommit::handleRequest`
- SNS - `com.knoldus.aws.lambdawithsns.LambdaWithSNS::handleRequest`
- Kinesis - `com.knoldus.aws.lambdawithkinesis.LambdaWithKinesis::handleRequest`
- DynamoDB - `com.knoldus.aws.lambdawithdynamodbstreams.LambdaWithDynamoDbStreams::handleRequest`

### Environment variables required for the Lambda
Whenever the lambda is triggered (except through API Gateway), it sends an E-mail to a specified email account using Amazon SES. Credentials for sending email has to be given in environment variables.

- FROM - Email from which the mail will be sent(Must be verified with Amazon SES).
- FROM_NAME - Name from which the email is going.
- HOST - Host to use while sending the email. Must be SES host.(For ex. - email-smtp.us-east-1.amazonaws.com)
- PORT - Port to use for the SMTP(Recommended - 587)
- SMTP_PASSWORD - SMTP password acquired from Amazon SES
- SMTP_USERNAME - SMTP username acquired from Amazon SES
- TO - Email to send the mail to(Must be Amazon SES verified)

Once set, you are ready to go!
# Template license
---
Written in 2018 by [Knoldus Inc.](http://www.knoldus.com)

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
