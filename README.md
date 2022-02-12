# UnrdApp
Protopyte project with intergration of API https://s3-eu-west-1.amazonaws.com

## Best practices

- Separation of concerns
- KISS
- DRY
- SOLID
- Commend Query
- Clean Architecture

## Architecture
Logic in application can be seen as segregated into four abstract layers:

**_User Interface layer:_**
* renders ui model (View - part of UiComponent)
* look&feel, animations, colors, styles, descriptions, layout
* captures user interactions with UI elements and only routes them (NOT handling) into the system

**_Application layer (aka "Glue layer"):_**
* controls user flow inside app e.g navigation 
* passes ui model to UI layer 
* handles user interaction with UI
* integrates standalone pieces of functionality from other layers

**_Domain layer:_**
* executes business domain flows aka "business logic

**_Infrastructure layer:_**
* provides general functionality not specific to business domain
    * networking (Retrofit)
    * reactive (RxJava)

#### Remarks
**UiModel** has only data to display, for a View. Colors, styles, descriptions etc. are View implementation details, they are not part of **UiModel**.

### Benefits :
Makes the code much more pleasant to work with!
* No need to look for things
* Readable and intuitive
* Easy to reason about and modify
* Productive and less stressful

### Example Unit tests :
* MainViewModelTest
* ResultRepositoryTest
* GetUiModelUseCaseTest

### Example Unit tests :
* MainViewModelTest
* ResultRepositoryTest
* GetUiModelUseCaseTest

### My ideal CI World for Unrd :
I will propose fastlane to sign and build application and GitHub action for run CI remote(cost $0.008 per minute)
For this kind of project monthly cost should be on acceptable level
Possible solution is set our own Linux machine and configure Jenkins/Bitrise or use CircleApp

What should be cover by CI:
* Run Unit test for each PR to develop and master
* Run nightly daily internal release build 
* Internal release process(Firebase, Alpha, Beta)
* Production release process

Nice to have
* Translation process
* Run nightly UI test
* Run code formatter for each PR  
* Security check for release file(MobSF)