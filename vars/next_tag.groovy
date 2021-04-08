def call(major_minor) {
    withEnv([
        "ENV_TARGET_MAJOR_MINOR_VERSION=$major_minor"
        ]) {
        return sh(script: libraryResource('next_tag.sh'), label: 'next_tag', returnStdout: true).trim()
    }
}
