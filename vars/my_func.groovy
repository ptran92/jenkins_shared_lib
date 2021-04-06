def call(message1, message2, message3) {
    echo "Hello world from groovy"

    withEnv(["ARGUMENT_1=$message1", "ARGUMENT_2=$message2", "ARGUMENT_3=$message3"]) {
        sh(libraryResource('my_script.sh'))
    }
}
