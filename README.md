Run from command line
mvn -Dbrowser=chrome -Denviroment=qa -Dsurefire.suiteXmlFiles=src/test/resources/sign_in_and_out_test.xml clean test
