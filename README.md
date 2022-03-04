# SYSC-4806-Labs
[![Java CI](https://github.com/alexandrehassan/SYSC-4806-Labs/actions/workflows/Java_CI.yml/badge.svg)](https://github.com/alexandrehassan/SYSC-4806-Labs/actions/workflows/Java_CI.yml)

## Description
Simple Java Spring Boot application created for SYSC-4806-Labs. Available on [Heroku](https://sysc-4806-lab-101117297.herokuapp.com/).

### Features
- Allows users to create, and add Buddies and AddressBook entries.
- Buddies can't be added until an address book entry is created.
- All the Buddies and AddressBook entries are stored in an H2 database.
- All the Buddies and AddressBook entries are shown on the home page.
- Application has only one single page.
- Form sending and displaying is done with AJAX and Thymeleaf.
- Application has CI/CD pipeline using GitHub Actions.
  - CI
    - Merge request to main is blocked until the tests pass.
    - [CI Action File](https://github.com/alexandrehassan/SYSC-4806-Labs/blob/main/.github/workflows/Java_CI.yml)
    - [CI Action Runs](https://github.com/alexandrehassan/SYSC-4806-Labs/actions/workflows/Java_CI.yml)
  - CD
    - Push to Heroku is blocked until PR is merged. Secret key is stored in the repository.
    - [CD Action File](https://github.com/alexandrehassan/SYSC-4806-Labs/blob/main/.github/workflows/HerokuDeploy.yml)
    - [CD Action Runs](https://github.com/alexandrehassan/SYSC-4806-Labs/actions/workflows/HerokuDeploy.yml)

### Considerations
- The data stored is wiped out every time the application times out.
  - This would need to be fixed if the application was to be used in a production environment.
  - Since the application is only used for labs, this is not a concern.
- There are no delete, update, or search functionality.