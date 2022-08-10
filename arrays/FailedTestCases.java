package test.arrays;

import java.util.*;

/**
Write an API/method which will get list of tests to be executed which are present in allTests (Input1) and are not passed in the testResults (Input2)
 */

public class FailedTestCases{
    public static void main(String[] args) {
        String allTests ="pkg1.class1.test1\n" + 
                            "pkg1.class1.test2\n" + 
                            "pkg1.class1.test3\n" + 
                            "pkg1.class2.test1\n" + 
                            "pkg1.class2.test2\n" + 
                            "pkg2.class1.test1\n" + 
                            "pkg2.class2.test1\n" + 
                            "pkg3.class1.test1\n" + 
                            "pkg3.class1.test2\n" + 
                            "pkg1.class1.test3";
        String testResults = "pkg1:class1:test1:passed\n" + 
                                "pkg1:class1:test2:failed\n" + 
                                "pkg1:class2:test1:passed\n" + 
                                "pkg1:class2:test2:failed\n" + 
                                "pkg1:class1:test3:";  
           
        List<String> failedTestCases = getTestsToExecute(allTests, testResults);
        System.out.println(failedTestCases);
        
    }
    /**Optimized Solution */
    public static List<String> getTestsToExecuteOld (String allTests, String testResults) {
        /**
        Store the result in failedTestCases List
         */
        List<String> failedTestCases = new ArrayList<>();

        /**
        Find all tests from the allTests string
         */
        String[] tests =  allTests.split("\n");

        /**
        Store result in HashMap , so that finding passed test case would be O(1)
         */
        String[] results =  testResults.split("\n");

        Map<String,String> hMap = new HashMap<>();
        for(String result : results){
            String testCase = result.substring(0, result.lastIndexOf(":")).replaceAll(":",".");            
            String testResult = result.substring(result.lastIndexOf(":")+1);
            hMap.put(testCase, testResult);
        }

        /**Check the status of each test and if the status is not 'passed', add the test in failedTestCases List */
        for(String test : tests){
            failedTestCases.add(test);
            if(hMap.containsKey(test) && hMap.get(test).equals("passed")){
                failedTestCases.remove(test);
            }
        }

        return failedTestCases;
    }
    /**Brute Force Solution */
    public static List<String> getTestsToExecute (String allTests, String testResults) {
        /**
        Store the result in failedTestCases List
         */
        List<String> failedTestCases = new ArrayList<>();

        /**
        Find all tests from the allTests string
         */
        String[] tests =  allTests.split("\n");

        /**
        Find all results from the testResults string
         */
        String[] results =  testResults.split("\n");         

        /**
        Check the status of each test and if the status is not 'passed', add the test in failedTestCases List
         */
        for(String test : tests){  
            failedTestCases.add(test);          
            for(String result : results){
                result = result.replaceAll(":",".");
                if(result.contains(test) && result.contains("passed")){
                    failedTestCases.remove(test);
                }
            }            
        }        

        return failedTestCases;
    }
}

