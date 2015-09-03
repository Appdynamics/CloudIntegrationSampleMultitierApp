<?php 

        $iterator = rand(1, 16000);
        
        print "$iterator";
        $addUsers = curl_init();
        while ($iterator < 16000){
            curl_setopt($addUsers, CURLOPT_URL, "http://localhost:8080/npm-sample-1.0-SNAPSHOT/demo/user/add?email=amitabh$iterator@foobar.com&username=turtles$iterator");
            curl_setopt($addUsers, CURLOPT_RETURNTRANSFER, 1);
            $addOutput = curl_exec($addUsers);
            print "added user is : $addOutput";
            
            sleep(60);
        
            curl_setopt($addUsers, CURLOPT_URL, "http://localhost:8080/npm-sample-1.0-SNAPSHOT/demo/user/add?email=shamitabh$iterator@foobar.com&username=bachchan$iterator");
            curl_setopt($addUsers, CURLOPT_RETURNTRANSFER, 1);
            $addOutput = curl_exec($addUsers);
            print "added user is : $addOutput";
        
            sleep(60);
            
            curl_setopt($addUsers, CURLOPT_URL, "http://localhost:8080/npm-sample-1.0-SNAPSHOT/demo/user/add?email=foo$iterator@foobar.com&username=foo$iterator");
            curl_setopt($addUsers, CURLOPT_RETURNTRANSFER, 1);
            $addOutput = curl_exec($addUsers);
            print "added user is : $addOutput";
        
            sleep(60);
        
            curl_setopt($addUsers, CURLOPT_URL, "http://localhost:8080/npm-sample-1.0-SNAPSHOT/demo/user/add?email=bar$iterator@foobar.com&username=bar$iterator");
            curl_setopt($addUsers, CURLOPT_RETURNTRANSFER, 1);
            $addOutput = curl_exec($addUsers);
            print "added user is : $addOutput";
            
            sleep(60);
            
            $iterator++;
        }
        $getUsers = curl_init();
        // set url 
        curl_setopt($getUsers, CURLOPT_URL, "http://localhost:8080/npm-sample-1.0-SNAPSHOT/demo/user/getall"); 

        //return the transfer as a string 
        curl_setopt($getUsers, CURLOPT_RETURNTRANSFER, 1); 

        // $output contains the output string 
        $output = curl_exec($getUsers); 
        
        print "users received is $output";

        // close curl resource to free up system resources 
        curl_close($getUsers);      
?>