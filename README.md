
# Maven wrapper

./mvnw

-> means "run Maven using the project's wrapper"

-> It allows the project to run Maven even if Maven is not installed on the computer.

# to compile & run the code

./mvnw spring-boot:run

            When we run Maven command: ./mvnw spring-boot:run

            Maven:

                    1️⃣ Compiles Java code src/main/java/*.java into target/classes/*.class

                    2️⃣ Copies resources src/main/resources into target/classes

                    3️⃣ Runs the application from target/classes

# to clean "target" folder

./mvnw clean 

-> forces Maven to start from scratch

# to compile the code

./mvnw compile

# to start a clean build 

./mvnw clean install

or

./mvnw clean spring-boot:run

-> cleans old build, compile again, run the application
