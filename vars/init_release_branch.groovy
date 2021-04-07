def call(major_minor, branch, xmlfile, prefix) {
    // withEnv([
    //     "ENV_RELEASE_MAJOR_MINOR=$major_minor",
    //     "ENV_RELEASE_BRANCH=$branch",
    //     "ENV_RELEASE_XML_FILE=$xmlfile",
    //     "ENV_RELEASE_TAG_PREDFIX=$prefix"
    //     ]) {
    //     sh(libraryResource('init_release_branch.sh'))
    // }

    // New way to input arguments to bash scripts
    withEnv([
        "1=$major_minor",
        "2=$branch",
        "3=$xmlfile",
        "#=3"
        ]) {
        sh(libraryResource('init_release_branch.sh'))
    }

    def nextVersion = ""

    withEnv([
        "ENV_TARGET_MAJOR_MINOR_VERSION=$major_minor"
        ]) {
        nextVersion = sh(libraryResource('next_tag.sh'))
    }

    withEnv([
        "ENV_RELEASE_XML_FILE=$xmlfile",
        "ENV_RELEASE_TAG=$prefix-$nextVersion",
        "ENV_RELEASE_XML_FILE=$xmlfile"
        ]) {
        sh(libraryResource('tag_all_projects.sh'))
    }

    sh(script: "echo \"current dir is \$PWD\"; ls -la")
    sh(script: "git tag -f $nextVersion")
    // sh(script: "git push --atomic origin $branch $nextVersion")
}
