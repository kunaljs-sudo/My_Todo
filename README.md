This file can be used as a template for initializing and running spring projects.

What's included: 
1. Gradle file created from start.spring.io
2. Other dependencies like Mongo, MySql and redis.

Usage - 

1. To build the repository - 

From the repository root, 

1. run `./gradlew build`run the build
2. run `./gradlew bootrun` to execute Srping Boot. The applicaiton will start and you can add, delete, modify and get Todos.

Need to be added:
Since this application uses cloud Atlas mongodb and have removed mongo-config.properties file, if you want to use mongodb cloud you can add the file in main/resources
FileName should be exact same as I have provided this filename to Application.java as property file, if you wish to change it change in Application.java too
# mongo-config.properties
## <ls> mongodb.username=username
## <ls> mongodb.password=password

License - 
While this repository is licensed under APACHE 2.0 license, It is mandatory for users to share the readme.md and License file along with the changes they do in the contents.
