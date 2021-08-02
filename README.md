# WebShopTestAutomation
BDD based framework for sample ecommerce web site called "DemoWebShop"

We have identified following critical and Risk areas in the Web application.

1.Sanity Test to validate all the links in the application are working fine and should not be broken, As application is going live in short time so this will be the quickest way to find out any broken piece or Link in the application.  
2. Search Store/Search Functionality
>> We have identified it as a Risk area because this is the entry point for user to search any product from the application datasets, This feature is also associated to the performance as in how quickly results are getting fetched
3. Adding the Product in the shopping cart and Update the Cart 
>>This will be a quick win to test any E2E flow through Automation, Because being a user I would always like to see if Website is able to handle the order flow. Which is a primary reason to building any Ecommerce Website.
4. User Registration and Login
>>This is important area of application as it provides authentication and trust to any User that Website is safe to use. 
5. Product Pricing and Quantity
>>We always need to validate if Pricings are calculated fine by increasing/decreasing the Quantity or We can get the Pricing data from integrated APIs and validate against the application data.


List of Test Cases Automated:

1. Validate the Search results as per the inputs given in the Search Text box
2. Adding and Updating the product into the cart
3.Sanity test of all the links present in the application and find if any broken link


Reason to choose above cases for the Automation:
1.Selected test cases are covering most of the critical and risk areas. 
2.Consdering the delivery timeline above cases are most possible scenarios to be automated and find the early defects. Also these test cases can be executed without any dependency like payment method, User Authentication etc.
3.Also above cases are able to demonstrate the type of framework and design I have used in test automation.


Steps to Build and run the scenarios: 
1. Clone the public repository from the Github account link 
2. Select the project and Open in to your preferred editor (I have created with Intelli J)
3. Now run by feature files, Go to folder path src>>test>>features>>Select the desired feature and Right Click to run
4.Observe the test results in the Editor
