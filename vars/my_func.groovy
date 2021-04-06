def call(message) {
    echo "Hello world from groovy: $message"

    sh(libraryResource('my_script.sh'))
}
