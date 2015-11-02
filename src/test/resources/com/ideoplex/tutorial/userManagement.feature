Feature: User Management

Scenario: Add New Email
  Given prospective user with email <user@example.com> exists
   And  email <user@example.com> is not registered
  When  user submits add <user@example.com> form
  Then  email <user@example.com> is registered

Scenario: Reject Duplicate Email
  Given prospective user with email <user@example.com> exists
   And  email <user@example.com> is registered
  When  user submits add <user@example.com> form
  Then  throw duplicate email <user@example.com> error
