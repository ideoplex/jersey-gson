Feature: User Management

Scenario: Add New Email
  Given prospective user with email "user@example.com" pre-exists
   And  email "user@example.com" is not pre-registered
  When  user submits add "user@example.com" form
  Then  email "user@example.com" is registered

Scenario: Reject Duplicate Email
  Given prospective user with email "user@example.com" pre-exists
   And  email "user@example.com" is pre-registered
  When  user submits add "user@example.com" form
  Then  duplicate email "user@example.com" error is thrown
