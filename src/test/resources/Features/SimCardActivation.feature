Feature: Test API

  Scenario: simCard successfully activated
    Given Activate sim card
    When iccid equal "1255789453849037777"
    Then result success
    And store into database
    Then get details of sim card
  Scenario: simCard successfully activated
    Given Activate sim card
    When iccid equal "8944500102198304826"
    Then result failed

