def call(major_minor, branch, xmlfile, prefix) {
    withEnv([
        "ENV_RELEASE_MAJOR_MINOR=$major_minor",
        "ENV_RELEASE_BRANCH=$branch",
        "ENV_RELEASE_XML_FILE=$xmlfile",
        "ENV_RELEASE_TAG_PREDFIX=$prefix"
        ]) {
        return sh(libraryResource('init_release_branch.sh'))
    }
}
