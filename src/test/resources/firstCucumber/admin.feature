Feature: Admin
  Background: The user already logged in 
  Given The user logged in with username "waaves3@gmail.com" and password "s3corp!"
  
  Scenario: Show list of cashback
    Given The dashboard page already showed
    When The user open cashback list
    Then The list cashback will showed